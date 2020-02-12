/*
Доработать задачу с MFU, реализовать синхронизацию процессов
печати и сканирования (в случае ксерокопии)
*/

package lesson5;

import java.util.concurrent.Semaphore;

public class MFU {
    Object printScanLock = new Object();
    Object mailLock = new Object();
    Semaphore s = new Semaphore(1);

    public void print(String doc, int n) {
        try {
            s.acquire();

            synchronized (printScanLock) {
                System.out.println("Начало печати");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Конец печати");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.release();
        }
    }

    public void scan(String doc, int n) {
        try {
            s.acquire();

            synchronized (printScanLock) {
                System.out.println("Начало сканирования");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Конец сканирования");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.release();
        }
    }

    public void mail(String doc, int n) {
        synchronized (mailLock) {
            System.out.println("Начало отправки скана по почте");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Конец отправки скана по почте");
        }
    }

    public static void main(String[] args) {
        final MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.mail("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 3", 5);
            }
        }).start();
    }
}


