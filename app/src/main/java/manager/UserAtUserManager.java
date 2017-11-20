package manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import Entities.User;
import service.ConnexionBD;
import utils.CDataBase;

/**
 * Created by samsung on 16/11/2017.
 */

public class UserAtUserManager {
    public static void insert (Context ctx, User user, User user2){

        ContentValues contVal = new ContentValues();
        contVal.put( CDataBase.userAtUser.id1,user.getId());
        contVal.put( CDataBase.userAtUser.id2,user2.getId());

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        bd.insert(CDataBase.userAtUser.nomTable,null,contVal);

        bd.close();
    }
}
