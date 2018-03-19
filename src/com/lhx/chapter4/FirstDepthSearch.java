package com.lhx.chapter4;

public class FirstDepthSearch {

	private int count = 0;
	private boolean[] visited;
	
	public static void main(String[] args) {
		

	}
	
	
	public FirstDepthSearch(Graph g, int s)
	{
		visited = new boolean [g.V()];
		dfs(g, s);
	}
	
	private void dfs(Graph g, int v)
	{
		visited[v] = true;
		count++;
		for (Integer w : g.adj(v))
		{
			if (!visited[w])
				dfs(g, w);
		}
	}
	
	
	
	boolean marked(int v)
	{
		return visited[v];
	}
	
	public int count()
	{
		return count;
	}

}
