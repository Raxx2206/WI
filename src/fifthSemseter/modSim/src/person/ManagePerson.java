package fifthSemseter.modSim.src.person;

import java.io.Serializable;
import java.util.Vector;

public class ManagePerson implements Serializable {
    private Vector<Person> people = new Vector<>();

    public void add(Person p) throws PersonExist {
        try {
            get(p.getLastname(), p.getForename());

            throw new PersonExist(p.getLastname(), p.getForename());
        } catch (PersonNotFound personNotFound) {
            people.add(p);
        }
    }

    public Person get(String lastname, String forename) throws PersonNotFound {
        for (Person p : people) {
            if (p.getLastname().equals(lastname) && p.getForename().equals(forename))
                return p;
        }
        throw new PersonNotFound(lastname, forename);
    }

    public void remove(Person person) throws PersonNotFound {
        remove(person.getLastname(), person.getForename());
    }

    public void remove(String lastname, String forename) throws PersonNotFound {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);

            if(person.getLastname().equals(lastname) && person.getForename().equals(forename)) {
                people.remove(i);
                return;
            }
        }
        throw new PersonNotFound(lastname, forename);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person p : people)
            stringBuilder.append(p);

        return stringBuilder.toString();
    }

    private class PersonNotFound extends Throwable {
        private String lastname, forename;

        public PersonNotFound(String lastname, String forename) {
            this.lastname = lastname;
            this.forename = forename;
        }

        @Override
        public String toString() {
            return "PersonNotFound{" +
                    "lastname='" + lastname + '\'' +
                    ", forename='" + forename + '\'' +
                    '}';
        }
    }

    public class PersonExist extends Throwable {
        private String lastname, forename;

        public PersonExist(String lastname, String forename) {
            this.lastname = lastname;
            this.forename = forename;
        }

        @Override
        public String toString() {
            return "PersonExist{" +
                    "lastname='" + lastname + '\'' +
                    ", forename='" + forename + '\'' +
                    '}';
        }
    }
}
