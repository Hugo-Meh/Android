package manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import Entities.User;
import service.ConnexionBD;
import utils.CDataBase;

/**
 * Created by androidlinux on 14/11/17.
 */

public class UserManager {

    private static final String queryLoginPwd = "select * from " + CDataBase.user.nomTable + " where login like ? and pwd like ?";
    private static final String queryToken = "select * from " + CDataBase.user.nomTable + " where token like ?";

    public static void insert (Context ctx, User user){

        ContentValues contVal = new ContentValues();
        contVal.put(CDataBase.user.login, user.getLogin());
        contVal.put(CDataBase.user.pwd, user.getPwd());

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        bd.insert(CDataBase.user.nomTable,null,contVal);

        bd.close();
    }

    public static User verifyToken (Context ctx, String token){
        User retour = null;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryLoginPwd, new String[]{token});

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

}
