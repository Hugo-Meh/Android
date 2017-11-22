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

    private static final String queryGetAllFromUser = "select * from "+ CDataBase.userAtImage.nomTable+" inner join "+ CDataBase.image.nomTable + " on "+ CDataBase.userAtImage.idImage + " = "+ CDataBase.image.id +" where idUser = ?";

    public static long insert(Context ctx, Photo photo){
        long id;

        // on doit envoyer l'image jpeg au server.

        ContentValues contVal;
        contVal = new ContentValues();
// on enregistre les valeur de l'objet photo dans la table photo.
        contVal.put(CDataBase.user.id,photo.getId());
        contVal.put(CDataBase.image.lat,photo.getLat());
        contVal.put(CDataBase.image.lon,photo.getLon());

        // conversion de la date en long.
        //contVal.put(CDataBase.image.date,photo.getDate().getTime());

        // on doit changer la source selon le path sous lequel on a enregistrer la photo sur le server apache.
        contVal.put(CDataBase.image.src,photo.getSrc());

        // recuperer id dans la bd
        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        id = bd.insert(CDataBase.user.nomTable, null, contVal);

        return id;
    }

    public static ArrayList<Photo> getAllFromUser(Context ctx, User user){
        ArrayList<Photo> retour = new ArrayList<Photo>();

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAllFromUser, new String[]{String.valueOf(user.getId())});

        while (c.moveToNext()){
            Photo photo = new Photo();
            photo.setId(c.getInt(c.getColumnIndex(CDataBase.image.id)));
            photo.setLat(c.getFloat(c.getColumnIndex(CDataBase.image.lat)));
            photo.setLon(c.getFloat(c.getColumnIndex(CDataBase.image.lon)));
            photo.setSrc(c.getString(c.getColumnIndex(CDataBase.image.src)));
            photo.setDate(new Date(c.getLong(c.getColumnIndex(CDataBase.image.date))));

            retour.add(photo);
        }
        bd.close();
        return retour;
    }
}
