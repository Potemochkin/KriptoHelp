package com.example.kriptohelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_algoritm_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritm_3);
    }
    public void onMyClickExit(View view) {
        finish();
    }

    int count; //подсчет для введенных данных количество столбцов
    boolean bool=false,bool1=false; //отвечает за возможность отката данных назад после очистки

    int g;
    int[] a = new int[20];
    int[] b = new int[20];
    int[] xa = new int[20];
    int[] ya = new int[20];
    int[] xb = new int[20];
    int[] yb = new int[20];


    //Глобальные переменные для построения таблицы
    int[][] twoD_1 = new int[6][20];  //массив таблицы
    int constB_1; //сонстанта переменной В
    int count_1; //подсчет для введенных данных количество столбцов
    int Os_1, a_1, b_1;
    int consA_1;
    int bConst;
    int cConst;


    public void onMyButtonClear(View view) {
        TextView Resh = findViewById(R.id.Reshen); //вывод формулы
        TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
        TextView info = findViewById(R.id.textView2); //вывод названия строк таблицы
        TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
        TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат
        TextView nameStrTabl = findViewById(R.id.TextNazvamieTabl); //вывод названия строк таблицы

        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание
        TableLayout stk_1 = (TableLayout) findViewById(R.id.table_massiva);
        stk_1.removeAllViews();
        bool=true;
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        stk.removeAllViews();
        // TextView mInfoTextView = findViewById(R.id.textView);// вывод
        nameStrTabl.setText(null);
        perA.setText(null);
        perB.setText(null);
        perOs.setText(null);
        // mInfoTextView.setText(null);
        info.setText(null);
        Rez1.setText(null);
        RezFormul.setText(null);
        Resh.setText(null);
        nameR.setText("Формат ввода: a/b(mod m)");
    }

    public void onMyButtonBack(View view) {
        if (bool1 && bool)
        {
            TextView Resh = findViewById(R.id.Reshen); //вывод формулы
            TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
            TextView info = findViewById(R.id.textView2); //вывод слова матрица
            TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
            TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат
            TextView nameStrTabl = findViewById(R.id.TextNazvamieTabl); //вывод названия строк таблицы

            info.setText("Матрица:");
            Rez1.setText("Формула");
            RezFormul.setText("Результат");
            nameStrTabl.setText("i - \na - \n2b - \nC+b*R2 - \nb - \nc - ");
            nameR.setText(g+"/"+bConst+" (mod "+cConst+") = "+g+" * "+bConst+"^(-1)");
            TableLayout stk = (TableLayout) findViewById(R.id.table_main);
            stk.removeAllViews();
            TableRow tbrow0 = new TableRow(this);
                for (int i = 0; i < count; i++) {


                    TextView tv0 = new TextView(this);
                    tv0.setText("(" + a[i] + "|" + xa[i] + " " + ya[i] + ")" + "\r\n" + "(" + b[i] + "|" + xb[i] + " " + yb[i] + ")" + "\r\n");
                    tv0.setTextColor(Color.WHITE);
                    tv0.setTextSize(14);
                    tv0.setGravity(Gravity.CENTER);
                    tbrow0.addView(tv0);


                }
            stk.addView(tbrow0);
                //Вывод результата, следующий шаг - сложение-умножение
            TableLayout stk_1 = (TableLayout) findViewById(R.id.table_massiva);
            stk_1.removeAllViews();
int i_1, j_1;
            for (i_1 = 0; i_1 < 6; i_1++) {

                TableRow tbrow0_1 = new TableRow(this);

                for (j_1 = 0; j_1 < count_1; j_1++) {
                    TextView tv0_1 = new TextView(this);
                    tv0_1.setText("  " + twoD_1[i_1][j_1] + "  ");
                    tv0_1.setTextColor(Color.WHITE);
                    tv0_1.setTextSize(17);
                    tv0_1.setGravity(Gravity.CENTER);
                    tbrow0_1.addView(tv0_1);

                }
                stk_1.addView(tbrow0_1);
            }
            int summ_1 = twoD_1[5][count_1 - 1] + twoD_1[4][count_1 - 1];

            //Вывод результата, следующий шаг - сложение-умножение
            Resh.setText(a[0] + "^(-1)(mod " + Os_1 + ") = " + xb[count - 1] + ";\n" + g + " * " + a[0] + "^(-1) (mod " + Os_1 + ") = " + " R_" +
                    Os_1 + "(" + consA_1 + " * " + constB_1 + ") = R_" + Os_1 + "(" + twoD_1[4][count_1 - 1] + " + " + twoD_1[5][count_1 - 1] + ") = \n = " + summ_1);
            if (summ_1 > Os_1) {
                summ_1 = summ_1 - Os_1;
                Resh.append(" - "+ Os_1 + " = "+summ_1);
            }

            }
        else Toast.makeText(this, "Проведи рассчет", Toast.LENGTH_SHORT).show();


    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onMyButtonClickAlgo3(View view) {

        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание


        String S1 = perA.getText().toString();//строка для переменной а и тд..
        String S2 = perB.getText().toString();
        String S3 = perOs.getText().toString();

        if (S1.length() == 0 || S2.length() == 0 || S3.length() == 0 || S1.startsWith("0") || S2.startsWith("0") || S3.startsWith("0") ) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {
            TextView Resh = findViewById(R.id.Reshen); //вывод формулы
            TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
            TextView info = findViewById(R.id.textView2); //вывод слова: матрица
            TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
            TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: результат
            TextView nameStrTabl = findViewById(R.id.TextNazvamieTabl); //вывод названия строк таблицы

            info.setText(null);
            Rez1.setText(null);
            RezFormul.setText(null);
            Resh.setText(null);
            nameR.setText(null);

            Toast.makeText(this, "Считаем...", Toast.LENGTH_SHORT).show();

            info.setText("Матрица:");

            RezFormul.setText("Результат");

            nameR.setText(S1 + "/" + S2 + " (mod " + S3 + ") = " + S1 + " * " + S2 + "^(-1)");

            count = 1;

            g = Integer.parseInt(S1);
            int bConst = Integer.parseInt(S2);
            int cConst = Integer.parseInt(S3);
            int nexta = 0;


            while (bConst != 0) {
                count++;
                nexta = cConst % bConst;
                cConst = bConst;
                bConst = nexta;
            }

            a[0] = Integer.parseInt(S2);
            b[0] = Integer.parseInt(S3);
            xa[0] = 1;
            ya[0] = 0;
            xb[0] = 0;
            yb[0] = 1;
            //Посчёт всех переменных матриц
            for (int i = 1; i < count; i++) {
                a[i] = b[i - 1] % a[i - 1];
                b[i] = a[i - 1];
                xa[i] = xb[i - 1] - (int) (Math.floor(b[i - 1] / a[i - 1])) * xa[i - 1];
                ya[i] = yb[i - 1] - (int) (Math.floor(b[i - 1] / a[i - 1])) * ya[i - 1];
                xb[i] = xa[i - 1];
                yb[i] = ya[i - 1];
            }

            TableLayout stk = (TableLayout) findViewById(R.id.table_main);
            stk.removeAllViews();
            TableRow tbrow0 = new TableRow(this);
            //Вывод МАТРИЦ согласно значениям переменных
            for (int i = 0; i < count; i++) {

                TextView tv0 = new TextView(this);
                tv0.setText("(" + a[i] + "|" + xa[i] + " " + ya[i] + ")" + "\r\n" + "(" + b[i] + "|" + xb[i] + " " + yb[i] + ")" + "\r\n");
                tv0.setTextColor(Color.WHITE);
                tv0.setTextSize(14);
                tv0.setGravity(Gravity.CENTER);
                tbrow0.addView(tv0);
            }
            stk.addView(tbrow0);

            // объявление переменных для построения таблицы
            int a1_1 = xb[count - 1]; //переменна а в число
            if (a1_1 > 1) {
                a_1 = a1_1; //копирование а в а1
                b_1 = Integer.parseInt(S1);
                count_1 = 0;
                Os_1 = Integer.parseInt(S3);
                consA_1 = a_1;
                constB_1 = b_1;

                boolean chek_1 = true; //для выхода из цикла проверки длины
                // конец объявления

                while (chek_1) {
                    if (a1_1 > 1) {
                        if (a1_1 % 2 == 0) {
                            count_1++;
                            a1_1 = a1_1 / 2;
                        } else {
                            count_1++;
                            a1_1 = (a1_1 - 1) / 2;
                        }
                    } else if (a1_1 == 1) {
                        count_1++;
                        chek_1 = false;
                    }
                }

                if (count_1 > 19) {
                    Toast.makeText(this, "Рассчет невозможен!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Сообщи разработчику код: 01", Toast.LENGTH_SHORT).show();
                    //    mInfoTextView.append("Сообщи разработчику код: 001");
                    Resh.append("Error 01\n\nВыход за рамки допустимого значения");
                } else {

                    int i_1, j_1, kol_1 = 0;

                    for (i_1 = 0; i_1 < 6; i_1++)
                        for (j_1 = 0; j_1 < count_1; j_1++) {
                            twoD_1[i_1][j_1] = 0;
                        }

                    int[] mass_1 = new int[20];
                    for (i_1 = 0; i_1 < 20; i_1++)
                        mass_1[i_1] = 0;

                    for (i_1 = 0; i_1 < count_1; i_1++) { // заполнение первых двух строк
                        twoD_1[0][i_1] = kol_1;
                        kol_1++;
                        if (i_1 == 0) {
                            twoD_1[1][i_1] = a_1;
                            mass_1[i_1] = a_1 % 2;
                        } else {
                            if (a_1 % 2 == 0) {
                                twoD_1[1][i_1] = a_1 / 2;
                                a_1 = a_1 / 2;
                                mass_1[i_1] = a_1 % 2;

                            } else {
                                twoD_1[1][i_1] = (a_1 - 1) / 2;
                                a_1 = (a_1 - 1) / 2;
                                mass_1[i_1] = a_1 % 2;

                            }
                        }
                    }
                    twoD_1[4][0] = b_1;
                    twoD_1[5][0] = 0;

                    int index_1 = 0;

                    for (j_1 = 1; j_1 < count_1; j_1++)
                        for (i_1 = 2; i_1 < 6; i_1++) {
                            if (i_1 == 2)
                                twoD_1[i_1][j_1] = 2 * twoD_1[i_1 + 2][j_1 - 1];
                            else if (i_1 == 3) {
                                twoD_1[i_1][j_1] = (twoD_1[i_1 + 1][j_1 - 1] * mass_1[index_1]) + twoD_1[i_1 + 2][j_1 - 1];
                                index_1++;
                            } else if (i_1 == 4) {
                                if (twoD_1[i_1 - 2][j_1] >= Os_1)
                                    twoD_1[i_1][j_1] = twoD_1[i_1 - 2][j_1] - Os_1;
                                else
                                    twoD_1[i_1][j_1] = twoD_1[i_1 - 2][j_1];

                            } else if (i_1 == 5) {
                                if (twoD_1[i_1 - 2][j_1] >= Os_1)
                                    twoD_1[i_1][j_1] = twoD_1[i_1 - 2][j_1] - Os_1;
                                else
                                    twoD_1[i_1][j_1] = twoD_1[i_1 - 2][j_1];
                            }
                        }
                    Rez1.setText("Формула");
                    nameStrTabl.setText("i - \na - \n2b - \nC+b*R2 - \nb - \nc - ");

                    TableLayout stk_1 = (TableLayout) findViewById(R.id.table_massiva);
                    stk_1.removeAllViews();

                    for (i_1 = 0; i_1 < 6; i_1++) {

                        TableRow tbrow0_1 = new TableRow(this);

                        for (j_1 = 0; j_1 < count_1; j_1++) {
                            TextView tv0_1 = new TextView(this);
                            tv0_1.setText("  " + twoD_1[i_1][j_1] + "  ");
                            tv0_1.setTextColor(Color.WHITE);
                            tv0_1.setTextSize(17);
                            tv0_1.setGravity(Gravity.CENTER);
                            tbrow0_1.addView(tv0_1);

                        }
                        stk_1.addView(tbrow0_1);
                    }
                    int summ_1 = twoD_1[5][count_1 - 1] + twoD_1[4][count_1 - 1];

                    //Вывод результата, следующий шаг - сложение-умножение
                    Resh.setText(a[0] + "^(-1)(mod " + Os_1 + ") = " + xb[count - 1] + ";\n" + g + " * " + a[0] + "^(-1) (mod " + Os_1 + ") = " + " R_" +
                            Os_1 + "(" + consA_1 + " * " + constB_1 + ") = R_" + Os_1 + "(" + twoD_1[4][count_1 - 1] + " + " + twoD_1[5][count_1 - 1] + ") = \n = " + summ_1);
                    if (summ_1 > Os_1) {
                        summ_1 = summ_1 - Os_1;
                        Resh.append(" - "+ Os_1 + " = "+summ_1);
                    }


                    bool1 = true;
                }
            }
            else
            {
                Toast.makeText(this, "Рассчет невозможен!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Сообщи разработчику код: 02", Toast.LENGTH_SHORT).show();
                //    mInfoTextView.append("Сообщи разработчику код: 001");
                Resh.append("Error 02\n\nНайдено отрицательное число\nРешение ошибки: проверь правильность введенных данных");
            }

        }
    }

}