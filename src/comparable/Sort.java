package comparable;

public class Sort {
	

		protected static void sortArray(String sortierverfahren, Comparable[] array) {
			System.out.println(sortierverfahren);
			System.out.println("Unsortiert:");
			printArray(array);
			if (sortierverfahren.equals("insertionSort")) {
				array = insertionSort1(array);
			} else if (sortierverfahren.equals("shakerSort")) {
				array = shakerSort(array);
			}
			System.out.println("Sortiert:");
			printArray(array);
		}

		private static void printArray(Comparable[] array) {

			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
				if (i != array.length)
					System.out.print(" | ");
			}
			System.out.println();

		}

		private static Comparable[] insertionSort1(Comparable[] numberSequence) {

			for (int i = 1; i < numberSequence.length; i++) {
				Comparable m = numberSequence[i]; // Marker-Field

				int j;
				for (j = i; j > 0 && numberSequence[j - 1].compareTo(m) == 1; j--)
					// for (j =i; j > 0 && numberSequence[j - 1] > m; j--)
					numberSequence[j] = numberSequence[j - 1];

				// Set m to free field
				if (numberSequence[j] != m) {
					numberSequence[j] = m;

				}
			}
			return numberSequence;
		}

		private static Comparable[] shakerSort(Comparable[] numberSequence) {
			boolean swapped;
			boolean moved;

			do {
				swapped = false;
				moved = false;

				// swap left to right
				for (int i = 0; i < numberSequence.length - 1; i++) {

					if (numberSequence[i].compareTo(numberSequence[i + 1]) > 0) {
						
						swap(numberSequence, i, i + 1);
						swapped = true;
						moved = true;

					}

					
				}

				// swap right to left
				for (int i = numberSequence.length - 1; i > 0; i--) {
					if (numberSequence[i].compareTo(numberSequence[i - 1]) < 0) {
						
						swap(numberSequence, i, i - 1);
						swapped = true;
						moved = true;

					}

					
				}

			} while (swapped);

			return numberSequence;
		}

		private static void swap(Comparable[] numberSequence, int idx1, int idx2) {
			Comparable tmp = numberSequence[idx1];
			numberSequence[idx1] = numberSequence[idx2];
			numberSequence[idx2] = tmp;
		}
}
