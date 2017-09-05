package com.shekspeare.algorithms.leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;


/**
 *  
Give a stream of stock prices, design a data structure to support the following operations:

1) StockSticker(int k) Initialize the size of the ticker.
2) void addOrUpdate(String stock, double price) add or update the price of a stock to the data structure.
3) List<Map.Entry<String, double>> top() return the top k price stocks and their current prices.
 
 **/

public class StockTicker {
	
	private int k;
	private HashMap<String, Double> map;
	private TreeSet<Map.Entry<String, Double>> set;    //**PTR : See how a map entry is stored in a TreeSet

	
	public StockTicker(int k) {
		this.k = k;
		map = new HashMap<String,Double>();
		set = new TreeSet<Map.Entry<String, Double>> (new Comparator<Map.Entry<String, Double>>() {
		
			public int compare(Map.Entry<String, Double> entry1, Map.Entry<String, Double> entry2){
				
				int res = entry2.getValue().compareTo(entry1.getValue());
				
				if(res==0){
					return entry2.getKey().compareTo(entry1.getKey());
				}
				
				return res;
			}

		});
		
	}
	
	
	public void addOrUpdate(String stock,  double price)  {
		AbstractMap.SimpleEntry<String, Double> entry =  new AbstractMap.SimpleEntry<String, Double>(stock,  price);	//** PTR: See how a Map.Entry is instantiated
			
		if (map.containsKey(stock)) {
				set.remove(new AbstractMap.SimpleEntry<String, Double>(stock, map.get(stock)));	    				
		}
		map.put(stock, price);
    	set.add(entry);     		
	}
	
	public List<Map.Entry<String, Double>> top() {
		List<Map.Entry<String, Double>> ls = new ArrayList<>();
		int i = 0;
	
		Iterator<Map.Entry<String, Double>> setIterator = set.iterator();
		while (i  <  k && setIterator.hasNext()) {
			ls.add(setIterator.next());
			i++;
		}
		return ls;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
