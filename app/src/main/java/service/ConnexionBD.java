package service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import utils.CDataBase;

public class ConnexionBD {
    private static SQLiteDatabase bd;
    private static int versionBD = 1;


    public static SQLiteDatabase getBd(Context ctx){
        GestionBd gbd = new GestionBd(ctx, CDataBase.nomBd, null, versionBD);
        bd = gbd.getWritableDatabase();
        return  bd;
    }

    public static void close(){
        bd.close();
    }


}