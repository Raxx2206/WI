package fifthSemseter.modSim.src;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> {
    private static final int CAPACITY_RESIZE_WIDTH = 32;
    private final Class<T> classType;
    private T[] values;
    private int capacity;
    private int lastElementIndex = 0;

    /**
     * Init an simple array with a capacity of 32
     *
     * @param type generic type class
     */
    public DynamicArray(Class<T> type) {
        capacity = CAPACITY_RESIZE_WIDTH;
        classType = type;

        values = newGenericArray(type, capacity);
    }

    /**
     * Init an simple array with a given capacity
     *
     * @param type     generic type class
     * @param capacity initial array size
     */
    public DynamicArray(Class<T> type, int capacity) {
        this.capacity = capacity;
        classType = type;

        values = newGenericArray(type, capacity);
    }

    /**
     * Copy constructor
     *
     * @param dynamicArray DynamicArray to copy
     */
    public DynamicArray(DynamicArray<T> dynamicArray) {
        capacity = dynamicArray.capacity;
        classType = dynamicArray.classType;
        values = newGenericArray(classType, capacity);

        add(dynamicArray);
    }

    /**
     * Generates an simple array of type T.
     *
     * @param type     class type
     * @param capacity initial array size
     * @param <T>      type
     * @return array of type T
     */
    public static <T> T[] newGenericArray(Class<T> type, int capacity) {
        if (capacity < 1)
            capacity = 1;

        @SuppressWarnings("unchecked") final T[] values = (T[]) Array.newInstance(type, capacity);
        return values;
    }

    /**
     * Insert a number of elements in the array. If the array is to small
     * It will be resized
     *
     * @param elements element to insert in the array
     */
    public void add(T... elements) {
        if (lastElementIndex + 1 >= capacity)
            values = resize();

        for (T element : elements)
            values[lastElementIndex++] = element;
    }

    /**
     * Insert a number of elements in the array. If the array is to small
     *
     * @param dynamicArray elements to insert in the array
     */
    public void add(DynamicArray<T> dynamicArray) {
        if (capacity + dynamicArray.capacity >= capacity)
            values = resize(dynamicArray.capacity - capacity + CAPACITY_RESIZE_WIDTH);

        Arrays.stream(dynamicArray.values).forEach(this::add);

    }

    /**
     * Return the element a position index
     *
     * @param index the nth element
     * @return nth element
     */
    public T get(int index) {
        return values[index];
    }

    /**
     * Removes the element at index and shift all elements from index + 1 one left
     *
     * @param index nth element to remove
     * @return true if element is removed, otherwise false
     */
    public boolean remove(int index) {
        if (index > lastElementIndex || index < 0) {
            return false;
        } else {
            if (index != lastElementIndex)
                for (int i = index; i < lastElementIndex; i++)
                    values[i] = values[i + 1];

            values[lastElementIndex--] = null;
            return true;
        }
    }

    /**
     * Create a new array of type T with capacity = capacity + resizeWidth.
     * Copies all elements from the old array in the new one
     *
     * @param resizeWidth resize width
     * @return new array with bigger capacity and all elements
     */
    private T[] resize(int resizeWidth) {
        capacity += resizeWidth;
        T[] newArray = newGenericArray(classType, capacity);

        System.arraycopy(values, 0, newArray, 0, values.length);

        return newArray;
    }

    /**
     * Overloaded method from resize(int resizeWidth).
     * See resize(int resizeWidth)
     *
     * @return new array with bigger capacity and all elements
     */
    private T[] resize() {
        return resize(CAPACITY_RESIZE_WIDTH);
    }

    @Override
    public String toString() {
        return "values=" + Arrays.toString(values);
    }
}
