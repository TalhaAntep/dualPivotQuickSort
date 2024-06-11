public class SortingClass {
    public static void dualPivotQuickSort(int[] array, int low, int high) {
        if (low < high) {
            // Comparing and swapping the pivots if necessary
            if (array[low] > array[high]) {
                swap(array, low, high);
            }

            int LP = array[low];
            int RP = array[high];

            int i = low + 1;
            int k = low + 1;
            int j = high - 1;

            // Partitioning between the pivots
            while (k <= j) {
                if (array[k] < LP) {
                    swap(array, k, i);
                    i++;
                } else if (array[k] >= RP) {
                    while (array[j] > RP && k < j) {
                        j--;
                    }
                    swap(array, k, j);
                    j--;

                    if (array[k] < LP) {
                        swap(array, k, i);
                        i++;
                    }
                }
                k++;
            }

            // Swapping the positions of the pivots
            swap(array, low, i-1);
            swap(array, high, j+1);

            // Sorting the array segments
            dualPivotQuickSort(array, low, i-2);
            dualPivotQuickSort(array, i, j);
            dualPivotQuickSort(array, j+2, high);
        }
    }

    // Swapping two elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    static void shellSort(int[] arr) {
        int n = arr.length;

        // first big gap and then reduce it
        int gap = n / 2;
        while( gap > 0 ) {

            // keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add arr[i] to the elements that have been gap sorted
                // save arr[i] in temp and make a hole at position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j=i;
                while( j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                // put temp in its correct location
                arr[j] = temp;

            }
            gap /= 2;
        }
    }

}
