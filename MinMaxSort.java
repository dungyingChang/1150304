import java.util.Random;

public class MinMaxSort {

    // 自創排序：Min-Max Sort
    public static void minMaxSort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int minIndex = left;
            int maxIndex = right;

            for (int i = left; i <= right; i++) {

                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }

                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            // swap min
            int temp = arr[left];
            arr[left] = arr[minIndex];
            arr[minIndex] = temp;

            // swap max
            temp = arr[right];
            arr[right] = arr[maxIndex];
            arr[maxIndex] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();

        int[] sizes = { 1000, 2000, 4000, 8000 };

        for (int n : sizes) {

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(10000);
            }

            long start = System.nanoTime();
            minMaxSort(arr);
            long end = System.nanoTime();

            System.out.println("Input Size: " + n);
            System.out.println("MinMax Sort Time: " + (end - start) + " ns");
            System.out.println("-------------------------");
        }
    }
}