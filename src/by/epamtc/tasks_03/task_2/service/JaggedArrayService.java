package epamtc.tasks_03.task_2.service;

import epamtc.tasks_03.task_2.comparator.MaxComparator;
import epamtc.tasks_03.task_2.comparator.MinComparator;
import epamtc.tasks_03.task_2.comparator.SumComparator;
import epamtc.tasks_03.task_2.exception.NullArrayException;

import java.util.Comparator;

public class JaggedArrayService {

    public static void sort(int[][] a, Comparator<int[]> cmp, boolean reversed) throws NullArrayException {
        if (a == null)
            throw new NullArrayException("Array must not be null!");
        for (int[] ints : a) {
            if (ints == null)
                throw new NullArrayException("Subarray must not be null!");
        }


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if ((cmp.compare(a[i], a[j]) > 0 && !reversed) ||
                        (reversed && cmp.compare(a[i], a[j]) < 0)) {
                    int[] tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void sortBySum(int[][] a, boolean reversed) throws NullArrayException {
        sort(a, new SumComparator(), reversed);
    }

    public static void sortByMax(int[][] a, boolean reversed) throws NullArrayException {
        sort(a, new MaxComparator(), reversed);
    }

    public static void sortByMin(int[][] a, boolean reversed) throws NullArrayException {
        sort(a, new MinComparator(), reversed);
    }
}
