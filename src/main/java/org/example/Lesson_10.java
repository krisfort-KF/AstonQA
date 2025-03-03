package org.example;

import java.util.Arrays;

public class Lesson_10 {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("iPhone 12, Pro", "13.10.20", "Apple Inc",
                "Taiwan", 55750, false);
        productsArray[1] = new Product("Realme-C75", "22.11.24", "Realmi",
                "China", 12699, false);
        productsArray[2] = new Product("Xiaomi Redmi-A3", "07.08.23", "Xiaomi",
                "China", 8999, true);
        productsArray[3] = new Product("Samsung Galaxy S25+", "06.11.25", "Samsung Electronics",
                "South Korea", 78960, false);
        productsArray[4] = new Product("Samsung Galaxy S25 Ultra", "25.03.24", "Samsung Electronics",
                "South Korea", 98000, false);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();

        }

        Park.Attraction[] parkArray = new Park.Attraction[3];
        parkArray[0] = new Park.Attraction("Небесный тихоход", "10:00 - 23:00", 590.00);
        parkArray[1] = new Park.Attraction (    "Спортивный батут", "11:00 - 20:00", 440.00);
        parkArray[2] = new Park.Attraction ("Морской бой", "10:00 - 23:00", 690.00);

        Arrays.stream(parkArray).forEach(Park.Attraction::printInfo);
    }

    public static class Product {
        private String name;
        private String manufactureDate;
        private String manufacturer;
        private String countryOfOrigin;
        private double price;
        private boolean isBooked;

        public Product(String name, String manufactureDate, String manufacturer, String originCountry, double price, boolean isBooked) {
            this.name = name;
            this.manufactureDate = manufactureDate;
            this.manufacturer = manufacturer;
            this.countryOfOrigin = originCountry;
            this.price = price;
            this.isBooked = isBooked;
        }

        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Дата производства: " + manufactureDate);
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна происхождения: " + countryOfOrigin);
            System.out.println("Цена: " + price);
            System.out.println("Забронирован: " + (isBooked ? "Да" : "Нет"));

        }
    }

    public static class Park {
        public static class Attraction {
            private String name;
            private String workingHours;
            private double price;

            public Attraction(String name, String workingHours, double price) {
                this.name = name;
                this.workingHours = workingHours;
                this.price = price;
            }
            public void printInfo() {
                System.out.println("Аттракцион: " + name);
                System.out.println("Часы работы: " + workingHours);
                System.out.println("Цена: " + price + " руб.");
            }
        }
    }
}

