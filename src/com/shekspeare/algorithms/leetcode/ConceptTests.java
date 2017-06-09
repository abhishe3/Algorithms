package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConceptTests {
	
	static int i=0;

	public void changeMe(List<Integer> list){
		
		if(list.size() ==5) return;
		
		list.add(new Integer(++i));
		
		changeMe(list);
	}
	
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		ConceptTests sol = new ConceptTests();
		//sol.changeMe(list);
		for(Integer i: list){
			System.out.println(i);
		}
		
		int x =1;
		
		System.out.println(x);

	}

}
