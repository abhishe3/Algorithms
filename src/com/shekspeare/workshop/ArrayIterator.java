package com.shekspeare.workshop;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * http://www.java2s.com/Tutorial/Java/0140__Collections/ImplementsanjavautilIteratoroveranyarray.htm
 * @author abashok
 *
 */
public class ArrayIterator implements java.util.Iterator{
	
	 /** The array to iterate over */    
    protected Object array;
    /** The end index to loop to */
    protected int endIndex = 0;
    /** The current iterator index */
    protected int index = 0;
    
    
    
    /**
     * Constructs an ArrayIterator that will iterate over the values in the
     * specified array.
     *
     * @param array the array to iterate over.
     * @throws IllegalArgumentException if <code>array</code> is not an array.
     * @throws NullPointerException if <code>array</code> is <code>null</code>
     */
    public ArrayIterator(final Object array) {
        setArray(array);
    }


	@Override
	public boolean hasNext() {
		return (index < endIndex);
	}

	@Override
	public Object next() {
		
		 if (hasNext() == false) {
	            throw new NoSuchElementException();
	        }
	        return Array.get(array, index++);
	}
	
	 public void remove() {
	        throw new UnsupportedOperationException("remove() method is not supported");
	    }
	 
	 
	  public Object getArray() {
	        return array;
	    }
	  
	  private void setArray(final Object array) {
	        // Array.getLength throws IllegalArgumentException if the object is not
	        // an array or NullPointerException if the object is null.  This call
	        // is made before saving the array and resetting the index so that the
	        // array iterator remains in a consistent state if the argument is not
	        // an array or is null.
	        this.endIndex = Array.getLength(array);
	        this.array = array;
	        this.index = 0;
	    }

}
