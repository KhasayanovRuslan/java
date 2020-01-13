class TwoMethodDemo implements Runnable {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];
    Thread t;

    class MyRunnableClass1 implements Runnable {
        @Override
        public void run() {
            try {
                long time = System.currentTimeMillis();
                for (int i = 0; i < h; i++)
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                System.out.println(System.currentTimeMillis() - time);

                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println("Прервано");
            }
        }
    }

    class MyRunnableClass2 implements Runnable {
        @Override
        public void run() {
            try {
                long time = System.currentTimeMillis();
                for (int i = 0; i < h; i++)
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                System.out.println(System.currentTimeMillis() - time);

                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println("Прервано");
            }
        }
    }

    public synchronized void method1() {
        for (int i = 0; i < size; i++) arr[i] = i;

        try {
            long time = System.currentTimeMillis();
            for (int i = 0; i < size; i++)
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println(System.currentTimeMillis() - time);

            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            System.out.println("Прервано");
        }

        System.out.println(arr);
    }

    public synchronized void method2() {
        for (int i = 0; i < size; i++) arr[i] = i;

        long time = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println(System.currentTimeMillis() - time);

        new Thread (new MyRunnableClass1()).start();
        new Thread (new MyRunnableClass2()).start();

        time = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - time);

        System.out.println(arr);
    }

    TwoMethodDemo() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        method2();
    }

    public static void main(String[] args) {
        TwoMethodDemo tmd = new TwoMethodDemo();
        tmd.method1();

        try {
            tmd.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}     


         
  