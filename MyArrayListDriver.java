
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class MyArrayIndexOutOfBoundException extends RuntimeException

{

public MyArrayIndexOutOfBoundException(String desc)

{

super (desc);

}

}

class MyArrayList<E>

{

E[] arr; // null

public int indx; // e

public static final int DEFAULT_CAPACITY = 10;

public MyArrayList() {

this(DEFAULT_CAPACITY);

}

public MyArrayList(int capacity){

arr =(E[]) new Object[capacity];

}


public MyArrayList(MyArrayList coll){

arr = (E[])new Object[coll.size()];

for(int i=0;i<coll.size();i++)

{

//arr[i] = (E)coll.get(i);

}

}

@Override
public String toString(){

if(size()==0)

return "[]";

String data ="[";

for (int i=0;i<size()-1;i++) {

data += arr[i]+", ";

}

data +=arr[indx-1]+"]";

return data;

}
public int size(){

return indx;

}

public boolean add (E element)

{

if(arr.length==size()){

E[] newArr = (E[])new Object[arr.length];

for(int i=0;i<size();i++){

newArr[i] = arr[i];

}

arr= newArr;

}

arr[indx++] = element;

return true;

}
public boolean contains(E ele) {
	for(int i=0;i<size();i++) {
		if(arr[i].equals(ele)) return true;
	}
	return false;
}
public boolean remove(int indx){ 
	for(int i =indx;i<size();i++) {
		arr[i]=arr[i+1];
	}
	this.indx--;
	return true;
}
public E get(int i) {
	return arr[i];
}
public boolean retainAll(MyArrayList coll) {
	boolean flag = true;
    E[] newArr = (E[])new Object[size()];
    int ind =0;
    
//	boolean [] flagArr = new boolean[coll.size()];
	for(int i=0;i<size();i++) {
		
		if(coll.contains(arr[i])) {
			newArr[ind++]=arr[i];
		}
//		for(int j=0;j<coll.size();j++) {
//			if(!flagArr[j]) {
//				if(arr[i].equals(coll.get(j))) {
//				newArr[ind++]=arr[i];
//				flagArr[j]=true;
//			    }
//			}
//		}
	
	}
	this.indx=ind;
	arr=newArr;
	return flag;
}


}
public class MyArrayListDriver {

	public static void main(String[] args) {
		MyArrayList aa = new MyArrayList();
		aa.add(10);
		aa.add(20);
		aa.add(30);
//		aa.add(null);
//		System.out.println(aa.contains(50));
		MyArrayList ab = new MyArrayList();
		ab.add(20);
		ab.add(50);
		ab.add(40);
		System.out.println(ab);
		aa.retainAll(ab);
		System.out.println(aa);
		List<Integer> arr1 = new CopyOnWriteArrayList<>();
//		List<Integer> arr1 = new ArrayList<>();
		arr1.add(20);
		arr1.add(10);
		arr1.add(30);
		arr1.add(20);
		arr1.add(40);
		arr1.add(50);
		System.out.println(arr1);	
		for(int i:arr1) {
			System.out.println(i);
			if(i==20) {
				arr1.add(10);
			}
		}
		System.out.println(arr1);
		
	}

}
