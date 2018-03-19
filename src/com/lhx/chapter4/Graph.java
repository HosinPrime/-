package com.lhx.chapter4;



import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
	
	private  int V;
	private int E;
	Bag<Integer> [] adj;
	
		
	
	public static void main(String[] args)
	{
		Graph g = new Graph(new In("C:\\Users\\xxx\\Desktop\\algs4-data\\tinyG.txt"));
		System.out.println(g.E);
	}
	
	
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer> ();
	}
	
	public Graph(In in)
	{
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++)
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}  
	
	public int V() 
	{
		
		return this.V;
	}
	
	public int E()
	{
		return this.E;
	}
	
	
	Iterable<Integer> adj(int v)
	{
		return adj[v];
		
	}
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	
	
	
}
