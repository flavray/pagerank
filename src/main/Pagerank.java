package main;

import html.Folder;
import html.Parser;
import pagerank.Graph;

public class Pagerank {
    public static void main(String[] args) {
        HTMLGraph g = new HTMLGraph(args[1]);

        System.out.println(g.computePagerankMap(0.8, 0.0001));
    }
}
