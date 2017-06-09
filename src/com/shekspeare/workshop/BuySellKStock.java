package com.shekspeare.workshop;

import java.util.ArrayList;
import java.util.List;

public class BuySellKStock {

	
	/** Buy sell one stock* 
	 * Source: EPI Page 70/  
	 * @param args
	 */
	
	public static Double computeMaxProfit(List<Double> prices){
		
		Double minPrice = Double.MAX_VALUE;
		Double maxProfit = 0.0;
		
		for(Double price: prices){
			maxProfit = Math.max(maxProfit, price-minPrice);           //probably these two lines can be swapped ..
			minPrice = Math.min(minPrice, price);
			
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Double> prices = new ArrayList<Double>();
		prices.add(310.0);
		prices.add(275.0);
		prices.add(275.0);
		prices.add(295.0);
		prices.add(260.0);
		prices.add(270.0);
		
		prices.add(290.0);
		prices.add(230.0);
		prices.add(255.0);
		prices.add(250.0);

		System.out.println(computeMaxProfit(prices));
		
	}

}
