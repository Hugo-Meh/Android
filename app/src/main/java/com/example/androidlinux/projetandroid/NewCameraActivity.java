package com.example.androidlinux.projetandroid;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utils.HttpUploadPictureToserver;
import utils.MyLocationListener;
import utils.MysharedPerfermence;

public class NewCameraActivity extends AppCompatActivity {
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String imageFileName;
    String mCurrentPhotoPath;
    Context ctx;
    int id;
    Long latitude=6056L;
    Long longitude =6008L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_camera);

        ctx = this;
        dispatchTakePictureIntent();

    }


    //    //recupere l'image capturé
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            saveImage(imageBitmap);
            Log.d("test","test on result act lon ="+longitude+"  lat="+latitude+"  src= "+imageFileName);
            new HttpUploadPictureToserver(imageBitmap,ctx,imageFileName,latitude,longitude).execute("uploadImage");
            finish();

        }
    }

    // creer un titre de fichier "image" unique
    @SuppressLint("MissingPermission")
    private File createImageFile() throws IOException {


        String login=new MysharedPerfermence(ctx).RecoverSharedPermenceUser().getLogin();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        imageFileName = login +"_"+ timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    private void saveImage(Bitmap finalBitmap) {
//        LocationManager locManager = new LocationManager();
        try {
            File file1=createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File (mCurrentPhotoPath);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
