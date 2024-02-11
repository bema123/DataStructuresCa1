/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import datastructures.dynamicarrayca1.DynamicArrayList;

/**
 *
 * @author michelle
 */
public class DynamicArrayListTest {
    
    public DynamicArrayListTest() {
    }
    
    /**
     * Testing the parameterized constructor, of class DynamicArrayList, with an invalid list size (less than 0).
     */
    @Test
    public void testParameterisedConstructor_InvalidValue_LessThanZero(){
        System.out.println("testing parameterised constructor with an invalid capacity value (less than 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(-1);
        });
    }
    
    /**
     * Testing the parameterized constructor, of class DynamicArrayList, with an invalid list size (equal to 0).
     */
    @Test
    public void testParameterisedConstructor_InvalidValue_EqualToZero(){
        System.out.println("testing parameterised constructor with an invalid capacity value (equal to 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(0);
        });
    }
    
    /**
     * Testing the parameterized constructor, of class DynamicArrayList, with a valid list size.
     */
    @Test
    public void testParameterisedConstructor_ValidValue(){
        System.out.println("testing parameterised constructor with a valid capacity value.");
        DynamicArrayList newList = new DynamicArrayList(5);
        int expResult = 0;
        int result = newList.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing the size method, of class DynamicArrayList, with an empty list.
     */
    @Test
    public void testSize_EmptyList() {
        System.out.println("testing size() with an empty list.");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Testing the size method, of class DynamicArrayList, with a populated list.
     */
    @Test
    public void testSize_PopulatedList() {
        System.out.println("testing size() with a populated list.");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry One");
        instance.add("Entry Two");
        instance.add("Entry Three");
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing valid input with get method, of class DynamicArrayList.
     */
    @Test
    public void testGet_ValidInput() {
        System.out.println("Testing the get method with valid input.");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        String expResult = "Entry One";
        String result = instance.get(1);
        assertEquals(expResult, result);
    }
       
    /**
     * Testing invalid input (below lower bound) with get method, of class DynamicArrayList.
     */
    @Test
    public void testGet_BreakingLowerBound() {
        System.out.println("Testing the get method with invalid input (less than 0).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });
    }
    
    /**
     * Testing invalid input (greater than size) with get method, of class DynamicArrayList.
     */
    @Test
    public void testGet_BreakingUpperBound_GreaterThanSize() {
        System.out.println("Testing the get method with invalid input (greater than the length of the list).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(4);
        });
    }
    
    /**
     * Testing invalid input (equal to size) with get method, of class DynamicArrayList.
     */
    @Test
    public void testGet_BreakingUpperBound_EqualToSize() {
        System.out.println("Testing the get method with invalid input (equal to the length of the list).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });
    }
    
    /**
     * Test of indexOf method with information in the list, of class DynamicArrayList.
     */
    @Test
    public void testIndexOf_TextInList() {
        System.out.println("Testing the indexOf method with information in the list.");
        String text = "Entry Two";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        int expResult = 2;
        int result = instance.indexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method with information in the list, of class DynamicArrayList.
     */
    @Test
    public void testIndexOf_TextNotInList(){
        System.out.println("Testing the indexOf method with information not in the list.");
        String text = "Entry five";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        int expResult = -1;
        int result = instance.indexOf(text);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of add method with empty list, of class DynamicArrayList.
     */
    @Test
    public void testAdd_String() {
        System.out.println("Testing adding a String to the end of the list (with an empty list)");
        String text = "First element";
        DynamicArrayList instance = new DynamicArrayList();
        
        boolean expResult = true;
        boolean result = instance.add(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method with empty list, of class DynamicArrayList.
     */
    @Test
    public void testAdd_AddingTwoElements_String() {
        System.out.println("Testing adding two Strings to a list");
        String text = "First element";
        String text2 = "Second element";
        DynamicArrayList instance = new DynamicArrayList();
        
        boolean expResult = true;
        instance.add(text);
        boolean result = instance.add(text2);
        assertEquals(expResult, result);
        String elem2 = instance.get(1);
        assertEquals("Second element", elem2);
    }    
    
    /**
     * Test of add method where list needs to grow, of class DynamicArrayList.
     */
    @Test
    public void testAdd_GrowingSpace_String() {
        System.out.println("Testing adding enough Strings to a list to trigger growing the array");

        DynamicArrayList instance = new DynamicArrayList();
        boolean result = false;
        boolean expResult = true;
        for(int i = 0; i < 11; i++){
             result = instance.add("Item " + i);
        }
        assertEquals(expResult, result);
        String lastItem = instance.get(10);
        assertEquals("Item 10", lastItem);
    } 
   
    /**
     * Test of set method with valid parameters, of class DynamicArrayList.
     */
    @Test
    public void testSet_ValidParameters() {
        System.out.println("Testing set method with valid parameters");
        int pos = 0;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        String expResult = "First element";
        
        String result = instance.set(pos, text);
        // Confirm method returns correctly
        assertEquals(expResult, result);
        // Confirm data was changed
        assertEquals(text, instance.get(0));
        // Confirm size doesn't decrease
        assertEquals(4, instance.size());
        // Confirm other elements are not changed
        assertEquals("Second element", instance.get(1));
        assertEquals("Third element", instance.get(2));
        assertEquals("Fourth element", instance.get(3));
    }

    /**
     * Test of set method with invalid parameters (position less than 0), of class DynamicArrayList.
     */
    @Test
    public void testSet_InvalidParameters_BreakingLowerBound() {
        System.out.println("Testing set method with invalid parameters (position less than 0)");
        int pos = -1;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }
    
    /**
     * Test of set method with invalid parameters (position greater than size), of class DynamicArrayList.
     */
    @Test
    public void testSet_InvalidParameters_BreakingUpperBound_GreaterThanSize() {
        System.out.println("Testing set method with invalid parameters (position greater than size)");
        int pos = 5;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }

    /**
     * Test of set method with invalid parameters (position equal to size), of class DynamicArrayList.
     */
    @Test
    public void testSet_InvalidParameters_BreakingUpperBound_EqualToSize() {
        System.out.println("Testing set method with invalid parameters (position equal to size)");
        int pos = 4;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }

  /**
     * Test of removeAll method to try and remove something not present, of class DynamicArrayList.
     */
    @Test
    public void testRemoveAll_RemovingSomethingNotPresent() {
        System.out.println("Testing the removeAll method to remove something that doesn't appear");
        String text = "Entry Three";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        boolean expResult = false;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);
        int expSize = 3;
        assertEquals(expSize, instance.size());
    }    
    
    /**
     * Test of removeAll method to remove one instance, of class DynamicArrayList.
     */
    @Test
    public void testRemoveAll_RemovingOneInstance() {
        System.out.println("Testing the removeAll method to remove something that appears once");
        String text = "Entry Zero";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        boolean expResult = true;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);
        int expSize = 2;
        assertEquals(expSize, instance.size());
    }
    
    /**
     * Test of removeAll method to remove multiple instances, of class DynamicArrayList.
     */
    @Test
    public void testRemoveAll_RemovingMultipleInstances() {
        System.out.println("Testing the removeAll method to remove something that appears multiple instances");
        String text = "Entry Zero";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry Zero");
        instance.add("Entry Two");
        instance.add("Entry Zero");
        
        boolean expResult = true;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);
        int expSize = 1;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of isEmpty method with an empty list, of class DynamicArrayList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty with an empty list");
        DynamicArrayList instance = new DynamicArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of isEmpty method with an populated list, of class DynamicArrayList.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        System.out.println("Testing isEmpty with a populated list");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}
