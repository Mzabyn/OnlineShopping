package com.example.onlineshopping.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static final String REG_USER = "rg_user";
    public static final String CART = "cart_array";
    public static final String LOGGED_IN = "logged_in";

    public Preference(Context context) {
        sharedPreferences = context.getSharedPreferences("royalty_preference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setCart(String cart_string) {
        editor.putString(CART, cart_string);
        editor.apply();
        editor.commit();
    }

    public String getCart() {
        return sharedPreferences.getString(CART, "");
    }

    public void setUser(String user_string) {
        editor.putString(REG_USER, user_string);
        editor.apply();
        editor.commit();
    }

    public String getUser() {
        return sharedPreferences.getString(REG_USER, "");
    }

    public void setLoggedIn(boolean value) {
        editor.putBoolean(LOGGED_IN, value);
        editor.apply();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(LOGGED_IN, false);
    }

    public void removeUser() {
        editor.remove(REG_USER);
        editor.commit();
    }
}
