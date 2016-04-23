package com.katedukhnay.worze;

import java.util.ArrayList;

/**
 * Класс, содержащий статические методы для шифрования
 */
public class CodingMeths {
    /**
     * Метод для кодирования строки в символы
     */
    public static String coding(String first) {
        String finaltext = "";
        boolean b = false;
        for (int i = 0; i < first.length(); i++) {
            switch (first.charAt(i)) {
                case 'а':
                    finaltext += ".-/";
                    break;
                case 'a':
                    finaltext += ".-/";
                    break;
                case 'б':
                    finaltext += "-.../";
                    break;
                case 'b':
                    finaltext += "-.../";
                    break;
                case 'в':
                    finaltext += ".--/";
                    break;
                case 'w':
                    finaltext += ".--/";
                    break;
                case 'г':
                    finaltext += "--./";
                    break;
                case 'g':
                    finaltext += "--./";
                    break;
                case 'д':
                    finaltext += "-../";
                    break;
                case 'd':
                    finaltext += "-../";
                    break;
                case 'е':
                    finaltext += "./";
                    break;
                case 'e':
                    finaltext += "./";
                    break;
                case 'ё':
                    finaltext += "./";
                    break;
                case 'ж':
                    finaltext += "...-/";
                    break;
                case 'v':
                    finaltext += "...-/";
                    break;
                case 'з':
                    finaltext += "--../";
                    break;
                case 'z':
                    finaltext += "--../";
                    break;
                case 'и':
                    finaltext += "../";
                    break;
                case 'i':
                    finaltext += "../";
                    break;
                case 'й':
                    finaltext += ".---/";
                    break;
                case 'j':
                    finaltext += ".---/";
                    break;
                case 'к':
                    finaltext += "-.-/";
                    break;
                case 'k':
                    finaltext += "-.-/";
                    break;
                case 'л':
                    finaltext += ".-../";
                    break;
                case 'l':
                    finaltext += ".-../";
                    break;
                case 'м':
                    finaltext += "--/";
                    break;
                case 'm':
                    finaltext += "--/";
                    break;
                case 'н':
                    finaltext += "-./";
                    break;
                case 'n':
                    finaltext += "-./";
                    break;
                case 'о':
                    finaltext += "---/";
                    break;
                case 'o':
                    finaltext += "---/";
                    break;
                case 'п':
                    finaltext += ".--./";
                    break;
                case 'p':
                    finaltext += ".--./";
                    break;
                case 'р':
                    finaltext += ".-./";
                    break;
                case 'r':
                    finaltext += ".-./";
                    break;
                case 'с':
                    finaltext += ".../";
                    break;
                case 's':
                    finaltext += ".../";
                    break;
                case 'т':
                    finaltext += "-/";
                    break;
                case 't':
                    finaltext += "-/";
                    break;
                case 'у':
                    finaltext += "..-/";
                    break;
                case 'u':
                    finaltext += "..-/";
                    break;
                case 'ф':
                    finaltext += "..-./";
                    break;
                case 'f':
                    finaltext += "..-./";
                    break;
                case 'х':
                    finaltext += "..../";
                    break;
                case 'h':
                    finaltext += "..../";
                    break;
                case 'ц':
                    finaltext += ".-.-/";
                    break;
                case 'c':
                    finaltext += ".-.-/";
                    break;
                case 'ч':
                    finaltext += "---./";
                    break;
                case 'ш':
                    finaltext += "----/";
                    break;
                case 'щ':
                    finaltext += "--.-/";
                    break;
                case 'q':
                    finaltext += "--.-/";
                    break;
                case 'ъ':
                    finaltext += "-..-/";
                    break;
                case 'ы':
                    finaltext += "-.--/";
                    break;
                case 'y':
                    finaltext += "-.--/";
                    break;
                case 'ь':
                    finaltext += "-..-/";
                case 'x':
                    finaltext += "-..-/";
                    break;
                case 'э':
                    finaltext += "..-../";
                    break;
                case 'ю':
                    finaltext += "..--/";
                    break;
                case 'я':
                    finaltext += ".-.-/";
                    break;
                case ' ':
                    finaltext += "/";
                    break;
                case '1':
                    finaltext += ".----/";
                    break;
                case '2':
                    finaltext += "..---/";
                    break;
                case '3':
                    finaltext += "...--/";
                    break;
                case '4':
                    finaltext += "....-/";
                    break;
                case '5':
                    finaltext += "...../";
                    break;
                case '6':
                    finaltext += "-..../";
                    break;
                case '7':
                    finaltext += "--.../";
                    break;
                case '8':
                    finaltext += "---../";
                    break;
                case '9':
                    finaltext += "----./";
                    break;
                case '0':
                    finaltext += "-----/";
                    break;
                case '.':
                    finaltext += "....../";
                    break;
                case ',':
                    finaltext += ".-.-.-/";
                    break;
                case ';':
                    finaltext += "-.-.-./";
                    break;
                case ':':
                    finaltext += "---.../";
                    break;
                case '?':
                    finaltext += "..--../";
                    break;
                case '"':
                    finaltext += ".-..-./";
                    break;
                case '(':
                    finaltext += "-.--.-/";
                    break;
                case ')':
                    finaltext += "-.--.-/";
                    break;
                case '!':
                    finaltext += "--..--/";
                    break;
                case '-':
                    finaltext += "-...-/";
                    break;
                case '/':
                    finaltext += "-..-./";
                    break;
                case '@':
                    finaltext += ".--.-./";
                    break;
                case '&':
                    finaltext += ".-.../";
                    break;
                case '+':
                    finaltext += ".-.-./";
                    break;
                case '=':
                    finaltext += "-...-/";
                    break;
                case '_':
                    finaltext += "..--.-/";
                    break;
                case '$':
                    finaltext += "...-..-/";
                    break;
                default:
                    b = true;
                    break;

            }
        }
        if (b) {
            return " ";
        } else {
            finaltext = finaltext.substring(0, finaltext.length() - 1);
            return finaltext;
        }
    }

    /**
     * Метод для декодирования из символов в строку
     */
    public static String decoding(String f, int language) {
        ArrayList<Character> al = new ArrayList<>();
        boolean b2 = false;
        int k = 0;
        String str = "";
        for (int i = 0; i < f.length(); i++) {
            switch (f.charAt(i)) {
                case '.':
                    al.add('.');
                    k++;
                    break;
                case '-':
                    al.add('-');
                    k++;
                    break;
                case '/':
                    StringBuilder result = new StringBuilder(al.size());
                    for (Character c : al) {
                        result.append(c);
                    }
                    String output = result.toString();
                    k = 0;
                    str += helpDecode(output, language);
                    al.clear();
                    if ((i + 1) <= f.length() - 1) {
                        if (f.charAt(i + 1) == '/') {
                            str += " ";
                        }
                    }

                    break;
                default:
                    b2 = true;
                    break;

            }

        }
        if (!al.isEmpty()) {
            StringBuilder result = new StringBuilder(al.size());
            for (Character c : al) {
                result.append(c);
            }
            String output = result.toString();
            str += helpDecode(output, language);
            al.clear();
        }
        if (b2) {
            return " ";
        } else {
            return str;
        }
    }

    /**
     * Вспомогательный метод для метода decoding()
     */
    public static String helpDecode(String s1, int lang) {
        String s_res = "";
        if (lang == 0) {
            switch (s1) {
                case ".-":
                    s_res += "а";
                    break;
                case "-...":
                    s_res += "б";
                    break;
                case ".--":
                    s_res += "в";
                    break;
                case "--.":
                    s_res += "г";
                    break;
                case "-..":
                    s_res += "д";
                    break;
                case ".":
                    s_res += "е";
                    break;
                case "...-":
                    s_res += "ж";
                    break;
                case "--..":
                    s_res += "з";
                    break;
                case "..":
                    s_res += "и";
                    break;
                case ".---":
                    s_res += "й";
                    break;
                case "-.-":
                    s_res += "к";
                    break;
                case ".-..":
                    s_res += "л";
                    break;
                case "--":
                    s_res += "м";
                    break;
                case "-.":
                    s_res += "н";
                    break;
                case "---":
                    s_res += "о";
                    break;
                case ".--.":
                    s_res += "п";
                    break;
                case ".-.":
                    s_res += "р";
                    break;
                case "...":
                    s_res += "с";
                    break;
                case "-":
                    s_res += "т";
                    break;
                case "..-":
                    s_res += "у";
                    break;
                case "..-.":
                    s_res += "ф";
                    break;
                case "....":
                    s_res += "х";
                    break;
                case "-.-.":
                    s_res += "ц";
                    break;
                case "---.":
                    s_res += "ч";
                    break;
                case "----":
                    s_res += "ш";
                    break;
                case "--.-":
                    s_res += "щ";
                    break;
                case "-..-":
                    s_res += "ь";
                    break;
                case "-.--":
                    s_res += "ы";
                    break;
                case "..-..":
                    s_res += "э";
                    break;
                case "..--":
                    s_res += "ю";
                    break;
                case ".-.-":
                    s_res += "я";
                    break;
            }
        } else if (lang == 1) {
            switch(s1){
                case".-": s_res += "a";break;
                case"-...":
                s_res += "b";break;
                case".--":
                s_res += "w";break;
                case"--.":
                s_res += "g";break;
                case"-..":
                s_res += "d";break;
                case".":
                s_res += "e";break;
                    case "...-":
                s_res += "v";break;
                case"--..":
                s_res += "z";break;
                case"..":
                s_res += "i";break;
                case".---":
                s_res += "j";break;
                case"-.-":
                s_res += "k";break;
                case".-..":
                s_res += "l";break;
                case"--":
                s_res += "m";break;
                case"-.":
                s_res += "n";break;
                case"---":
                s_res += "o";break;
                case".--.":
                s_res += "p";break;
                case".-.":
                s_res += "r";break;
                case"...":
                s_res += "s";break;
                case"-":
                s_res += "t";break;
                case"..-":
                s_res += "u";break;
                case"..-.":
                s_res += "f";break;
                case"....":
                s_res += "h";break;
                case"-.-.":
                s_res += "c";break;
                case"--.-":
                s_res += "q";break;
                case"-..-":
                s_res += "x";break;
                case"-.--":
                s_res += "y";break;
            }
        }

        switch(s1){
            case "......":
            s_res += ".";break;
            case".-.-.-":
            s_res += ",";break;
            case"..--..":
            s_res += "?";break;
            case"--..--":
            s_res += "!";break;
            case"---...":
            s_res += ":";break;
            case"-.-.-.":
            s_res += ";";break;
            case"-.--.-":
            s_res += ")";break;
            case"-..-.":
            s_res += "/";break;
            case".--.-.":
            s_res += "@";break;
            case".-...":
            s_res += "&";break;
            case".-.-.":
            s_res += "+";break;
            case"-...-":
            s_res += "=";break;
            case"..--.-":
            s_res += "_";break;
            case "...-..-":
            s_res += "$";break;
            case".----":
            s_res += "1";break;
            case"..---":
            s_res += "2";break;
            case"...--":
            s_res += "3";break;
            case"....-":
            s_res += "4";break;
            case".....":
            s_res += "5";break;
            case"-....":
            s_res += "6";break;
            case"--...":
            s_res += "7";break;
            case"---..":
            s_res += "8";break;
            case"----.":
            s_res += "9";break;
            case"-----":
            s_res += "0";break;
        }
        return s_res;
    }
}

