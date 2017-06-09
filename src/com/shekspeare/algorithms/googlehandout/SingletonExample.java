package com.shekspeare.algorithms.googlehandout;

public class SingletonExample {
	
	
	
		 private static SingletonExample theOneInstance = null;

		 private SingletonExample() {
		 // do stuff to make the object
		 }

		 public static SingletonExample getInstance() {
		 if (theOneInstance == null) {
		 theOneInstance = new SingletonExample();
		 }
		 return theOneInstance;
		 }
	
		 /*
		 Notice that there is no public constructor.  If you want an instance of this class, you 
		 have to call "getInstance()", which ensures that only one instance of the class is ever 
		 made. */
		 
		 
		 
	
}
