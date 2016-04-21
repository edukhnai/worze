package com.katedukhnay.worze;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**Активность для показа пользователю результата тренировки и его рекорда*/
public class TrainResults extends AppCompatActivity {
    /**Текстовое поле с нынешним результатом и рекордом соответственно*/
    TextView finalPercents, maxPercents;
    /**Поле синглтона*/
    WorzeSingleton ws;
    /**Контекст класса*/
    Context context;
    /**Кнопка для перехода в главное меню*/
    Button toMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_results);
        finalPercents=(TextView)findViewById(R.id.finalPersents);
        maxPercents=(TextView)findViewById(R.id.maxPercents);
        ws=WorzeSingleton.getInstance(getApplicationContext());
        context=this.getApplicationContext();
        toMenu=(Button)findViewById(R.id.toMenu);
        toMenu.setOnClickListener(toMenuListener);
        finalPercents.setText(Integer.toString(ws.getCurrentScore()).concat(getString(R.string.prsent)));
        maxPercents.setText(Integer.toString(ws.getMaxScore()).concat(getString(R.string.prsent)));
    }
    /**Слушатель нажатия на кнопку возрата в главное меню*/
    View.OnClickListener toMenuListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(TrainResults.this, MainMenu.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };
    /**Не позволяет пользователю использовать кнопку Back*/
    @Override
    public void onBackPressed(){}

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

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        finalPercents.setText(Integer.toString(ws.getCurrentScore()).concat(getString(R.string.prsent)));
        maxPercents.setText(Integer.toString(ws.getMaxScore()).concat(getString(R.string.prsent)));super.onResume();
    }
}
