package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.person.ManagePerson;
import fifthSemseter.modSim.src.person.Person;

public class ManagePersonTester {

    public static void main(String[] args) {
        ManagePerson managePerson = new ManagePerson();

        try {
//            managePerson.add(new Person("Test1", "Test2", "street1", "1"));
//            managePerson.add(new Person("Test3", "Test3", "street1", "1"));

            managePerson.add(new Person("Mustermann", "Max", "Maxstrasse", "1"));
            managePerson.add(new Person("Mustermann", "Adam", "Maxstrasse", "1"));
            managePerson.add(new Person("Adams", "Max", "Maxstrasse", "1"));


        } catch (ManagePerson.PersonExist personExist) {
            personExist.printStackTrace();
        }

        System.out.println(managePerson);

        managePerson.sort();

        System.out.println();
        System.out.println(managePerson);

//        try {
//            System.out.println(managePerson.get("Test1", "Test2"));
//            System.out.println();
//        } catch (ManagePerson.PersonNotFound personNotFound) {
//            personNotFound.printStackTrace();
//        }
//
//        try {
//            FileOutputStream fos = new FileOutputStream("/home/dieter/projects/modSim/stuff/dummy.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(managePerson);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ManagePerson inputManagePerson = new ManagePerson();
//
//        try {
//            FileInputStream fis = new FileInputStream("/home/dieter/projects/modSim/stuff/dummy.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            inputManagePerson = (ManagePerson) ois.readObject();
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(inputManagePerson);

    }
}
