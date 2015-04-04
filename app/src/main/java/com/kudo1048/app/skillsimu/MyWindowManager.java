package com.kudo1048.app.skillsimu;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by 0901AND on 2015/02/26.
 */
public class MyWindowManager{

    private static WindowManager mWindowManager;
    private static WindowManager.LayoutParams params;
    private static View view;

    public static void createWindow(Context context, int pls){
Log.d("lllllll",String.valueOf(pls));
        if(view==null) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.overlay, null);
            getWindowManager(context).addView(view,params);
        }


    }

    private static WindowManager getWindowManager(Context context) {
        if (mWindowManager == null) {

            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                    PixelFormat.TRANSLUCENT);

            mWindowManager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
        }
        return mWindowManager;
    }



    public static boolean isWindowShowing() {
        return true;
    }
}
