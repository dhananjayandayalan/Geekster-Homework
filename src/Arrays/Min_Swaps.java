package Arrays;
/*
Given an array of n positive integers and a number k. 
Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1
Explanation: 
To bring elements 2, 1, 3 together, swap 
element '5' with '3' such that final array
will be-
arr[] = {2, 1, 3, 6, 5}

Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
Output: 2
*/
public class Min_Swaps {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 7, 9, 5, 8, 7, 4}, 5));
    }

    public static int solve(int[] arr, int k) {
        int count = 0;
        for(int i : arr) {
            if(i <= k) {
                count++;
            }
        }
        int bad = 0;
        for(int i = 0 ; i < count ; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;
        for(int i = 0, j = count ; j < arr.length ; ++i, ++j) {
            if(arr[i] > k) {
                bad++;
            }

            if(arr[j] > k) {
                bad--;
            }

            ans = Math.max(ans, bad);
        }

        return ans;
    }
}
