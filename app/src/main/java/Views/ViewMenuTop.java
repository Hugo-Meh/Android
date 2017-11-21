package Views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by samsung on 18/11/2017.
 */

public class ViewMenuTop extends View {
    Button btn_profil,btn_contact,btn_album;
    MenuTop myViewgroup;

    public ViewMenuTop(Context context) {
        super(context);


        myViewgroup.addView(btn_profil);
        myViewgroup.addView(btn_contact);
        myViewgroup.addView(btn_album);



    }


}
