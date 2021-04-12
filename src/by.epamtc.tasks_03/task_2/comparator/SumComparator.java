package task_2.comparator;

import task_2.exception.NullArrayException;
import task_2.service.ArrayService;

import java.util.Comparator;

public class SumComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int sum1 = 0;
        int sum2 = 0;
        try {
            sum1 = ArrayService.sum(o1);
            sum2 = ArrayService.sum(o2);
            return sum1 - sum2;
        } catch (NullArrayException e) {
            if (o1 == null)
                return -1;
            else if (o2 == null)
                return 1;
            else
                return 0;
        }
    }

}
