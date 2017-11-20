package Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by samsung on 18/11/2017.
 */

public class MenuTop extends ViewGroup{
    LinearLayout lL;

    public MenuTop(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int retourWidth = getResources().getDisplayMetrics().widthPixels;
        int retourheight = getResources().getDisplayMetrics().heightPixels/15;

        setMeasuredDimension(retourWidth, retourheight);
    }

    @Override
    protected void onLayout(boolean b, int l, int t, int r, int bt) {
        Log.d("debug","l :" + l);
        Log.d("debug","t :" + t);
        Log.d("debug","r :" + r);
        Log.d("debug","b :" + bt);

        getChildAt(0).layout(l,t,r/3,bt);
        getChildAt(1).layout(r/3,t,2*r/3,bt);
        getChildAt(2).layout(2*r/3,t,r,bt);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

    }


}
