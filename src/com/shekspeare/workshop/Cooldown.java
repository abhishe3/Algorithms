package com.shekspeare.workshop;

import java.util.HashMap;
import java.util.Map;

public class Cooldown {

	
	public static int minTimeSlots(int[] tasks, int recoveryInterval){
		  
		  //validate input
		  if(recoveryInterval<0) return -1;
		  
		  if(recoveryInterval==0) return tasks.length;
		  
		 // List<Integer> output = new ArrayList<Integer>();
		  int timeLength = 0;
		  Map<Integer,Integer> priorityMap = new HashMap<Integer,Integer>();
		  
		  //iterate through tasks array
		  for(int i=0;i<tasks.length;i++){
		    
		    Integer index = priorityMap.put(tasks[i],i);
		    
		    if(index!=null){   
		      
		      //calculate diff if already exists in map     
		      int diff = i-index;                               //diff = 2 
		      
		      //till the cooldown is reached, add to length
		      while(diff<=recoveryInterval){      
		        timeLength++;
		        diff++;
		      }
		      
		      //add the task to output 
		      timeLength++;              
		      
		    }else{
		      
		      //task was not encountered before; increment length;
		      timeLength++;  
		      
		    }
		    
		    
		  }
		  
		  return timeLength;
		  
		  
		  
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] tasks = {1,2,3,1,2,3}; //{1,1,2,1};
		
		System.out.print(minTimeSlots(tasks,3));

	}

}
