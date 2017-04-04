package com.example.arrow.apppersistencia05sqlite;

import android.provider.BaseColumns;

/**
 * Created by ARROW on 30/03/2017.
 */

public final class NotaContract {

    private NotaContract(){

    }

    public static class NotaEntry implements BaseColumns {
        public static  final String TABLA ="Notas";
        public static final String TEXTO ="Texto";
    }
}
