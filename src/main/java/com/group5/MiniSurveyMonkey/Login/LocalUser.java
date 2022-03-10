package com.group5.MiniSurveyMonkey.Login;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class LocalUser
{
    @Id
    private int id;

    private String user;
    private String password;
    private String accessType;

    private final ArrayList<String> validUsers;
    private final ArrayList<String> validPasswords;

    public LocalUser()
    {
        this.id = 1;
        this.user = "";
        this.password = "";
        validUsers = new ArrayList<>();
        validPasswords = new ArrayList<>();
        setValid();
    }

    public LocalUser(String user, String password)
    {
        this.id = 1;
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
            if ((user.equals("surveyor") && password.equals("surveyor")) || (user.equals("user1") || user.equals("user2")) && password.equals("password"))
            {
                if (user.equals("surveyor")) accessType = "surveyor";
                else accessType = "user";
                return true;
            }
        }
        return false;
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

}
