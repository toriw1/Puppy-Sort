package edu.guilford;

import java.text.DecimalFormat;
import java.util.Random;

public class Puppy {

    // attributes
    private String name;
    private int age;
    private String breed;
    private String color;
    private String furtype;
    private String size;
    private double weight;
    private boolean spots;
    private String sex;

    Random rand = new Random();

    // constructor
    public Puppy(String name, String size, double weight, int age, String breed, String color, String furtype,
            boolean spots, String sex) {
        this.name = name;
        this.weight = weight;
        this.spots = spots;
        this.age = age;
        this.breed = breed;
        this.color = color;
        this.furtype = furtype;
        this.size = size;
        this.sex = sex;
    }

    // random constructor that sets the attributes to random values
    public Puppy() {
        // choose a random puppy name from a list of 20
        String[] puppyNames = { "Bella", "Charlie", "Luna", "Lucy", "Max", "Sissy", "Cooper", "Daisy", "Sadie",
                "Molly", "Buddy", "Lola", "Stella", "Tinker", "Bear", "Stevie", "Duke", "Penny", "Sophie", "Harley" };
        int randomName = rand.nextInt(puppyNames.length);
        this.name = puppyNames[randomName];
        // choose a random size from a list of 3
        String[] puppySizes = { "Small", "Medium", "Large" };
        int randomSize = rand.nextInt(puppySizes.length);
        this.size = puppySizes[randomSize];
        // choose a random weight between 1.0 and 100.0 based on the size
        if (this.size == "Small") {
            this.weight = rand.nextDouble() * 15;
        } else if (this.size == "Medium") {
            this.weight = rand.nextDouble() * 50 + 10;
        } else {
            this.weight = rand.nextDouble() * 50 + 50;
        }
        // choose a random age between 0 and 15
        this.age = rand.nextInt(16);
        // choose a random breed from a list of 10
        String[] puppyBreeds = { "Labrador Retriever", "German Shepherd", "Golden Retriever", "Jack Russell",
                "Bulldog", "Poodle", "Beagle", "Rottweiler", "Chihuahua", "Yorkie" };
        int randomBreed = rand.nextInt(puppyBreeds.length);
        this.breed = puppyBreeds[randomBreed];
        // choose a random color from a list of 5
        String[] puppyColors = { "Black", "White", "Brown", "Red", "Yellow" };
        int randomColor = rand.nextInt(puppyColors.length);
        this.color = puppyColors[randomColor];
        // choose a random fur type from a list of 2
        String[] puppyFurTypes = { "Short", "Long" };
        int randomFurType = rand.nextInt(puppyFurTypes.length);
        this.furtype = puppyFurTypes[randomFurType];
        // choose a random boolean for spots based on a list of three options
        String[] puppySpots = { "No Spots", "Few Spots", "Many Spots" };
        int randomSpots = rand.nextInt(puppySpots.length);
        if (puppySpots[randomSpots] == "No Spots") {
            this.spots = false;
        } else {
            this.spots = true;
        }
        // choose a random sex based on a list of two options
        String[] puppySex = { "Female", "Male" };
        int randomSex = rand.nextInt(puppySex.length);
        this.sex = puppySex[randomSex];
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getFurtype() {
        return furtype;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isSpots() {
        return spots;
    }

    public String getSex() {
        return sex;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFurtype(String furtype) {
        this.furtype = furtype;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSpots(boolean spots) {
        this.spots = spots;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // methods
    public void bark() {
        System.out.println("Woof!");
    }

    public void eat() {
        System.out.println("Yum!");
    }

    public void cuddle() {
        System.out.println("Pet me!");
    }

    public void play() {
        System.out.println("Let's play!");
    }

    // write a method to help analyze weights of puppies
    public void weightAnalysis() {
        if (weight < 10) {
            System.out.println("This puppy is very small!");
        } else if (weight >= 10 && weight < 20) {
            System.out.println("This puppy is small!");
        } else if (weight >= 20 && weight < 40) {
            System.out.println("This puppy is medium!");
        } else if (weight >= 40 && weight < 60) {
            System.out.println("This puppy is large!");
        } else if (weight >= 60) {
            System.out.println("This puppy is very large!");
        }
    }

    // toString method
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return "Name: " + name + ", Size: " + size + ", Weight: " + formatter.format(weight) + ", Age: " + age
                + ", Breed: " + breed + ", Color: " + color + ", Fur Type: " + furtype + ", Spots: " + spots + ", Sex: "
                + sex;
    }
}
