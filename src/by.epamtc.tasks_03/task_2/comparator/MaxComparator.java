package task_2.comparator;

import task_2.exception.NullArrayException;
import task_2.service.ArrayService;

import java.util.Comparator;

public class MaxComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {

        int max1 = 0;
        int max2 = 0;
        try {
            max1 = ArrayService.max(o1);
            max2 = ArrayService.max(o2);
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
