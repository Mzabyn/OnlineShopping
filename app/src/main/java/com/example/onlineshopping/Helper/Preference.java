package com.example.onlineshopping.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static final String REG_USER = "rg_user";

    public Preference(Context context) {
        sharedPreferences = context.getSharedPreferences("royalty_preference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUser(String user_string) {
        editor.putString(REG_USER, user_string);
        editor.apply();
        editor.commit();
    }

    public String getUser() {
        return sharedPreferences.getString(REG_USER, "");
    }
}
