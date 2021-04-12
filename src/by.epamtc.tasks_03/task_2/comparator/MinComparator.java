package task_2.comparator;

import task_2.service.ArrayService;

import java.util.Comparator;

public class MinComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int min1 = ArrayService.min(o1);
        int min2 = ArrayService.min(o2);
        return min1 - min2;
    }

}
