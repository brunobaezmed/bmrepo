package com.graph;

public class Search {
    private Graph  g;
    private int s;
    Search(Graph g, int s){
        this.g = g;
        this.s = s;

    }
    public boolean marked(int v){
        for (Integer e : g.adj(s)) {
            if(e.equals(v)){
                return true;
            }

        }
        return false;
    }
    public int count(){
        int q = 0;
        for(Integer e: g.adj(s)){
            q++;
        }
        return q;
    }
}
