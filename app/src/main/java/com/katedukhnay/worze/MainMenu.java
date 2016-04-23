package com.katedukhnay.worze;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**Главное меню*/
public class MainMenu extends AppCompatActivity {
    /**Поле, с помощью которого можно обращаться к содержимому синглтона*/
    WorzeSingleton ws;
    /** Поля для кнопок в главном меню */
    Button alphabet_btn, code_btn, train_btn, tips_btn, exit_btn;
    /** Поле для ввода имени игрока */
    TextView name_tv;
    /** Контекст главного меню */
Context context;
    /** Слушатель нажатий на кнопки в главном меню*/
    View.OnClickListener listener1;
    LinearLayout linButtons;
    ScrollView scrollButtons;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.mainmenu);
        }
        ws = WorzeSingleton.getInstance(getApplicationContext());
        context = this.getApplicationContext();
        initListener();
        scrollButtons = (ScrollView) findViewById(R.id.scrollButtons);
        linButtons = (LinearLayout) findViewById(R.id.linButtons);
        if (linButtons != null)  linButtons.setOnClickListener(listener1);
        alphabet_btn = (Button) findViewById(R.id.alphabet_btn);
        if (alphabet_btn != null)  alphabet_btn.setOnClickListener(this.listener1);
        code_btn = (Button) findViewById(R.id.code_btn);
        if (code_btn!= null)code_btn.setOnClickListener(this.listener1);
        train_btn = (Button) findViewById(R.id.train_btn);
        if (train_btn!= null)  train_btn.setOnClickListener(this.listener1);
        tips_btn = (Button) findViewById(R.id.tips_btn);
        if (tips_btn!= null) tips_btn.setOnClickListener(this.listener1);
        exit_btn = (Button) findViewById(R.id.exit_btn);
        if (exit_btn!= null)exit_btn.setOnClickListener(this.listener1);
        name_tv = (TextView) findViewById(R.id.name_tv);
        name_tv.setText(ws.getName().concat(getString(R.string.exclam_point)));
        name_tv.setOnClickListener(this.listener1);
    }


/**Метод для инициализации слушателя нажатий на кнопки*/
public void initListener(){
listener1= new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.name_tv:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenu.this);

                LayoutInflater inflater = LayoutInflater.from(context);

                View dialogview = inflater.inflate(R.layout.name_dialog, null);

                builder.setView(dialogview)

                        .setTitle(getString(R.string.name_quest))
                        .setCancelable(false)

                        .setIcon(R.mipmap.alert_icon)

                        .setPositiveButton(getString(R.string.ready),

                                new DialogInterface.OnClickListener() {

                                    @Override

                                    public void onClick(DialogInterface dialog, int id) {

                                        AlertDialog alertDialog=(AlertDialog)dialog;

                                        EditText poleaddname = (EditText) alertDialog.findViewById(R.id.poleaddname);

                                        String straddName = poleaddname.getText().toString();
                                        if(straddName.isEmpty()){straddName=getString(R.string.player_name1);}
                                        String str1=straddName.replaceAll("\\s","").toLowerCase();
                                        if(UnnormalWords.check(str1)) {
                                       ws.makeToast(context, getString(R.string.unnorm_word), R.drawable.toast_red);
                                            return;}
                                        ws.setName(straddName);
                                        name_tv.setText(ws.getName().concat(getString(R.string.exclam_point)));
                                        dialog.dismiss();
                                    }

                                })
                        .show();
                break;
            case R.id.alphabet_btn:
                startActivity(new Intent(MainMenu.this, RusListActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.code_btn:
                startActivity(new Intent(MainMenu.this, CodeActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.train_btn:
                startActivity(new Intent(MainMenu.this, TrainOptions.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.tips_btn:
                startActivity(new Intent(MainMenu.this, Tips.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.exit_btn:
                finishAffinity();
                break;
        }
    }};}
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



