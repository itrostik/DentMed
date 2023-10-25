package ru.kpfu.itis.sergeev.Dto;

import ru.kpfu.itis.sergeev.Model.VisitHistory;

import java.util.ArrayList;
import java.util.Date;

public class UserDto {
    private String firstName; //имя пациента (юзера)
    private String lastName; //фамилия пациента (юзера)
    private String login; //логин
    private String hashPassword; //пароль
    private String address; //адрес пациента (юзера)
    private String phoneNumber; //телефон пациента (юзера)
    private String email; //почта пациента (юзера)
    private int userId;
    private ArrayList<VisitHistory> visitHistory; //список посещений пациента (история посещений)
    public UserDto() {

    }
    public UserDto(int userId, String firstName, String lastName, String login, String hashPassword, String address, String phoneNumber, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.hashPassword = hashPassword;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.visitHistory = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }
    public String getHashPassword() {
        return hashPassword;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setHashPassword(String password) {
        this.hashPassword = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVisitHistory(ArrayList<VisitHistory> visitHistory) {
        this.visitHistory = visitHistory;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
