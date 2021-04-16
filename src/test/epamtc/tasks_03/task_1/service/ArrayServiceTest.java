package epamtc.tasks_03.task_1.service;

import org.junit.jupiter.api.Test;
import epamtc.tasks_03.task_1.exception.NotEnoughDataException;
import epamtc.tasks_03.task_1.exception.WrongSizeException;

import java.io.FileNotFoundException;

class ArrayServiceTest {

    @Test
    void generateRandomArray() throws WrongSizeException {
        System.out.println(ArrayService.generateRandomArray(30));
    }

    @Test
    void readArrayFromFile() throws FileNotFoundException, NotEnoughDataException {
        System.out.println(ArrayService.readArrayFromFile("test.txt", 3));
    }

    @Test
    void readArrayFromConsole() throws WrongSizeException, NotEnoughDataException {
        System.out.println(ArrayService.readArrayFromConsole(30));
    }
}