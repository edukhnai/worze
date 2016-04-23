package com.katedukhnay.worze;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * Активность для тренировки
 */
public class TrainActivity extends AppCompatActivity {
    /**
     * Текстовое поле, в которое пользователь записывает услышанные символы
     */
    EditText train_et;
    /**
     * Кнопки для включения групп и отправки ответа соотв.
     */
    Button ready_train, btnReady;
    /**
     * Поле синглтона
     */
    WorzeSingleton ws;
    /**
     * Контекст класса
     */
    Context context;
    /**
     * Поле SoundPool-а
     */
    SoundPool soundPool;
    /**
     * Строка, в которую будет записываться правильная расшифровка включенных группы
     */
    String str;
    /**
     * Слушатель нажатий на кнопки данной активности
     */
    View.OnClickListener trainListener;
   /**Счетчик нажатий на кнопку динамика*/
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.train_main);
        }
        ws = WorzeSingleton.getInstance(getApplicationContext());
        context = this.getApplicationContext();
        str = "";
        train_et = (EditText) findViewById(R.id.train_et);
        ready_train = (Button) findViewById(R.id.ready_train);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        initListener();
        ready_train.setOnClickListener(trainListener);
        btnReady = (Button) findViewById(R.id.btnReady);
        if(btnReady!=null)btnReady.setOnClickListener(trainListener);

        Thread thread = new Thread() {
            @Override
            public void run() {
                MakeSounds.loadSounds(soundPool, context);
            }
        };
        thread.start();
    }

    public void initListener() {
        trainListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ready_train:
                        if (ws.getRightStr().length() == ws.getGroups() * 5) {
                            ready_train.setClickable(true);
                            if (train_et.getText().toString().equals("")) {
                                ws.makeToast(context, getString(R.string.where_answ), R.drawable.toast_red);
                            } else {
                                ws.setCustomStr(train_et.getText().toString());
                                ws.setCurrentScore(compareAnswer(ws.getRightStr(), ws.getCustomStr()));
                                ws.setMaxScore(ws.getCurrentScore());
                                startActivity(new Intent(TrainActivity.this, TrainResults.class));
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                        } else
                            ws.makeToast(context, getString(R.string.where_answ), R.drawable.toast_red);
                        break;
                    case R.id.btnReady:
                        counter++;
                            btnReady.setBackgroundResource(R.mipmap.playsay_btn_selected);
                        btnReady.setClickable(false);
                            new MyTask().execute();
                        btnReady.setClickable(true);
                        btnReady.setBackgroundResource(R.mipmap.playsay_btn);
                        break;
                }
            }
        };
    }

    /**
     * Метод, создающий массив произвольных символов в соответствии с предпочтениями пользователя, проигрывающий их кодировки
     * и сохраняющий правильную строку
     */
    public void playGroups() {
        char[] ch;
        if (ws.getRightStr().equals("")) {
            ch = new char[5];
            for (int i = 0; i < ch.length; i++) {
                if (ws.getTrainLanguage() == 0) {
                    if (ws.getUsingSymbs() == 0) {
                        ch[i] = charRandom("абвгдежзийклмнопрстуфхцчшщьыэюя");
                    } else {
                        ch[i] = charRandom("абвгдежзийклмнопрстуфхцчшщьыэюя1234567890-+=.,/!@;:?)&amp;+=_$");
                    }
                } else {
                    if (ws.getUsingSymbs() == 0) {
                        ch[i] = charRandom("abcdefghijklmnopqrstuvwxyz");
                    } else {
                        ch[i] = charRandom("abcdefghijklmnopqrstuvwxyz1234567890-+=.,/!@;:?)&amp;+=_$");
                    }

                }
            }
        } else {
            ch = ws.getRightStr().toCharArray();
        }
        for (int j = 0; j < ch.length; j++) {
            MakeSounds.playSound(ch[j], soundPool);
            MakeSounds.makeDelay(ws.getDelay());
           if(counter==1){ str += String.valueOf(ch[j]);}
            Log.d("myLogs", "str=" + str);
        }
        MakeSounds.makeDelay(ws.getDelay() * 2);
        ws.setRightStr(str);
    }

    /**
     * Метод, генерирующий произвольный символ
     */
    public char charRandom(String str) {
        Random random = new Random();
        return str.charAt(random.nextInt(str.length()));

    }

    /**
     * Метод для сравнения пользовательского ответа с правильным и возвращающий
     */
    public int compareAnswer(String right_str, String custom_str) {
        int res = 0;
        custom_str = custom_str.replaceAll("\\s+", "").toLowerCase();
        if (custom_str.length() > right_str.length()) {
            custom_str = custom_str.substring(0, right_str.length());
        }
        for (int i = 0; i < custom_str.length(); i++) {
            if (right_str.charAt(i) == custom_str.charAt(i)) {
                res++;
            } else if (right_str.charAt(i) != custom_str.charAt(i)) {
                switch (right_str.charAt(i)) {
                    case '(':
                        if (custom_str.charAt(i) == ')') {
                            res++;
                        }

                        break;
                    case ')':
                        if (custom_str.charAt(i) == '(') {
                            res++;
                        }

                        break;
                    case 'е':
                        if (custom_str.charAt(i) == 'ё') {
                            res++;
                        }

                        break;
                    case 'ь':
                        if (custom_str.charAt(i) == 'ъ') {
                            res++;
                        }

                        break;
                }
            }
        }
        res = res * 20 / ws.getGroups();
        return res;
    }

    /**
     * Не позволяет пользователю использовать кнопку Back
     */
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        soundPool.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * AsyncTask для воспроизведения звуков
     */
    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < ws.getGroups(); i++) {
                playGroups();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void res) {
            super.onPostExecute(res);
        }

    }
}