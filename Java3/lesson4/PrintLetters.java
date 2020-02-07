/* Создать три потока, каждый из которых
   выводит определенную букву (A, B и C) 5 раз
   (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
*/

package lesson4;

public class PrintLetters {
    private final Object obj = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        PrintLetters pL = new PrintLetters();

        Thread t1 = new Thread(() -> {
            pL.printA();
        });
        Thread t2 = new Thread(() -> {
            pL.printB();
        });
        Thread t3 = new Thread(() -> {
            pL.printC();
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        obj.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        obj.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        obj.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

