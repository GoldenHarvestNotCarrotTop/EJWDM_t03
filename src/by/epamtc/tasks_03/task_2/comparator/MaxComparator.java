package epamtc.tasks_03.task_2.comparator;

import epamtc.tasks_03.task_2.exception.NullArrayException;
import epamtc.tasks_03.task_2.service.ArrayService;

import java.util.Comparator;

public class MaxComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {

        try {
            int max1 = ArrayService.max(o1);
            int max2 = ArrayService.max(o2);
            return max1 - max2;
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
