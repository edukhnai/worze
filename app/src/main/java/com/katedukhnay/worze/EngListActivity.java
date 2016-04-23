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
/**Активность, позволяющая отображать список английских букв с их зашифровкой и напевами в виде списка*/
public class EngListActivity extends AppCompatActivity {
    /**Кнопки для перемещения в активность со списком русских букв и со списком символов и цифр соотв.*/
    Button toRusListFromEng, toSymbsListFromEng;
    /**ListView для английских букв*/
    ListView listAlphabetEng;
    /**ArrayList для английских букв с их зашифровкой и напевами*/
    private ArrayList<HashMap<String, Object>> alphaListEng;
    /**Код(зашифровка) элемента списка*/
    private static final String CODE1 = "-----";
    /**Напев элемента списка*/
    private static final String SING1 = "la-la-la";
    /**Иконка элемента списка*/
    private static final String ICON1 = "icon";
    /**Поле SoundPool-а*/
    SoundPool sp;
    /**Контекст класса*/
    Context context;
    /**Таблица отдельных английских букв в качестве символов*/
    HashMap<Integer, Character> soundsEng;
    final static String engAlphabet="abcdefghijklmnopqrstuvwxyz";
    /**Слушатель для кнопок переходов из данной активности в соседние*/
    View.OnClickListener fromEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
       if (savedInstanceState == null) {
        setContentView(R.layout.alphabet_list_eng);}
        toRusListFromEng = (Button) findViewById(R.id.toRusListFromEng);
        initListener();
        toRusListFromEng.setOnClickListener(fromEng);
        toSymbsListFromEng = (Button) findViewById(R.id.toSymbsListFromEng);
        if(toSymbsListFromEng!=null)toSymbsListFromEng.setOnClickListener(fromEng);
        listAlphabetEng = (ListView) findViewById(R.id.listAlphabetEng);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        context = this;
        alphaListEng = new ArrayList<>();
        soundsEng = new HashMap<>();
        Thread thread = new Thread() {
            @Override
            public void run() {
                MakeSounds.loadSounds(sp, context);
            }
        };
        thread.start();
/**Массив зашифровок букв*/
        String[] codes = {getString(R.string.a_rus_code), getString(R.string.b_rus_code), getString(R.string.ce_rus_code), getString(R.string.d_rus_code),
                getString(R.string.e_rus_code), getString(R.string.f_rus_code), getString(R.string.ge_rus_code), getString(R.string.x_rus_code),
                getString(R.string.i_rus_code), getString(R.string.ij_rus_code), getString(R.string.k_rus_code), getString(R.string.el_rus_code), getString(R.string.m_rus_code),
                getString(R.string.n_rus_code), getString(R.string.o_rus_code), getString(R.string.pe_rus_code), getString(R.string.shja_rus_code),
                getString(R.string.r_code), getString(R.string.es_rus_code), getString(R.string.t_rus_code), getString(R.string.y_rus_code),
                getString(R.string.je_rus_code), getString(R.string.ve_rus_code), getString(R.string.znaki_rus_code), getString(R.string.ji_rus_code),
                getString(R.string.ze_rus_code)};
/**Массив напевов для букв*/
        String[] sings = {getString(R.string.a_rus_sing), getString(R.string.b_rus_sing), getString(R.string.ce_rus_sing), getString(R.string.d_rus_sing),
                getString(R.string.e_rus_sing), getString(R.string.f_rus_sing), getString(R.string.ge_rus_sing), getString(R.string.x_rus_sing),
                getString(R.string.i_rus_sing), getString(R.string.ij_rus_sing), getString(R.string.k_rus_sing), getString(R.string.el_rus_sing), getString(R.string.m_rus_sing),
                getString(R.string.n_rus_sing), getString(R.string.o_rus_sing), getString(R.string.pe_rus_sing), getString(R.string.shja_rus_sing),
                getString(R.string.er_rus_sing), getString(R.string.es_rus_sing), getString(R.string.t_rus_sing), getString(R.string.y_rus_sing),
                getString(R.string.je_rus_sing), getString(R.string.ve_rus_sing), getString(R.string.znaki_rus_sing), getString(R.string.ji_rus_sing),
                getString(R.string.ze_rus_sing)};
/**Массив изображений для букв*/
        int[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.eng_d, R.mipmap.e, R.mipmap.eng_f, R.mipmap.eng_g, R.mipmap.nh, R.mipmap.eng_i,
                R.mipmap.eng_j, R.mipmap.k, R.mipmap.eng_l, R.mipmap.m, R.mipmap.eng_n, R.mipmap.o, R.mipmap.p, R.mipmap.eng_q, R.mipmap.eng_r, R.mipmap.eng_s,
                R.mipmap.t, R.mipmap.eng_u, R.mipmap.eng_v, R.mipmap.eng_w, R.mipmap.x, R.mipmap.eng_y, R.mipmap.eng_z};

        for (int q = 0; q < images.length; q++) {
            soundsEng.put(q, engAlphabet.charAt(q));
        }
        for (int i = 0; i < codes.length; i++) {
            addToHm(codes[i], sings[i], images[i], alphaListEng);
        }
        /**Адаптер для заполнения ListView с английскими буквами*/
        SimpleAdapter adapter2 = new SimpleAdapter(this, alphaListEng,
                R.layout.alphabetlist_item, new String[]{CODE1, SING1, ICON1},
                new int[]{R.id.text_code, R.id.text_sing, R.id.img});
/**Установка адаптера на ListView с английскими буквами*/
        listAlphabetEng.setAdapter(adapter2);
        listAlphabetEng.setClickable(true);
        /**По нажатию на элемент ListView проигрывается его зашифровка*/
        listAlphabetEng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MakeSounds.playSound(soundsEng.get(position), sp);
            }
        });

    }

public void initListener(){
fromEng = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toRusListFromEng:
                    startActivity(new Intent(EngListActivity.this, RusListActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;
                case R.id.toSymbsListFromEng:
                    startActivity(new Intent(EngListActivity.this, SymbsListActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;
            }
        }
    };}
    /**Метод для добавления элемента в HashMap*/
    public static void addToHm(String s1, String s2, int icon, ArrayList<HashMap<String, Object>> alphaList) {
        HashMap<String, Object> h = new HashMap<>();
        h.put(CODE1, s1);
        h.put(SING1, s2);
        h.put(ICON1, icon);
        alphaList.add(h);
    }
    /**При нажатии на кнопку Back пользователь попадает в главное меню*/
    @Override
    public void onBackPressed(){
        startActivity(new Intent(EngListActivity.this, MainMenu.class));
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
