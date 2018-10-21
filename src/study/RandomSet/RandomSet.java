package study.RandomSet;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomSet {
    private static Random rnd = new Random(123);

    private int[] values;
    private int lastPos;
    private int capacity;

    public RandomSet() {
        lastPos = 0;
        capacity = 32;
        values = new int[capacity];
    }

    public RandomSet(int size) {
        if (size < 1)
            capacity = 1;
        else
            capacity = size;

        lastPos = 0;
        values = new int[capacity];
    }

    public RandomSet(int amount, int upperBound) {
        capacity = amount;
        values = new int[capacity];

        for (int i = 0; i < capacity; ++i)
            add(rnd.nextInt(upperBound));
    }

    public boolean add(int value) {
        if (lastPos + 1 >= capacity)
            return false;

        if (contains(value))
            return false;

        values[lastPos++] = value;
        return true;
    }

    public RandomSet union(RandomSet rs) {
        if (this.equals(rs)) return this;
        return RandomSet.union(this, rs);
    }

    public RandomSet intersection(RandomSet rs) {
        if (this.equals(rs)) return this;
        return RandomSet.intersection(this, rs);
    }

    public RandomSet difference(RandomSet rs) {
        if (this.equals(rs)) return this;
        return RandomSet.difference(this, rs);
    }

    public boolean contains(int value) {
        return IntStream.of(values).anyMatch(x -> x == value);
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if(index >= capacity) throw new IndexOutOfBoundsException(String.format("Index(%d) Capacity(%d)", index, capacity));

        return values[index];
    }

    public int getCapacity() {
        return capacity;
    }

    public static RandomSet union(@NotNull RandomSet rs1, @NotNull RandomSet rs2) {
        RandomSet tmp = new RandomSet(rs1.capacity + rs2.capacity);
        for (int i = 0; i < rs1.lastPos; ++i)
            tmp.add(rs1.get(i));
        for (int i = 0; i < rs2.lastPos; ++i)
            tmp.add(rs2.get(i));

        return tmp;
    }

    public static RandomSet intersection(@NotNull RandomSet rs1, @NotNull RandomSet rs2) {
        RandomSet tmp = new RandomSet(rs1.capacity + rs2.capacity);
        for (int i = 0; i < rs1.lastPos; ++i) {
            if (rs2.contains(rs1.get(i)))
                tmp.add(rs1.get(i));
        }

        for (int i = 0; i < rs2.lastPos; ++i) {
            if (rs1.contains(rs2.get(i)))
                tmp.add(rs2.get(i));
        }

        return tmp;
    }

    public static RandomSet difference(@NotNull RandomSet rs1, RandomSet rs2) {
        RandomSet tmp = new RandomSet(rs1.getCapacity());

        boolean[] flags = new boolean[rs1.getCapacity()];

        for (int i = 0; i < rs1.getCapacity(); ++i) {
            for (int j = 0; j < rs2.getCapacity(); ++j) {
                if (rs1.get(i) == rs2.get(j)) {
                    flags[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < flags.length; ++i) {
            if (!flags[i]) tmp.add(rs1.get(i));
        }

        return tmp;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < lastPos; ++i) {
            sb.append(values[i]).append("; ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RandomSet))
            return false;
        RandomSet randomSet = (RandomSet) o;
        return lastPos == randomSet.lastPos && capacity == randomSet.capacity && Arrays.equals(values, randomSet.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lastPos, capacity);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
