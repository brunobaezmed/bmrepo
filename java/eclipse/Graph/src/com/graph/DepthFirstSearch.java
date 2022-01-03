package com.graph;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[]marked;
    private int c;
    private int []edgeT;
    private int s;
    public DepthFirstSearch(Graph g,int s){
        marked = new boolean[g.V()];
        edgeT = new int[g.V()];
        this.s = s;
        dfs(g, s);

    }
    private void dfs(Graph g,int v) {
        marked[v] = true;
        c++;
        for (int w : g.adj(v))
            if (!marked[w]){
                edgeT[w] = v;
                dfs(g, w);
            }
    }
    public boolean marked(int w) {
        return marked[w];
    }
    public int count(){
            return c;
        }

    public boolean hasPathTo(int v){
        return marked(v);
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int q = v; q != s; q = edgeT[q]){
            path.push(q);
        }
        path.push(s);
        return path;
    }
    }

