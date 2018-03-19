package com.lhx.chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.algs4.In;

public class BreadthFirstPaths {
	
	private boolean[] marked;
	private final int s;
	private int[] edgeTo;
	
	
	public static void main(String[] args) {
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		BreadthFirstPaths dp = new BreadthFirstPaths(g, 0);
		System.out.println( dp.pathTo(4) );

	}
	
	public BreadthFirstPaths(Graph G, int s)
	{
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
		
	}
	
	public void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new LinkedList<Integer> ();
		queue.offer(s);
		marked[s] = true;
		while (!queue.isEmpty())
		{
			int v = queue.poll();
			for (int w : G.adj(v))
			{
				
				if (!marked[w])
				{
					marked[w] = true;
					edgeTo[w] = v;
					queue.offer(w);
				}
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
