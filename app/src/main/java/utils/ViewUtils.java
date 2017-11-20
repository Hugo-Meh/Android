package utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by mohamed on 17-11-18.
 */

public class ViewUtils {
    private static ProgressDialog mProgressDialog;

    public static void startProgressDialog(Context ctx,String message){
        mProgressDialog = new ProgressDialog(ctx);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }
    public static  void stopProgressBar(){

        mProgressDialog.dismiss();

    }


}
