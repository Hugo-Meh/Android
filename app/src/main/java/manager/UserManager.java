package manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import Entities.User;
import service.ConnexionBD;
import service.GestionBd;
import utils.CDataBase;

/**
 * Created by androidlinux on 14/11/17.
 */

public class UserManager {

    private static final String queryLoginPwd = "select * from " + CDataBase.user.nomTable + " where login like ? and pwd like ?";
    private static final String queryToken = "select * from " + CDataBase.user.nomTable + " where token like ?";
    //private static final String queryGetAllContact = "select * from " + CDataBase.user.nomTable + " inner join " + CDataBase.userAtUser.nomTable + " on " + CDataBase.user.id + " = " + CDataBase.userAtUser.id1 + " where id = ?";
    private static final String queryGetAllContact = "select * from " + CDataBase.user.nomTable;
    private static final String queryLogin = "select * from " + CDataBase.user.nomTable + " where login like ?";


    public static void insert (Context ctx, User user) {
        Log.d("logintest  ",user.getLogin());
       User user1= verifyLogin(ctx,user.getLogin());

       if(user1==null) {
           ContentValues contVal = new ContentValues();
          // contVal.put(CDataBase.user.id, user.getId());
           contVal.put(CDataBase.user.fName, user.getfName());
           contVal.put(CDataBase.user.lName, user.getlName());


           SQLiteDatabase bd = ConnexionBD.getBd(ctx);
           bd.insert(CDataBase.user.nomTable, null, contVal);


           bd.close();
       }
    }

    public static User verifyToken (Context ctx, String token){
        User retour = null;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryToken, new String[]{token});

        if (c.moveToNext())
            retour = new User(c.getString(c.getColumnIndex(CDataBase.user.token)));
        return retour;

    }

    public static User verifyUser(Context ctx, String login, String pwd){
        User retour = null;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryLoginPwd, new String[]{login, pwd});

        if (c.moveToNext())
            retour = new User();
            retour.setLogin(c.getString(c.getColumnIndex(CDataBase.user.login)));
            retour.setPwd(c.getString(c.getColumnIndex(CDataBase.user.pwd)));


        return retour;

    }

    /*public static ArrayList<User> getAllContact (Context ctx, User user){
        ArrayList<User> contact = new ArrayList<User>();

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllContact, new String[]{String.valueOf(user.getId())});

        while (c.moveToNext()){
            User aUser = new User();
            aUser.setId(c.getInt(c.getColumnIndex(CDataBase.user.id)));
            aUser.setlName(c.getString(c.getColumnIndex(CDataBase.user.lName)));
            aUser.setfName(c.getString(c.getColumnIndex(CDataBase.user.fName)));

            contact.add(aUser);
        }

        return contact;
    }*/

   public static ArrayList<User> getAllContact (Context ctx){
        ArrayList<User> contact = new ArrayList<User>();

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllContact,null);

        while (c.moveToNext()){
            User aUser = new User();
            aUser.setId(c.getInt(c.getColumnIndex(CDataBase.user.id)));
            aUser.setlName(c.getString(c.getColumnIndex(CDataBase.user.lName)));
            aUser.setfName(c.getString(c.getColumnIndex(CDataBase.user.fName)));

            contact.add(aUser);
        }
        return contact;
    }

    public static User verifyLogin (Context ctx, String login){
        User retour = null;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryLogin, new String[]{login});

        if (c.moveToNext())
            retour = new User(c.getString(c.getColumnIndex(CDataBase.user.token)));
        return retour;

    }

}
