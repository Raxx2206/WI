package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.DynamicArray;
import fifthSemseter.modSim.src.person.Person;

public class DynamicArrayTester {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>(Integer.class);
        dynamicArray1.add(1, 2, 3, 4, 5, 6);
        System.out.println(dynamicArray1);
        System.out.printf("get(): %s\n", dynamicArray1.get(0));
        dynamicArray1.remove(0);
        System.out.println(dynamicArray1);

        System.out.println("\n----------------------------");

        DynamicArray<Double> dynamicArray2 = new DynamicArray<>(Double.class, 3);
        dynamicArray2.add(1.2, 2.2, 2.3);
        System.out.println(dynamicArray2);
        dynamicArray2.add(3.2, 3.5);
        System.out.println(dynamicArray2);

        System.out.println("\n----------------------------");

        DynamicArray<Person> daPerson = new DynamicArray<>(Person.class);
        daPerson.add(new Person("Peter", "John", "street1", "2"));
        System.out.println(daPerson);
    }
}
