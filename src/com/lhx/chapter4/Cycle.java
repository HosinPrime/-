package com.lhx.chapter4;

import edu.princeton.cs.algs4.In;

public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;

	
	public static void main(String[] args) {
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		Cycle cc = new Cycle(g);
		System.out.println(cc.hasCycle());

	}
	
	public Cycle(Graph g)
	{
		marked = new boolean[g.V()];
		for (int i = 0; i < g.V(); i++)
		{
			if (!marked[i])
				dfs(g, i, i);
		}
	}
	
	public void dfs(Graph g, int v, int u)
	{
		marked[v] = true;
		for (int w : g.adj(v))
		{
			if (!marked[w])
				dfs(g, w, v);
			else if (w != u)
				hasCycle = true;
		}
	}
	
	public boolean hasCycle()
	{
		return hasCycle;
	}

}
