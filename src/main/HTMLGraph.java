package main;

import html.Folder;
import html.Parser;
import pagerank.Graph;
import pagerank.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HTMLGraph {
    private Graph mGraph;
    private Folder mFolder;
    private ArrayList<String> mFiles;
    private Map<String, Integer> mUrls;

    public HTMLGraph(String folderPath) {
        mFolder = new Folder(folderPath);
        mFiles = mFolder.getHTMLFiles();
        mGraph = new Graph(mFiles.size());
        mUrls = new HashMap<String, Integer>();

        for (int i = 0; i < mFiles.size(); ++i)
            mUrls.put(mFiles.get(i), i);

        for (String file : mFiles) {
            ArrayList<String> links = new Parser(folderPath + file).getHyperlinks();

            for (String link : links)
                mGraph.addEdge(mUrls.get(file), mUrls.get(link));
        }
    }

    Vector computePagerank(double beta, double epsilon) {
        return mGraph.computePagerank(beta, epsilon);
    }

    Map<String, Double> computePagerankMap(double beta, double epsilon) {
        Map<String, Double> m = new HashMap<String, Double>();

        Vector v = computePagerank(beta, epsilon);

        for (int i = 0; i < mFiles.size(); ++i)
            m.put(mFiles.get(i), v.get(i));

        return m;
    }

    Folder getFolder() {
        return mFolder;
    }

    ArrayList<String> getFiles() {
        return mFiles;
    }

    Map<String, Integer> getUrls() {
        return mUrls;
    }
}
