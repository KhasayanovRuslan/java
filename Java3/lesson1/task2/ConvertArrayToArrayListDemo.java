package task2;

import java.util.*;

public class ConvertArrayToArrayListDemo {
    public static void main (String[] args) {
        Integer[] arr = {87, 314, 2, 435, 757, 12, 89, 34, 90, 143};
        ArrayList<Integer> arrList = new ArrayList<>();

        ConvertArrayToArrayList<Integer> conv = new ConvertArrayToArrayList<>(arr);
        conv.convertArrayToArrayList(arrList);

        System.out.println("Array: " + Arrays.toString(conv.getArr()));
        System.out.println("ArrayList: " + arrList);

        arrList.add(34);
        arrList.add(16);
        arrList.add(18);
        System.out.println("ArrayList после добавления новых элементов: " + arrList);
    }
}
