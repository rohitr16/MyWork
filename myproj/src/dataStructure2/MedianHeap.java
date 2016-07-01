package dataStructure2;

public class MedianHeap {

	private int median;
	HeapMax<Integer> maxHeap;
	Heap<Integer> minHeap;
	public int size;

	public MedianHeap(){
		median=0;
		maxHeap=new HeapMax<>();
		minHeap=new Heap<>();	
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public void insert(int priority,int value){


		if(minHeap.size()==maxHeap.size()){

			if(priority<median){

				maxHeap.insert(priority, value);
				median=maxHeap.MaxPriority();
			}
			else{

				minHeap.insert(priority, value);
				median=minHeap.MinPriority();
			}

		}
		else if(minHeap.size()>maxHeap.size()){

			if(priority<median){

				maxHeap.insert(priority, value);
			}
			else{

				maxHeap.insert(minHeap.MinPriority(), minHeap.MinValue());
				minHeap.removeMin();
				minHeap.insert(priority, value);
			}

			median=(minHeap.MinPriority()+maxHeap.MaxPriority())/2;
		}
		else{
			if(priority<median){

				minHeap.insert(maxHeap.MaxPriority(), maxHeap.MaxValue());
				maxHeap.removeMax();
				maxHeap.insert(priority, value);			
			}
			else{

				minHeap.insert(priority, value);	
			}

			median=(minHeap.MinPriority()+maxHeap.MaxPriority())/2;
		}
	}

	public int getMedian(){

		return median;
	}

	public int removeMedian(){

		if(minHeap.size()==maxHeap.size()){

			minHeap.removeMin();
			maxHeap.removeMax();
			int val=median;
			if(minHeap.size()>=1)
				median=(minHeap.MinPriority()+maxHeap.MaxPriority())/2;	
			else
				median=0;

			return val;
		}
		if(minHeap.size()>maxHeap.size()){

			minHeap.removeMin();
			int val=median;
			if(minHeap.size()>=1)
				median=(minHeap.MinPriority()+maxHeap.MaxPriority())/2;
			else
				median=0;
			
			return val;
		}
		
		maxHeap.removeMax();
		int val=median;
		if(minHeap.size()>=1)
			median=(minHeap.MinPriority()+maxHeap.MaxPriority())/2;
		else
			median=0;
		
		return val;
		
	}


}
