package com.katedukhnay.worze;

import android.content.Context;
import android.content.SharedPreferences;

public class WorzeSingleton {

    /**
     * Поле, с помощью которого из системы извлекаются настройки
     * SharedPreferences
     */

    public static SharedPreferences mSettings;

    /** Имя игрока, которое он добавил в главном меню */

    public static String name;

    /** Константа для имени игрока */

    public static final String PLAYER_NAME = "playername";

    /** Получение имени игрока */

    public static String getName(Context context) {

        /** Получение настроек на уровне приложения */

        mSettings = context.getSharedPreferences("Worze", Context.MODE_PRIVATE);

        /** Имя игрока. Если отсутствует, то строка "игрок" */

        name = mSettings.getString(PLAYER_NAME, "игрок");

        return name;
    }
    /** Получение имени игрока */

    public static void setName(Context ct) {
        getSetts(ct);
        name = mSettings.getString(PLAYER_NAME, "игрок");

    }

    /** Получение настроек на уровне приложения */

    public static void getSetts(Context context){
        mSettings = context.getSharedPreferences("Worze", Context.MODE_PRIVATE);
    }
}
