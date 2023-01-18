public class EnhancedForStatement {
    public static void main(String[] args) {
        var nums =  new int[] {10,20,30,40,50};

        for(int i : nums){    /*nums should be iterable*/
            System.out.println(i);
        }
        int sum=0;
        for(int j : nums){
            sum += j;
        }
        System.out.println("sum : " + sum);
    }
}
