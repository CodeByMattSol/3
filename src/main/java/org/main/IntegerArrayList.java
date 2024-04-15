package org.main;

import java.util.Arrays;

public class IntegerArrayList {
    private int[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntegerArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }

    public IntegerArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = new int[initialCapacity];
        } else {
            throw new IllegalStateException("Capacity can't be less then 0!");
        }
    }

    private int isIndexExist(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Элемент не найден!");
        }

        return index;
    }

    private int[] increaseCapacity() {
        int[] temp = new int[(elementData.length * 2)];
        System.arraycopy(elementData, 0, temp, 0, elementData.length);

        return temp;
    }

    public int get(int index) {
        isIndexExist(index);
        return elementData[index];
    }

    public int size() {
        return size;
    }

    public boolean add (int value) {
        if (size == elementData.length) {
            elementData = increaseCapacity();
        }

        elementData[size] = value;
        size++;

        return true;
    }

    public int set(int value, int index) {
        isIndexExist(index);
        int temp  = elementData[index];
        elementData[index] = value;
        return temp;
    }

    @Override
    public String toString() {
        int[] temp = new int[size];
        System.arraycopy(elementData, 0, temp, 0, size);

        return Arrays.toString(temp);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int remove(int index) {
        isIndexExist(index);
        int[] temp = elementData;
        elementData = new int[temp.length - 1];
        int value  = temp[index];
        System.arraycopy(temp, 0, elementData, 0, index);
        System.arraycopy(temp, index+1, elementData, index, temp.length - index - 1);

        size--;
        return value;
    }
}
