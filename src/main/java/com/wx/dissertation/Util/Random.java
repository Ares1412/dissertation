package com.wx.dissertation.Util;

public class Random {

    public static String getNumber(){
        long L = System.currentTimeMillis();
        long i = (long)( L % 1000000 );

        return String.valueOf(i);
    }
}
