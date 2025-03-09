package org.example;

public class Lesson_11 {
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

        System.out.println(cat1.name + " сыт? " + (cat1.isSatiety() ? "да" : " нет"));
        System.out.println(cat2.name + " сыт? " + (cat2.isSatiety() ? "да" : " нет"));
        System.out.println(cat3.name + " сыт? " + (cat3.isSatiety() ? "да" : " нет"));

        Circle circle = new Circle(5, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Triangle triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");



        circle.printDetails();
        rectangle.printDetails();
        triangle.printDetails();
    }

    public static abstract class Animal {
        protected String name;
        protected static int animalCount = 0;

        public Animal(String name) {
            this.name = name;
            animalCount++;
        }

        public void run(int distance) {
            System.out.println(name + " пробежал " + distance + " м.");
        }

        public void swim(int distance) {
            System.out.println(name + " проплыл " + distance + " м.");
        }

        public int getAnimalCount() {
            return animalCount;
        }
    }

    static class Dog extends Animal {
        private static int dogCount = 0;

        public Dog(String name) {
            super(name);
            dogCount++;
        }

        public static int getDogCount() {
            return dogCount;
        }

        @Override
        public void run(int distance) {
            if (distance <= 500) {
                super.run(distance);
            } else {
                System.out.println(name + " не может пробежать больше 500 м.");
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= 10) {
                super.swim(distance);
            } else {
                System.out.println(name + " не может плавать больше 10 м.");
            }
        }
    }

    static class Cat extends Animal {
        private static int catCount = 0;
        private boolean satiety;

        public Cat(String name) {
            super(name);
            catCount++;
        }

        public static int getCatCount() {
            return catCount;
        }

        @Override
        public void run(int distance) {
            if (distance <= 200) {
                super.run(distance);
            } else {
                System.out.println(name + " не может пробежать больше 200 м.");
            }
        }

        @Override
        public void swim(int distance) {
            System.out.println(name + " не умеет плавать.");
        }

        public void eat(FoodBowl bowl, int needFoodAmount) {
            satiety = bowl.eatFood(needFoodAmount);
            if (satiety) {
                System.out.println(name + " поел и теперь сыт.");
            } else {
                System.out.println("В миске недостаточно еды для " + name);
            }
        }

        public boolean isSatiety() {
            return satiety;
        }
    }

    static class FoodBowl {
        private int foodAmount;

        public FoodBowl(int foodAmount) {
            this.foodAmount = foodAmount;
        }

        public int getFoodAmount() {
            return foodAmount;
        }

        public boolean eatFood(int amount) {
            if (foodAmount >= amount) {
                foodAmount -= amount;
                return true;
            }
            return false;
        }

        public void addFood(int amount) {
            foodAmount += amount;
        }
    }

    //задание №2

    interface Shape {
        int getArea();

        int getPerimeter();

        default void printInfo() {
            System.out.println("Периметр: " + getPerimeter() + ". Площадь: " + getArea() + ". ");

        }
    }

    abstract static class ColoredShape implements Shape {
        protected String fillColor;
        protected String borderColor;

        public ColoredShape(String fillColor, String borderColor) {
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public void printColors() {
            System.out.println("Цвет заливки - " + fillColor + ". Цвет контура - " + borderColor + ".");
        }
    }

    static class Circle extends ColoredShape {
        private int radius;

        public Circle(int radius, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.radius = radius;
        }

        @Override
        public int getArea() {
            return (int) (Math.PI * radius * radius);
        }

        @Override
        public int getPerimeter() {
            return (int) (2 * Math.PI * radius);
        }

        public void printDetails() {
            System.out.print("\nФигура - Круг. ");
            printInfo();
            printColors();
        }
    }

    static class Rectangle extends ColoredShape {
        private int width, height;

        public Rectangle(int width, int height, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.width = width;
            this.height = height;
        }

        @Override
        public int getArea() {
            return width * height;
        }

        @Override
        public int getPerimeter() {
            return 2 * (width + height);
        }

        public void printDetails() {
            System.out.print("\nФигура - Прямоугольник. ");
            printInfo();
            printColors();
        }
    }

    static class Triangle extends ColoredShape {
        private int a, b, c;

        public Triangle(int a, int b, int c, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int getArea() {
            int s = (a + b + c) / 2;
            return (int) Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public int getPerimeter() {
            return a + b + c;
        }

        public void printDetails() {
            System.out.print("\nФигура - Треугольник. ");
            printInfo();
            printColors();
        }
    }
}
