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

    //public static final String queryGetAllFromUser = "select * from "+ CDataBase.userAtImage.nomTable+" where idUser = ?";

    public static void insert (Context ctx, int id,int idu){

        ContentValues contVal = new ContentValues();
        contVal.put( CDataBase.userAtImage.idUser,idu);
        contVal.put( CDataBase.userAtImage.idImage,id);

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        bd.insert(CDataBase.userAtImage.nomTable,null,contVal);

        bd.close();
    }


    // moved to PhotoManager
    /*public static ArrayList<Photo> getAllFromUser(Context ctx, User user){
        ArrayList<Photo> retour;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllFromUser, new String[]{String.valueOf(user.getId())});

        while (c.moveToNext()){
            Photo photo = new Photo;
            photo.setId(c.getInt(c.getColumnIndex(CDataBase.image.id)));
            photo.setLat(c.getFloat(c.getColumnIndex(CDataBase.image.lat)));
            photo.getLon(c.)


            retour.add(new Photo(c.getInt(c.getColumnIndex(CDataBase.userAtImage.))))
        }
        return retour;
    }*/
}
