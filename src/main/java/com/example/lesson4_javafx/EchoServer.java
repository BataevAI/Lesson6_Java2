package com.example.lesson4_javafx;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключения клиента ...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            final String messageS = in.readUTF();
                            System.out.println("Получено сообщение от клиента: " + messageS);
                            if (messageS.startsWith("/end")) {
                                out.writeUTF("/end");
                                break;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            while (true) {
                Scanner scr = new Scanner(System.in);
                System.out.println("Введите сообщение... ");
                String messageS = scr.nextLine();
                out.writeUTF(messageS);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
