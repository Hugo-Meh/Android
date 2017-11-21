package Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidlinux.projetandroid.R;

import java.util.ArrayList;
import java.util.List;

import Entities.User;

/**
 * Created by androidlinux on 20/11/17.
 */

public class ContactAdapter extends ArrayAdapter<User> {
    ArrayList<User> Contact;
    Context ctx;
    public ContactAdapter(Context context,int resource,List<User> objects) {
        super(context, resource, objects);
        ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if(convertView == null){
            LayoutInflater li = LayoutInflater.from(ctx);

            convertView = li.inflate(R.layout.contact_listview_view,null);


        }

        TextView nom = convertView.findViewById(R.id.tvnom);
        TextView prenom = convertView.findViewById(R.id.tvprenom);

        nom.setText(user.getlName());
        prenom.setText(user.getfName());

        return convertView;
    }
}
