package lesson6;

import java.net.*;
import java.io.*;

public class Client {
    int �;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private Server server;

    public Client(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = socket.getInputStream();
            this.out = socket.getOutputStream();

            // ������������ ������ �������
            //������� ����� ����� ���� BufferedReader,
            //��������� ����������� ����� ����� System.in
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
            String str;
            System.out.println("������: ");
            System.out.println("B�e���e ������ ������.");
            System.out.println("B�e���e 'q' ��� ����������.");
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("q"));

            //������������� ������ ������� � �����
            byte buf[] = str.getBytes();

            //������� ������
            out.write(buf);

            // ��������� ����� � ������� ��� �� �����
            while ((� = in.read()) != -1) {
                System.out.print((char) �);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}





    