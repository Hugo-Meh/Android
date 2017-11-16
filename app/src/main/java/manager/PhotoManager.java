package manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import Entities.Photo;
import Entities.User;
import service.ConnexionBD;
import utils.CDataBase;

/**
 * Created by androidlinux on 14/11/17.
 */

public class PhotoManager {

    public static final String queryGetAllFromUser = "select * from " + CDataBase.userAtImage.nomTable + " inner join " + CDataBase.image.nomTable + " on " + CDataBase.userAtImage.nomTable + " . " + CDataBase.userAtImage.idImage + " = " + CDataBase.image.nomTable + " . " + CDataBase.image.id +  " where idUser = ?;";

    public static ArrayList<Photo> getAllFromUser(Context ctx, User user){
        ArrayList<Photo> retour = null;

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllFromUser, new String[]{String.valueOf(user.getId())});

        while (c.moveToNext()){
            Photo photo = new Photo();
            photo.setId(c.getInt(c.getColumnIndex(CDataBase.image.id)));
            photo.setLat(c.getFloat(c.getColumnIndex(CDataBase.image.lat)));
            photo.setLon(c.getFloat(c.getColumnIndex(CDataBase.image.lon)));

            // SQLite ne store pas de type Date enregistre la date en miliseconde comme un long et recupérer un mong puis convertir en Date
            photo.setDate(new Date((c.getLong(c.getColumnIndex(CDataBase.image.date)))));

            photo.setSrc(c.getString(c.getColumnIndex(CDataBase.image.src)));

            retour.add(photo);
        }
        return retour;
    }

    public static void insert (Context ctx, Photo photo){

        ContentValues contVal = new ContentValues();
        contVal.put(CDataBase.image.id,photo.getId());
        SQLiteDatabase bd = ConnexionBD.getBd(ctx);

    }

}
