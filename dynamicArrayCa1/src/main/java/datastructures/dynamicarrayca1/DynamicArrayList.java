/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package datastructures.dynamicarrayca1;

import java.util.Arrays;

/**
 *
 * @author Bema Meite
 */
public class DynamicArrayList {
 private String[] array;
    private int size;
    private int capactiy=10;

    public DynamicArrayList() {
       this.capactiy=10;
        this.array = new String[capacity];
        this.size = 0;
    }
 /** * Your dynamic array list should include a constructor that lets the user supply
    an initial array of values to be added.The constructor should take in one
    parameter, a String array, and its contents should be added to the list
    after you initialise the array. The supplied array should be validated,
    and invalid values handled accordingly.
     * @param size**/
    public DynamicArrayList(String[] size) {
        //this.DEFAULT_CAPACITY = 10;
        if (size == null || size.equals(0)) {
            throw new IllegalArgumentException("Initial array cannot be null");
        }
        this.array = Arrays.copyOf(size, Math.max(size.length, DEFAULT_CAPACITY));
        this.size = size.length;
    }
    public int size() {
        return this.size;
    }

    public String get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return array[pos];
    }

    public int indexOf(String str) {
        for (int i = 0; i < size; i++) {
            if (str == null && array[i] == null || str != null && str.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(String str) {
        if (size == array.length) {
            int newCapacity = array.length * 2;
        String[] newArray = new String[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        }
        array[size++] = str;
        return true;
    }
   
    
    /*Your list should contain a method called addAll() that takes one parameter:

An array of Strings to be added. 
All values from this array should be added to the list (nulls included). The method should return nothing. */
    public void addAll(String[] values) {
    if (values == null) {
        throw new IllegalArgumentException("Input array cannot be null");
    }
    if (size + values.length > array.length) {
        throw new IllegalArgumentException("Insufficient space in the list");
    }
    System.arraycopy(values, 0, array, size, values.length);
    size += values.length;
}
    
    /*Your list should contain a method called remove() that takes two parameters: 

The String to be removed (This should not be null). 
An int indicating the position from which to start the removal process.
The first instance of this String found starting at the specified position should be removed from the list. The method should return a boolean indicating if an instance of the String was removed.

Further information:
Sample run:
The list contains:
 ["hi", "Hello", "hi", "hi there", "hi", "farewell"] 
remove("hi", 2) is called. The list should then contain:
 ["hi", "Hello", "hi there", "hi", "farewell"] 
and the method should return true.
Explanation:
Only the first instance was removed, but it's the first instance found STARTING at the specified position (hence the instance in slot 0 still being present after the remove is carried out)
Sample run 2:
The list contains:
 ["hi", "Hello", "hi", "hi there", "hi", "farewell"] 
remove("hi", 4) is called. The list should then contain:
 ["hi", "Hello", "hi there", "hi", "farewell"] 
and the method should return false.
Explanation:
No instances were removed. Even though "hi" is in the list, it doesn't appear anywhere AFTER the supplied position and therefore is not eligible to be removed.
 */
    public boolean remove(String str, int startPos) {
    if (str == null) {
        throw new IllegalArgumentException("String to be removed cannot be null");
    }
    if (startPos < 0 || startPos >= size) {
        throw new IndexOutOfBoundsException("Invalid start position");
    }

    for (int i = startPos; i < size; i++) {
        if (str.equals(array[i])) {
            // Shift elements to the left to remove the found string
            System.arraycopy(array, i + 1, array, i, size - i - 1);
            array[--size] = null; // Clear the last element
            return true;
        }
    }
    return false; // String not found
}
    /*Your list should contain a method called lastIndexOf() that takes one parameter:
The String to be found in the list (This should not be null)
The method should return an int indicating the last position at which the String could
be found. If the String could not be found, an appropriate value should be returned
to indicate this. Comparisons should be done in a case-sensitive manner, and null
should not be acceptable as a parameter for this method. */
    public int lastIndexOf(String str) {
    if (str == null) {
        throw new IllegalArgumentException("String to be found cannot be null");
    }

    for (int i = size - 1; i >= 0; i--) {
        if (str.equals(array[i])) {
            return i;
        }
    }
    return -1; // String not found
}
    
}
