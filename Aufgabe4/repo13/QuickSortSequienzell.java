package repo13;

public class QuickSortSequienzell {
	  	
		private Comparable array[];
	    private int length;
	    public double time;
	 
	    public void sort(Comparable[] inputArr) {
	         
	    	double startTime = System.currentTimeMillis();
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	        double endTime = System.currentTimeMillis();
	        this.time=endTime-startTime;
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        Comparable pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	     
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which
	             * is greater then the pivot value, and also we will identify a number
	             * from right side which is less then the pivot value. Once the search
	             * is done, then we exchange both numbers.
	             */
	        	
	        	/**
	        	 * compareTo gibt -1 aus wenn links kleiner als rechts ist 
	        	 * gibt 0 aus wenn gleich 
	        	 * gibt 1 aus wenn links größer als rechts
	        	 */
	            while (array[i].compareTo(pivot)<0) {
	                i++;
	            }
	            while (array[j].compareTo(pivot) >0) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        Comparable temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	    public double getTime(){
	    	return time;
	    }
}
