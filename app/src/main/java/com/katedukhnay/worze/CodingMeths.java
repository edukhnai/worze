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
            if (s1.equals(".-")) {
                s_res += "а";
            } else if (s1.equals("-...")) {
                s_res += "б";
            } else if (s1.equals(".--")) {
                s_res += "в";
            } else if (s_res.equals("--.")) {
                s_res += "г";
            } else if (s1.equals("-..")) {
                s_res += "д";
            } else if (s1.equals(".")) {
                s_res += "е";
            } else if (s1.equals("...-")) {
                s_res += "ж";
            } else if (s1.equals("--..")) {
                s_res += "з";
            } else if (s1.equals("..")) {
                s_res += "и";
            } else if (s1.equals(".---")) {
                s_res += "й";
            } else if (s1.equals("-.-")) {
                s_res += "к";
            } else if (s1.equals(".-..")) {
                s_res += "л";
            } else if (s1.equals("--")) {
                s_res += "м";
            } else if (s1.equals("-.")) {
                s_res += "н";
            } else if (s1.equals("---")) {
                s_res += "о";
            } else if (s1.equals(".--.")) {
                s_res += "п";
            } else if (s1.equals(".-.")) {
                s_res += "р";
            } else if (s1.equals("...")) {
                s_res += "с";
            } else if (s1.equals("-")) {
                s_res += "т";
            } else if (s1.equals("..-")) {
                s_res += "у";
            } else if (s1.equals("..-.")) {
                s_res += "ф";
            } else if (s1.equals("....")) {
                s_res += "х";
            } else if (s1.equals("-.-.")) {
                s_res += "ц";
            } else if (s1.equals("---.")) {
                s_res += "ч";
            } else if (s1.equals("----")) {
                s_res += "ш";
            } else if (s1.equals("--.-")) {
                s_res += "щ";
            } else if (s1.equals("-..-")) {
                s_res += "ь";
            } else if (s1.equals("-.--")) {
                s_res += "ы";
            } else if (s1.equals("..-..")) {
                s_res += "э";
            } else if (s1.equals("..--")) {
                s_res += "ю";
            } else if (s1.equals(".-.-")) {
                s_res += "я";
            }
        } else if (lang == 1) {
            if (s1.equals(".-")) {
                s_res += "a";
            } else if (s1.equals("-...")) {
                s_res += "b";
            } else if (s1.equals(".--")) {
                s_res += "w";
            } else if (s_res.equals("--.")) {
                s_res += "g";
            } else if (s1.equals("-..")) {
                s_res += "d";
            } else if (s1.equals(".")) {
                s_res += "e";
            } else if (s1.equals("...-")) {
                s_res += "v";
            } else if (s1.equals("--..")) {
                s_res += "z";
            } else if (s1.equals("..")) {
                s_res += "i";
            } else if (s1.equals(".---")) {
                s_res += "j";
            } else if (s1.equals("-.-")) {
                s_res += "k";
            } else if (s1.equals(".-..")) {
                s_res += "l";
            } else if (s1.equals("--")) {
                s_res += "m";
            } else if (s1.equals("-.")) {
                s_res += "n";
            } else if (s1.equals("---")) {
                s_res += "o";
            } else if (s1.equals(".--.")) {
                s_res += "p";
            } else if (s1.equals(".-.")) {
                s_res += "r";
            } else if (s1.equals("...")) {
                s_res += "s";
            } else if (s1.equals("-")) {
                s_res += "t";
            } else if (s1.equals("..-")) {
                s_res += "u";
            } else if (s1.equals("..-.")) {
                s_res += "f";
            } else if (s1.equals("....")) {
                s_res += "h";
            } else if (s1.equals("-.-.")) {
                s_res += "c";
            } else if (s1.equals("--.-")) {
                s_res += "q";
            } else if (s1.equals("-..-")) {
                s_res += "x";
            } else if (s1.equals("-.--")) {
                s_res += "y";
            }
        }

        if (s1.equals("......")) {
            s_res += ".";
        } else if (s1.equals(".-.-.-")) {
            s_res += ",";
        } else if (s1.equals("..--..")) {
            s_res += "?";
        } else if (s1.equals("--..--")) {
            s_res += "!";
        } else if (s1.equals("---...")) {
            s_res += ":";
        } else if (s1.equals("-.-.-.")) {
            s_res += ";";
        } else if (s1.equals("-.--.-")) {
            s_res += ")";
        } else if (s1.equals("-..-.")) {
            s_res += "/";
        } else if (s1.equals(".--.-.")) {
            s_res += "@";
        } else if (s1.equals(".-...")) {
            s_res += "&";
        } else if (s1.equals(".-.-.")) {
            s_res += "+";
        } else if (s1.equals("-...-")) {
            s_res += "=";
        } else if (s1.equals("..--.-")) {
            s_res += "_";
        } else if (s1.equals("...-..-")) {
            s_res += "$";
        } else if (s1.equals(".----")) {
            s_res += "1";
        } else if (s1.equals("..---")) {
            s_res += "2";
        } else if (s1.equals("...--")) {
            s_res += "3";
        } else if (s1.equals("....-")) {
            s_res += "4";
        } else if (s1.equals(".....")) {
            s_res += "5";
        } else if (s1.equals("-....")) {
            s_res += "6";
        } else if (s1.equals("--...")) {
            s_res += "7";
        } else if (s1.equals("---..")) {
            s_res += "8";
        } else if (s1.equals("----.")) {
            s_res += "9";
        } else if (s1.equals("-----")) {
            s_res += "0";
        }
        return s_res;
    }
}

