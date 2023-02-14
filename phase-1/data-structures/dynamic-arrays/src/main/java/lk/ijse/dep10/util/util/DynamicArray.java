package lk.ijse.dep10.util.util;

import java.util.Arrays;

public class DynamicArray {

    int[] intArray;
    int[] intermediate;

    public void add(String value) {
        if(intArray == null){
            intArray = new int[0];
            intermediate = new int[1];
        }
        int intValue = Integer.parseInt(value);
        intermediate[intermediate.length-1] = intValue;
        intArray = intermediate;
        intermediate = new int[intArray.length+1];
        for (int i = 0; i < intArray.length + 1; i++) {
            if(intArray.length == i) break;
            intermediate[i] = intArray[i];
        }


    }

    public void clear() {
        intArray = new int[0];
    }

    public boolean contains(String value) {
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == Integer.parseInt(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return intArray.length;
    }

    public String get(int index) {
        return Integer.toString(intArray[index]);
    }

    public void remove(int index) {
        int[] intermediate2 = new int[intArray.length-1];
        for (int i = 0; i < intArray.length-1; i++) {
            if(i < index) intermediate2[i] = intArray[i];
            else intermediate2[i] = intArray[i+1];
        }
        intArray = intermediate2;

        intermediate = new int[intArray.length+1];
        for (int i = 0; i < intArray.length; i++) {
            intermediate[i] = intArray[i];
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(intArray);
    }
}
