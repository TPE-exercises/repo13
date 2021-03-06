package repo13;

public class QuickSortThread extends Thread {
	 /** The back-reference to the class containing the sorting routine.*/
    Sorter sorter;
    /** The ID of this thread.*/
    int id;
    /** The lowest index this thread goes in the array.*/
    int low;
    /** The highest index this thread goes in the array.*/
    int high;
    /** The array to be sorted.*/
    Comparable[] array;
    public static int threads =0;
    public double time;
    

   /**
     * @param id The ID of this thread.
     * @param low The lowest index this thread goes in the array.
     * @param high The highest index this thread goes in the array.
     * @param array The array to be sorted.
     */
    public QuickSortThread (Sorter sorter, int id, int low, int high, Comparable[] array)
    {
        this.sorter = sorter;
        this.id = id;
        this.low = low;
        this.high = high;
        this.array = array;
        threads++;
    }

    /**
     * Instantiates the thread and performs the sort on the given array for the
     * specified portions.
     */
    @Override
    public void run()
    {
    	System.out.println("Thread "+id+" gestartet");
    	double startTime = System.currentTimeMillis();
    	
        sorter.sort(array, low, high);
       
        double endTime = System.currentTimeMillis();
        double time = endTime-startTime;
        this.time=time;

 }
    public int getThreads(){
    	return threads;
    }
    public double getTime(){
    	return time;
    }

}
