package fifthSemseter.modSim.src.person;

import java.io.Serializable;

public class Person implements Serializable {
    private String lastname, forename, street, houseNr;

    public Person(String lastname, String forename, String street, String houseNr) {
        this.lastname = lastname;
        this.forename = forename;
        this.street = street;
        this.houseNr = houseNr;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", forename='" + forename + '\'' +
                ", street='" + street + '\'' +
                ", houseNr='" + houseNr + '\'' +
                '}';
    }
}
