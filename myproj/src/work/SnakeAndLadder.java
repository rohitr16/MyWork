package work;

import java.util.HashMap;

import dataStructure.QueueLL;


public class SnakeAndLadder {
	
	private static int N=30;
	
	public static int snaleNLadder(int[] sNl){


		
		QueueLL<Vertex<Integer>> queue=new QueueLL<>();
		
		Vertex<Integer> s=new Vertex<>();
		s.vertex=0;
		s.distance=0;
		queue.Enqueue(s);
		HashMap<Integer, Boolean> visited=new HashMap<>();
		visited.put(s.vertex, true);
		Vertex<Integer> parent=new Vertex<>();
		
		while(!queue.isEmpty()){
			
			 parent=queue.Dequeue();
			
			if(parent.vertex==N-1){
				
				break;
			}
			
			for(int i=parent.vertex+1;i<N&&i<=parent.vertex+6;i++){
				
				if(!visited.containsKey(i)){
					
					Vertex<Integer> v=new Vertex<>();			
					v.distance=parent.distance+1;
					
					if(sNl[i]!=-1){
						v.vertex=sNl[i];
					}
					else{
						v.vertex=i;
					}
					visited.put(v.vertex, true);
					queue.Enqueue(v);	
				}
			}	
		}
		
		return parent.distance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sNl=new int[N];
		
		for(int i=0;i<N;i++){
			sNl[i]=-1;
		}

		sNl[2] = 21;
		sNl[4] = 7;
		sNl[10] = 25;
		sNl[19] = 28;

		sNl[26] = 0;
		sNl[20] = 8;
		sNl[16] = 3;
		sNl[18] = 6;
		
		System.out.println(snaleNLadder(sNl));
	}

}
