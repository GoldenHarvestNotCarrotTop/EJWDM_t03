package epamtc.tasks_03.task_1.collections;

import epamtc.tasks_03.task_1.exception.ArrayIndexOutOfBoundsException;
import epamtc.tasks_03.task_1.exception.ArrayNotSortedException;
import epamtc.tasks_03.task_1.service.IntegerService;

import java.util.function.Predicate;

@SuppressWarnings("ManualArrayCopy")
public class Array {
    private int[] array;
    private int size = 0;
    private boolean sorted = false;

    public Array() {
        array = new int[2];
    }

    public Array(int[] array) {
        this.size = array.length;
        this.array = new int[size * 2 + 2];

        for (int i = 0; i < array.length; i++)
            this.array[i] = array[i];
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        return array[index];
    }

    public void set(int value, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        array[index] = value;

        if (isSorted() &&
                ((index != 0 && array[index - 1] > array[index]) ||
                        (index + 1 < size && array[index] > array[index + 1])))
            resetSorted();
    }

    public void add(int value) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2 + 2];
            for (int i = 0; i < array.length; i++)
                newArray[i] = array[i];
            array = newArray;
        }
        array[size] = value;
        size++;

        if (size != 1 && array[size - 2] > array[size - 1] && isSorted())
            resetSorted();
    }


    public void sortBubble() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        setSorted();
    }


    public void sortInsertion() {
        for (int i = 1; i < size; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        setSorted();
    }

    public void sortMerge() {
        array = sortMergeHelper(0, size - 1);
    }

    private int[] sortMergeHelper(int l, int r) {
        if (r - l == 0) {
            return new int[]{array[l]};
        }
        if (r < l)
            return new int[0];
        int mid = l + (r - l) / 2;

        int[] leftArray = sortMergeHelper(l, mid);
        int[] rightArray = sortMergeHelper(mid + 1, r);

        int[] ansArray = new int[r - l + 1];
        int leftPointer = 0;
        int rightPointer = 0;
        int ansPointer = 0;
        while (leftPointer < leftArray.length && rightPointer < rightArray.length) {
            if (leftArray[leftPointer] < rightArray[rightPointer]) {
                ansArray[ansPointer++] = leftArray[leftPointer++];
            } else {
                ansArray[ansPointer++] = rightArray[rightPointer++];
            }
        }
        while (leftPointer < leftArray.length)
            ansArray[ansPointer++] = leftArray[leftPointer++];

        while (rightPointer < rightArray.length)
            ansArray[ansPointer++] = rightArray[rightPointer++];

        return ansArray;

    }


    private void setSorted() {
        sorted = true;
    }

    private void resetSorted() {
        sorted = false;
    }

    public boolean isSorted() {
        return sorted;
    }

    public int lower_bound(int value) throws ArrayNotSortedException, ArrayIndexOutOfBoundsException {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("Array must not be empty when lower bound!");
        if (!isSorted()) {
            throw new ArrayNotSortedException("Array must be sorted before lower bound!");
        }

        int l = 0;
        int h = size;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (value <= array[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findMax() throws ArrayIndexOutOfBoundsException {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("Array must not be empty when find max!");

        if (isSorted())
            return array[size - 1];
        int mx = array[0];
        for (int i = 1; i < size(); i++)
            mx = Math.max(mx, array[i]);
        return mx;
    }

    public int findMin() throws ArrayIndexOutOfBoundsException {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("Array must not be empty when find max!");

        if (isSorted())
            return array[0];
        int mn = array[0];
        for (int i = 1; i < size(); i++)
            mn = Math.min(mn, array[i]);
        return mn;
    }

    public Array filter(Predicate<Integer> predicate) {
        Array a = new Array();
        for (int i = 0; i < size; i++) {
            if (predicate.test(array[i]))
                a.add(array[i]);
        }
        return a;
    }

    public Array filterPrimes() {
        return filter(IntegerService::isPrime);
    }

    public Array filterFib() {
        return filter(IntegerService::isFib);
    }

    public Array filterHasOnlyThreeDifferentDigits() {
        return filter(IntegerService::hasOnlyThreeDifferentDigits);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        resetSorted();
        size = 0;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("Array(");
        for (int i = 0; i < size; i++) {
            ans.append(array[i]).append(", ");

        }
        ans.delete(ans.length() - 2, ans.length()).append(")");
        return ans.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array1 = (Array) o;
        if (size != array1.size)
            return false;
        for (int i = 0; i < size; i++) {
            if(array[i] != array1.array[i]){
               return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (size == 0)
            return 0;
        int result = array[0];
        for (int i = 0; i < size; i++) {
           result = result*31 + array[i];
        }
        return result;
    }
}
