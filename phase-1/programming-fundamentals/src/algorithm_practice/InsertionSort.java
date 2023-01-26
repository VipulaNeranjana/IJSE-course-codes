package algorithm_practice;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 6, 3, 9, -1, 4, 0, -3};
        int[] numbers1 = new int[]{-2, -1, 0, 1, 2, 4, 5, 6, 7, 8};

//        System.out.println(Arrays.toString(insertionSortByFor(numbers)));
//        System.out.println(Arrays.toString(insertionSortByWhile(numbers)));
//        System.out.println(Arrays.toString(insertionSortByDoWhile(numbers)));
//        System.out.println(Arrays.toString(insertionSortByRecursion(numbers)));
//        System.out.println(Arrays.toString(insertionSortByForByBinarySearch(numbers)));
//        System.out.println(Arrays.toString(insertionSortByWhileByBinarySearch(numbers)));
        System.out.println(Arrays.toString(insertionSortByDoWhileByBinary(numbers)));
//        System.out.println(findBestIndexByBinarySearchByWhile(numbers1,6,3));
//        System.out.println(Arrays.toString(dropInputInSortedMannerByWhile(numbers1,3,7)));
    }

    public static int[] insertionSortByFor(int[] intArray) {
//        int i= 1;
        for (int i = 1; i < intArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intArray[j] > intArray[i]) {
                    int intermediate = intArray[i];
                    for (int k = i; k > j; k--) {
                        intArray[k] = intArray[k - 1];
                    }
                    intArray[j] = intermediate;
                }
            }
        }
        return intArray;
    }


    /*-------------------------------------------------------------by binary search------------------------------------------------------------------------*/

    public static int[] insertionSortByForByBinarySearch(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            int bestIndex = findBestIndexByBinarySearch(intArray, i, intArray[i]);
            intArray = dropInputInSortedManner(intArray, bestIndex, i);
        }
        return intArray;
    }

    public static int findBestIndexByBinarySearch(int[] intArray, int rotatingIndex, int searchableNo) {
        int index1 = 0;
        int index2 = rotatingIndex - 1;
        for (; true; ) {
            if ((index1 + index2) / 2 == 0) return 0;
            if (intArray[(index1 + index2) / 2] == searchableNo || intArray[1 + (index1 + index2) / 2] == searchableNo)
                return 1 + (index1 + index2) / 2;
            else if (intArray[(index1 + index2) / 2] < searchableNo && intArray[1 + (index1 + index2) / 2] > searchableNo) {
                return 1 + (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] > searchableNo && intArray[-1 + (index1 + index2) / 2] < searchableNo) {
                return (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] < searchableNo) {
                index1 = (index1 + index2) / 2;
                index2 = rotatingIndex;
            } else if (intArray[(index1 + index2) / 2] > searchableNo) {
                index1 = 0;
                index2 = (index1 + index2) / 2;
            }
        }
    }

    public static int[] dropInputInSortedManner(int[] intArray, int index, int rotatingIndex) {
        int intermediate = intArray[rotatingIndex];
        for (int i = rotatingIndex - 1; i >= index; i--) {
            intArray[i + 1] = intArray[i];
        }
        intArray[index] = intermediate;
        return intArray;

        /*-------------------------------------------------------------------------------------------------------------------------------------*/

    }

    public static int[] insertionSortByWhile(int[] intArray) {
        int index1 = 1;
        while (index1 < intArray.length) {
            int index2 = index1 - 1;
            int intermediate = intArray[index1];
            while (index2 >= 0) {
                if (intermediate > intArray[index2]) {
                    break;
                }
                intArray[index2 + 1] = intArray[index2];
                index2--;
            }
            intArray[index2 + 1] = intermediate;
            index1++;
        }
        return intArray;
    }

    /*-------------------------------------------------------binary while---------------------------------------------------------------------*/
    public static int[] insertionSortByWhileByBinarySearch(int[] intArray) {
        int index1 = 1;
        while (index1 < intArray.length) {
            int input = findBestIndexByBinarySearchByWhile(intArray, index1, intArray[index1]);
            intArray = dropInputInSortedMannerByWhile(intArray, input, index1);
            index1++;
        }
        return intArray;
    }

    public static int[] dropInputInSortedMannerByWhile(int[] intArray, int index, int droppableNoIndex) {
        int intermediate = intArray[droppableNoIndex];
        int index1 = droppableNoIndex;
        while (index < index1) {
            intArray[index1] = intArray[index1 - 1];
            index1--;
        }
        intArray[index] = intermediate;
        return intArray;
    }

    public static int findBestIndexByBinarySearchByWhile(int[] intArray, int rotatingIndex, int searchableNo) {
        int index1 = 0;
        int index2 = rotatingIndex;
        while (true) {
            if ((index1 + index2) / 2 == 0 && intArray[1] > intArray[2] || intArray[1 + (index1 + index2) / 2] == searchableNo) {
                return 1 + (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] == searchableNo || (index1 + index2) / 2 == 0) {
                return (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] < searchableNo && intArray[1 + (index1 + index2) / 2] >= searchableNo) {
                return 1 + (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] > searchableNo && intArray[-1 + (index1 + index2) / 2] <= searchableNo) {
                return (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] < searchableNo) {
                index1 = 1 + (index1 + index2) / 2;
                index2 = rotatingIndex - 1;
            } else if (intArray[(index1 + index2) / 2] > searchableNo) {
                index1 = 0;
                index2 = (index1 + index2) / 2;
            }
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------*/
    public static int[] insertionSortByDoWhile(int[] intArray) {
        int index1 = 1;
        do {
            int intermediate = intArray[index1];
            int index2 = index1 - 1;
            do {
                if (intermediate > intArray[index2]) break;
                intArray[index2 + 1] = intArray[index2];
            } while (--index2 >= 0);
            intArray[index2 + 1] = intermediate;
        } while (++index1 < intArray.length);
        return intArray;
    }

    /*------------------------------------------------------------------do while by binary---------------------------------------------------------------------*/

    public static int[] insertionSortByDoWhileByBinary(int[] intArray) {
        int index = 1;
        do {
            int suitableIndex = findBestIndexByBinarySearchByDoWhile(intArray, index,intArray[index]);
            intArray = dropInputInSortedMannerByDoWhile(intArray, suitableIndex, index);
        } while (++index < intArray.length);
        return intArray;
    }

    public static int[] dropInputInSortedMannerByDoWhile(int[] intArray, int index, int droppableNoIndex) {
        int intermediate = intArray[droppableNoIndex];
        int index1 = droppableNoIndex;

        do{
            intArray[index1] = intArray[index1 - 1];
            index1--;
        }while (index < index1);

        intArray[index] = intermediate;
        return intArray;
    }

    public static int findBestIndexByBinarySearchByDoWhile(int[] intArray, int rotatingIndex,int searchableNo) {
        int index1 = 0;
        int index2 = rotatingIndex - 1;
        do {
            if ((index1 + index2) / 2 == 0 && intArray[1] > intArray[2] || intArray[1 + (index1 + index2) / 2] == searchableNo) {
                return 1 + (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] == searchableNo || (index1 + index2) / 2 == 0) {
                return (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] < searchableNo && intArray[1 + (index1 + index2) / 2] >= searchableNo) {
                return 1 + (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] > searchableNo && intArray[-1 + (index1 + index2) / 2] <= searchableNo) {
                return (index1 + index2) / 2;
            } else if (intArray[(index1 + index2) / 2] < searchableNo) {
                index1 = 1 + (index1 + index2) / 2;
                index2 = rotatingIndex - 1;
            } else if (intArray[(index1 + index2) / 2] > searchableNo) {
                index1 = 0;
                index2 = (index1 + index2) / 2;
            }
        } while (true);
    }

    public static int[] insertionSortByRecursion(int[] intArray, int... param) {
        if (param.length == 0) {
            int rotation = 1;
            int start = rotation - 1;
            int intermediate = intArray[rotation];
            return insertionSortByRecursion(intArray, start, rotation, intermediate);
        }
        if (param[1] == intArray.length) return intArray;
        if (param[0] >= 0) {
            if (param[2] > intArray[param[0]]) {
                intArray[param[0] + 1] = param[2];
                int rotation = param[1] + 1;
                int start = rotation - 1;
                int intermediate = intArray[rotation];
                return insertionSortByRecursion(intArray, start, rotation, intermediate);
            }
            if (param[0] == 0 && param[2] < intArray[param[0]]) {
                intArray[param[0] + 1] = intArray[param[0]];
                intArray[param[0]] = param[2];
                int rotation = param[1] + 1;
                int start = rotation - 1;
                if (rotation == intArray.length) {
                    return insertionSortByRecursion(intArray, start, rotation, 0);
                }
                int intermediate = intArray[rotation];
                return insertionSortByRecursion(intArray, start, rotation, intermediate);
            }
            intArray[param[0] + 1] = intArray[param[0]];
            int rotation = param[1];
            int start = param[0] - 1;
            int intermediate = param[2];
            return insertionSortByRecursion(intArray, start, rotation, intermediate);
        }
        return intArray;

    }
}
