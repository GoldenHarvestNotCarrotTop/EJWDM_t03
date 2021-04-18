package epamtc.tasks_03.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import epamtc.tasks_03.task_2.exception.NullArrayException;
import epamtc.tasks_03.task_2.service.JaggedArrayService;

import java.util.Optional;

class JaggedArrayServiceTest {
    int[][] a;

    @BeforeEach
    void before() {
        a = new int[][]{
                {1, 4, 2, 5},
                {1, 5},
                {1, 23, 4, 1, 2, 3, 4, 5, 25},
                {5000},
                {23, 4, 2, 4, 4}};
    }

    @Test
    void sort() throws NullArrayException {
        Optional
        JaggedArrayService.sort(a, (int[] o1, int[] o2) -> o1[0] - o2[0], true);
        printArr();
    }

    void printArr(){
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    @Test
    void sortBySum() throws NullArrayException {
        JaggedArrayService.sortBySum(a, false);
        printArr();
    }

    @Test
    void sortByMax() throws NullArrayException {
        JaggedArrayService.sortByMax(a, false);
        printArr();
    }

    @Test
    void sortByMin() throws NullArrayException {
        JaggedArrayService.sortByMin(a, false);
        printArr();
    }
}