package dataStructure2;

import java.util.ArrayList;

import dataStructure.Node;

public class HashMap<K,V> {

	private ArrayList<Node<MapPair<K,V>>> bucket=new ArrayList<>();
	private int size;

	public int size(){
		return size;
	}

	public  HashMap(){
		for(int i=0;i<10;i++){
			bucket.add(null);
		}
	}

	public boolean isEmpty(){
		return size==0;
	}

	private int getBucketIndex(K Key){

		int hashcode=Key.hashCode();
		if(hashcode<0){
			hashcode=-hashcode;
		}
		int bucketIndex=hashcode%bucket.size();
		return bucketIndex;

	}

	public void put(K Key,V Value){

		int bucketIndex=getBucketIndex(Key);
		Node<MapPair<K, V>> head=bucket.get(bucketIndex);
		MapPair<K,V> map=new MapPair<>();
		map.Key=Key;
		map.Value=Value;
		Node<MapPair<K, V>> newNode=new Node<>();
		newNode.data=map;

		if(head==null){
			bucket.set(bucketIndex, newNode);
			size++;
		}

		else{
			Node<MapPair<K, V>> temp=head,prev=null;

			while(temp!=null){

				if(temp.data.Key.equals(Key)){
					temp.data.Value=Value;
					return;
				}
				prev=temp;
				temp=temp.next;
			}

			prev.next=newNode;
			size++;
		}
		
		double loadFactor=(1.0*size)/bucket.size();
		if(loadFactor>=0.75){
			rehash();
		}
	}

	public V get(K Key){

		int bucketIndex=getBucketIndex(Key);
		Node<MapPair<K, V>> head=bucket.get(bucketIndex);

		if(head==null){
			return null;
		}

		Node<MapPair<K, V>> temp=head;

		while(temp!=null){

			if(temp.data.Key.equals(Key)){
				return temp.data.Value;
			}
			temp=temp.next;
		}

		return null;
	}

	public V remove(K Key){

		int bucketIndex=getBucketIndex(Key);
		Node<MapPair<K, V>> head=bucket.get(bucketIndex);

		if(head==null){
			return null;
		}

		Node<MapPair<K, V>> temp=head,prev=null;

		while(temp!=null){

			if(temp.data.Key.equals(Key)){
				if(prev==null){
					prev=head;
					bucket.set(bucketIndex, head.next);
					size--;
					return prev.data.Value;

				}

				V val=temp.data.Value;
				prev.next=temp.next;
				size--;
				return val;	
			}
			prev=temp;
			temp=temp.next;
		}
		return null;
	}
	
	private void rehash(){
		
		ArrayList<Node<MapPair<K, V>>> temp=bucket;
		bucket=new ArrayList<>();
		for(int i=0;i<temp.size()*2;i++){
			bucket.add(null);
		}
		
		size=0;
		
		for(Node<MapPair<K, V>> head:temp){
			Node<MapPair<K, V>> currentNode=head;
			while(currentNode!=null){	
				put(currentNode.data.Key,currentNode.data.Value);
				currentNode=currentNode.next;
			}
		}	
	}
	

}
