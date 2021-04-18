package epamtc.tasks_03.task_1.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import epamtc.tasks_03.task_1.exception.ArrayIndexOutOfBoundsException;
import epamtc.tasks_03.task_1.exception.ArrayNotSortedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    private static Array array;
    private static List<Integer> arrayList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        int[] a = {10, 23, 3, 243, 5, 77, 3, 345, 6, 4};
        array = new Array(a);
        arrayList.clear();
        for (int i : a) {
            arrayList.add(i);
        }
    }

    @Test
    void get() throws ArrayIndexOutOfBoundsException {
        assertEquals(array.get(0), arrayList.get(0));
        assertEquals(array.get(1), arrayList.get(1));
        assertEquals(array.get(3), arrayList.get(3));
        assertEquals(array.size(), arrayList.size());
        assertEquals(array.get(arrayList.size() - 1), arrayList.get(arrayList.size() - 1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(arrayList.size()));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(arrayList.size() + 100));
    }

    @Test
    void set() {
    }

    @Test
    void add() {
    }

    @Test
    void sortBubble() throws ArrayIndexOutOfBoundsException {
        array.sortInsertion();
        arrayList.sort(Integer::compareTo);
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), array.get(i));
        }
    }

    @Test
    void sortInsertion() throws ArrayIndexOutOfBoundsException {
        array.sortInsertion();
        arrayList.sort(Integer::compareTo);
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), array.get(i));
        }
    }

    @Test
    void getSorted() {
        assertFalse(array.isSorted());
        array.sortBubble();
        assertTrue(array.isSorted());
    }

    @Test
    void lower_bound() throws ArrayNotSortedException, ArrayIndexOutOfBoundsException {
        assertThrows(ArrayNotSortedException.class, () -> array.lower_bound(3));
        array.sortBubble();
        assertEquals(2, array.lower_bound(4));
        assertEquals(0, array.lower_bound(1));
        assertEquals(5, array.lower_bound(7));
        assertEquals(0, array.lower_bound(3));
        assertEquals(7, array.lower_bound(77));
    }

    @Test
    void printArray(){
        System.out.println(array.filterPrimes());
        System.out.println(array.filterFib());
        System.out.println(array.filterHasOnlyThreeDifferentDigits());
        System.out.println(array);
    }

    @Test
    void findMax() throws ArrayIndexOutOfBoundsException {
        assertEquals(arrayList.stream().max(java.lang.Integer::compareTo).get(), array.findMax());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.clear();
            array.findMax();
        });
    }

    @Test
    void findMin() throws ArrayIndexOutOfBoundsException {
        assertEquals(arrayList.stream().min(java.lang.Integer::compareTo).get(), array.findMin());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.clear();
            array.findMin();
        });
    }

    @Test
    void primeArray() {
    }

    @Test
    void getSize() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void sortMerge() throws ArrayIndexOutOfBoundsException {
        array.sortMerge();
        arrayList.sort(Integer::compareTo);
//        System.out.println(array);
//        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), array.get(i));
        }
    }
}