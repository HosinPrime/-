package com.lhx.chapter4;

import java.util.Stack;

import edu.princeton.cs.algs4.In;

public class DepthFirstPaths {

	private boolean[] marked;
	private final int s;
	private int[] edgeTo;
	
	public static void main(String[] args)
	{
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		DepthFirstPaths dp = new DepthFirstPaths(g, 0);
		System.out.println( dp.pathTo(3) );
	}
	
	public DepthFirstPaths(Graph G, int s)
	{
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	public void dfs(Graph G, int v)
	{
		marked[v] = true;
		
		for (Integer w: G.adj(v))
		{
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v)) return null;
		Stack<Integer> paths = new Stack<Integer> ();
		for (int x = v; x != s; x = edgeTo[x])
		{
			paths.push(x);
		}
		
		paths.push(s);
		return paths;
	}
	
	
}
