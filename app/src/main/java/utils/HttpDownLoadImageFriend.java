package utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import Entities.Photo;
import service.C;

/**
 * Created by mohamed on 17-11-21.
 */

public class HttpDownLoadImageFriend extends AsyncTask<String,Long,String> {

    Context ctx;

    public HttpDownLoadImageFriend(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String retour="";
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp + params[0];
        OutputStream out;
        String idUser=params[1];
        String idImage=params[2];


        URL url = null;
        try {

            String paramtoSend="idUser="+idUser+"idImage="+idImage;
            url = new URL(requestURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            out = new BufferedOutputStream(conn.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return retour;
    }

}
