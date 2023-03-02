package lk.ijse.dep10.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.8.124", 5050);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter something to send:");
            String input = scanner.nextLine();
            outputStream.write(input.getBytes());
        }
    }
}
