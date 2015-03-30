package com.artech.prototypev2.chuiko.manager;

//import com.snowtide.PDF;
//import com.snowtide.pdf.Document;
//import com.snowtide.pdf.OutputTarget;
import com.artech.prototypev2.chuiko.graph.AbstractGraph;
import com.artech.prototypev2.chuiko.vertex.AbstractVertex;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Класс для управления графом.
 * 1 менеджер содержит 1 граф.
 * Возможноти:
 * добавить в граф слова из текста по разделителю,
 * Добавить в граф слова из файла,
 * Добавить в граф все txt файлы в директории,
 * вывести граф в String,
 * вывести граф в txt файл,
 */

public class GraphManager {

    protected class Graph extends AbstractGraph {
    }

    protected final Graph graph;
    //
    protected static Logger logger = Logger.getLogger(GraphManager.class.getName());

    public GraphManager() {
        graph = new Graph();

    }

    /**
     * Добавить в граф слова из string по разделителю regex и устанавливает связь с предыдущим словом.
     */
    //создать метод для разделения предложений и слов.
    //вынести обработку слов из AbstracGraph.
    public void addSplitsOfStringInGraph(String string, String regex) {
        String[] data = string.split(regex);
        String pastWord = null;
        for (String s : data) {
            if(s.length() > 30){
                continue;
            }
            graph.addVertex(s);
            if (pastWord != null) {
                graph.addEdge(pastWord, s);
            }
            pastWord = s;
        }
    }

    /**
     * Установить файл для экспорта графа. Если файла нет, создается новый.
     */
    protected File setFileForExport(String pathname) throws IOException {
        File fileForExport = new File(pathname);
        if (!fileForExport.exists()) {
            try {
                fileForExport.createNewFile();
            } catch (IOException e) {
                throw new IOException("не удалось создать файл");
            }
        }
        return fileForExport;
    }

    /**
     * Напечатать граф в строку
     */
    public String getGraphToString() {
        return graph.toString();
    }

    /**
     * Напечатать граф в файл
     */
    public void printGraphInFile(String pathname) throws IOException {
        logger.info("формирование файла графа");
        File fileForPrint = setFileForExport(pathname);
        if (fileForPrint == null) {
            throw new FileNotFoundException("файл не найден");
        }

        Date date = new Date();
        PrintWriter out = new PrintWriter(fileForPrint);

        StringBuilder rezultString = new StringBuilder();
        for (Map.Entry<String, AbstractVertex> entry : graph.getMapVertices().entrySet()) {
            rezultString.delete(0, rezultString.length());
            rezultString.append(entry.getValue().toString()).append(" - ");
            for (Map.Entry<AbstractVertex, Integer> entryElement : entry.getValue().getOutGoingEdges().entrySet()) {
                rezultString.append("[").append(entryElement.getKey().toString()).append(", ").append(entryElement.getValue()).append("];");
            }
            out.println(rezultString.toString());
        }

        out.close();

        logger.info("Граф выведен\n" +
                "Время вывода: " + (new Date().getTime() - date.getTime())/1000. + "сек");
    }

    /**
     * Добавляет в граф файл, если формат файла поддерживается
     *
     * @param fullFileName
     */
    //txt должно быть в конце строки
    public void addFileinGraph(String fullFileName) throws IOException {
        if (fullFileName.contains(".txt")) {
            addTxtFileInGraph(fullFileName);
        } else if (fullFileName.contains(".fb2")) {
            addFb2FileInGraph(fullFileName);
        } else if (fullFileName.contains(".doc")) {
            addDocFileInGraph(fullFileName);
        } else if (fullFileName.contains(".pdf")) {
            //addPDFFileInGraph(fullFileName);
        }
    }

    /**
     * Занести в граф doc файл
     */
    public void addDocFileInGraph(String pathname) throws IOException {
        if (pathname == null) {
            return;
        }
        POIFSFileSystem fileForImport =  new POIFSFileSystem(new FileInputStream(pathname));

        HWPFDocument doc = new HWPFDocument(fileForImport);

        String text = doc.getDocumentText();
        addSplitsOfStringInGraph(text, " ");
    }

    /**
     * Занести в граф fb2 файл
     */
   public void addFb2FileInGraph(String pathname) throws IOException {
       if (pathname == null) {
           return;
       }
       File fileForImport = new File(pathname);

       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileForImport)));
       String text;
       while ((text = reader.readLine()) != null) {
           String[] textFragments = text.toLowerCase().split("<[^<>]*.>");
           for (String fragment: textFragments){
               addSplitsOfStringInGraph(fragment, " ");
           }
       }

       reader.close();
   }
    /**
     * Занести в граф pdf файл
     */
    public void addPDFFileInGraph(String pathname) throws IOException {
//        if (pathname == null) {
//            return;
//        }
//        File fileForImport = new File(pathname);
//
//        Document doc = PDF.open(fileForImport);
//
//        StringBuilder text = new StringBuilder();
//
//        for (int i = 0; i < doc.getPageCnt(); i++) {
//            doc.getPage(i).pipe(new OutputTarget(text));
//            addSplitsOfStringInGraph(text.toString(), " ");
//        }
//
//        doc.close();
    }

    /**
     * Занести в граф txt файл
     */
    public void addTxtFileInGraph(String pathname) throws IOException {
        if (pathname == null) {
            return;
        }
        File fileForImport = new File(pathname);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileForImport)));
        String s;
        while ((s = reader.readLine()) != null) {
            addSplitsOfStringInGraph(s, " ");
        }

        reader.close();
    }

    /**
     * Занести в граф все файлы для чтения из директории
     */
    public void addAllFilesForReadingInGraph(String pathname) throws IOException {
        File dir = new File(pathname);
        if (!dir.isDirectory()) {
            return;
        }

        String[] allFiles = dir.list();
        List<String> filesForReading = new ArrayList<String>();
        for (String filename : allFiles) {
            filename = filename.toLowerCase();
            if (filename.contains(".txt") || filename.contains(".fb2") || filename.contains(".doc") /*|| filename.contains(".pdf")*/) {
                filesForReading.add(filename);
            }
        }

        StringBuilder logString = new StringBuilder();
        int progress = 0;
        for (String fileName : filesForReading) {
            logger.info("Обрабатывается файл: " + fileName);
            Date date = new Date();

            addFileinGraph(pathname + "\\" + fileName);

            progress++;
            logString.delete(0, logString.length());
            logString.append("\nВремя обработки файла: ").append((new Date().getTime() - date.getTime()) / 1000.).append("сек")
                    .append("\n").append("Количество слов в графе: ").append(graph.getVertices().size())
                    .append("\n").append("Обработано файлов: ").append(progress).append("/").append(filesForReading.size());
            logger.info(logString.toString());
        }
    }
}
