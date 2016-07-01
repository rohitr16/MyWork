package dataStructure2;

import java.util.ArrayList;

public class HeapMax<V> {
	
	ArrayList<PriorityQueue<Integer,V>> heap=new ArrayList<>();

	public int size(){

		return heap.size();
	}

	public boolean isEmpty(){

		return size()==0;
	}

	public void insert(Integer priority,V value){

		PriorityQueue<Integer, V> newNode=new PriorityQueue<>();
		newNode.priority=priority;
		newNode.value=value;
		heap.add(newNode);

		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;


		while(childIndex>0){	
			if(heap.get(childIndex).priority>heap.get(parentIndex).priority){

				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, newNode);
			}
			childIndex=parentIndex;
			parentIndex=(childIndex-1)/2;
		}
	}
	
	public V MaxValue(){
		
		return heap.get(0).value;
	}
	
	public int MaxPriority(){
		
		return heap.get(0).priority;
	}
	
	public void removeMax(){
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		downHeapify(0);
		
	}
	
	public void downHeapify(int index){
		
		if(index>=heap.size()){
			return;
		}
		
		int minIndex=index;
		
		int leftIndex=2*index+1;
		int rightIndex=2*index+2;
		
		if(leftIndex>=heap.size()){
			return;
		}
		
		if(leftIndex<heap.size()&&heap.get(minIndex).priority<heap.get(leftIndex).priority){
			minIndex=leftIndex;
		}
		if(rightIndex<heap.size()&&heap.get(minIndex).priority<heap.get(rightIndex).priority){
			minIndex=rightIndex;
		}
		
		if(minIndex==index){
			return;
		}
		if(minIndex!=index){
			PriorityQueue<Integer, V> temp=heap.get(minIndex);
			heap.set(minIndex, heap.get(index));
			heap.set(index, temp);	
		}
		downHeapify(minIndex);		
	}



}
