package com.example.rememberme;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    public static final String PREFERENCE_DB="mausam.rememberme";

    public static SharedPreferences getDataPreference(Context context){
        return context.getSharedPreferences(PREFERENCE_DB,Context.MODE_PRIVATE);
    }

    public static void writeToPreference(Context context,String key, String value){
        SharedPreferences.Editor editor=getDataPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getFromPreference(Context context,String key){
        return  getDataPreference(context).getString(key,null);
    }

    public static void writeBooleanToPreference(Context context,String key, boolean value){
        SharedPreferences.Editor editor=getDataPreference(context).edit();
        editor.putBoolean(key,value);
        editor.apply();
    }
    public static boolean getBooleanFromPreference(Context context, String key){
        return  getDataPreference(context).getBoolean(key,false);
    }
}
