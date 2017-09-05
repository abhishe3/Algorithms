package com.shekspeare.algorithms.epi;


/**
 * EPI page 339 : Greedy Algorithms (Easy)
 * 
 * Given a list of task durations, optimize the task assignment to workers, such that each worker gets exactly two tasks
 * and the total time taken by all workers (in parallel) is minimum.
 * 
 * Soln: By intuition, its most optimum to pair the most time consuming task with the least time consuming task.
 * So sort the array first and then pair the first with the last, second with second last etc..
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class OptimumTaskAssignment {
	

	

	private static class PairedTask{
		
		int task1;
		int task2;
		
		public PairedTask(int task1, int task2){
			this.task1 = task1;
			this.task2 = task2;
		}
	}
	
	
	public static List<PairedTask> optimizeTaskAssignment(List<Integer> taskDuration){
		
		if(taskDuration == null || taskDuration.size()==0) return null;
		List<PairedTask> listOfPairedTask = new ArrayList<PairedTask>();
		
		Collections.sort(taskDuration);
		int size = taskDuration.size();
		for(int i= 0 ; i<size/2; i++){
			
			listOfPairedTask.add(new PairedTask(taskDuration.get(i), taskDuration.get(size-1-i)));
			
		}
		
		return listOfPairedTask;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> taskDuration = new ArrayList<Integer>();
		taskDuration.add(5);
		taskDuration.add(2);
		taskDuration.add(1);
		taskDuration.add(6);
		taskDuration.add(4);
		taskDuration.add(4);

		List<PairedTask> listOfPairedTask = optimizeTaskAssignment(taskDuration);
		
		for(PairedTask pt : listOfPairedTask){
			
			System.out.println(pt.task1+ ","+ pt.task2);
		}
	}

}
