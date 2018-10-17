package no.kodia.test;

import java.util.Arrays;

/**
 * This is just a silly implementation of a quicksort-like algorithm.
 * It is likely to be somewhat inaccurate because it was developed within few hours.
 *
 * Complexity is calculated to be about O(n lg n) at best. Let us hope.
 *
 * @author Espen Gjendem
 */
public class SillyQuicksort {

    public static void main(String[] args) {
        SillyQuicksort obj = new SillyQuicksort();
        int[] a = new int[]{872, 23, 1, 5, 4, 8, 2, 3, 44, 55, 66, 92, 12, 334};
        System.out.println(Arrays.toString(a));
        obj.sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Partition the array keeping track of invariants.
     *
     * @param arr Array
     * @param s Index start
     * @param e Index end
     */
    public int partition(int[] arr, int s, int e) {
        int r = e - s; // Range of current position (range-1)
        int p = r / 2 + s; // Median pivot (dividing range and add start)

        int i = s;
        int j = e;

        while (i < j) {
            if (arr[i] > arr[j]) {
                swap(arr, i, j);
            }

            j--;
            i++;
        }

        if (arr[p] < arr[s]) swap(arr, s, p);
        if (arr[p] > arr[e]) swap(arr, e, p);

        if (p > 0 && p < arr.length - 1) {
            if (arr[p] < arr[p - 1]) swap(arr, p - 1, p);
            if (arr[p] > arr[p + 1]) swap(arr, p + 1, p);
        }

        return p;
    }

    /**
     *
     * @param arr Array
     * @param s
     * @param e
     */
    public void sort(int[] arr, int s, int e) {
        if (e <= s) return;

        int p = partition(arr, s, e);
        sort(arr, s, p);
        sort(arr, p+1, e);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
