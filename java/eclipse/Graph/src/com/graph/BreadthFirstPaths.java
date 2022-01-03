package com.graph;

import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[]  marked;
    private int[] edgeTo;
    private final int s;
    public  BreadthFirstPaths(Graph g, int s){
        marked =  new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g,s);
    }
    private void bfs(Graph g,int s) {
        Stack<Integer> queue = new Stack<Integer>();
        marked[s] = true;
        queue.push(s);
        while (!queue.isEmpty()) {
            int v = queue.pop();
            for (int w : g.adj(v))
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.push(w);
                }
        }
    }
    public boolean hasPathTo(int v){
            return marked[v];
        }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int q = v; q != s; q = edgeTo[q]){
            path.push(q);
        }
        path.push(s);
        return path;
    }
}
