package org.example.arrays;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlipAndInvertImage {

    public static void main(String[] args) {

        Date dummyCutoffDate2 = new Date(1633046400000L);
        System.out.println(dummyCutoffDate2);
        Date dummyCutoffDate3 = new Calendar.Builder().setDate(2024, Calendar.SEPTEMBER, 5).build().getTime();
        System.out.println(dummyCutoffDate3);

        Date cutoffDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7));
        System.out.println(cutoffDate);
        int [][] input = {  {1,1,0},
                            {1,0,1},
                            {0,0,0} };
        int[][] answer = flipAndInvertImage(input);
        System.out.println(Arrays.deepToString(answer));

    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] ints : image) {
            reverseArray(ints);
            flip(ints);
        }
        return image;
    }

    static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] number, int start, int end) {
        int temp = number[start];
        number[start] = number[end];
        number[end] = temp;
    }

    static void flip(int[] number) {
        for (int i = 0; i < number.length; i++) {
            number[i] ^= number[i];
        }
    }
}
