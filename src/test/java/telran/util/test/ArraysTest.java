package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Random;
public class ArraysTest {
private static final int N_ELEMENTS = 1_000;
int[] numbers = {10, 7, 12, -4, 13, 3, 14};
@Test
void searchTest() {
    assertEquals(0, search(numbers, 10));
    assertEquals(6, search(numbers, 14));
    assertEquals(3, search(numbers, -4));
    assertEquals(-1, search(numbers,100));
}
@Test
void addTest() {
    int newNumber = 100;
    int [] expected = {10, 7, 12, -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected, add(numbers, newNumber));
}
@Test
void insertTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int newNumber = 30;
    int[] expected_0 ={newNumber, 10, 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, newNumber, -4, 13, 3, 14};
    int[] expected_last = {10, 7, 12,  -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected_0, insert(numbers, 0, newNumber));
    assertArrayEquals(expected_3, insert(numbers, 3, newNumber));
    assertArrayEquals(expected_last, insert(numbers, numbers.length, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, numbers.length + 1, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, -1, newNumber));
}
@Test
void removeTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int[] expected_0 ={ 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, 13, 3, 14};
    int[] expected_last = {10, 7, 12, -4, 13, 3};
    assertArrayEquals(expected_0, remove(numbers,0));
    assertArrayEquals(expected_3, remove(numbers, 3));
    assertArrayEquals(expected_last, remove(numbers, numbers.length-1));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, numbers.length));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, -1));
}

@Test
void sortTest() {
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
    int[] expected = {-4, 3, 7, 10,  12,  13,  14};
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}
@Test
void sortTestRandomArray() {
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length - 1;
    sort(array);
    for(int i = 0; i < limit; i++) {
        assertTrue(array[i] <= array[i + 1]);
    }
}

    @Test 
    void binarySearchTest() {
        int[] arrayTest = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        assertEquals(5, binarySearch(arrayTest, 23));
        // int [] arrayRandom = {-1, -7, -8, 10, 1, 2, 3, 90, 25, -2};
        int[] arrayTest2 = {-8, -7, -2, -1, 1, 2, 3, 10, 25, 90};
        assertEquals(1, binarySearch(arrayTest2, -7));
        assertEquals(-1, binarySearch(arrayTest2, 100));
    }

    @Test
    void insertSortedTest() {
        int[] ar = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int number = 18;
        int[] newAr = {2, 5, 8, 12, 16, 18, 23, 38, 56, 72, 91};
        assertArrayEquals(newAr, insertSorted(ar,number));
        int[] ar2 = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int number2 = 100;
        int[] newAr2 = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91, 100};
        assertArrayEquals(newAr2, insertSorted(ar2,number2));
        int[] ar3 = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int number3 = -20;
        int[] newAr3 = {-20, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        assertArrayEquals(newAr3, insertSorted(ar3,number3));
    }

private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}
}