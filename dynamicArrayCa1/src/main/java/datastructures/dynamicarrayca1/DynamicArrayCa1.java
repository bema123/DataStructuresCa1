/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package datastructures.dynamicarrayca1;

/**
 *
 * @author Bema Meite
 */
public class DynamicArrayCa1 {
 private String[] array;
    private int size;
    private final int capacity = 10;

    public DynamicArrayCa1() {
        this.array = new String[capacity];
        this.size = 0;
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
    /**Your dynamic array list should include a constructor that lets the user supply
    an initial array of values to be added. The constructor should take in one
    parameter, a String array, and its contents should be added to the list
    after you initialise the array. The supplied array should be validated,
    and invalid values handled accordingly.**/
    
    /*Your list should contain a method called addAll() that takes one parameter:

An array of Strings to be added. 
All values from this array should be added to the list (nulls included). The method should return nothing. */
    
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
    
    /*Your list should contain a method called lastIndexOf() that takes one parameter:
The String to be found in the list (This should not be null)
The method should return an int indicating the last position at which the String could
be found. If the String could not be found, an appropriate value should be returned
to indicate this. Comparisons should be done in a case-sensitive manner, and null
should not be acceptable as a parameter for this method. */
}
