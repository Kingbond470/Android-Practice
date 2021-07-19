package com.example.sprintcoding;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    public static final String DATABASE_NAME = "mausam.coding";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
    }

    public static void writeEmailToPrefernce(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void writePasswordToPrefernce(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void writeBooleanToPrefernce(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBooleanFromPrefernce(Context context, String key) {
        return getSharedPreference(context).getBoolean(key, false);
    }

    public static String getEmailFromPrefernce(Context context, String key) {
        return getSharedPreference(context).getString(key, null);

    }

    public static String getPasswordFromPrefernce(Context context, String key) {
        return getSharedPreference(context).getString(key, null);

    }

}
















