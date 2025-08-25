package MyCollPackage;
import java.util.*;

class MyLinkedList<E>{
	Node<E> head;
	Node<E> tail;
	int indx;
	private class Node<E>{
		E ele;
		Node<E> next;
		public Node(E ele) {
			this.ele=ele;
		}
	}
	
	@Override
	public String toString() {
		String op ="[";
		if(indx==0) {
			return "[]";
		}else {
			Node<E> currNode = head;
			while(currNode.next!=null) {
				op+=currNode.ele+", ";
				currNode = currNode.next;
			}
			op+=currNode.ele+"]";
		}
		return op;
		
	}
	
	public void add(E ele) {
		Node<E> newNode = new Node<>(ele);
		if(head==null) {
			head = newNode;
			tail = newNode;
		}else {
			Node<E> currNode= head;
			while(currNode.next!=null) {
				currNode=currNode.next;
			}
			currNode.next = newNode;
			tail = newNode;
		}
		indx++;
            
	}
	
	public int size() {
		return indx;
	}
	
	public E getFirst() {
		//if(indx ==0)
		return head.ele;
			
	}
	public E getLast(){
		return tail.ele;
	}
	public E removeFirst() {
		E temp = head.ele;
		head = head.next;
		if(indx==1) tail = null;
		indx--;
		return temp;
	}
	
	public E removeLast() {
		E temp = tail.ele;
		Node<E> currNode = head;
		for(int i=0;i<size()-1;i++) {
			currNode = currNode.next;
		}
		currNode.next = null;
		tail=currNode;
		if(indx==1) head=null;
		indx--;
		return temp;
	}
	
	public E get(int indx) {
		Node<E> currNode =head;
		for(int i=0;i<indx;i++) {
			currNode = currNode.next;
		}
		return currNode.ele;
	}
	public E set(int indx,E ele) {
		Node<E> currNode = head;
		for(int i=0;i<indx;i++) {
			currNode =currNode.next;
			
		}
		E temp = currNode.ele;
		currNode.ele = ele;
		return temp;
	}
	public boolean contains(Object ele) {
		Node<E> currNode = head;
		for(int i=0;i<size();i++) {
			if(ele==null&&currNode.ele==null) {
				return true;
			}
			if(currNode.ele== null)
				continue;
			if(currNode.ele.equals(ele)) return true;
			currNode = currNode.next;
		}
		return false;
	}
	public int indexOf(E ele) {
		Node<E> currNode = head;
		for(int i=0;i<size();i++) {
			if(ele==null&&currNode.ele==null) {
				return i;
			}
			if(currNode.ele== null)
				continue;
			if(currNode.ele.equals(ele)) return i;
			currNode = currNode.next;
		}
		return -1;
	}
	public int lastIndexOf(E ele) {
		Node<E> currNode = head;
//		System.out.print(size()-1);
		for(int i=size()-1;i>=0;i--) {
			if(ele==null&&currNode.ele==null) {
				return i;
			}
			if(currNode.ele== null)             
				continue;
			if(currNode.ele.equals(ele)) return i;
			currNode = currNode.next;
		}
		return -1;
	}
	public void clear() {
		indx=0;
		head=null;
		tail = null;
	}
	
	
}

class DoublyLinkedList<E>{
	Node<E> head;
	Node<E> tail;
	int indx;
	private class Node<E>{
		E ele;
		Node<E> prev;
		Node<E> next;
		public Node(Node prev,E ele) {
			this.ele = ele;
			this.prev =prev;
		}
	}
	public int Size(){
		return indx;
	}
	public void addLast(E ele){
		
		if(indx==0) {
			Node<E> newNode = new Node<>(null,ele);
			head = newNode;
			tail = newNode;
		}else {
			Node<E> newNode = new Node<>(tail,ele);
			tail.next = newNode;
			tail = newNode;
			}
		indx++;
	}
	public void add(E ele){
		addLast(ele);
	}
	
	public void addFirst(E ele) {
		if(indx==0) {
			addLast(ele);
		}else {
			Node<E> newNode = new Node<>(null,ele);
			head.prev = newNode;
			newNode.next=head;
			head=newNode;
			indx++;
		}
		
	}
	public E removeFirst(){
		E temp;
		temp = head.ele;
		head =head.next;
		head.prev.next=null;
		head.prev=null;
		indx--;
		return temp;
	}
	
   public E removeLast() {
	   E temp =tail.ele;
	   tail=tail.prev;
	   tail.next.prev=null;
	   tail.next =null;
	   indx--;
	   return temp;
   }	
	
	@Override
	public String toString() {
		String op ="[";
		if(indx==0) {
			return "[]";
		}else {
			Node<E> currNode = head;
			while(currNode.next!=null) {
				op+=currNode.ele+", ";
				currNode = currNode.next;
			}
			op+=currNode.ele+"]";
		}
		return op;
		
	}
}

public class MyLinkedListDriver {

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(null);
//		System.out.println(ll);
//		ll.clear();
//		System.out.println(ll);
//		System.out.println(ll.contains(10));
		DoublyLinkedList<Integer> list =new DoublyLinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.addFirst(100);
		System.out.println(list);
	    

	}

}
