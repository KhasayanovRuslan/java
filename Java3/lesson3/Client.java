package lesson3;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    byte[] byteCat = null;
                    try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
                         ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
                        Cat catOut = new Cat("Барсик");
                        objOut.writeObject(catOut);
                        byteCat = barrOut.toByteArray();
                        System.out.println("Кот до сериализации: " + catOut);
                        System.out.println("Вот так он выглядит в байтовом представлении: " + Arrays.toString(byteCat));
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        out.write(byteCat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            t.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}




