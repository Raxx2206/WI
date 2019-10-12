package fifthSemseter.modSim.tests;

import fifthSemseter.modSim.src.person.ManagePerson;
import fifthSemseter.modSim.src.person.Person;

import java.io.*;

public class ManagePersonTester {

    public static void main(String[] args) {
        ManagePerson managePerson = new ManagePerson();

        try {
            managePerson.add(new Person("Test1", "Test2", "street1", "1"));
            managePerson.add(new Person("Test3", "Test3", "street1", "1"));

        } catch (ManagePerson.PersonExist personExist) {
            personExist.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream("/home/dieter/projects/modSim/stuff/dummy.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(managePerson);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ManagePerson inputManagePerson = new ManagePerson();

        try {
            FileInputStream fis = new FileInputStream("/home/dieter/projects/modSim/stuff/dummy.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            inputManagePerson = (ManagePerson) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(inputManagePerson);

    }
}
