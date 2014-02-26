package upm.miw.solitaire.models.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nick;

    private String password;

    private String firstName;

    private String lastName;

    private int age;

    private Gender gender;

    private String country;

    private boolean administrator;

    public User() {
    }

    public User(String nick, String password, String firstName, String lastName, int age,
            Gender gender, String country) {
        super();
        this.nick = nick;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.administrator = false;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "User [nick=" + nick + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + ", edad=" + age + ", gender=" + gender + ", country="
                + country + ", administrator=" + administrator + "]";
    }

}
