package epamtc.tasks_03.task_2.service;

import epamtc.tasks_03.task_2.exception.NullArrayException;

public class ArrayService {
    public static int sum(int[] a) throws NullArrayException {
        if(a == null)
            throw new NullArrayException("Array must not be null");
        int ans = 0;
        for (int i : a) {
            ans += i;
        }
        return ans;
    }

    public static int max(int[] a) throws NullArrayException {
        if(a == null)
            throw new NullArrayException("Array must not be null");
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int min(int[] a) throws NullArrayException {
        if(a == null)
            throw new NullArrayException("Array must not be null");
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            min = Math.min(min, i);
        }
        return min;
    }
}
