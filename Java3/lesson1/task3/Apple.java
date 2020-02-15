package task3;

public class Apple extends Fruit {
    private float weightOneFruit = 1.0f;

    public Apple(int number) {
        super(number);
    }

    public int getNumber() {
        return this.number;
    }

    public float getWeightOneFruit() {
        return this.weightOneFruit;
    }
}
