package Asm2;

public class LinearSearch {
    //Method to perform linear search
    public static int linearSearch(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) { // Check if the current element matches x
                return i; // Return the index of the found element
            }
        }
        return -1; // Return -1 if x is not found

    }

    public static void main(String[] args) {
        // Example array and target value
        int[] array = {10, 25, 30, 40, 50, 5};
        int target = 30;

        // Perform linear search
        int result = linearSearch(array, target);

        // Print the result
        if (result == -1) {
            System.out.println("Element " + target + " not found in the array.");
        } else {
            System.out.println("Element " + target + " found at index " + result + ".");
        }
    }
}
