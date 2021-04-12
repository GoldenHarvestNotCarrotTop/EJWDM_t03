package task_2.comparator;

import task_2.service.ArrayService;

import java.util.Comparator;

public class MaxComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int max1 = ArrayService.max(o1);
        int max2 = ArrayService.max(o2);
        return max1 - max2;
    }

}
