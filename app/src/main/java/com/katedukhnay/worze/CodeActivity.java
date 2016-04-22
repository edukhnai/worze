package com.katedukhnay.worze;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Активноть для шифровки текста
 */
public class CodeActivity extends AppCompatActivity {
    /**
     * Константа для распознавания речи
     */
    protected static final int RESULT_SPEECH = 1;
    /**
     * Текстовое поле для ввода исходного слова или текста
     */
    EditText textabove;
    /**
     * Текстовое поле, в котором выводится результат шифровки содержимого верхнего поля
     */
    TextView textbelow;
    /**
     * Кнопка для шифровки, выбора опции шифрования и включения распознавания речи соответственно
     */
    Button translate_btn, shest_btn, sounds_btn, speech_btn;
    /**
     * Контекст класса
     */
    Context context;
    /**
     * Поле синглтона
     */
    WorzeSingleton ws;
    /**
     * Поле SoundPool-а
     */
    SoundPool sp;
    /**
     * Слушатель откликов сенсора
     */
    SensorEventListener mylistener;
    /**
     * Слушатель нажатий на кнопки
     */
    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.speech_btn:
                    speech_btn.setBackgroundResource(R.mipmap.speech_btn_selected);
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                    try {
                        startActivityForResult(intent, RESULT_SPEECH);
                        speech_btn.setBackgroundResource(R.mipmap.speech_btn);
                    } catch (ActivityNotFoundException a) {
                        ws.makeToast(context, getString(R.string.speech_recognize_not_support), R.drawable.toast_red);
                        speech_btn.setBackgroundResource(R.mipmap.speech_btn);
                    }

                    break;
                case R.id.sounds_btn:
                    if (ws.getUsingSounds() == 0) {
                        ws.setUsingSounds(1);
                        sounds_btn.setBackgroundResource(R.mipmap.sounds_btn_selected);
                    } else {
                        ws.setUsingSounds(0);
                        sounds_btn.setBackgroundResource(R.mipmap.sounds_btn);
                    }

                    break;
                case R.id.shest_btn:
                    PopupMenu pm = new PopupMenu(context, v);
                    pm.inflate(R.menu.popup_codeact);
                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.tocode:
                                    sounds_btn.setClickable(true);
                                    speech_btn.setClickable(true);
                                    if (ws.getUsingSounds() == 1) {
                                        sounds_btn.setBackgroundResource(R.mipmap.sounds_btn_selected);
                                    } else sounds_btn.setBackgroundResource(R.mipmap.sounds_btn);
                                    speech_btn.setBackgroundResource(R.mipmap.speech_btn);
                                    if (ws.getConverting() == 1) {
                                        textabove.setText("");
                                        textbelow.setText("");
                                    }
                                    ws.setConverting(0);
                                    return true;
                                case R.id.todecoderus:
                                    sounds_btn.setClickable(false);
                                    speech_btn.setClickable(false);
                                    sounds_btn.setBackgroundResource(R.mipmap.sounds_btn_pressed);
                                    speech_btn.setBackgroundResource(R.mipmap.speech_btn_pressed);
                                    if (ws.getConverting() == 0) {
                                        textabove.setText("");
                                        textbelow.setText("");
                                    }
                                    ws.setConverting(1);
                                    ws.setLanguage(0);
                                    return true;
                                case R.id.todecodeeng:
                                    sounds_btn.setClickable(false);
                                    speech_btn.setClickable(false);
                                    sounds_btn.setBackgroundResource(R.mipmap.sounds_btn_pressed);
                                    speech_btn.setBackgroundResource(R.mipmap.speech_btn_pressed);
                                    if (ws.getConverting() == 0) {
                                        textabove.setText("");
                                        textbelow.setText("");
                                    }
                                    ws.setConverting(1);
                                    ws.setLanguage(1);
                                    return true;
                                case R.id.tosend:
                                    if (textbelow.getText().toString().equals("")) {
                                        ws.makeToast(context, getString(R.string.translate_anything), R.drawable.toast_red);
                                    } else {
                                        String body = textbelow.getText().toString();
                                        if (ws.getConverting() == 0) {
                                            body += getResources().getString(R.string.i_encrypt);
                                        } else {
                                            body += getResources().getString(R.string.i_decrypt);
                                        }
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        Uri data = Uri.parse(getResources().getString(R.string.mt_subj) +
                                                getResources().getString(R.string.morzeWithWorze) +
                                                getResources().getString(R.string.amp_body) + body);
                                        intent.setData(data);
                                        startActivity(intent);
                                    }

                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    pm.show();
                    break;
                case R.id.translate_btn:
                    if (textabove.getText().toString().length() == 0) {
                        textbelow.setText("");
                        ws.makeToast(context, getString(R.string.whattotranslate), R.drawable.toast_red);
                    } else {
                        textbelow.setText("");
                        if (ws.getConverting() == 0) {
                            textbelow.setText(CodingMeths.coding(textabove.getText().toString().toLowerCase()));
                            if (ws.getUsingSounds() == 1) {
                                Thread thread2 = new Thread() {
                                    @Override
                                    public void run() {
                                        String st = textabove.getText().toString().replaceAll("\\s", "").toLowerCase();
                                        for (int i = 0; i < st.length(); i++) {
                                            MakeSounds.playSound(st.charAt(i), sp);
                                            MakeSounds.makeDelay(ws.getDelay());
                                        }
                                    }
                                };
                                thread2.start();
                            }
                        } else {
                            textbelow.setText(CodingMeths.decoding(textabove.getText().toString(), ws.getLanguage()));
                        }

                    }
            }

        }
    };
    /**
     * Показания акселерометра
     */
    private float mAccel;
    /**
     * Текущие показания акселерометра
     */
    private float mAccelCurrent;
    /**
     * Последние показания акселерометра
     */
    private float mAccelLast;
    /**
     * Менеджер сенсоров
     */
    private SensorManager sensorManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.code);
        }
        context = this.getApplicationContext();
        ws = WorzeSingleton.getInstance(context);
        textabove = (EditText) findViewById(R.id.textabove);
        textbelow = (TextView) findViewById(R.id.textbelow);
        sounds_btn = (Button) findViewById(R.id.sounds_btn);
        translate_btn = (Button) findViewById(R.id.translate_btn);
        shest_btn = (Button) findViewById(R.id.shest_btn);
        speech_btn = (Button) findViewById(R.id.speech_btn);
        speech_btn.setOnClickListener(listener2);
        sounds_btn.setOnClickListener(this.listener2);
        shest_btn.setOnClickListener(this.listener2);
        translate_btn.setOnClickListener(this.listener2);
        context = this;
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
        enableAccelerometerListening();
        mylistener = new CleanSensorEventListener();
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        Thread thread = new Thread() {
            @Override
            public void run() {
                MakeSounds.loadSounds(sp, context);
            }
        };
        thread.start();
    }

    /**
     * Получение результата работы распознавания речи
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textabove.setText(text.get(0));
                }
                break;
            }
        }
    }

    /**
     * При нажатии на кнопку Back пользователь попадает в главное меню
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(CodeActivity.this, MainMenu.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * При паузе активности акселерометр не прослушивается
     */
    @Override
    protected void onPause() {
        super.onPause();
        disableAccelerometerListening();
    }

    /**
     * Включение прослушки акселерометра
     */
    private void enableAccelerometerListening() {
        sensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(mylistener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * Выключение прослушки акселерометра
     */
    private void disableAccelerometerListening() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(
                    mylistener,
                    sensorManager.getDefaultSensor(
                            SensorManager.SENSOR_ACCELEROMETER));
            sensorManager = null;
        }
    }

    /**
     * Помимо снятия работы активности с паузы - проверка работоспособности акселерометра
     */
    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (s == null)
            ws.makeToast(context, getString(R.string.accel_lost), R.drawable.toast_red);
        ((SensorManager) getSystemService(SENSOR_SERVICE)).registerListener(
                mylistener, s, SensorManager.SENSOR_DELAY_NORMAL);
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
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Класс, реализующий очистку текстовых полей
     */
    class CleanSensorEventListener implements SensorEventListener {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        /**
         * Метод, позволяющий очищать текстовые поля
         */
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;

            if ((!textabove.getText().toString().equals("") || !textbelow.getText().toString().equals("")) && mAccel * mAccel > 150) {
                textabove.setText("");
                textbelow.setText("");
                mAccelLast = mAccelCurrent = mAccel = 0;

            }
        }

    }
}
