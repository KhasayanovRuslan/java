package task1;

public class ChangePosition <T> {
    private T[] arr;
    private T v;

    public ChangePosition(T[] arr){
        this.arr = arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void changePosition() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                v = arr[i];
                arr[i] = arr[j];
                arr[j] = v;
            }
        }
    }
}
