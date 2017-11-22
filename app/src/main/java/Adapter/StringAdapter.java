package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidlinux.projetandroid.R;

import java.util.ArrayList;
import java.util.List;

import Entities.User;

/**
 * Created by samsung on 21/11/2017.
 */

public class StringAdapter extends ArrayAdapter<String> {
    ArrayList<String> Contact;
    Context ctx;

    public StringAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        ctx=context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String pays = getItem(position);

        if(convertView == null){
            LayoutInflater li = LayoutInflater.from(ctx);

            convertView = li.inflate(R.layout.string_view,null);


        }

        TextView paystv = convertView.findViewById(R.id.tv_pays);
        ImageView flag = convertView.findViewById(R.id.img_flag_pays);


        paystv.setText(pays);


        return convertView;
    }
}
