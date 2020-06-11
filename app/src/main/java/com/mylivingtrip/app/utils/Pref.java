package com.mylivingtrip.app.utils;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class Pref {
    public static final String KEY_Infant = "infant";
    public static final String KEY_CabinClass = "cabinclass";
    // Sharedpref file name
    private static final String PREF_NAME = "TravellersClassPref";
    private static final String KEY_Adult = "adult";
    private static final String KEY_Children = "children";

    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Constructor
    @SuppressLint("CommitPrefEdits")
    public Pref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setData(String adult, String children,String infant) {


        editor.putString(KEY_Adult, adult);


        editor.putString(KEY_Children, children);


        editor.putString(KEY_Infant, infant);



        editor.commit();
    }

    public void setCabinClass( String cabinclass)
    {
        editor.putString(KEY_CabinClass, cabinclass);
        editor.commit();
    }


    public String getAdult() {
        if (pref.getString(KEY_Adult, "").isEmpty()) {
            return "";
        } else {
            return pref.getString(KEY_Adult, "");
        }
    }

    public String getChidren() {
        if (pref.getString(KEY_Children, "").isEmpty()) {
            return "";
        } else {
            return pref.getString(KEY_Children, "");
        }
    }
    public String getInfrant() {
        if (pref.getString(KEY_Infant, "").isEmpty()) {
            return "";
        } else {
            return pref.getString(KEY_Infant, "");
        }
    }

    public String getCabinClass() {
        if (pref.getString(KEY_CabinClass, "").isEmpty()) {
            return "";
        } else {
            return pref.getString(KEY_CabinClass, "");
        }
    }

}
