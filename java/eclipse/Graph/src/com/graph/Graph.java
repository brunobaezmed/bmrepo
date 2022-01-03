package com.graph;
import java.util.Scanner;
import java.util.Stack;
public class Graph {
    private Scanner in ;
    private int E,V;

    private  Stack<Integer>[] adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Stack<Integer>[]) new Stack[V];

        for (int v = 0; v < V; v++)
            adj[v] = new Stack<Integer>();
    };
    public Graph(Scanner in){
        this(Integer.parseInt(in.nextLine()));
        int E = Integer.parseInt(in.nextLine());
        for(int i = 0; i < E; i++){
            int v = Integer.parseInt(in.nextLine());
            int w = Integer.parseInt(in.nextLine());
            addEdge(v, w);
        }
    };
    public int V(){
        return V;
    };

    public int E(){
        return E;
    };

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    };
    Iterable<Integer> adj(int v){
        return adj[v];
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
