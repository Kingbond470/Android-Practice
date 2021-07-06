package com.example.eventbooking;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String PREFERENCE_DB = "mausam.singh";

    // to store the data in local device
    public static SharedPreferences getDataPreference(Context context) {
        return context.getSharedPreferences(PREFERENCE_DB, Context.MODE_PRIVATE);
    }

    // for storing the string value
    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getDataPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    // for retrieving the string value
    public static String getStringFromPreference(Context context, String key) {
        return getDataPreference(context).getString(key, null);
    }

    //for storing the int value
    public static void writeIntToPreference(Context context, String key, int value) {
        SharedPreferences.Editor editor = getDataPreference(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }


    //for retrieving the int value
    public static int getIntFromPreference(Context context, String key) {
        return getDataPreference(context).getInt(key, 0);
    }

}
