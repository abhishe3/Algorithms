package com.shekspeare.algorithms.googlehandout;

import java.util.Arrays;

public class NearestNeighbors {

	public static class Person implements Comparable<Person>{
		
		String name;
		int position;
		
		Person(String name, int position){
			this.name=name;
			this.position=position;
		}
		
		public int compareTo(Person p){
			
			if(this.position == p.position)  return 0;
			
			if(this.position > p.position) return 1;
			
			else return -1;
			
		}
		
	}
	
	
	public static void findThreeNearestNeighbors (Person[] arr){
		
		if(arr==null || arr.length==0) return;
		
		//First sort the array on the basis of positions
		
		Arrays.sort(arr);
		
		int n = arr.length;
		
		int i =0;
			System.out.println(arr[0].name+"'s neighbors are: "+ arr[1].name +"," + arr[2].name+" and "+arr[3].name);
		
		for( i=1; i<n-2;i++){
			
			System.out.println(arr[i].name+"'s neighbors are: "+ arr[i-1].name +"," + arr[i+1].name+" and "+arr[i+2].name);
		}
		//for n-2
		System.out.println(arr[i].name+"'s neighbors are: "+ arr[i-2].name +"," + arr[i-1].name+" and "+arr[i+1].name);
		i++;
		
		//for n-1 (last element)
		System.out.println(arr[i].name+"'s neighbors are: "+ arr[i-3].name +"," + arr[i-2].name+" and "+arr[i-1].name);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person("A",1);
		Person p2 = new Person("B",2);
		Person p3 = new Person("C",3);
		Person p4 = new Person("D",4);
		Person p5 = new Person("E",5);
		Person p6 = new Person("F",6);
		Person p7 = new Person("G",7);
		Person p8 = new Person("H",8);
		
	//	System.out.println(p1.compareTo(p2));
		Person[] arr = new Person[8];
		
		arr[0] = p1;
		arr[1] = p7;
		arr[2] = p4;
		arr[3] = p8;
		arr[4] = p2;
		arr[5] = p5;
		arr[6] = p3;
		arr[7] = p6;
		
		findThreeNearestNeighbors(arr);
		
		for(Person p: arr){
			System.out.println(p.name);
		}

	}

}
