package com.katedukhnay.worze;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
/**Активность с советами*/
public class Tips extends AppCompatActivity {
    /**Контекст класса*/
    Context context;
    /**Ткстовое поле с эл.почтой*/
    TextView myMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  if (savedInstanceState == null) {  setContentView(R.layout.tips);}

        context=this;
        myMail=(TextView)findViewById(R.id.myMail);
myMail.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (intent.resolveActivity(getPackageManager()) != null) {
        Uri data = Uri.parse(getResources().getString(R.string.mt_subj) +
                getResources().getString(R.string.morzeWithWorze) +
                getResources().getString(R.string.amp_body) + getResources().getString(R.string.ihaveaquest));
        intent.setData(data);
        startActivity(intent);}
    }});
}
    /**При нажатии на кнопку Back пользователь попадает в главное меню*/
    @Override
    public void onBackPressed() {
startActivity(new Intent(Tips.this, MainMenu.class));
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
