package manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Entities.Photo;
import Entities.User;
import service.ConnexionBD;
import utils.CDataBase;

/**
 * Created by androidlinux on 15/11/17.
 */

public class UserAtPhotoManager {

    public static final String queryGetAllFromUser = "select * from "+ CDataBase.userAtImage.nomTable+" where idUser = ?";

    public static void insert (Context ctx, Photo photo, User user){
        ContentValues contVal = new ContentValues();
        contVal.put( CDataBase.userAtImage.idUser,user.getId());
        contVal.put( CDataBase.userAtImage.idImage,photo.getId());

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        bd.insert(CDataBase.userAtImage.nomTable,null,contVal);

        bd.close();
    }



    public static Photo[] getAllFromUser(Context ctx, User user){
        ArrayList<Photo> retour;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllFromUser, new String[]{String.valueOf(user.getId())});

        while (c.moveToNext()){
            retour.add(new Photo(c.getInt(c.getColumnIndex(CDataBase.userAtImage.))))
        }




        return retour;
    }
}
