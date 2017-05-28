package repo13;

public class Main {
	public static void main(String[] args) {
		Sorter sorter = new Sorter();
        Comparable[] array = {1,93,2,5,29,44,89,28,22};
        System.out.println("Vorher: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+",");
        }
        System.out.println("");
        System.out.println("------------");
        
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
        System.out.println("------------");
        
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
    }

}
