package org.vsu.amm;

/**
 * IntegerContainer class: container for working with integers.
 * Implemented with using array
 * */
public class IntegerContainer {
    private int[] elements;
    private int size;

    /**
     * Default constructor
     * Creates container with starting capacity which equals 10 elements
     */
    public IntegerContainer(){
        this.elements = new int[10];
        this.size = 0;
    }

    /**
     * Constructor with setting up an initial capacity
     * @param capacity container's initial capacity
     * @throws IllegalArgumentException when initial capacity is negative
     */
    public IntegerContainer(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException("Negative initial capacity");
        }
        this.elements = new int[capacity];
        this.size = 0;
    }

    /**
     * Adds element to the end of container
     * @param elem element to be added
     */
    public void add(int elem){
        adjustCapacity();
        elements[size++] = elem;
    }

    /**
     * Peeks element at given element
     * @param index index of element to peek
     * @return element at given index
     * @throws IndexOutOfBoundsException if index is negative or bigger than size of the container
     */
    public int elementAt(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return elements[index];
    }

    /**
     * removes element at given index
     * @param index index of the element to be removed
     */
    public void remove(int index){
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    /**
     * Gives an opportunity to remove several elements starting from some index
     * @param index index - the start of range to be removed
     * @param count amount of elements to be removed
     */
    public void removeRange(int index, int count){
        if (index < 0 || count < 0 || index + count > size){
            throw new IndexOutOfBoundsException("Incorrect index or amount of elements");
        }
        System.arraycopy(elements, index+count, elements, index, size-index-count);
    }

    /**
     * Returns current size of the container
     * @return size of the container
     */
    public int size(){
        return size;
    }

    /**
     * Checks if container is empty
     * @return true if container is empty, otherwise false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Enlarges the capacity of the container if it is needed
     */
    private void adjustCapacity(){
        if (size == elements.length){
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
        }
    }
    /**
     * Check if index is in bounds
     * @param index index to be checked
     */
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    /**
     * Getting string view of the container
     * @return string view of the container in template [element_0, element_1, ...]
     */
    @Override
    public String toString(){
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; ++i){
            sb.append(elements[i]);
            if (i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}