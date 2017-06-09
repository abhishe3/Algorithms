package com.shekspeare.algorithms.threads;


import java.util.concurrent.Semaphore;
public class SemaphoreDemo {

	static Semaphore semaphore = new Semaphore(4);  //Mutex implementation is same but with 1 semaphore ..ie. new Semaphore(1);
	
	
	static class myATMThread extends Thread{
		
		String name = "";
		
		public myATMThread(String name) {
			this.name = name;
		}
		
		public void run(){
			
			try{
			
				System.out.println(name + " : acquiring lock...");
				System.out.println(name + " : available Semaphore permits now: "
							+ semaphore.availablePermits());
			
				semaphore.acquire();
				
				System.out.println(name + " : available Semaphore permits now: "
						+ semaphore.availablePermits());
				
				
				
				try {

					for (int i = 1; i <= 5; i++) {

						System.out.println(name + " : is performing operation " + i
								+ ", available Semaphore permits : "
								+ semaphore.availablePermits());

						// sleep 1 second
						Thread.sleep(1000);
					}

					}finally {

						// calling release() after a successful acquire()
						System.out.println(name + " : releasing lock...");
						semaphore.release();
						System.out.println(name + " : available Semaphore permits now: "
									+ semaphore.availablePermits());

					}
				
				
			}catch (InterruptedException  e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Total available Semaphore permits : "
				+ semaphore.availablePermits());
		
		myATMThread t1 = new myATMThread("A");
		t1.start();
		
		myATMThread t2 = new myATMThread("B");
		t2.start();

		myATMThread t3 = new myATMThread("C");
		t3.start();

		myATMThread t4 = new myATMThread("D");
		t4.start();

		myATMThread t5 = new myATMThread("E");
		t5.start();

		myATMThread t6 = new myATMThread("F");
		t6.start();
	}

}
