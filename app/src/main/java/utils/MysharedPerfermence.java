package utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import Entities.User;

/**
 * Created by mohamed on 17-11-19.
 */

public class MysharedPerfermence {
    Context ctx;
    User user;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public MysharedPerfermence(Context ctx) {
        this.ctx = ctx;
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this.ctx);
        editor=sharedPreferences.edit();

    }

    public MysharedPerfermence(Context ctx, User user) {
        this.ctx = ctx;
        this.user=user;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this.ctx);
        editor=sharedPreferences.edit();

    }

    public void saveMySharedPerfermence(){

        editor.putString("token",user.getToken());
        editor.putString("lName",user.getlName());
        editor.putString("fName",user.getfName());
        editor.putString("login",user.getLogin());
        editor.putInt("id",user.getId());
        editor.commit();

    }
    public User RecoverSharedPermenceUser(){


        user = null;

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(ctx);
        String token=sharedPreferences.getString("token","");
        if(!token.equals("")){
            String fName=sharedPreferences.getString("fName","");
            String lName=sharedPreferences.getString("lName","");
            String login=sharedPreferences.getString("login","");

            int id=sharedPreferences.getInt("id",0);
            user = new User(id,  fName,  lName,  login,  "",  token);

        }
        return user;
    }

    public void removeKey(String key){
        editor.remove(key);
        editor.commit();
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }


}
