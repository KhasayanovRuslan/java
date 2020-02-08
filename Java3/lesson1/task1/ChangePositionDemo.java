package task1;

import java.util.Arrays;

public class ChangePositionDemo {
    public static void main(String[] args) {
        Integer[] arr = {12, 289, 308, 29, 928, 938, 243, 99, 34, 89};
        ChangePosition<Integer> cp = new ChangePosition<>(arr);
        System.out.println("Исходный массив: " + Arrays.toString(cp.getArr()));

        cp.changePosition();
        System.out.println("Измененный массив: " + Arrays.toString(cp.getArr()));
    }
}