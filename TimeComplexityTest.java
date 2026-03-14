import java.util.Random;

public class TimeComplexityTest {

    // Linear Scan O(n)
    public static int linearSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

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

    // Merge Sort O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] sizes = { 1000, 2000, 4000, 8000, 16000 };

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

            // Linear Scan
            long start = System.nanoTime();
            linearSum(arr1);
            long end = System.nanoTime();
            long linearTime = end - start;

            // Insertion Sort
            start = System.nanoTime();
            insertionSort(arr2);
            end = System.nanoTime();
            long insertionTime = end - start;

            // Merge Sort
            start = System.nanoTime();
            mergeSort(arr3, 0, arr3.length - 1);
            end = System.nanoTime();
            long mergeTime = end - start;

            System.out.println("Input Size: " + n);
            System.out.println("Linear Scan O(n): " + linearTime + " ns");
            System.out.println("Insertion Sort O(n^2): " + insertionTime + " ns");
            System.out.println("Merge Sort O(n log n): " + mergeTime + " ns");
            System.out.println("------------------------------");
        }
    }
}