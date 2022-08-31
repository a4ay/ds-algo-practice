import java.sql.Array;
import java.util.ArrayList;

/***
 * Problem Statement #
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 * 
 * Example 1:
 * 
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 * 
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 * 
 */
class Solution {

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /***
     * Two pointer solution
     * @param arr
     * @return
     * Complexity: O(N) time O(1) space
     */
    public static int remove(int[] arr) {
        int leftPtr = 1, rightPtr = 1;

        while(rightPtr < arr.length && leftPtr < arr.length) {
            if(arr[rightPtr-1] != arr[rightPtr]) { 
                arr[leftPtr] = arr[rightPtr];
                ++leftPtr;
            }
            ++rightPtr;
        }

        return leftPtr;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr)  );
        // print(arr);

        arr = new int[]{2, 2, 2, 11};
        System.out.println(remove(arr) );
        // print(arr);
    }
}