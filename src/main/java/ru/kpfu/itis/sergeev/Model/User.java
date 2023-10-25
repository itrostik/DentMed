package ru.kpfu.itis.sergeev.Model;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String firstName; //имя пациента (юзера)
    private String lastName; //фамилия пациента (юзера)
    private String gender; //пол пациента (юзера)
    private String login; //логин
    private String password; //пароль
    private String address; //адрес пациента (юзера)
    private String phoneNumber; //телефон пациента (юзера)
    private String email; //почта пациента (юзера)
    private ArrayList<VisitHistory> visitHistory; //список посещений пациента (история посещений)

    public User(String firstName, String lastName, Date dateOfBirth, String gender, String login, String password, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.visitHistory = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<VisitHistory> getVisitHistory() {
        return visitHistory;
    }
}
