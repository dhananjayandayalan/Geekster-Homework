package Arrays;
/*
Given two sorted arrays A and B,
generate all possible arrays such that
first element is taken from A then from B
then from A and so on in increasing order till the arrays exhausted.
The generated arrays should end with an element from B.

For Example

A = {10, 15, 25}
B = {1, 5, 20, 30}

The resulting arrays are:
  10 20
  10 20 25 30
  10 30
  15 20
  15 20 25 30
  15 30
  25 30
*/

import java.util.*;
public class GenerateArrays {
    public static void main(String[] args) {
        int[] A = {10, 15, 25};
        int[] B = {1, 5, 20, 30};
        solve(A, B, A.length, B.length);
    }

    static void solve(int A[], int B[], int C[], int i, int j, int m, int n,
                      int len, boolean flag)
    {
        if (flag)
        {
            if (len != 0)
                printArr(C, len + 1);

            for (int k = i; k < m; k++)
            {
                if (len == 0)
                {
                    C[len] = A[k];

                    solve(A, B, C, k + 1, j, m, n, len, !flag);
                }

                else if (A[k] > C[len])
                {
                    C[len + 1] = A[k];
                    solve(A, B, C, k + 1, j, m, n, len + 1, !flag);
                }
            }
        }

        else
        {
            for (int l = j; l < n; l++)
            {
                if (B[l] > C[len])
                {
                    C[len + 1] = B[l];
                    solve(A, B, C, i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    public static void solve(int A[], int B[], int m, int n)
    {
        int C[] = new int[m + n];

        solve(A, B, C, 0, 0, m, n, 0, true);
    }

    static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

}
