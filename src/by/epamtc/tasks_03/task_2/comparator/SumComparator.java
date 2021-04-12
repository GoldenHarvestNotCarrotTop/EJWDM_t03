package epamtc.tasks_03.task_2.comparator;

import epamtc.tasks_03.task_2.exception.NullArrayException;
import epamtc.tasks_03.task_2.service.ArrayService;

import java.util.Comparator;

public class SumComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        try {
            int sum1 = ArrayService.sum(o1);
            int sum2 = ArrayService.sum(o2);
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
