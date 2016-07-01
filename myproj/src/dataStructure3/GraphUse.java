package dataStructure3;

import java.util.*;

public class GraphUse {

	public static boolean isConnected(Graph g){

		if(g.numEdges()<g.vertices.size()-1){

			return false;
		}

		for(Vertex v:g.vertices){

			for(Vertex adjacentV:g.vertices){

				if(v==adjacentV){
					continue;
				}

				if(v.isAdjacentTo(adjacentV)){
					continue;
				}

			}

		}
		return true;
	}

	public static boolean havePath(Graph g,Vertex v1,Vertex v2,ArrayList<Vertex> visited){

		if(v1.isAdjacentTo(v2)){
			return true;
		}

		ArrayList<Vertex> adjacentVertices=v1.getAdjacentVertices();

		for(Vertex v:adjacentVertices){
			boolean flag=false;
			for(int i=0;i<visited.size();i++){
				if(v.equals(visited.get(i))){
					flag=true;
				}
			}
			if(!flag){
				visited.add(v);		
				boolean check= havePath(g, v, v2,visited);
				if(check){
					return true;
				}
			}
		}
		return false;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addEdge("a", "b");	
		g.addEdge("d", "e");
       g.addEdge("e", "f");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("f", "a");
		g.print();
		Vertex v1=g.getVertex("a");
		Vertex v2=g.getVertex("e");
		ArrayList<Vertex> visited=new ArrayList<>();
		visited.add(v1);
		System.out.println(havePath(g,v1,v2,visited));
		System.out.println(g.havePathBFS("a", "e"));
		System.out.println(g.isConnected());
		
		ArrayList<ArrayList<Vertex>> out=g.connectedCmp();
		
		for(int i=0;i<out.size();i++){
			for(int j=0;j<out.get(i).size();j++){
				System.out.print(out.get(i).get(j).getName()+"<->");
			}
			System.out.println();
		}
		
		System.out.println(g.isBipartite());
		System.out.println(g.isCyclic());

	}

}
