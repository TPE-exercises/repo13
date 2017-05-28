package repo13;

public class Sorter implements SortAlgorithm {
	public static int changes = 0;
	public static int compare = 0;
	public static int rekursion=0;

	public void sort(Comparable[] array, int low, int high) {

		if (low < high) {
			// Locate the most precise partition point
			int mid = partition(array, low, high);
			// Recursively sort the lower half
			sort(array, low, mid - 1);
			// Recursively sort the upper half
			sort(array, mid + 1, high);
			rekursion++;
		}
	}

	/**
	 * Finds the most logical point to split the array in two parts and uses
	 * that point as the partition. Uses a while loop to evaluate the partition.
	 *
	 * @param array
	 *            The array to be sorted.
	 * @param low
	 *            The lowest index.
	 * @param high
	 *            The highest index.
	 * @return The index of the partitioning point.
	 */
	public int partition(Comparable[] array, int low, int high) {
		Comparable pivot = array[high];
		int left = low;
		int right = high - 1;

		while (left <= right) {
			// Increment the low pointer until you meet the pivot
			while (array[left].compareTo(pivot) < 0) {
				++left;
				compare++;
			}
			// Decrement the high pointer until you meet the pivot
			while (array[right].compareTo(pivot) > 0) {
				--right;
				compare++;
			}

			// If the pointers have crossed, swap the items
			if (left < right) {
				// Swap value at left with value at right
				swap(array, left, right);
			}
		}

		// Finally, swap value at left with value at high
		swap(array, left, high);

		return left;
	}

	/**
	 * Swaps the two indeces in the array given.
	 *
	 * @param array
	 *            The array to perform the swap on.
	 * @param first
	 *            Swap this index with element at second.
	 * @param second
	 *            Swap this index with element at first.
	 */
	public void swap(Comparable[] array, int first, int second) {
		Comparable temp = array[first];
		array[first] = array[second];
		array[second] = temp;
		changes++;
	}

	public static int getChange() {
		return changes;
	}

	public static int getCompares() {
		return compare;
	}
	public static int getRekursion(){
		return rekursion;
	}
	

}
