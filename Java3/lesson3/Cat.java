package lesson3;

import java.io.*;

public class Cat implements Serializable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }
}

