package org.example.binary_search;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    static int arrangeCoins(int n) {
        long start = 0; long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long current = mid * (mid + 1) / 2;
            if (current == n) {
                return (int) mid;
            } else if (current < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) end;
    }
}
