package Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by androidlinux on 14/11/17.
 */

public class User implements Serializable {
    private int id;
    private String fName;
    private String lName;
    private String login;
    private String pwd;
    private ArrayList<Integer> friendListId;
    private ArrayList<Integer> photoListId;
    private String token;


    public User(int id, String fName, String lName, String login, String pwd, String token) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.login = login;
        this.pwd = pwd;
        this.token = token;
    }

    public User(String fName, String lName, String login, String pwd) {
        this.fName = fName;
        this.lName = lName;
        this.login = login;
        this.pwd = pwd;
    }

    public User(String token) {
        this.token = token;
    }

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {

        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {

        this.lName = lName;
    }

    public ArrayList<Integer> getFriendListId() {
        return friendListId;
    }

    public void setFriendListId(ArrayList<Integer> friendListId) {
        this.friendListId = friendListId;
    }

    public ArrayList<Integer> getPhotoListId() {
        return photoListId;
    }

    public void setPhotoListId(ArrayList<Integer> photoListId) {
        this.photoListId = photoListId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "id:\"" + id +"\"fName:\"" + fName + "\",lName:\"" + lName + "\",login:\"" + login + "\",pwd:\"" + pwd + "\",token\""+token+"\"";
    }
}
