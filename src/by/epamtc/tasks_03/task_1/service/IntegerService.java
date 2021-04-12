package epamtc.tasks_03.task_1.service;

import epamtc.tasks_03.task_1.collections.Array;
import epamtc.tasks_03.task_1.exception.ArrayIndexOutOfBoundsException;

import java.util.HashSet;
import java.util.Set;

public class IntegerService {
    private static Array fibCache = new Array(new int[]{0, 1});

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
            if (n % 2 == 0)
                return false;
        }
        return true;
    }

    public static boolean isFib(int n) {
        try {
            for (int i = 0; i < fibCache.getSize(); i++) {
                if (n == fibCache.get(i))
                    return true;
            }
            while (fibCache.get(fibCache.getSize() - 1) <= n && fibCache.get(fibCache.getSize() - 1) > 0) {
                if (n == fibCache.get(fibCache.getSize() - 1))
                    return true;
                fibCache.add(fibCache.get(fibCache.getSize() - 1) + fibCache.get(fibCache.getSize() - 2));
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean hasOnlyThreeDifferentDigits(int n) {
        if (countDigits(n) != 3)
            return false;

        n = Math.abs(n);
        Set<Integer> st = new HashSet<>();
        while (n != 0) {
            if (st.contains(n % 10))
                return false;
            st.add(n % 10);
            n /= 10;

        }
        return true;
    }

    public static int countDigits(int n) {
        int ans = 0;
        n = Math.abs(n);
        while (n != 0) {
            n /= 10;
            ans++;
        }
        return ans;
    }

}
