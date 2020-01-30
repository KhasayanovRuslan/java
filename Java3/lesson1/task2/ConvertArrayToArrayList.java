package task2;

import java.util.*;

public class ConvertArrayToArrayList<T> {
    private T[] arr;
    private ArrayList<T> arrList;

    public ConvertArrayToArrayList(T[] arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public void convertArrayToArrayList(ArrayList<T> arrList) {
        for (int i = 0; i < this.arr.length; i++) {
            T element = this.arr[i];
            arrList.add(element);
        }
    }
}






