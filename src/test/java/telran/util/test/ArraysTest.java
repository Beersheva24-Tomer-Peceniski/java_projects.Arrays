package telran.util.test;

import static telran.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArraysTest {
    int[] numbers = {10, 7, 12, -4, 13, 3, 14};

    @Test 
    void searchTest() {
        assertEquals(0, search(numbers, 10));
        assertEquals(3, search(numbers, -4));
        assertEquals(6, search(numbers, 14));
        assertEquals(-1, search(numbers, 100));
    }

    @Test 
    void addTest() {
        int newNumber = 100;
        int[] expected = {10, 7, 12, -4, 13, 3, 14, 100};
        assertArrayEquals(expected, add(numbers, newNumber));
    }
}
