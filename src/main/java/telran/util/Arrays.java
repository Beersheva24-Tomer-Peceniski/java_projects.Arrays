package telran.util;

public class Arrays {
    public static int search(int[] ar, int key) {
        int index = 0;
        while(index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
        // If index == ar.lenght, return -1, else return index
    }

    public static int[] add(int[] ar, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    /*
    * @param oldArray
    * @param index
    * @param number
    * @return reference to a new array containing @param number at @param index
    */

    public static int[] insert(int[] oldArray, int index, int number) {
        int[] newArray = new int[oldArray.length + 1];
        if (index >= 0 && index <= oldArray.length) {
            newArray[index] = number;
            System.arraycopy(oldArray, 0, newArray, 0, index);
            System.arraycopy(oldArray, index, newArray, index + 1, oldArray.length - index);    
        }
        return newArray;
    }
}



/*
oldarray = {1, 2, 3, 4, 5, 6}
new array = {0, 0, 0, 0, 0, 0, 0}
new array = {0, 0, 0, 0, 8, 0, 0}
new array = {1, 2, 3, 4, 8, 0, 0}
new array = 
*/






/*
{1, 2, 3, 4, 5, 6}

add 8 at 4

{1, 2, 3, 4, 8, 5, 6}

ou seja, até a posição 3 ficou igual
da posição 5 até o final ficou igual

*/