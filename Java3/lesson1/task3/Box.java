package task3;

import java.util.*;

public class Box<T extends Fruit> {
    private float weightBoxFruit;
    private ArrayList<T> boxFruit = new ArrayList<>();
    private Box<T> anotherBoxFruit;
    private T fruit;

    public Box() {

    }

   // public Box(T...fruits){
   //     boxFruit = new ArrayList<>(Arrays.asList(fruits));
  //  }

  //  public Box(ArrayList<T> boxFruit) {
  //      this.boxFruit = boxFruit;
  //  }

    public ArrayList<T> getBoxFruit() {
        return boxFruit;
    }

    public void setBoxFruit(ArrayList<T> boxFruit) {
        this.boxFruit = boxFruit;
    }

    public float getWeight(int number, float weightOneFruit) {
        weightBoxFruit = number * weightOneFruit;
        return weightBoxFruit;
    }

    public boolean compare(Box<? extends Fruit> boxFruit) {
        if (Objects.equals(this.weightBoxFruit, boxFruit.weightBoxFruit))
            return true;
        else
            return false;
    }

    public void addFruitInBox(T fruit) {
        this.boxFruit.add(fruit);
    }

    public void pourFruitInAnotherBox(Box<T> anotherBoxFruit) {
       // Не получается реализовать то, что ниже закомментировано. В чем ошибка?
       // if (anotherBoxFruit.getBoxFruit() instanceof ArrayList<T> && this.getBoxFruit() instanceof ArrayList<T>)
       //       anotherBoxFruit.boxFruit.addAll(this.boxFruit);
        //      this.boxFruit.clear();
        // else
       //       System.out.println("Содержимое коробок отличается по типу");
        anotherBoxFruit.boxFruit.addAll(this.boxFruit);
        this.boxFruit.clear();
    }
}

