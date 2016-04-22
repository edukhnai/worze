package com.katedukhnay.worze;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;


public class WorzeSingleton {

    /**
     * Константа для максимальной правильности тренировки
     */

    public static final String CURRENTSCORE = "currentScore";
    /**
     * Константа для имени игрока
     */

    public static final String PLAYER_NAME = "playerName";
    /**
     * Константа для шифрования
     */

    public static final String CONVERTING = "converting";
    /**
     * Константа для языка количества групп
     */

    public static final String GROUPS = "groups";
    /**
     * Константа для задержки между символами
     */

    public static final String DELAY = "delay";
    /**
     * Константа для языка дешифровки
     */

    public static final String LANGUAGE = "language";
    /**
     * Константа для языка тренировки
     */

    public static final String TRAINLANGUAGE = "trainLanguage";
    /**
     * Константа для исходной строки из раздела тренировки
     */

    public static final String RIGHTSTR = "rightStr";
    /**
     * Константа для пользовательской строки из раздела тренировки
     */

    public static final String CUSTOMSTR = "customStr";
    /**
     * Константа для использования символов и цифр из раздела тренировки
     */

    public static final String USINGSYMBS = "usingSymbs";
    /**
     * Константа для использования звуков при шифровке
     */

    public static final String USINGSOUNDS = "usingSounds";
    /**
     * Поле, с помощью которого из системы извлекаются настройки
     * SharedPreferences
     */

    public static SharedPreferences mSettings;
    /** Имя игрока, которое он добавил в главном меню */

    public static String name;
    /**
     * Переменная для шифрования. По умолчанию - 0, т.е. зашифровать
     */

    public static int converting = 0;
    /**Переменная для языка дешифровки. По умолчанию - 0, т.е. русский*/

    public static int trainLanguage = 0;
    /**Переменная для языка тренировки. По умолчанию - 0, т.е. русский*/

    public static int language = 0;
    /**
     * Переменная для количества предаваемых групп. По умолчанию - 2
     */

    public static int groups = 2;
    /**
     * Задержка между передаваемыми символами. По умолчанию - 1 c
     */

    public static long delay = 1;
    /**
     * Текущая правильность в разделе тренировки в процентах
     */

    public static int currentScore = 0;
    /**
     * Максимальная правильность в разделе тренировки в процентах
     */

    public static int maxScore = 0;
    /**
     * Использование символов и цифр в разделе тренировки, по умолчанию 0, т.е. не использовать
     */

    public static int usingSymbs = 0;
    /**
     * Включение звука в разделе шифровки при шифровке, по умолчанию 0, т.е. не включать
     */

    public static int usingSounds = 0;
    /**
     * Исходная строка из раздела тренировки
     */

    public static String rightStr = "";
    /**
     * Введенная пользователем строка из раздела тренировки
     */

    public static String customStr = "";
    /**
     * Объект синглтона
     */

    private static WorzeSingleton instance;

    /**
     * Контекст синглтона
     */

    private Context context;

    /**
     * Конструктор, создающий синглтон
     */

    private WorzeSingleton() {

    }

    /**
     * Метод для получения объекта синглтона
     */
    public static synchronized WorzeSingleton getInstance(Context context) {

        if (instance == null) {

            instance = new WorzeSingleton();

        }

        instance.context = context;

        instance.loadParameters(context);

        return instance;

    }

    /**
     * Метод для получения настроек приложения
     */

    public void loadParameters(Context context) {

        /** Получение настроек на уровне приложения */

        mSettings = context.getSharedPreferences("Worze", Context.MODE_PRIVATE);

        /** Имя игрока. Если отсутствует, то строка "Player". */

        name = mSettings.getString(PLAYER_NAME, "Player");
    }

    /**
     * Получение имени игрока
     */

    public String getName() {
        return name;
    }

    /**
     * Выставляет и сохраняет новое имя игрока
     */

    public void setName(String str) {

        name = str;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putString(PLAYER_NAME, name);

        editor.apply();
    }

    /**
     * Получение выбранного действия в разделе шифрования
     */
    public int getConverting() {
        return converting;
    }

    /**
     * Устанавливает, будет ли пользователь шфровать или расшифровывать
     */
    public void setConverting(int conv) {

        converting = conv;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(CONVERTING, converting);

        editor.apply();

    }

    /**
     * Получение выбранного языка в разделе шифрования
     */
    public int getLanguage() {
        return language;
    }

    /**
     * Устанавливает язык для шифровки
     */
    public void setLanguage(int lang) {

        language = lang;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(LANGUAGE, language);

        editor.apply();

    }

    /**
     * Получение выбранного языка в разделе тренировки
     */
    public int getTrainLanguage() {
        return trainLanguage;
    }

    /**
     * Устанавливает язык для тренировки
     */
    public void setTrainLanguage(int tlang) {

        trainLanguage = tlang;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(TRAINLANGUAGE, trainLanguage);

        editor.apply();

    }

    /**
     * Получение количества групп
     */
    public int getGroups() {
        return groups;
    }

    /**
     * Устанавливает количество групп для тренировки
     */

    public void setGroups(int gr) {

        groups = gr;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(GROUPS, groups);

        editor.apply();

    }

    /**
     * Получение задержки между символами
     */
    public long getDelay() {
        return delay;
    }

    /**
     * Устанавливает выбранную пользователем задержку между символами
     */

    public void setDelay(long del) {

        delay = del;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putLong(DELAY, delay);

        editor.apply();

    }

    /**
     * Получение текущей правильности тренировки
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * Устанавливает текущий результат тренировки
     */

    public void setCurrentScore(int sc) {

        currentScore = sc;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putFloat(CURRENTSCORE, currentScore);

        editor.apply();
    }

    /**
     * Получение максимальной правильности тренировки
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * Устанавливает максимальный результат тренировки
     */

    public void setMaxScore(int score) {
        if (score > maxScore) {
            maxScore = score;

            SharedPreferences.Editor editor = mSettings.edit();

            editor.putFloat(DELAY, delay);

            editor.apply();
        }

    }

    /**
     * Получение правильной строки из раздела тренировки
     */
    public String getRightStr() {
        return rightStr;
    }

    /**
     * Устанавливает правильную строку озвученных символов из раздела тренировки
     */

    public void setRightStr(String s) {

        rightStr = s;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putString(RIGHTSTR, rightStr);

        editor.apply();

    }

    /**
     * Получение пользовательской строки из раздела тренировки
     */
    public String getCustomStr() {
        return customStr;
    }

    /**
     * Устанавливает пользовательскую строку озвученных символов из раздела тренировки
     */

    public void setCustomStr(String st) {

        customStr = st;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putString(CUSTOMSTR, customStr);

        editor.apply();

    }

    /**
     * Используются ли символы и цифры в разделе тренировки. 0 - нет, 1 - да
     */
    public int getUsingSymbs() {
        return usingSymbs;
    }

    /**
     * Устанавливает п, используются ли звуки в разделе тренировки
     */

    public void setUsingSymbs(int us) {

        usingSymbs = us;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(USINGSYMBS, usingSymbs);

        editor.apply();

    }

    /**
     * Включается ли звук при шифровке. 0 - нет, 1 - да
     */
    public int getUsingSounds() {
        return usingSounds;
    }

    /**
     * Устанавливает использование звуков в разделе шифровки
     */

    public void setUsingSounds(int snd) {

        usingSounds = snd;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(USINGSOUNDS, usingSounds);

        editor.apply();

    }

    /**
     * Метод, выводящий цветной toast
     */

    public void makeToast(Context ct, String s, int adress) {
        Toast toast = Toast.makeText(ct,
                s, Toast.LENGTH_SHORT);
        View toastView = toast.getView();
        toastView.setBackgroundResource(adress);
        toast.show();
    }

}

