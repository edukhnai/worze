package com.katedukhnay.worze;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @author Kate Dukhnay
 * Сплеш-заставка*/
public class Entring extends AppCompatActivity {
    /**Текстовое поле с процентами, показывающими прогресс загрузки игры*/
    TextView percent;
    /**Индикаор прогресса загрузки игры*/
    ProgressBar pbView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            setContentView(R.layout.entring);
            percent = (TextView) findViewById(R.id.percent);
            pbView = (ProgressBar) findViewById(R.id.pbView);
            SystemClock.sleep(2000);
            new MyAsyncTask().execute();
        }

    }
    /**Класс, позволяющий имитировать загрузку программы*/
    class MyAsyncTask extends AsyncTask<Void, Integer, View> {

        /**Процент, стоящий в текстовом поле для прогресса загрузки игры*/
        private int pbValue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        /**Установка текста, содержащего процент загрузки приложения*/
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pbView.setProgress(values[0]);
            percent.setText(values[0] + getString(R.string.prsent));

        }
        /**Наращивание процента загруженности приложения*/
        @Override
        protected View doInBackground(Void... params) {

            for (int i=0;i < 100; i++) {
                pbValue++;
                publishProgress(pbValue);
                SystemClock.sleep(50);
            }
            return null;
        }
        /**По окончании "загрузки" приложения - переход в главное меню*/
        @Override
        protected void onPostExecute(View a) {
            Intent intent2 = new Intent(Entring.this,
                    MainMenu.class);
            startActivity(intent2);
            super.onPostExecute(a);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }
    /**Не позволяет пользователю использовать кнопку back */
    @Override
    public void onBackPressed(){}
}
