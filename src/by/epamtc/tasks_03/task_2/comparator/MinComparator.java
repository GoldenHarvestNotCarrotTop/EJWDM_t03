package epamtc.tasks_03.task_2.comparator;

import epamtc.tasks_03.task_2.exception.NullArrayException;
import epamtc.tasks_03.task_2.service.ArrayService;

import java.util.Comparator;

public class MinComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        try {
            int min1 = ArrayService.min(o1);
            int min2 = ArrayService.min(o2);
            return min1 - min2;
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
