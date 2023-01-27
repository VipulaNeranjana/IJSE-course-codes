package lk.ikse.dep10.myapp;

import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Shout the fk up and tell ur name : ");
        var input = scanner.nextLine();
        System.out.printf("is this ur name it is bull shit, what kind of name is %s",input);
    }
}
