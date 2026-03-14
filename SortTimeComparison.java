import java.util.Random;

public class SortTimeComparison {

    // Insertion Sort O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Bubble Sort O(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort O(n log n)
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Random rand = new Random();

        int[] sizes = {1000, 2000, 4000, 8000, 16000};

        for (int n : sizes) {

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            int[] arr3 = new int[n];

            for (int i = 0; i < n; i++) {

                int num = rand.nextInt(10000);

                arr1[i] = num;
                arr2[i] = num;
                arr3[i] = num;
            }

            // Insertion Sort
            long start = System.nanoTime();
            insertionSort(arr1);
            long end = System.nanoTime();
            long insertionTime = end - start;

            // Bubble Sort
            start = System.nanoTime();
            bubbleSort(arr2);
            end = System.nanoTime();
            long bubbleTime = end - start;

            // Quick Sort
            start = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            end = System.nanoTime();
            long quickTime = end - start;

            System.out.println("Input Size: " + n);
            System.out.println("Insertion Sort O(n^2): " + insertionTime + " ns");
            System.out.println("Bubble Sort O(n^2): " + bubbleTime + " ns");
            System.out.println("Quick Sort O(n log n): " + quickTime + " ns");
            System.out.println("-------------------------------");
        }
    }
}