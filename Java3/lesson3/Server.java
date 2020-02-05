package lesson3;

import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte[] byteCat = new byte[512];
                    try {
                        in.readFully(byteCat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteCat);
                         ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
                        Cat catIn = (Cat) objIn.readObject();
                        System.out.println("А вот такого кота мы восстановили из набора байтов: " + catIn);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(10000);
                in.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                out.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                socket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                server.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}


