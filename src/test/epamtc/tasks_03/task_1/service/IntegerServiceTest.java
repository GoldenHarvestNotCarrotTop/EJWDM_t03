package epamtc.tasks_03.task_1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegerServiceTest {
    @Test
    void isPrime() {
        assertTrue(IntegerService.isPrime(2));
        assertTrue(IntegerService.isPrime(5));
        assertTrue(IntegerService.isPrime(7));
        assertTrue(IntegerService.isPrime(11));
        assertTrue(IntegerService.isPrime(239));
        assertFalse(IntegerService.isPrime(4));
        assertFalse(IntegerService.isPrime(1));
    }

    @Test
    void isFib()  {
        assertTrue(IntegerService.isFib(0));
        assertTrue(IntegerService.isFib(1));
        assertTrue(IntegerService.isFib(2));
        assertTrue(IntegerService.isFib(3));
        assertTrue(IntegerService.isFib(5));
        assertTrue(IntegerService.isFib(8));
    }

    @Test
    void hasOnlyThreeDifferentDigits() {
        assertTrue(IntegerService.hasOnlyThreeDifferentDigits(123));
        assertTrue(IntegerService.hasOnlyThreeDifferentDigits(321));
        assertTrue(IntegerService.hasOnlyThreeDifferentDigits(234));
        assertTrue(IntegerService.hasOnlyThreeDifferentDigits(934));
        assertFalse(IntegerService.hasOnlyThreeDifferentDigits(93234));
        assertFalse(IntegerService.hasOnlyThreeDifferentDigits(4));
        assertFalse(IntegerService.hasOnlyThreeDifferentDigits(34));
        assertFalse(IntegerService.hasOnlyThreeDifferentDigits(2334));

    }
}
