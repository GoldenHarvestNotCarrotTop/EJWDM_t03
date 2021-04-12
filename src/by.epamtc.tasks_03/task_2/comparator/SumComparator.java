package task_2.comparator;

import task_2.service.ArrayService;

import java.util.Comparator;

public  class SumComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int sum1 = ArrayService.sum(o1);
        int sum2 = ArrayService.sum(o2);
        return sum1 - sum2;
    }

}
