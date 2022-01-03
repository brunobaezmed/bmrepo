package com.graph;

import java.util.Scanner;
import java.util.Stack;

public class Digraph {
    private final int V;
    private int E;
    private Stack<Integer>[] adj;

    public Digraph(int V ){
        this.V = V;
        this.E = 0;
        adj = (Stack<Integer>[]) new Stack[V];
        for (int v = 0;v < V; v++)
            adj[v] = new Stack<Integer>();
    };
    public int V(){ return V;};
    public int E(){ return E;};
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    };
    public Iterable<Integer> adj(int v){
        return adj[v];
    };
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for (int v = 0; v < V ; v++)
            for(int w: adj(v))
                R.addEdge(w,v);
        return  R;
    };
    public String toString(){
        String s = V + " vertices,"+ E + " edges\n";
        for(int v = 0 ; v < V; v++) {
            s += v + ":";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    };
}
