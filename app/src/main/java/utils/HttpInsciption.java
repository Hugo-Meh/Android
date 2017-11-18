package utils;

import android.content.Context;
import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by mohamed on 17-11-17.
 */

public class HttpInsciption extends AsyncTask<String,Long,String> {
    Context ctx;
    String urlServlet;
    String pwd;
    String nom;
    String prenom;
    String login;

    public HttpInsciption(Context ctx, String urlServlet, String pwd, String nom, String prenom, String login) {
        this.ctx = ctx;
        this.urlServlet = urlServlet;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
    }

    @Override
    protected String doInBackground(String...servlet) {
        String retour=null;
        StringBuilder sb= new StringBuilder();
        URL url=null;
        //url= new URL()
        return retour;
    }
}
