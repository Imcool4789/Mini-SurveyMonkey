package com.group5.MiniSurveyMonkey.Login;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document("LocalUser")
@Entity(name = "User")
@Table(name = "user")
public class LocalUser
{
    @Id
    private long id;
    private String user;
    private String password;
    private String accessType;

    @ElementCollection
    private final List<String> validUsers;

    @ElementCollection
    private final List<String> validPasswords;

    public LocalUser()
    {
        id = 1;
        user = "";
        password = "";
        validUsers = new ArrayList<>();
        validPasswords = new ArrayList<>();
        setValid();
    }

    public LocalUser(String user, String password)
    {
        id = 1;
        this.user = user;
        this.password = password;
        validUsers = new ArrayList<>();
        validPasswords = new ArrayList<>();
        setValid();
    }

    private void setValid()
    {
        validUsers.add("surveyor");
        validUsers.add("user1");
        validUsers.add("user2");
        validPasswords.add("surveyor");
        validPasswords.add("password");
    }

    protected boolean login()
    {
        if (validUsers.contains(user) && validPasswords.contains(password))
        {
            if ((user.equals("surveyor") && password.equals("surveyor")) || ((user.equals("user1") || user.equals("user2")) && password.equals("password")))
            {
                if (user.equals("surveyor"))
                {
                    accessType = "surveyor";
                }
                else
                {
                    accessType = "user";
                }
                return true;
            }
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "LocalUser{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", accessType='" + accessType + '\'' +
                ", validUsers=" + validUsers +
                ", validPasswords=" + validPasswords +
                '}';
    }
}
