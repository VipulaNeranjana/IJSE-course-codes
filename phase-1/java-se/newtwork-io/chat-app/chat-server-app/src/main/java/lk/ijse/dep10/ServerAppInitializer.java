package lk.ijse.dep10;

import lk.ijse.dep10.shared.Dep10Header;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ServerAppInitializer {
    private static volatile ArrayList<String> userList = new ArrayList<>();
    private static volatile ArrayList<Socket> localSocketList = new ArrayList<>();
    private  static  volatile String chatHistory = "";
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("server is listening to 5050");

        while (true) {
            System.out.println("waiting for incoming message");
            Socket localSocket = serverSocket.accept();
            localSocketList.add(localSocket);
            System.out.println("incoming connection: " + localSocket.getRemoteSocketAddress());

            InetSocketAddress remoteSocketAddress = (InetSocketAddress) localSocket.getRemoteSocketAddress();
            String ipAddress = remoteSocketAddress.getHostName();
            userList.add(ipAddress);
            broadCastUsers();

            new Thread(() -> {
                try {
                    /*To do send chat history*/
                    sendChatHistory(localSocket);
                    /*To do handle the incoming messages*/
                    InputStream inputStream = localSocket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    Dep10Message dep10Message = (Dep10Message) objectInputStream.readObject();
                    if(dep10Message.getHeader() == Dep10Header.MSG){
                        chatHistory += ipAddress + " : " + dep10Message.getBody()+ "\n";
                        broadChatHistory();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    userList.remove(ipAddress);
                    localSocketList.remove(localSocket);
                    broadCastUsers();
                    e.printStackTrace();
                }

            });
        }
    }

    private static void sendChatHistory(Socket localSocket) throws IOException {
        OutputStream outputStream = localSocket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Dep10Message dep10Message = new Dep10Message(Dep10Header.MSG, chatHistory);
        objectOutputStream.writeObject(dep10Message);
        objectOutputStream.flush();
    }

    private static void broadCastUsers(){
        for (Socket socket : localSocketList) {
            new Thread(() -> {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    Dep10Message dep10Message = new Dep10Message(Dep10Header.USERS, userList);
                    objectOutputStream.writeObject(dep10Message);
                    objectOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    private static void broadChatHistory(){
        for (Socket socket : localSocketList) {
            new Thread(() -> {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    Dep10Message dep10Message = new Dep10Message(Dep10Header.MSG, chatHistory);
                    objectOutputStream.writeObject(dep10Message);
                    objectOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
