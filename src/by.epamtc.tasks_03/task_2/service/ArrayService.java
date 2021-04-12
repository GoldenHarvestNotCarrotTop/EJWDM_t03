package task_2.service;

public class ArrayService {
    public static int sum(int[] a) {
        int ans = 0;
        for (int i : a) {
            ans += i;
        }
        return ans;
    }

    public static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int min(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            min = Math.min(min, i);
        }
        return min;
    }
}
