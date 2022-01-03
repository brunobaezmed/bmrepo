package com.graph;

import java.util.HashMap;
import java.util.Scanner;


public class SymbolGraph {
    private Scanner in ;
    private HashMap<String,Integer> vertexIdMap;
    private String []keys;
    private  Graph g;


    public SymbolGraph(String instream,String delimiter){
        vertexIdMap = new HashMap<>();
        in = new Scanner(instream);
        while(in.hasNextLine()){
            String[] V = in.nextLine().split(delimiter);
            for(int q = 0; q < V.length; q++){
                if(!vertexIdMap.containsKey(V[q])){
                    vertexIdMap.put(V[q],vertexIdMap.size());
                }
            }
        }
       keys = new String[vertexIdMap.size()];
        for(String Vname:vertexIdMap.keySet()){
            keys[vertexIdMap.get(Vname)] = Vname;
        }
        g = new Graph(vertexIdMap.size());

        in = new Scanner(instream);

        while(in.hasNextLine()){
            String[] vertices = in.nextLine().split(delimiter);
            int vertex = vertexIdMap.get(vertices[0]);
            for(int q = 1;q < vertices.length ; q++ ){
                g.addEdge(vertex,vertexIdMap.get(vertices[q]));
            }
        }
    };
    public boolean contains(String Vname){
        return vertexIdMap.containsKey(Vname);
    }
    public int index(String Vname){
        return vertexIdMap.get(Vname);
    }
    public String name(int vertexId){
        return keys[vertexId];
    }
    public Graph graph(){
        return g;
    }
}
