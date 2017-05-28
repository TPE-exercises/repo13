package repo13;

public class Main {
	public static void main(String[] args) {
		Sorter sorter = new Sorter();
        Comparable[] array = new Comparable[10000];
        fillArray(array);
        System.out.println("Vorher: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+",");
        }
        System.out.println("");
        seperator();
        
        int low = 0;
        int high = array.length - 1;
            
            
        int mid = sorter.partition (array, low, high);
        int first = sorter.partition (array, low, mid - 1);
        int second = sorter.partition (array, mid + 1, high);
        for(int k=low;k<mid;k++){
        	System.out.print(array[k]+",");
        }
        System.out.println("");
        for(int j=mid+1;j<=high;j++){
        	System.out.print(array[j]+",");
        }
        System.out.println("");
        seperator();
        
        QuickSortThread thread2 = new QuickSortThread (sorter, 1, first + 1, mid - 1, array);
        QuickSortThread thread3 = new QuickSortThread (sorter, 2, mid + 1, second - 1, array);
        //QuickSortThread thread4 = new QuickSortThread (sorter, 3, second + 1, high, array);

    
        thread2.start();
        thread3.start();
        //thread4.start();
        
        System.out.println("");
        System.out.println("Nachher: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+",");
        }
        Sorter st = new Sorter();
        System.out.println("");
        System.out.println("Vertauschungen:     "+st.getChange());
        System.out.println("Vergleiche:         "+st.getCompares());
        System.out.println("Rekursionstiefe:    "+st.getRekursion());
        System.out.println("Anzahl der Threads: "+thread2.getThreads());
        System.out.println("Laufzeit:           "+thread2.getTime());
        seperator();
        
       QuickSortSequienzell Quickseq = new QuickSortSequienzell();
       Quickseq.sort(array);
       System.out.println("Sequenziell Zeit: "+Quickseq.getTime());
        
        
    }
	
	public static void seperator(){
		System.out.println("--------------");
	}
	
	public static void fillArray(Comparable[]array){
		for(int i=0; i<array.length;i++){
			array[i]=Math.random()*100;
		} 
	}
	
	
	

}
