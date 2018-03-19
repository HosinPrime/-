package com.lhx.chapter4;

import edu.princeton.cs.algs4.In;

public class TwoColor {

	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColor = true;
	
	public static void main(String[] args) {
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		TwoColor tc = new TwoColor(g);
		System.out.println(tc.isTwoColor());

	}
	
	public TwoColor(Graph g)
	{
		marked = new boolean[g.V()];
		color = new boolean[g.V()];
		for (int s = 0; s < g.V(); s++)
		{
			if (!marked[s])
				dfs(g, s);
		}
	}
	
	public void dfs(Graph g, int v)
	{
		marked[v] = true;
		for (int w : g.adj(v))
		{
			if (!marked[w])
			{
				color[w] = !color[v];
				dfs(g, w);
			}
			else if (color[v] == color[w])
				isTwoColor = false;
		}
	}
	
	public boolean isTwoColor()
	{
		return isTwoColor;
	}
	

}
