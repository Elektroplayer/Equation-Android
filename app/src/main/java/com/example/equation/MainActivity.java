package com.example.equation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText a, b, c;
    private TextView out;
    private String latter;
    private final String[] countries = {"x", "y", "z", "t", "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","u","v","w"};

    public static double string_to_double(String number, double or) {
        double out;

        if(number.equals("")) return or;
        else if(number.equals("-")) out = -1;
        else if( ("" + number.charAt(number.length() - 1)).equals(".") ) out = Double.parseDouble(number+"0");
        else out = Double.parseDouble(number);

        return out;
    }

    public static String findX(double a, double b, double c, String latter) {
        String out = "";

        NumberFormat nf = new DecimalFormat("#.######");

        if(a!=1) out = out + nf.format(a);

        out = out + latter +"² ";

        if(b!=0) {
            if (b == 1) out = out + "+ " + latter +" ";
            else if (b == -1) out = out + "- "  + latter + " ";
            else if (b < 0) out = out + "- " + nf.format(-b)  + latter + " ";
            else out = out + "+ " + nf.format(b) + latter + " ";
        }

        if(c!=0) {
            if(c<0) out = out + "- "+ nf.format(-c) + " ";
            else out = out + "+ "+ nf.format(c) + " ";
        }

        out = out + "= 0\n"; // Составлено квадратное уравнение. Далее его решение

        if (b != 0 && c != 0) {
            if(b % 2 == 0) {
                out = out + "k = b/2\n";

                double D, k, x1,x2;

                k=b/2;
                out = out + "D = k² - ac = ";

                if(a == 1) {
                    D = k*k - c;
                    x1 = (-k-Math.sqrt(D));
                    x2 = -k+Math.sqrt(D);

                    out = out + (nf.format(k) + "² - " + nf.format(c)) + " = " +(nf.format(k*k) + " - " + nf.format(c)) + " = " + nf.format(D) + "\n";

                    if(D<0) {
                        out = out + "D < 0\nКорней нет!";
                    } else if(D==0) {
                        out = out + "D = 0\nОдин корень\n" +
                                latter + " = -k/a = " + nf.format(-k) + "/ 1 = " + nf.format(-k);
                    } else {
                        out = out + "D > 0\nДва корня\n" +
                                latter + "₁ = (-k - √D) / a = " + ("(" + nf.format(-k) + " - √" + nf.format(D) + ") / 1 = ") + nf.format(x1) + "\n" +
                                latter + "₂ = (-k + √D) / a = " + ("(" + nf.format(-k) + " + √" + nf.format(D) + ") / 1 = ") + nf.format(x2);
                    }
                }
                else {
                    D = k*k - c * a;
                    x1 = (-k-Math.sqrt(D))/a;
                    x2 = (-k+Math.sqrt(D))/a;

                    out = out + (nf.format(k) + "² - " + nf.format(c) + " * " + nf.format(a)) + " = " +(nf.format(k*k) + " - " + nf.format(a*c)) + " = " + nf.format(D) + "\n";

                    if(D<0) {
                        out = out + "D < 0\nКорней нет!";
                    } else if(D==0) {
                        out = out + "D = 0\nОдин корень\n" +
                                latter + " = -k/a = " + nf.format(-k) + "/ " + nf.format(a) + " = " + nf.format(-k/a);
                    } else {
                        out = out + "D > 0\nДва корня\n" +
                                latter + "₁ = (-k - √D) / a = " + ("(" + nf.format(-k) + " - √" + nf.format(D) + ") / " + nf.format(a) + " = ") + nf.format(x1) + "\n" +
                                latter + "₂ = (-k + √D) / a = " + ("(" + nf.format(-k) + " + √" + nf.format(D) + ") / " + nf.format(a) + " = ") + nf.format(x2);
                    }
                }

            }
            else {
                double D, x1,x2;

                out = out + "D = b² - 4ac = ";

                if(a == 1) {
                    D = b*b - 4*c;
                    x1 = (-b-Math.sqrt(D))/2;
                    x2 = (-b+Math.sqrt(D))/2;

                    out = out + (nf.format(b) + "² - 4 * " + nf.format(c) + " * 1") + " = " +(nf.format(b*b) + " - " + nf.format(c*4)) + " = " + nf.format(D) + "\n";

                    if(D<0) {
                        out = out + "D < 0\nКорней нет!";
                    } else if(D==0) {
                        out = out + "D = 0\nОдин корень\n" +
                                latter + " = -b/2a = " + nf.format(-b) + "/ 2 = " + nf.format(-b/2);
                    } else {
                        out = out + "D > 0\nДва корня\n" +
                                latter + "₁ = (-b - √D) / (2 * a) = " + ("(" + nf.format(-b) + " - √" + nf.format(D) + ") / 2 = ") + nf.format(x1) + "\n" +
                                latter + "₂ = (-b + √D) / (2 * a) = " + ("(" + nf.format(-b) + " + √" + nf.format(D) + ") / 2 = ") + nf.format(x2);
                    }
                }
                else {
                    D = b*b - 4 * c * a;
                    x1 = (-b-Math.sqrt(D))/(2*a);
                    x2 = (-b+Math.sqrt(D))/(2*a);

                    out = out + (nf.format(b) + "² - 4 * " + nf.format(a) + " * " + nf.format(c)) + " = " +(nf.format(b*b) + " - " + nf.format(4*a*c)) + " = " + nf.format(D) + "\n";

                    if(D<0) {
                        out = out + "D < 0\nКорней нет!";
                    } else if(D==0) {
                        out = out + "D = 0\nОдин корень\n" +
                                latter + " = -b/2a = " + nf.format(-b) + "/ " + nf.format(2*a) + " = " + nf.format(-b/(2*a));
                    } else {
                        out = out + "D > 0\nДва корня\n" +
                                latter + "₁ = (-b - √D) / (2 * a) = " + ("(" + nf.format(-b) + " - √" + nf.format(D) + ") / (2 * " + nf.format(a) + ") = ") + nf.format(x1) + "\n" +
                                latter + "₂ = (-b + √D) / (2 * a) = " + ("(" + nf.format(-b) + " + √" + nf.format(D) + ") / (2 * " + nf.format(a) + ") = ") + nf.format(x2);
                    }
                }
            }
        }

        return out;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Определим все переменные
        a = findViewById(R.id.num_a);
        b = findViewById(R.id.num_b);
        c = findViewById(R.id.num_c);

        out = findViewById(R.id.textView3);

        latter = "x";

        Spinner spinner = findViewById(R.id.spinner);

        //  Займёмся спиннером
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                latter = (String)parent.getItemAtPosition(position);

                System.out.println(latter);

                if(string_to_double("" + a.getText(), 1) == 0) {
                    out.setText("Ошибка!\nПервый множитель не может быть равен 0!");
                    return;
                }

                out.setText(findX(
                        string_to_double("" + a.getText(), 1),
                        string_to_double("" + b.getText(), 0),
                        string_to_double("" + c.getText(), 0),
                        latter
                ));

                //latter = item;
                //selection.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        //  Займёмся полями
        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(string_to_double("" + a.getText(), 1) == 0) {
                    out.setText("Ошибка!\nПервый множитель не может быть равен 0!");
                    return;
                }

                out.setText(findX(
                        string_to_double("" + a.getText(), 1),
                        string_to_double("" + b.getText(), 0),
                        string_to_double("" + c.getText(), 0),
                        latter
                ));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(string_to_double("" + a.getText(), 1) == 0) {
                    out.setText("Ошибка!\nПервый множитель не может быть равен 0!");
                    return;
                }

                out.setText(findX(
                        string_to_double("" + a.getText(), 1),
                        string_to_double("" + b.getText(), 0),
                        string_to_double("" + c.getText(), 0),
                        latter
                ));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(string_to_double("" + a.getText(), 1) == 0) {
                    out.setText("Ошибка!\nПервый множитель не может быть равен 0!");
                    return;
                }

                out.setText(findX(
                        string_to_double("" + a.getText(), 1),
                        string_to_double("" + b.getText(), 0),
                        string_to_double("" + c.getText(), 0),
                        latter
                ));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}