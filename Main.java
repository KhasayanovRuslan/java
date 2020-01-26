package Lesson_1.Marathon;

import Lesson_1.Marathon.Comprtitor.*;
import Lesson_1.Marathon.Obstacle.*;

public class Main {
    publis static void main(String[] args) {
        Team team = new Team("Command", new Human("Ivan"), new Human("Petr"), new Dog("Sharik"), new Cat("Barsik"));
        Course course = new Course(new Wall(3), new Water(4), new Cross(100));
        course.doIt(team);
        team.showResults();
    }
}
        