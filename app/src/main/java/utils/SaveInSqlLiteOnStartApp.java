package utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import Entities.Photo;
import Entities.User;
import manager.PhotoManager;
import manager.UserAtPhotoManager;
import manager.UserManager;

/**
 * Created by mohamed on 17-11-21.
 */

public class SaveInSqlLiteOnStartApp {
    static public void Save(Context ctx, String users, String images, String imagesAtUser) {
        User user= new MysharedPerfermence(ctx).RecoverSharedPermenceUser();
        try {
            JSONArray jsonarray = new JSONArray(users);
            for (int i = 0; i < jsonarray.length(); i++) {
                User u = new User();
                u.setId(jsonarray.getJSONObject(i).getInt(CDataBase.user.id));
                u.setfName(jsonarray.getJSONObject(i).getString(CDataBase.user.fName));
                u.setlName(jsonarray.getJSONObject(i).getString(CDataBase.user.lName));
                u.setLogin(jsonarray.getJSONObject(i).getString(CDataBase.user.login));

                if (!user.getLogin().equals(jsonarray.getJSONObject(i).getString(CDataBase.user.login)) && !(UserManager.getAllContact(ctx).contains(u))) {
                    UserManager.insert(ctx, u);
                } else {
                    u.setToken(jsonarray.getJSONObject(i).getString(CDataBase.user.token));
                    new MysharedPerfermence(ctx, u).saveMySharedPerfermence();
                }

            }
            jsonarray = new JSONArray(imagesAtUser);
            for (int i = 0; i < jsonarray.length(); i++) {
                int idImage = jsonarray.getJSONObject(i).getInt("idImage");
                int idUser = jsonarray.getJSONObject(i).getInt("idUser");
                UserAtPhotoManager.insert(ctx, idImage, idUser);

            }
            jsonarray = new JSONArray(images);
            for (int i = 0; i < jsonarray.length(); i++) {
                int id = jsonarray.getJSONObject(i).getInt("id");
                double lat = jsonarray.getJSONObject(i).getDouble("lat");
                double lon = jsonarray.getJSONObject(i).getDouble("long");
                Photo phototosave = new Photo(id, lat, lon);
                PhotoManager.insert(ctx, phototosave);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
