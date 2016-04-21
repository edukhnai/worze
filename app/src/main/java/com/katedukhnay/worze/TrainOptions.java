package com.katedukhnay.worze;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

/**Активность, в которой пользователь будет выбирать параметры тренировки*/
public class TrainOptions extends AppCompatActivity {
    /**Текстовые поля для выбора пользователем количества групп и задержки между символами соответственно*/
EditText groupAmount, symbolDelay;
    /**Поле синглтона*/
    WorzeSingleton ws;
    /**Контекст класса*/
    Context context;
    /**Кнопка, по нажатии которой пользователь переходит в активность тренировки*/
    Button readyToPlay;
    /**Текстовое поле для выбора пользователем языка смволов в группах*/
    TextView chooseLang;
    /**CheckBox для выбора пользователем, будут ли в группах символы и цифры или нет*/
    CheckBox symbCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_options);
        ws=WorzeSingleton.getInstance(getApplicationContext());
        context=this.getApplicationContext();
        groupAmount=(EditText)findViewById(R.id.groupAmount);
        symbolDelay=(EditText)findViewById(R.id.symbolDelay);
        readyToPlay=(Button)findViewById(R.id.readyToPlay);
        readyToPlay.setOnClickListener(this.readyListener);
        chooseLang=(TextView)findViewById(R.id.chooselang);
        chooseLang.setOnClickListener(this.readyListener);
        symbCheck=(CheckBox)findViewById(R.id.symbCheck);

    }
    /**Слушатель нажатий на кнопки данной активности*/
    View.OnClickListener readyListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.readyToPlay:
          if (groupAmount.getText().toString().equals("")||symbolDelay.getText().toString().equals("")) {
              ws.makeToast(context, getString(R.string.error_f), R.drawable.toast_red);
           }              else  if((Integer.parseInt(groupAmount.getText().toString())<1 || Integer.parseInt(groupAmount.getText().toString())>15)
                  ||(Long.valueOf(symbolDelay.getText().toString())<1L || Float.valueOf(symbolDelay.getText().toString())>5L)){
              ws.makeToast(context, getString(R.string.edges_error), R.drawable.toast_red);
          } else {
               if (symbCheck.isChecked()) {
                   ws.setUsingSymbs(1);
               } else {
                   ws.setUsingSymbs(0);
               }
               ws.setGroups(Integer.parseInt(groupAmount.getText().toString()));
               ws.setDelay(Long.valueOf(symbolDelay.getText().toString()));
               startActivity(new Intent(TrainOptions.this, TrainActivity.class));
              overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
           };
            break;
                case R.id.chooselang:
                    PopupMenu pm= new PopupMenu(context, v);
                    pm.inflate(R.menu.choose_l);
                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.rusl:if(ws.getTrainLanguage()==1){
                                   chooseLang.setText(R.string.ruslang);
                                }
                                    ws.setTrainLanguage(0);
                                    return true;
                                case R.id.engl:if(ws.getTrainLanguage()==0){
                                    chooseLang.setText(R.string.englang);
                                }
                                    ws.setTrainLanguage(1);
                                    return true;
                                default:return false;
                            }
                        }
                    });
                    pm.show();break;



            }
        }
    };
    /**При нажатии на кнопку Back пользователь попадает в главное меню*/
    @Override
    public void onBackPressed(){
        startActivity(new Intent(TrainOptions.this, MainMenu.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
