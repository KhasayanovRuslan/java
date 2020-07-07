public class SimpleAlgorithms {
    //Возведение в степень
    public static int power(int a, int b) {
        int result = 1;

        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    //Поиск минимального элемента в массиве
    public static int min(int[] arr) {
        int minElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        return minElement;
    }

    //Нахождение среднего арифметического массива
    public static double average(int[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        double average = sum / arr.length;
        return average;
    }

    // В каждом методе происходит линейный поиск внутри массива: необходимо обойти
    // все элементы массива -> n(=arr.length) итераций цикла.
    // Поэтому сложность алгоритмов равняется O(n), линейная сложность.

    public static void main(String[] args) {
        int[] arr = {12, 56, 89, 23, -34, -45, 9, 10,-128};

        System.out.println(power(4,5));
        System.out.println(min(arr));
        System.out.println(average(arr));
    }
}
