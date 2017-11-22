package service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utils.CDataBase;

public class GestionBd extends SQLiteOpenHelper {

    private static final String queryDropUser = "DROP TABLE IF EXISTS"+CDataBase.user.nomTable+";";
    private static final String queryDropImage = "DROP TABLE IF EXISTS"+CDataBase.image.nomTable+";";
    private static final String queryDropUserAtUser = "DROP TABLE IF EXISTS"+CDataBase.userAtUser.nomTable+";";
    private static final String queryDropUserAtImage = "DROP TABLE IF EXISTS"+CDataBase.userAtImage.nomTable+";";

    private static final String queryCreateUser = "CREATE TABLE "+ CDataBase.user.nomTable + " ("+
            CDataBase.user.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            CDataBase.user.lName + " TEXT , " +
            CDataBase.user.fName+ " TEXT , " +
            CDataBase.user.login+ " TEXT , " +
            CDataBase.user.pwd+ " TEXT , " +
            CDataBase.user.token+ " INTEGER);";

    private static final String queryCreateImage = "CREATE TABLE "+ CDataBase.image.nomTable + " ("+
            CDataBase.image.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            CDataBase.image.lat + " REAL  , " +
            CDataBase.image.lon + " REAL  , " +
            CDataBase.image.date + " INTEGER);";

    private static final String queryCreateUserAtImage = "CREATE TABLE "+ CDataBase.userAtImage.nomTable + " ("+
            CDataBase.userAtImage.idUser + " INTEGER , " +
            CDataBase.userAtImage.idImage + " INTEGER);";

    private static final String queryCreateUserAtUser = "CREATE TABLE "+ CDataBase.userAtUser.nomTable + " ("+
            CDataBase.userAtUser.id1 + " INTEGER , "+
            CDataBase.userAtUser.id2 + " INTEGER);";

    public GestionBd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryCreateUser);
        db.execSQL(queryCreateImage);
        db.execSQL(queryCreateUserAtUser);
        db.execSQL(queryCreateUserAtImage);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(queryDropUser);
        db.execSQL(queryDropImage);
        db.execSQL(queryDropUserAtUser);
        db.execSQL(queryDropUserAtImage);
        onCreate(db);
    }



}
