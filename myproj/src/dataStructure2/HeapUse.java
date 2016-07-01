package dataStructure2;

public class HeapUse {

	public static void main(String[] args) {
		
		MedianHeap heap=new MedianHeap();
		
		heap.insert(5, 5);
		System.out.println(heap.getMedian());
		heap.insert(15, 15);
		System.out.println(heap.getMedian());
		heap.insert(3, 3);
		System.out.println(heap.getMedian());
		heap.insert(16, 11);
		heap.insert(7, 7);
		System.out.println(heap.getMedian());
		System.out.println(heap.removeMedian());
		System.out.println(heap.getMedian());
//		Heap<Integer> heap=new Heap<>();
//		heap.insert(3, 5);
//		heap.insert(4, 8);
//		heap.insert(1, 9);
//		heap.insert(2, 10);
//		heap.insert(5, 2);
//		heap.insert(7, 3);
//		for(int i=0;i<heap.size();i++){
//			System.out.println(heap.heap.get(i).priority);
//		}
//		heap.removeMin();
//		heap.removeMin();
//		heap.removeMin();
//		heap.removeMin();
//		System.out.println();
//		for(int i=0;i<heap.size();i++){
//			System.out.println(heap.heap.get(i).priority);
//		}

	}

}
