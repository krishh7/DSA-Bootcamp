package org.example.binary_search;

/*
 * Find how many times the array is rotated.
 * Eg : [3, 4, 5, 6, 2]
 * Original array was [2, 3, 4, 5, 6]
 * First rotation = [6, 2, 3, 4, 5]
 * Second = [5, 6, 2, 3, 4]
 * Third = [4, 5, 6, 2, 3]
 * Fourth = [3, 4, 5, 6, 2]
 * Rotated 4 times.
 * formula is always pivot + 1;
 */
public class Q10FindRotationCount {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 2};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] array) {
        int pivot = findPivot(array);
        return pivot + 1;
    }

    /*
     * This method will work for an array which do not have duplicates in it.
     */
    private static int findPivot(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            //case 1
            if (mid < end && array[mid] > array[mid+1]) {
                return mid;
            }
            //case 2
            if (mid > start && array[mid] < array[mid - 1]) {
                return mid - 1;
            }
            //case 3
            if (array[mid] <= array[start]) {
                //eg [4, 5, 6, 3, 2, 1, 0]
                //start 4, mid 3, end 0. For this condition after mid everything will be smaller than start.
                //in that case we will not search for pivot that side. So end gets mid - 1.
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return -1;
    }

    //This will work for array with duplicates
    private static int findPivotWithDuplicates(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            //case 1
            if (mid < end && array[mid] > array[mid+1]) {
                return mid;
            }
            //case 2
            if (mid > start && array[mid] < array[mid - 1]) {
                return mid - 1;
            }
            //case 3
            if (array[mid] == array[start] && array[mid] == array[end]) {
                //check start and end are pivots or not then skip start and end.
                if (array[start] > array[start + 1]) {
                    return start;
                }
                start++;
                if (array[end] < array[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (array[start] < array[mid] || (array[start] == array[mid] && array[mid] > array[end])) {
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return -1;
    }

}
