package com.katedukhnay.worze;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MakeSounds {
   static final String fullAlphabet = "абвгдежзийклмнопрстуфхцчшщьыэюяabcdefghijklmnopqrstuvwxyz1234567890-'\"+=.,/!@;:?()&_$";
     static int[] adresses = {R.raw.a, R.raw.b, R.raw.w, R.raw.g, R.raw.d, R.raw.e, R.raw.v, R.raw.z, R.raw.i, R.raw.j, R.raw.k,
            R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.f, R.raw.h, R.raw.c,
            R.raw.che, R.raw.sha, R.raw.q, R.raw.x, R.raw.y, R.raw.ee, R.raw.ju, R.raw.ja, R.raw.a, R.raw.b,
            R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n,
            R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z,
            R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five, R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine,
            R.raw.zero, R.raw.realtire, R.raw.apostrof, R.raw.kavychki, R.raw.plus, R.raw.doubleslash, R.raw.realpoint,
            R.raw.comma, R.raw.realslash, R.raw.vosklzn, R.raw.at, R.raw.pointcomma, R.raw.doublepoint, R.raw.questzn,
            R.raw.brackets, R.raw.brackets, R.raw.ampersand, R.raw.underscore, R.raw.dollar};

    static HashMap<Character, Integer> soundMap;

    static{
        soundMap = new HashMap<Character,Integer>();
        Log.d("myTags", "soundMap создался");
    }

    public static void makeDelay(long i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void loadSounds(SoundPool sp,Context c){
        for (int i = 0; i < fullAlphabet.length(); i++) {
            soundMap.put(fullAlphabet.charAt(i), sp.load(c, adresses[i], 1));
            Log.d("myTags", "В soundMap добавилось (" + fullAlphabet.charAt(i) + ";" + soundMap.get(fullAlphabet.charAt(i)) + ")");
        }
        }


    public static void playSound(char ch, SoundPool sp) {
        sp.play(soundMap.get(ch), 1, 1, 1, 0, 1f);
        Log.d("myTags", "sp.play сработал");
    }

}