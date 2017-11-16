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
    // probleme ici les objet doivent d'abord êtres enregistrer dans la base pour avoir les id. insert UserManager doit etres appeler a la creation d'une photo. procedure stockée ?
    public static void insert (Context ctx, Photo photo, User user){
        ContentValues contVal = new ContentValues();
        contVal.put( CDataBase.userAtImage.idUser,user.getId());
        contVal.put( CDataBase.userAtImage.idImage,photo.getId());

        SQLiteDatabase bd = ConnexionBD.getBd(ctx);
        bd.insert(CDataBase.userAtImage.nomTable,null,contVal);

        bd.close();
    }


}
