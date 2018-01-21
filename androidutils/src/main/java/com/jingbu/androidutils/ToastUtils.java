package com.jingbu.androidutils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by guojingbu on 2017/12/16.
 */

public class ToastUtils {

    private ToastUtils()
    {

    }

    public static boolean isShow = true;

    public static void showShort(Context context, String message)
    {
        if (isShow){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showShort(Context context, int message)
    {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String message)
    {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    public static void showLong(Context context, int message)
    {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

}
