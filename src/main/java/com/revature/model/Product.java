package com.revature.model;

import java.util.Objects;

// Product class for drinks with name, price, calories, and category:
// Fully encapsulate class with getters, setters, constructors, toString, hashCode, and equals
// class Product {     // ORIGINAL AI CODE, DID NOT MAKE CLASS PUBLIC
public class Product {
    private String name;
    private double price;
    private int calories;
    private String category;

    public Product() {
    }

    public Product(String name, double price, int calories, String category) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }
    
    public void setCalories(int calories) {
        this.calories = calories;
    }   

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", calories=" + calories + ", category=" + category + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + this.calories;
        hash = 97 * hash + Objects.hashCode(this.category);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.calories != other.calories) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }
}