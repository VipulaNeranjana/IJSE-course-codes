public class ContinueStatement {
    public static void main(String[] args) {

        forloop :
        for (int i = 0; i <5; i++) {
            System.out.println("For loop!: Start, iteration:"+i);

            int k= 0;
            whileloop :
            while(k++ < 3){
                System.out.println("While loop : start, iteration:"+k);
                if(k==2) continue forloop;
                System.out.println("While loop : end, iteration:"+ k);
            }

            System.out.println("For loop!: End, iteration:"+i+ "\n");
        }
    }
}
