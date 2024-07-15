package telran.util;

public class Arrays {
public static int search(int[] ar, int key){
    int index = 0;
    while(index < ar.length && key != ar[index]) {
        index++;
    }
    return index == ar.length ? -1 : index;
}
public static int[] add(int [] ar, int number) {
    int [] res = java.util.Arrays.copyOf(ar, ar.length + 1);
    res[ar.length] = number;
    return res;
}
/**
 * 
 * @param ar
 * @param index
 * @param number
 * @return reference to a new array containing @param number at @param index
 */
public static int[] insert(int[] ar, int index, int number) {
    //creates new array with all elements from the given "ar" and
    //the given "number" at the given index
    //to apply System.arraycopy method 
    int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
    System.arraycopy(ar, index, res, index + 1, ar.length - index);
    res[index] = number;
    return res; 
}
/**
 * 
 * @param numbers
 * @param index
 * @return new array with no removed from @param numbers number at @param index
 */
public static int[] remove(int[] numbers, int index) {
    //creates new array with no element in "numbers" at "index"
    //to apply System.arraycopy method 
    int[] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
    System.arraycopy(numbers, index + 1, res, index, res.length - index);
    return res;

}
private static boolean pushMaxAtEnd(int [] ar, int length) {
    boolean res = true;
    for(int i = 0; i < length; i++) {
        if (ar[i] > ar[i + 1]) {
            res = false;
            swap(ar, i, i + 1);
        }
    }
    return res;
}
private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
}

public static void sort(int [] ar) {
    int length = ar.length ;
    boolean flSorted = false;
    while(!flSorted) {
        length--;
        flSorted = pushMaxAtEnd(ar, length);
    }
}

/**
 * 
 * @param ar - sorted array
 * @param key - being searched number 
 * @return see comments definition
 */
public static int binarySearch(int [] ar, int key) {
    int max = ar.length - 1;
    int min = 0;
    while(min <= max) {
        int half = (max + min) / 2;
        if(key > ar[half]) {
            min = half + 1;
        } else if(key < ar[half]) {
                max = half - 1;
        } else{
            return half;
    }
    }
    return -1;
}    

public static int[] insertSorted(int[] arSorted, int number) {
    int [] newArSorted = java.util.Arrays.copyOf(arSorted, arSorted.length + 1);
    int index = 0;
    while (index < newArSorted.length - 1) {
        if(number < newArSorted[index]) {
            break;
        }
        index++;
    }
    newArSorted[index] = number;
    System.arraycopy(arSorted, index, newArSorted, index + 1, arSorted.length - index);
    return newArSorted;
}

public static boolean isOneSwap(int [] array) {
    //TODO
    //return true if a given array has exactly one swap to get sorted array
    //the swaped array's elements may or may not be neighbors 
    return false;

}
}