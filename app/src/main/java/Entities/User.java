package Entities;

import java.util.ArrayList;

/**
 * Created by androidlinux on 14/11/17.
 */

public class User {
    private int id;
    private String Fname;
    private String Lname;
    private String login;
    private String pwd;
    private ArrayList<Integer> friendListId;
    private ArrayList<Integer> photoListId;

    public User(int id, String fname, String lname, ArrayList<Integer> friendListId, ArrayList<Integer> photoListId) {
        this.id = id;
        Fname = fname;
        Lname = lname;
        this.friendListId = friendListId;
        this.photoListId = photoListId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
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
}
