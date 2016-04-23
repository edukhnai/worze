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
/**Активность, позволяющая отображать список русских букв с их зашифровкой и напевами в виде списка*/
public class RusListActivity extends AppCompatActivity {
    /**Кнопка для перемещения в активность со списком английских букв*/
Button toEngListFromRus;
    /**ListView для русских букв*/
    ListView listAlphabetRus;
    /**ArrayList для русских букв с их зашифровкой и напевами*/
    private ArrayList<HashMap<String, Object>> alphaListRus;
    /**Код(зашифровка) элемента списка*/
    private static final String CODE = "-----";
    /**Напев элемента списка*/
    private static final String SING = "la-la-la";
    /**Иконка элемента списка*/
    private static final String ICON = "icon";
    /**Поле SoundPool-а*/
    SoundPool sp;
    /**Контекст класса*/
    Context context;
    /**Таблица отдельных русских букв в качестве символов*/
    HashMap<Integer, Character> soundsRus;
    final static String rusAlphabet="абвгдежзийклмнопрстуфхцчшщьыэюя";
   /**Слушатель нажатий на кнопки*/
    View.OnClickListener toEngFromRus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
        setContentView(R.layout.alphabet_list_rus);}
        toEngListFromRus=(Button)findViewById(R.id.toEngListFromRus);
        initListener();
        toEngListFromRus.setOnClickListener(toEngFromRus);
        listAlphabetRus = (ListView) findViewById(R.id.listAlphabetRus);
        alphaListRus = new ArrayList<>();
        context=this;
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        soundsRus=new HashMap<>();
        Thread thread = new Thread() {
            @Override
            public void run() {
                MakeSounds.loadSounds(sp, context);
            }
        };
        thread.start();
/**Массив зашифровок букв*/
        String[] codes={getString(R.string.a_rus_code),getString(R.string.b_rus_code),getString(R.string.ve_rus_code),
                getString(R.string.ge_rus_code), getString(R.string.d_rus_code),getString(R.string.e_rus_code),getString(R.string.je_rus_code),
                getString(R.string.ze_rus_code),getString(R.string.i_rus_code), getString(R.string.ij_rus_code),getString(R.string.k_rus_code),
                getString(R.string.el_rus_code),getString(R.string.m_rus_code),getString(R.string.n_rus_code),getString(R.string.o_rus_code),
                getString(R.string.pe_rus_code),getString(R.string.r_code),getString(R.string.es_rus_code),getString(R.string.t_rus_code),
                getString(R.string.y_rus_code),getString(R.string.f_rus_code),getString(R.string.x_rus_code),getString(R.string.ce_rus_code),
                getString(R.string.che_rus_code),getString(R.string.sha_rus_code),getString(R.string.shja_rus_code),getString(R.string.znaki_rus_code),
                getString(R.string.ji_rus_code),getString(R.string.ee_rus_code),getString(R.string.ju_rus_code),getString(R.string.ja_rus_code)};
/**Массив напевов для букв*/
         String[] sings= {getString(R.string.a_rus_sing), getString(R.string.b_rus_sing), getString(R.string.ve_rus_sing),
                 getString(R.string.ge_rus_sing), getString(R.string.d_rus_sing), getString(R.string.e_rus_sing), getString(R.string.je_rus_sing),
                 getString(R.string.ze_rus_sing), getString(R.string.i_rus_sing), getString(R.string.ij_rus_sing), getString(R.string.k_rus_sing),
                 getString(R.string.el_rus_sing), getString(R.string.m_rus_sing), getString(R.string.n_rus_sing), getString(R.string.o_rus_sing),
                 getString(R.string.pe_rus_sing), getString(R.string.er_rus_sing), getString(R.string.es_rus_sing), getString(R.string.t_rus_sing),
                 getString(R.string.y_rus_sing), getString(R.string.f_rus_sing), getString(R.string.x_rus_sing), getString(R.string.ce_rus_sing),
                 getString(R.string.che_rus_sing),getString(R.string.sha_rus_sing),getString(R.string.shja_rus_sing),getString(R.string.znaki_rus_sing),
                 getString(R.string.ji_rus_sing),getString(R.string.ee_rus_sing),getString(R.string.ju_rus_sing), getString(R.string.ja_rus_sing)};
/**Массив изображений для букв*/
        int[] images={R.mipmap.a, R.mipmap.be, R.mipmap.b,R.mipmap.ge,R.mipmap.de,R.mipmap.e, R.mipmap.je, R.mipmap.ze,R.mipmap.i, R.mipmap.ij,
                R.mipmap.k, R.mipmap.el,R.mipmap.m,R.mipmap.nh,R.mipmap.o,R.mipmap.pe, R.mipmap.p, R.mipmap.c, R.mipmap.t, R.mipmap.y, R.mipmap.ef,
        R.mipmap.x, R.mipmap.tce, R.mipmap.che, R.mipmap.sha,R.mipmap.shja, R.mipmap.tmznak,R.mipmap.ji, R.mipmap.ee,R.mipmap.ju, R.mipmap.ja};

        for (int q=0; q<images.length; q++){
            soundsRus.put(q,rusAlphabet.charAt(q));
        }

        for(int i=0; i<codes.length; i++){
        EngListActivity.addToHm(codes[i], sings[i] ,images[i], alphaListRus);
        }
        /**Адаптер для заполнения ListView с русскими буквами*/
        SimpleAdapter adapter1 = new SimpleAdapter(this, alphaListRus,
                R.layout.alphabetlist_item, new String[]{CODE, SING, ICON},
                new int[]{R.id.text_code, R.id.text_sing, R.id.img});
/**Установка адаптера на ListView с русскими буквами*/
        listAlphabetRus.setAdapter(adapter1);
        listAlphabetRus.setClickable(true);
        /**По нажатию на элемент ListView проигрывается его зашифровка*/
        listAlphabetRus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MakeSounds.playSound(soundsRus.get(position), sp);
            }
        });}
public void initListener(){
   toEngFromRus=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            startActivity(new Intent(RusListActivity.this, EngListActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };}
    /**При нажатии на кнопку Back пользователь попадает в главное меню*/
    @Override
    public void onBackPressed(){
        startActivity(new Intent(RusListActivity.this, MainMenu.class));
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
