package com.lhx.chapter4;

import edu.princeton.cs.algs4.In;

public class CC {

	private boolean[] marked;
	private int count;
	private int[] id;
	public static void main(String[] args) {
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		CC cc = new CC(g);
		System.out.println(cc.count());

	}
	
	public CC(Graph G)
	{
		marked = new boolean[G.V()];
		count = 0;
		id = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
		{
			if (!marked[v])
			{
				dfs(G, v);
				count++;
			}
			
		}
	}
	
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
		{
			if (!marked[w])
				dfs(G, w);
		}
	}
	
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];
	}
	
	int count()
	{
		return count;
	}
	
	int id(int v)
	{
		return id[v];
	}

}
