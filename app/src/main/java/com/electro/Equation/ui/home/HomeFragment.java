package com.electro.Equation.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.electro.Equation.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class HomeFragment extends Fragment {

    //private HomeViewModel homeViewModel;

    private View root;

    //public SharedPreferences prefs = getSharedPreferences("settings", Context.MODE_PRIVATE);;

    private final NumberFormat nf = new DecimalFormat("#.######");

    private double a=1, b=0, c=0;
    public boolean fo = true;
    //private boolean bi = false; //  Би может понадобиться позже
    private String letter = "x";

    private TextView answer;
    private EditText numA, numB, numC;
    private SwitchCompat formulaSwitch;

    private static double string_to_double(String number, double or) {
        double out;

        if(number.equals("")) return or;
        else if(number.equals("-")) out = -1;
        else if( ("" + number.charAt(number.length() - 1)).equals(".") ) out = Double.parseDouble(number+"0");
        else out = Double.parseDouble(number);

        return out;
    }

    private String formatNum (double num) {
        return (num<0 ? "(" : "") + nf.format(num) + (num<0 ? ")" : "");
    }

    private String makeEquation () {
        //  ax² + bx + c = 0

        String out = "";

        //  Разбираемся с первым аргументов
        if(a == 0) return "Первый аргумент не может быть равен нулю!";
        if(a != 1 && a != -1) out += nf.format(a);
        if(a == -1) out += "-";
        out += letter + "² ";

        //  Разбираемся с вторым аргументом
        if(b != 0) {
            out += b>0 ? "+ " : "- ";

            if(b != 1 && b != -1) out += nf.format(Math.abs(b));
            out += letter + " ";
        }

        //  Разбираемся с третьим
        if(c != 0) out += (c>0 ? "+ " : "- ") + nf.format(Math.abs(c))+" ";

        out += "= 0;";

        return out;
    }

    private String solve_full () {
        //  ax² + bx + c = 0

        String out = "";
        if(b%2==0) {

            double k = b/2;
            double D = k*k - a*c;

            out+= "k = b/2<br>";

            out+= "D₁ = " + (fo ? "k² - ac = " : "") +
                    formatNum(k) + "² - " + formatNum(a) + " * " + formatNum(c) + " = " +
                    formatNum(k*k) + (-a*c > 0 ? " + " : " - ") + formatNum( Math.abs(-a*c) ) + " = <b>" + nf.format(D) + "</b><br>";

            if(D<0) return out + "D₁ < 0 => Корней нет<br><br><b>Ответ: </b>Корней нет";

            if(D==0) {
                out += "D₁ = 0 => Один корень<br>";

                out += letter + " = " + (fo ? "-k/a = " : "") +
                        formatNum(-k) + " / " + formatNum(a) + " = <b>" +
                        nf.format(-k/a) + "</b><br>";

                out+= "<br><b>Ответ:</b> " + nf.format(-k/a);

            }

            if(D>0) {
                out += "D₁ > 0 => Два Корня<br>";

                out += letter + "₁ = " + (fo ? "(-k - √D)/a = " : "") +
                        "(" + formatNum(-k) + " - √" + formatNum(D) + ") / " + formatNum(a) + " = " +
                        "(" + formatNum(-k) + " - " + formatNum(Math.sqrt(D)) + ") / " + formatNum(a) + " = " +
                        formatNum(-k-Math.sqrt(D)) + " / " + formatNum(a) + " = <b>" +
                        nf.format((-k-Math.sqrt(D))/a) + "</b><br>";

                out += letter + "₂ = " + (fo ? "(-k + √D)/a = " : "") +
                        "(" + formatNum(-k) + " + √" + formatNum(D) + ") / " + formatNum(a) + " = " +
                        "(" + formatNum(-k) + " + " + formatNum(Math.sqrt(D)) + ") / " + formatNum(a) + " = " +
                        formatNum(-k+Math.sqrt(D)) + " / " + formatNum(a) + " = <b>" +
                        nf.format((-k+Math.sqrt(D))/a) + "</b><br>";

                out+= "<br><b>Ответ:</b> " + nf.format((-k-Math.sqrt(D))/a) + "; " + nf.format((-k+Math.sqrt(D))/a);

            }

        } else {

            double D = b*b - 4*a*c;

            out+= "D = " + (fo ? "b² - 4ac = " : "") +
                    formatNum(b) + "² - 4 * " + formatNum(a) + " * " + formatNum(c) + " = " +
                    formatNum(b*b) + (-4*a*c > 0 ? " + " : " - ") + formatNum( Math.abs(4*a*c) ) + " = <b>" + nf.format(D) + "</b><br>";

            if(D<0) return out + "D < 0 => Корней нет<br><br><b>Ответ: </b>Корней нет";

            if(D==0) {
                out += "D = 0 => Один корень<br>";

                out += letter + " = " + (fo ? "-b/2a = " : "") +
                        formatNum(-b) + " / " + "(2 * " + formatNum(a) + ") = " +
                        formatNum(-b) + " / " + formatNum(2*a) + " = <b>" +
                        nf.format(-b/(2*a)) + "</b><br>";

                out+= "<br><b>Ответ:</b> " + nf.format(-b/(2*a));

            }

            if(D>0) {
                out += "D > 0 => Два Корня<br>";

                out += letter + "₁ = " + (fo ? "(-b - √D)/2a = " : "") +
                        "(" + formatNum(-b) + " - √" + formatNum(D) + ") / " + "(2 * " + formatNum(a) + ") = " +
                        "(" + formatNum(-b) + " - " + formatNum(Math.sqrt(D)) + ") / " + formatNum(2*a) + " = " +
                        formatNum(-b-Math.sqrt(D)) + " / " + formatNum(2*a) + " = <b>" +
                        nf.format((-b-Math.sqrt(D))/(2*a)) + "</b><br>";

                out += letter + "₂ = " + (fo ? "(-b + √D)/2a = " : "") +
                        "(" + formatNum(-b) + " + √" + formatNum(D) + ") / " + "(2 * " + formatNum(a) + ") = " +
                        "(" + formatNum(-b) + " + " + formatNum(Math.sqrt(D)) + ") / " + formatNum(2*a) + " = " +
                        formatNum(-b+Math.sqrt(D)) + " / " + formatNum(2*a) + " = <b>" +
                        nf.format((-b+Math.sqrt(D))/(2*a)) + "</b><br>";

                out+= "<br><b>Ответ:</b> " + nf.format((-b-Math.sqrt(D))/(2*a)) + "; " + nf.format((-b+Math.sqrt(D))/(2*a));

            }

        }

        return out;
    }

    private String solve_b () {
        //  ax² + bx = 0

        String out = "";

        if (a == 1) {

            out += letter + " (" + letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + ") = 0;<br>";
            out += letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + " = 0 или " + letter + " = 0<br>";
            out += letter + " = " + nf.format(-b) + "<br>";

        } else if (a == -1) {

            out += letter + " (-" + letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + ") = 0;<br>";
            out += "-" + letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + " = 0 или " + letter + " = 0<br>";
            out += "-" + letter + " = " + nf.format(-b) + "<br>";
            //out += letter + " = " + formatNum(-b) + "/" + formatNum(a) + "<br>";
            out += letter + " = " + formatNum(-b / a) + "<br>";

        } else {

            out += letter + " (" + nf.format(a) + letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + ") = 0;<br>";
            out += nf.format(a) + letter + (b > 0 ? " + " : " - ") + nf.format(Math.abs(b)) + " = 0 или " + letter + " = 0<br>";
            out += nf.format(a) + letter + " = " + nf.format(-b) + "<br>";
            out += letter + " = " + formatNum(-b) + "/" + formatNum(a) + "<br>";
            out += letter + " = " + formatNum(-b / a) + "<br>";
        }

        out+= "<br><b>Ответ:</b> " + nf.format(-b/a) + "; 0";

        return out;
    }

    private String solve_c () {
        String out = "";

        if(a == 1) {
            out +=  letter+"² = " + nf.format(-c)+"<br>";

            if(-c < 0) return out + nf.format(-c) +" < 0 => Корней нет<br><br><b>Ответ: </b>Корней нет";

            out += letter+ " = " + nf.format(Math.sqrt(-c)) + "<br>";
        } else if(a == -1) {
            out +=  "-"+letter+"² = " + nf.format(-c)+"<br>" +
                    letter+"² = " + nf.format(c) + "<br>";

            if(c < 0) return out + nf.format(c) +" < 0 => Корней нет<br><br><b>Ответ: </b>Корней нет";

            out += letter+ " = " + nf.format(Math.sqrt(c)) + "<br>";
        } else {
            out +=  nf.format(a) + letter+"² = " + nf.format(-c)+"<br>"+
                    letter+"² = " + formatNum(-c)+ "/" + formatNum(a) + "<br>" +
                    letter+"² = " + nf.format(-c/a) + "<br>";

            if(-c/a < 0) return out + nf.format(-c/a) +" < 0 => Корней нет<br><br><b>Ответ: </b>Корней нет";

            out += letter+ " = " + nf.format(Math.sqrt(-c/a)) + "<br>";
        }

        out+= "<br><b>Ответ:</b> " + nf.format(Math.sqrt(-c/a));

        return out;
    }

    private String solve_without () {
        String out = "";

        if(a == 1) {
            out += "x = 0<br>";
        } else {
            out += "x² = 0/"+ formatNum(a) + "<br>" +
                    "x² = 0<br>" +
                    "x = 0";
        }

        out+= "<br><b>Ответ:</b> 0";

        return out;
    }

    private void initEquation () {
        String out = "<h4>" + makeEquation() + "</h4>";

        if(a==0) {
            answer.setText(Html.fromHtml(out));
            return;
        }

        if(b != 0 && c != 0) out += solve_full();
        if(b != 0 && c == 0) out += solve_b();
        if(b == 0 && c != 0) out += solve_c();
        if(b == 0 && c == 0) out += solve_without();

        answer.setText(Html.fromHtml(out));
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);

        //  Определим все переменные
        answer  = root.findViewById(R.id.answer);

        numA = root.findViewById(R.id.num_a);
        numB = root.findViewById(R.id.num_b);
        numC = root.findViewById(R.id.num_c);

        Spinner spinner = root.findViewById(R.id.spinner);

        formulaSwitch = root.findViewById(R.id.showFormuls);

        initEquation(); //  Инициализируемся

        //  Устанавливаем слушателей на изменение текста на поля для введения A, B, C.
        TextWatcher textwatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                a = string_to_double(numA.getText()+"", 1);
                b = string_to_double(numB.getText()+"", 0);
                c = string_to_double(numC.getText()+"", 0);

                initEquation();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        numA.addTextChangedListener(textwatcher);
        numB.addTextChangedListener(textwatcher);
        numC.addTextChangedListener(textwatcher);

        //  Устанавливаем слушателя на изменение на разворачивающееся меню (выбор буквы)
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                letter = (String)parent.getItemAtPosition(position);

                initEquation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //  Займёмся свитчем формул
        formulaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            fo = isChecked;
            initEquation();
        });

        return root;
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        // Запоминаем данные
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putBoolean("show_formula", fo);
//        editor.apply();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (prefs.contains("show_formula")) {
//            // Получаем число из настроек
//            fo = prefs.getBoolean("show_formula", true);
//            // Выводим на экран данные из настроек
//            formulaSwitch.setChecked(fo);
//        }
//    }

}