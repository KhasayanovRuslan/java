package task3;

public class Orange extends Fruit {
    private float weightOneFruit = 1.5f;

    public Orange(int number) {
        super(number);
    }

    public int getNumber() {
        return this.number;
    }

    public float getWeightOneFruit() {
        return this.weightOneFruit;
    }
}
