package com.example.kriptohelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_algoritm_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritm_1);
    }

    public void onMyClickExit(View view) {
        finish();
    }

    int[][] twoD = new int[6][20];  //массив таблицы
    int constB; //сонстанта переменной В
    int count; //подсчет для введенных данных количество столбцов
    boolean bool,bool1=false; //отвечает за возможность отката данных назад после очистки
    int Os, a, b;
    int consA;

    public void onMyButtonClear(View view) {
        TextView Resh = findViewById(R.id.Reshen); //вывод формулы
        TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
        TextView info = findViewById(R.id.textView2); //вывод названия строк таблицы
        TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
        TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат

        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание

        bool=true;
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        stk.removeAllViews();
        // TextView mInfoTextView = findViewById(R.id.textView);// вывод

        perA.setText(null);
        perB.setText(null);
        perOs.setText(null);
        // mInfoTextView.setText(null);
        info.setText(null);
        Rez1.setText(null);
        RezFormul.setText(null);
        Resh.setText(null);
        nameR.setText("Формат ввода: R_m(a*b)");
    }

    public void onMyButtonBack(View view) {
        if (bool1 && bool) {
            TextView Resh = findViewById(R.id.Reshen); //вывод формулы
            TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
            TextView info = findViewById(R.id.textView2); //вывод названия строк таблицы
            TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
            TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат
            RezFormul.setText("Таблица");
            Rez1.setText("\nФормула");
            nameR.setText("R_" + Os + "(" + consA + " * " + b + ") = ?");
            //подстчет длины символов в столбцах
            info.setText("i - \na - \n2b - \nC+b*R2 - \nb - \nc - ");
            TableLayout stk = (TableLayout) findViewById(R.id.table_main);
            stk.removeAllViews();
            for (int i = 0; i < 6; i++) {

                TableRow tbrow0 = new TableRow(this);

                for (int j = 0; j < count; j++) {
                    TextView tv0 = new TextView(this);
                    tv0.setText("  " + twoD[i][j] + "  ");
                    tv0.setTextColor(Color.WHITE);
                    tv0.setTextSize(17);
                    tv0.setGravity(Gravity.CENTER);
                    tbrow0.addView(tv0);
                }
                stk.addView(tbrow0);
            }
            int summ = twoD[5][count - 1] + twoD[4][count - 1];
            Resh.setText(" R_" + Os + "(" + consA + " * " + constB + ") = R_" + Os + "(" + twoD[4][count - 1] + " + " + twoD[5][count - 1] + ") = " + summ);
            if (summ > Os) {
                Resh.setText(" R_" + Os + "(" + consA + " * " + constB + ") = R_" + Os + "(" + twoD[4][count - 1] + " + " + twoD[5][count - 1] + ") = " + summ + " - " + Os + " = ");
                summ = summ - Os;
                Resh.append("" + summ);
            }
        } else Toast.makeText(this, "Проведи рассчет", Toast.LENGTH_SHORT).show();

    }


    public void onMyButtonClickAlgo1(View view) {

        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание

        String S1 = perA.getText().toString();//строка для переменной а и тд..
        String S2 = perB.getText().toString();
        String S3 = perOs.getText().toString();

        if (S1.length() == 0 || S2.length() == 0 || S3.length() == 0 || S1.startsWith("0") || S2.startsWith("0") || S3.startsWith("0")) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {

                TextView Resh = findViewById(R.id.Reshen); //вывод формулы
                TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
                TextView info = findViewById(R.id.textView2); //вывод названия строк таблицы
                TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
                TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат

                bool1 = true;

                info.setText(null);
                nameR.setText(null);
                Rez1.setText(null);
                RezFormul.setText(null);
                Resh.setText(null);//обнуление поля вывода


                Toast.makeText(this, "Считаем...", Toast.LENGTH_SHORT).show();

                int a1 = Integer.parseInt(S1); //переменна а в число
                a = a1; //копирование а в а1
                b = Integer.parseInt(S2);
                count = 0;
                Os = Integer.parseInt(S3);
                consA = a;
                constB = b;

                boolean chek = true; //для выхода из цикла проверки длины

                while (chek) {
                    if (a1 > 1) {
                        if (a1 % 2 == 0) {
                            count++;
                            a1 = a1 / 2;
                        } else {
                            count++;
                            a1 = (a1 - 1) / 2;
                        }
                    } else if (a1 == 1) {
                        count++;
                        chek = false;
                    }
                }
                nameR.setText("R_" + Os + "(" + consA + " * " + b + ") = ?");
                if (count > 19) {
                    Toast.makeText(this, "Рассчет невозможен!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Сообщи разработчику код: 01", Toast.LENGTH_SHORT).show();
                    //    mInfoTextView.append("Сообщи разработчику код: 001");
                    Resh.append("Error 01\n\nВыход за рамки допустимого значения\nРешение ошибки: Уменьшить вводимые данные. Например разложить. Пример: 800 = 80 * 10 ");
                } else {

                    int i, j, kol = 0;

                    for (i = 0; i < 6; i++)
                        for (j = 0; j < count; j++) {
                            twoD[i][j] = 0;
                        }

                    int[] mass = new int[20];
                    for (i = 0; i < 20; i++)
                        mass[i] = 0;

                    for (i = 0; i < count; i++) { // заполнение первых двух строк
                        twoD[0][i] = kol;
                        kol++;
                        if (i == 0) {
                            twoD[1][i] = a;
                            mass[i] = a % 2;
                        } else {
                            if (a % 2 == 0) {
                                twoD[1][i] = a / 2;
                                a = a / 2;
                                mass[i] = a % 2;

                            } else {
                                twoD[1][i] = (a - 1) / 2;
                                a = (a - 1) / 2;
                                mass[i] = a % 2;

                            }
                        }
                    }
                    twoD[4][0] = b;
                    twoD[5][0] = 0;

                    int index = 0;

                    for (j = 1; j < count; j++)
                        for (i = 2; i < 6; i++) {
                            if (i == 2)
                                twoD[i][j] = 2 * twoD[i + 2][j - 1];
                            else if (i == 3) {
                                twoD[i][j] = (twoD[i + 1][j - 1] * mass[index]) + twoD[i + 2][j - 1];
                                index++;
                            } else if (i == 4) {
                                if (twoD[i - 2][j] >= Os)
                                    twoD[i][j] = twoD[i - 2][j] - Os;
                                else
                                    twoD[i][j] = twoD[i - 2][j];

                            } else if (i == 5) {
                                if (twoD[i - 2][j] >= Os)
                                    twoD[i][j] = twoD[i - 2][j] - Os;
                                else
                                    twoD[i][j] = twoD[i - 2][j];
                            }
                        }


                    RezFormul.setText("Таблица");
                    Rez1.setText("\nФормула");
                    info.setText("i - \na - \n2b - \nC+b*R2 - \nb - \nc - ");

                    TableLayout stk = (TableLayout) findViewById(R.id.table_main);
                    stk.removeAllViews();

                    for (i = 0; i < 6; i++) {

                        TableRow tbrow0 = new TableRow(this);

                        for (j = 0; j < count; j++) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("  " + twoD[i][j] + "  ");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);

                        }
                        stk.addView(tbrow0);
                    }
                    int summ = twoD[5][count - 1] + twoD[4][count - 1];

                    Resh.setText(" R_" + Os + "(" + consA + " * " + constB + ") = R_" + Os + "(" + twoD[4][count - 1] + " + " + twoD[5][count - 1] + ") = " + summ);
                    if (summ > Os) {
                        Resh.setText(" R_" + Os + "(" + consA + " * " + constB + ") = R_" + Os + "(" + twoD[4][count - 1] + " + " + twoD[5][count - 1] + ") = " + summ + " - " + Os + " = ");
                        summ = summ - Os;
                        Resh.append(""+summ);

                    }

                }


        }
    }

    }

