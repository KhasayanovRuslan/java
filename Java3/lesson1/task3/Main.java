package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(20);
        Orange orange = new Orange(20);
        Orange orange2 = new Orange(20);

        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        boxApple.addFruitInBox(apple);
        boxOrange.addFruitInBox(orange);
        boxOrange2.addFruitInBox(orange2);

        int numberApple = apple.getNumber();
        int numberOrange = orange.getNumber();
        int numberOrange2 = orange2.getNumber();
        float weightOneApple = apple.getWeightOneFruit();
        float weightOneOrange = orange.getWeightOneFruit();

        float weightBoxApple = boxApple.getWeight(numberApple, weightOneApple);
        float weightBoxOrange = boxOrange.getWeight(numberOrange, weightOneOrange);
        float weightBoxOrange2 = boxOrange2.getWeight(numberOrange2, weightOneOrange);
        System.out.println("Вес коробки яблок равен " + weightBoxApple);
        System.out.println("Вес первой коробки апельсинов равен " + weightBoxOrange);
        System.out.println("Вес второй коробки апельсинов равен " + weightBoxOrange2);

        if (boxApple.compare(boxOrange))
            System.out.println("Веса двух сравниваемых коробок равны.");
        else
            System.out.println("Веса двух сравниваемых коробок неравны.");

        boxOrange.pourFruitInAnotherBox(boxOrange2);
        System.out.println("Первая коробка апельсинов: " + boxOrange.getBoxFruit());
        System.out.println("Вторая коробка апельсинов: " + boxOrange2.getBoxFruit());
    }
}
