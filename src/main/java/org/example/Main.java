package org.example;

import org.example.animal.Animal;
import org.example.animal.Cat;
import org.example.animal.Dog;
import org.example.animal.FoodBowl;
import org.example.shape.Circle;
import org.example.shape.Rectangle;
import org.example.shape.Triangle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Рыжик");

        dog1.run(300);
        dog2.swim(5);

        cat1.run(150);
        cat2.swim(5);

        System.out.println("Общее количество животных: " + Animal.animalCount);
        System.out.println("Общее количество собак: " + Dog.dogCount);
        System.out.println("Общее количество котов: " + Cat.catCount);

        FoodBowl bowl = new FoodBowl(10);

        cat1.eat(bowl, 1);
        cat2.eat(bowl, 3);

        bowl.addFood(5);

        System.out.println("Количество еды до начала трапезы = " + bowl.getFoodAmount());
        Cat[] cats = {cat1, cat2, cat3};
        for (Cat cat : cats) {
            cat.eat(bowl, 1);
        }
        System.out.println("Количество еды после трапезы = " + bowl.getFoodAmount());

        System.out.println(cat1.getName() + " сыт? " + (cat1.isSatiety() ? "да" : " нет"));
        System.out.println(cat2.getName() + " сыт? " + (cat2.isSatiety() ? "да" : " нет"));
        System.out.println(cat3.getName() + " сыт? " + (cat3.isSatiety() ? "да" : " нет"));

        Circle circle = new Circle(5, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Triangle triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");



        circle.printDetails();
        rectangle.printDetails();
        triangle.printDetails();
    }
}
