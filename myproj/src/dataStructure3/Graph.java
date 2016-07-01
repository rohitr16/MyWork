package dataStructure3;

import java.util.ArrayList;
import java.util.HashMap;

import dataStructure.QueueLL;

public class Graph {

	ArrayList<Vertex> vertices;

	Graph(){
		vertices=new ArrayList<>();
	}

	public void print(){
		for(Vertex v : vertices){
			v.print();
		}
		System.out.println();
	}

	public int numVertices(){
		return vertices.size();
	}

	public int numEdges(){
		int count = 0;
		for(Vertex v : vertices){
			count += v.numEdges();
		}
		return count / 2;
	}

	public void addVertex(String name){
		if(isVertexPresent(name)){
			return;
		}
		Vertex v = new Vertex(name);
		vertices.add(v);
	}

	public void addEdge(String name1, String name2){
		if(!isVertexPresent(name1) || !isVertexPresent(name2)){
			return;
		}
		if(areAdjacent(name1,name2)){
			return;
		}
		Vertex first = getVertex(name1);
		Vertex second = getVertex(name2);
		Edge e = new Edge(first,second);
		first.addEdge(e);
		second.addEdge(e);
	}

	public void removeEdge(String name1, String name2){
		if(!isVertexPresent(name1) || !isVertexPresent(name2)){
			return;
		}
		if(!areAdjacent(name1,name2)){
			return;
		}
		Vertex first = getVertex(name1);
		Vertex second = getVertex(name2);	
		first.removeEdgeWith(second);
		second.removeEdgeWith(first);
	}

	public void removeVertex(String name){
		Vertex v = getVertex(name);
		if(v == null){
			return;
		}

		ArrayList<Vertex> adjacentVertices = v.getAdjacentVertices();
		for(Vertex adjVertex : adjacentVertices){
			adjVertex.removeEdgeWith(v);
		}
		vertices.remove(v);
	}


	public  boolean areAdjacent(String name1, String name2) {
		if(!isVertexPresent(name1) || !isVertexPresent(name2)){
			return false;
		}
		Vertex first = getVertex(name1);
		Vertex second = getVertex(name2);
		return first.isAdjacentTo(second);	
	}

	Vertex getVertex(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return v;
			}
		}
		return null;
	}

	private boolean isVertexPresent(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	public  boolean havePathBFS(String v1,String v2){

		QueueLL<Vertex> queue=new QueueLL<>();
		HashMap<Vertex, Boolean> map=new HashMap<>();
		Vertex first=getVertex(v1);
		map.put(first, true);
		queue.Enqueue(first);
		Vertex second=getVertex(v2);

		while(!queue.isEmpty()){

			Vertex currentVertex=queue.Dequeue();
			if(currentVertex.isAdjacentTo(second)){
				return true;
			}
			ArrayList<Vertex> adjacent=currentVertex.getAdjacentVertices();
			for(Vertex v:adjacent){		
				if(!map.containsKey(v)){
					map.put(v, true);
					queue.Enqueue(v);
				}	
			}
		}
		return false;
	}

	public boolean isConnected(){

		Vertex u=vertices.get(0);	
		for(Vertex v:vertices){
			if(u!=v&&!havePathBFS(u.getName(), v.getName())){
				return false;
			}
		}

		return true;
	}

	public ArrayList<ArrayList<Vertex>> connectedCmp(){

		ArrayList<ArrayList<Vertex>> out=new ArrayList<>();

		HashMap<Vertex, Boolean> visited=new HashMap<>();

		for(Vertex u:vertices){

			if(!visited.containsKey(u)){
				ArrayList<Vertex> temp=new ArrayList<>();
				visited.put(u, true);
				temp.add(u);

				for(Vertex v:vertices){
					if(u!=v&&havePathBFS(u.getName(), v.getName())&&!visited.containsKey(v)){
						visited.put(v, true);
						temp.add(v);
					}
				}
				out.add(temp);
			}
		}

		return out;
	}
	
	public boolean isBipartite(){
		
		QueueLL<Vertex> queue=new QueueLL<>();
		HashMap<Vertex, Character> map=new HashMap<>();
		
		queue.Enqueue(vertices.get(0));
		map.put(vertices.get(0), 'b');
		
		while(!queue.isEmpty()){
			
			Vertex currenrVertex=queue.Dequeue();
			char ch;
			if(map.get(currenrVertex)=='b'){
				ch='w';
			}
			else{
				ch='b';
			}
			
			ArrayList<Vertex> adjacent=currenrVertex.getAdjacentVertices();
			for(Vertex v:adjacent){
				
				if(!map.containsKey(v)){
					map.put(v, ch);
					queue.Enqueue(v);
				}
				else{
					if(map.get(currenrVertex)==map.get(v)){
						return false;
					}
				}	
			}		
		}
		return true;
	}
	
	public boolean isCyclic(){
		
	   HashMap<Vertex, Boolean> visited=new HashMap<>();
		
		for(Vertex u:vertices){
			
			if(!visited.containsKey(u)){
				visited.put(u, true);
				if(checkCycle(u,null,visited))
					return true;
				}
			}
		return false;
	}

	private boolean checkCycle(Vertex u, Vertex parent,
			HashMap<Vertex, Boolean> visited) {
		
		ArrayList<Vertex> adArrayList=u.getAdjacentVertices();
		
		for(Vertex v:adArrayList){
			
			if(!visited.containsKey(v)){
				visited.put(v, true);
				boolean check=checkCycle(v, u, visited);
				if(check){
					return true;
				}
			}
			else if(visited.containsKey(v)&&!v.equals(parent)){
				return true;
			}
		}
		
		return false;
	}

}
