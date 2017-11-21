package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import Entities.Photo;
import Entities.User;
import service.C;

/**
 * Created by mohamed on 17-11-19.
 */

public class HttpUploadPictureToserver extends AsyncTask<String, Long, String> {
    Bitmap bitmap;
    String filename;
    Context ctx;
    double latitude;
    double longitude;

    public HttpUploadPictureToserver(Bitmap bitmap, Context ctx, String filename, double latitude, double longitude) {
        this.bitmap = bitmap;
        this.ctx = ctx;
        this.filename = filename;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    protected String doInBackground(String... params) {
        String retour = "";
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp + params[0];
        OutputStream out;
        Log.d("test", "test http =" + longitude + "  lat=" + latitude + "  src= " + filename);

        URL url = null;
        try {
            String image= FormatBitmap.encodeTobase64(bitmap);
            Photo p = new Photo(latitude, longitude, new Date(), filename,image);

            Gson gson = new Gson();
            String imageTosend= gson.toJson(p);

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
            writer.write(imageTosend);
            writer.flush();
            writer.close();
            int response=conn.getResponseCode();
            Log.d("test",""+response);
            if(response==HttpsURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        in, "UTF-8"));
                sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                in.close();
            }

            retour = sb.toString();
            Log.d("test",retour);


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retour;
    }

    @Override
    protected void onPreExecute() {
        ViewUtils.startProgressDialog(ctx,"En cours de chargement de l'image");
    }

    @Override
    protected void onPostExecute(String s) {
      //  ViewUtils.stopProgressBar();
    }
}

