package edu.guilford;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class PuppySort {
    public static void main(String[] args) {
        // instantiate a scanner object
        Scanner scan = new Scanner(System.in);
        // start time variable
        long startTime;
        // end time variable
        long endTime;
        // duration variable
        long duration;
        // decimal formatter
        DecimalFormat smallFormatter = new DecimalFormat("#.####");

        // instantiate an array of Puppy objects based on user input
        System.out.println("How many puppies would you like to create?");
        int numPuppies = scan.nextInt();
        Puppy[] puppies = new Puppy[numPuppies];
        for (int i = 0; i < numPuppies; i++) {
            puppies[i] = new Puppy();
        }
        // print the array of puppies
        System.out.println("\nHere are the puppies you created:");
        for (int i = 0; i < numPuppies; i++) {
            System.out.println(puppies[i]);
        }

        // sort the array of puppies using the selection sort algorithm and time it
        startTime = System.nanoTime();
        selectionSort(puppies);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        // print the duration of the sort
        System.out.println("\nSelectionSort took " + smallFormatter.format(duration / 1.e6)
                + " milliseconds");
        System.out.println("\nHere are the puppies sorted by weight using selection sort:");
        for (int i = 0; i < numPuppies; i++) {
            System.out.println(puppies[i]);
        }

        // shuffle the array of puppies using the shuffle method
        shuffle(puppies);

        // sort the array of puppies using the quick sort algorithm and time it
        startTime = System.nanoTime();
        quickSort(puppies);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        // print the duration of the sort
        System.out.println("\nQuickSort took " + smallFormatter.format(duration / 1.e6) + " milliseconds");
        System.out.println("\nHere are the puppies sorted by weight using quick sort:");
        for (int i = 0; i < numPuppies; i++) {
            System.out.println(puppies[i]);
        }

        // shuffle the array of puppies using the shuffle method
        shuffle(puppies);

        // use the linear search algorithm to find a random puppy and time it
        Puppy randomPuppy = puppies[(int) (Math.random() * numPuppies)];
        startTime = System.nanoTime();
        int linearIndex = linearSearch(puppies, randomPuppy);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        // print the duration of the search
        System.out.println("\nLinearSearch took " + smallFormatter.format(duration / 1.e6) + " milliseconds");
        System.out.println("\nHere is the puppy you searched for using linear search:");
        System.out.println(puppies[linearIndex]);

        // use the binary search algorithm to find a random puppy and time it
        // first, sort the array of puppies using the quick sort algorithm
        quickSort(puppies);
        // then, search for the random puppy
        startTime = System.nanoTime();
        int binaryIndex = binarySearch(puppies, randomPuppy);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        // print the duration of the search
        System.out.println("\nBinarySearch took " + smallFormatter.format(duration / 1.e6) + " milliseconds");
        System.out.println("\nHere is the puppy you searched for using binary search:");
        System.out.println(puppies[binaryIndex]);
    }

    // add a static selectionSort method that takes an array of Puppy objects as a
    // parameter and sorts them by weight using the selection sort algorithm
    public static void selectionSort(Puppy[] puppies) {
        // loop through the array
        for (int i = 0; i < puppies.length - 1; i++) {
            // set the minimum index to the current index
            int minIndex = i;
            // loop through the array again starting at the next index
            for (int j = i + 1; j < puppies.length; j++) {
                // if the current element is less than the element at the minimum index
                if (puppies[j].getWeight() < puppies[minIndex].getWeight())
                    // set the minimum index to the current index
                    minIndex = j;
            }
            // call the swap method
            swap(puppies, i, minIndex);
        }
    }

    // add a static quickSort method that takes an array of Puppy objects as a
    // parameter and sorts them by weight using the quick sort algorithm
    public static void quickSort(Puppy[] puppies) {
        // call the recursive quickSort method
        quickSort(puppies, 0, puppies.length - 1);
    }

    // add a static recursive quickSort method that takes an array of Puppy objects
    public static void quickSort(Puppy[] puppies, int left, int right) {
        // if the left index is less than the right index
        if (left < right) {
            // partition the array
            int pivotIndex = partition(puppies, left, right);
            // recursively call quickSort on the left and right partitions
            quickSort(puppies, left, pivotIndex - 1);
            quickSort(puppies, pivotIndex + 1, right);
        }
    }

    // add a static partition method that takes an array of Puppy objects
    public static int partition(Puppy[] puppies, int left, int right) {
        // set the pivot element to the rightmost element
        Puppy pivot = puppies[right];
        // set the partition index to the leftmost element
        int partitionIndex = left;
        // loop through the array
        for (int i = left; i < right; i++) {
            // if the current element is less than the pivot element
            if (puppies[i].getWeight() < pivot.getWeight()) {
                // swap the current element with the element at the partition index
                swap(puppies, i, partitionIndex);
                // increment the partition index
                partitionIndex++;
            }
        }
        // swap the pivot element with the element at the partition index
        swap(puppies, right, partitionIndex);
        // return the partition index
        return partitionIndex;
    }

    // add a static linearSearch method that takes an array of Puppy objects
    public static int linearSearch(Puppy[] puppies, Puppy puppy) {
        // loop through the array
        for (int i = 0; i < puppies.length; i++) {
            // if the current element is equal to the Puppy object
            if (puppies[i].equals(puppy)) {
                // return the index of the Puppy object
                return i;
            }
        }
        // return -1
        return -1;
    }

    // add a static binarySearch method that takes an array of Puppy objects
    public static int binarySearch(Puppy[] puppies, Puppy puppy) {
        // set the left index to 0
        int left = 0;
        // set the right index to the length of the array minus 1
        int right = puppies.length - 1;
        // loop while the left index is less than or equal to the right index
        while (left <= right) {
            // set the middle index to the average of the left and right indices
            int middle = (left + right) / 2;
            // if the Puppy object is equal to the element at the middle index
            if (puppy.equals(puppies[middle])) {
                // return the middle index
                return middle;
            }
            // if the Puppy object is less than the element at the middle index
            if (puppy.getWeight() < puppies[middle].getWeight()) {
                // set the right index to the middle index minus 1
                right = middle - 1;
            }
            // if the Puppy object is greater than the element at the middle index
            if (puppy.getWeight() > puppies[middle].getWeight()) {
                // set the left index to the middle index plus 1
                left = middle + 1;
            }
        }
        // return -1
        return -1;
    }

    // add a static swap method that takes an array of Puppy objects and two indices
    public static void swap(Puppy[] puppies, int i, int j) {
        Puppy temp = puppies[i];
        puppies[i] = puppies[j];
        puppies[j] = temp;
    }

    // add a shuffle method that shuffles an array of Puppy objects
    public static void shuffle(Puppy[] puppies) {
        // loop through the array
        for (int i = 0; i < puppies.length; i++) {
            // generate a random index
            int randomIndex = (int) (Math.random() * puppies.length);
            // call the swap method
            swap(puppies, i, randomIndex);
        }
    }
}
