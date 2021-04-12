package task_1.service;

import task_1.collections.Array;
import task_1.exception.NotEnoughDataException;
import task_1.exception.WrongSizeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayService {
    public static Array generateRandomArray(int size) throws WrongSizeException {
        if (size < 0)
            throw new WrongSizeException("Size must be positive integer");

        Array a = new Array();
        for (int i = 0; i < size; i++) {
            a.add(ThreadLocalRandom.current().nextInt(0, 100));
        }
        return a;
    }

    public static Array readArrayFromFile(String fileName, int size) throws FileNotFoundException, NotEnoughDataException {
        File file = new File(fileName);
        Array a;
        try (Scanner scanner = new Scanner(file)) {

            a = new Array();

            while (scanner.hasNext() && a.getSize() != size) {
                a.add(scanner.nextInt());
            }
        }

        if (a.getSize() != size) {
            throw new NotEnoughDataException("File has less integers than size parameter");
        }
        return a;
    }

    public static Array readArrayFromConsole(int size) throws WrongSizeException, NotEnoughDataException {
        if (size < 0)
            throw new WrongSizeException("Size must be positive integer");

        Scanner scanner = new Scanner(System.in);
        Array a = new Array();

        System.out.println("Write integers every in its own line");

        while (scanner.hasNextInt() && a.getSize() != size) {
            a.add(scanner.nextInt());
        }

        if (a.getSize() != size) {
            throw new NotEnoughDataException("Stdin has less integers than size parameter");
        }
        return a;

    }
}
