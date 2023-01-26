package algorithm_practice;

public class Task5 {
    public static void main(String[] args) {
        int[] h = new int[]{1,2,3,4,5,6,7,8};
        find(h);

    }
    public static boolean find(int[] array){
        int input = 1;

        int index1 =0;
        int index2 = array.length-1;
        if(input< array[index1] && input> array[index2]) return false;

        while (true){
        if(array[(index1+index2)/2] == input) return true;
        else if(array[(index1+index2)/2] < input){
            index1=(index1+index2)/2;
            index2 = array.length;
        }
        else if (array[(index1+index2)/2] > input){
            index1=0;
            index2 =(index1+index2)/2 ;
        }
        else if (index1 == index2 && array[index1] != index1) {
            return  false;
        }
        }
    }
}
