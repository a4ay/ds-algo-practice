import java.util.ArrayList;
import java.util.List;

/***
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
class Main {

    public static void printArray(float[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /***
     * Brute Force Solution
     * @param arr
     * @param k
     * Worst Case => O(N * K) time O(K) space
     */
    public static void avgContiguousSumsBrute(int[] arr, int k) {

        List<Float> avgs = new ArrayList<>();

        for(int i = 0; i <= arr.length - k; ++i) {
            float sum = 0;
            for(int j = i; j < i+k; ++j) {
                sum += arr[j];
            }
            avgs.add(sum/k);
        }

        System.out.print(avgs);
    }

    /***
     * Sliding Window Solution
     * @param arr
     * @param k
     * @return arr of results
     * WorstCase => O(N) time O(K) space
     */
    public static float[] avgContiguousSums(int[] arr, int k) {
        int size = arr.length - k + 1;
        if(size <= 0) return null;
        float[] avgs = new float[size];
        
        int start = 0, end = 0;
        float sum = 0;
        while(end < arr.length) {
            sum += arr[end];
            if(end >= k-1) {
                avgs[start] = sum/k;
                sum -= arr[start];
                start++;
            }
            end++;
        }

        return avgs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        float[] avgs = avgContiguousSums(arr, k);

        printArray(avgs);

        avgContiguousSumsBrute(arr, k);
    }

}