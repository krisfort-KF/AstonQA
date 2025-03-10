package org.example.animal;

public class Cat extends Animal {
    public static int catCount = 0;
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
