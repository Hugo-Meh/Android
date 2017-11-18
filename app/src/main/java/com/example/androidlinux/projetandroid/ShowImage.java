package com.example.androidlinux.projetandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.util.ArrayList;

public class ShowImage extends AppCompatActivity {

    GridView gridView;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        gridView = (GridView) findViewById(R.id.gridview);
        File f = getExternalFilesDir("Pictures");
        ctx = this;
       final ImageAdapter img=new ImageAdapter(ctx,f);
        gridView.setAdapter(img);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bitmap im = (Bitmap) img.bitmapTab.get(i);
                Log.d("test","i ="+i+"l = "+im);


                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                ImageView img= new ImageView(ctx);
                img.setImageBitmap(im);
                img.setLayoutParams(new LinearLayout.LayoutParams(100,100));
                builder.setView(img);

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        ArrayList<Bitmap> bitmapTab;


        public ImageAdapter(Context c, File imgFile) {
            mContext = c;
            bitmapTab = new ArrayList<>();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Log.d("test", "" + imgFile.list().length);
            for (String s : imgFile.list()) {
                String uripath = imgFile.getAbsolutePath() + File.separator + s;
                Bitmap myBitmap = BitmapFactory.decodeFile(uripath, options);
                bitmapTab.add(myBitmap);
            }
            Log.d("test", "" + bitmapTab.size());
        }

        public int getCount() {
            return bitmapTab.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            Log.d("test", "test get view");
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(80, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageBitmap(bitmapTab.get(position));

            return imageView;
        }

    }

}
