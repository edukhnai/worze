package com.katedukhnay.worze;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
/**Активность, позволяющая отображать список символов и цифр с их зашифровкой и напевами в виде списка*/
public class SymbsListActivity extends AppCompatActivity {
    /**Кнопка для перемещения в активность со списком английских букв*/
    Button toEngListFromSymbs;
    /**ListView для символов и цифр*/
    ListView listAlphabetSymbs;
    /**ArrayList для символов  цифр с их зашифровкой и напевами*/
    private ArrayList<HashMap<String, Object>> alphaListSymbs;
    /**Код(зашифровка) элемента списка*/
    private static final String CODE2 = "-----";
    /**Напев элемента списка*/
    private static final String SING2 = "la-la-la";
    /**Иконка элемента списка*/
    private static final String ICON2 = "icon";
    /**Поле SoundPool-а*/
    SoundPool sp;
    /**Контекст класса*/
    Context context;
    /**Таблица отдельных русских букв в качестве символов*/
    HashMap<Integer, Character> soundsSymbs;
    final static String symbsAlphabet="1234567890,.;:?)!-/@&+=_$";
    /**Слушатель для кнопки перехода из данной активности в соседнюю*/
    View.OnClickListener fromSymbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.alphabet_list_symbs);}
        toEngListFromSymbs=(Button)findViewById(R.id.toEngListFromSymbs);
        initListener();
        toEngListFromSymbs.setOnClickListener(fromSymbs);
        listAlphabetSymbs = (ListView) findViewById(R.id.listAlphabetSymbs);
        alphaListSymbs = new ArrayList<>();
        context=this;
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        soundsSymbs=new HashMap<>();
        Thread thread = new Thread() {
            @Override
            public void run() {
                MakeSounds.loadSounds(sp, context);
            }
        };
        thread.start();
        /**Массив зашифровок символов*/
        String[] codes={getString(R.string.one),getString(R.string.two), getString(R.string.three), getString(R.string.four),getString(R.string.five),
                getString(R.string.six), getString(R.string.seven), getString(R.string.eight), getString(R.string.nine), getString(R.string.zero),
                getString(R.string.comma_code), getString(R.string.point_code),getString(R.string.pointcomma_code),
                getString(R.string.doublepoint_code), getString(R.string.questzn_code),getString(R.string.brackets_code),getString(R.string.vosklzn_code),
                getString(R.string.tire_code),getString(R.string.realslash_code), getString(R.string.at_code),getString(R.string.ampersand_code),
                getString(R.string.plus_code),getString(R.string.doubledash),getString(R.string.underscore_code),getString(R.string.dollar_code)};
/**Массив напевов для сиволов*/
        String[] sings= {getString(R.string.one_sing),getString(R.string.two_sing),getString(R.string.three_sing),getString(R.string.four_sing),
                getString(R.string.five_sing),getString(R.string.six_sing),getString(R.string.seven_sing),getString(R.string.eight_sing),
                getString(R.string.nine_sing),getString(R.string.zero_sing),getString(R.string.comma_sing),getString(R.string.point_sing),
                getString(R.string.pointcomma_sing),getString(R.string.doublepoint_sing),getString(R.string.questzn_sing),
                getString(R.string.brackets_sing),getString(R.string.vosklzn_sing),getString(R.string.tire_sing),getString(R.string.realslash_sing),
                getString(R.string.at_sing),getString(R.string.ampersand_sing),getString(R.string.plus_sing),getString(R.string.doubledash_sing),
                getString(R.string.underscore_sing),getString(R.string.dollar_sing)};
/**Массив изображений для символов*/
        int[] images={R.mipmap.one, R.mipmap.two, R.mipmap.three,R.mipmap.four,R.mipmap.five,R.mipmap.six, R.mipmap.seven,R.mipmap.eight,
                R.mipmap.nine, R.mipmap.zero,R.mipmap.comma,R.mipmap.point,R.mipmap.pointcomma,R.mipmap.doublepoint, R.mipmap.questzn, R.mipmap.skobka,
                R.mipmap.vosklzn, R.mipmap.tire, R.mipmap.slash, R.mipmap.at,R.mipmap.ampersand,R.mipmap.plus,R.mipmap.doubledash,
                R.mipmap.underscore,R.mipmap.dollar};

        for (int q=0; q<images.length; q++){
            soundsSymbs.put(q,symbsAlphabet.charAt(q));
        }

        for(int i=0; i<codes.length; i++){
            EngListActivity.addToHm(codes[i], sings[i], images[i], alphaListSymbs);
        }
        /**Адаптер для заполнения ListView с символами и цифрами*/
        SimpleAdapter adapter1 = new SimpleAdapter(this, alphaListSymbs,
                R.layout.alphabetlist_item, new String[]{CODE2, SING2, ICON2},
                new int[]{R.id.text_code, R.id.text_sing, R.id.img});
/**Установка адаптера на listView*/
        listAlphabetSymbs.setAdapter(adapter1);
        listAlphabetSymbs.setClickable(true);
        /**По нажатию на элемент ListView проигрывается его зашифровка*/
        listAlphabetSymbs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MakeSounds.playSound(soundsSymbs.get(position), sp);
            }
        });}
    public void initListener(){
        fromSymbs=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            startActivity(new Intent(SymbsListActivity.this, EngListActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };}
    /**При нажатии на кнопку Back пользователь попадает в главное меню*/
    @Override
    public void onBackPressed(){
        startActivity(new Intent(SymbsListActivity.this, MainMenu.class));
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

