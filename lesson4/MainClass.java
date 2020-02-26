import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        jta.setBackground(Color.cyan);
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);
        JPanel jp = new JPanel(new BorderLayout());
        jp.setPreferredSize(new Dimension(2,30));
        jp.setBackground(Color.green);
        add(jp, BorderLayout.SOUTH);
        JButton jb = new JButton("Отправить");
        jb.setBackground(Color.yellow);
        jp.add(jb, BorderLayout.EAST);
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(1, 20));
        jp.add(jtf, BorderLayout.CENTER);
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ае) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ае) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });
        setVisible(true);
    }
}

class MainClass {
    public static void main(String[] args) {
        new MyWindow();
    }
}
