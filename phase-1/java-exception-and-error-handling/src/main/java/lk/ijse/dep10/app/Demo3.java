package lk.ijse.dep10.app;

import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) {
        try {

            myMethod1();

        }
//        catch (ClassNotFoundException | InterruptedException | SQLException e ){
//            //multi catch claus
//        }
        catch (ClassNotFoundException e){
            System.out.println("class not found exception");
        }catch (InterruptedException e){
            System.out.println("interruption exception");
        }catch (SQLException e){
            System.out.println("SQL exception");
        }

    }
    public static void myMethod1() throws ClassNotFoundException, InterruptedException, SQLException {
        System.out.println("Entering My method 1");
        myMethod2();
        throw new SQLException();        // this method is going to stop here
//        System.out.println("Leaving My method 1");
    }
    public static void myMethod2(){
        System.out.println("Entering My method 2");
        myMethod3();
        System.out.println("Leaving My method 2");
    }
    public static void myMethod3(){
        System.out.println("Entering My method 3");
        System.out.println("Leaving My method 3");
    }
}
