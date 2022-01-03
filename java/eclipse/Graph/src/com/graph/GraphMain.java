package com.graph;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class GraphMain {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/bruno/" +
                "Documents/java/eclipse/Graph/src/com/graph/grafo"));

        Graph g = new Graph(8);
        g.addEdge(5, 7);
        g.addEdge(0,1);
        g.addEdge(0,7);
        g.addEdge(3,5);
        g.addEdge(1,7);

        Graph g2 = new Graph(in);


        System.out.println(g.toString()+"path to 1  ");
        Search s = new Search(g2,5);
        boolean r = s.marked(1);
        int c = s.count();

        DepthFirstSearch dfs = new DepthFirstSearch(g,0);
        for (Integer i : dfs.pathTo(1)) {
           System.out.println(i);
        }
        BreadthFirstPaths bfp = new BreadthFirstPaths(g , 0);
        for(Integer l : bfp.pathTo(1)){
            System.out.println(l);
        }
        Cycle l = new Cycle(g2);
        l.hasCycle();

        in.close();

        SymbolGraph stringGraph = new SymbolGraph("/home/bruno/" +
                "Documents/java/eclipse/Graph/src/com/graph/symbolgraph"," ");
        System.out.println(stringGraph.name(1));
    }
}
