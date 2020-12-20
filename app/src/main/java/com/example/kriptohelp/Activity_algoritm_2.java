package com.example.kriptohelp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_algoritm_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritm_2);
        Resh = findViewById(R.id.Reshen); //Вывод слова: сложение удвоение
        Resh.setMovementMethod(new ScrollingMovementMethod());

        //
    }

    public void onMyClickExit(View view) {
        finish();
    }

    TextView Resh;
    int kolTab; //считает количество таблиц сложения удвоения
    boolean bool; //отвечает за возможность отката данных назад после очистки

    int constA_1;


    public void onMyButtonClear(View view) {

        TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы

        TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
        TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: Главная таблица
        TextView RezFormul2 = findViewById(R.id.TextRes2);
        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание

        bool = true;
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        stk.removeAllViews();
        TableLayout stk1 = (TableLayout) findViewById(R.id.table_main1);
        stk1.removeAllViews();
        // TextView mInfoTextView = findViewById(R.id.textView);// вывод
        perA.setText(null);
        perB.setText(null);
        perOs.setText(null);
        // mInfoTextView.setText(null);
        Rez1.setText(null);
        RezFormul.setText(null);
        RezFormul2.setText(null);
        Resh.setText(null);
        nameR.setText("Формат ввода: R_m(b^a)");
    }

    public int TablSumm(int A, int M) {
        int Rezult = 0, ConsA = A, countT = 0;
        boolean chek = true; //для выхода из цикла проверки длины
        kolTab++;
        while (chek) {
            if (A > 1) {
                if (A % 2 == 0) {
                    countT++;
                    A = A / 2;
                } else {
                    countT++;
                    A = (A - 1) / 2;
                }
            } else if (A == 1) {
                countT++;
                chek = false;
            }
        }
        if (countT > 19) {
            Toast.makeText(this, "Рассчет невозможен!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Сообщи разработчику код: 01", Toast.LENGTH_SHORT).show();
            //    mInfoTextView.append("Сообщи разработчику код: 001");
            TextView Resh = findViewById(R.id.Reshen); //вывод формулы
            Resh.append("Error 01\n\nВыход за рамки допустимого значения\nРешение ошибки: Уменьшить вводимые данные. Например разложить. Пример: 800 - 80 *10 ");
            return -1;
        } else {
            A = ConsA;
            int iT, jT, kolT = 0;
            int[][] twoDT = new int[6][20];
            for (iT = 0; iT < 6; iT++)
                for (jT = 0; jT < countT; jT++) {
                    twoDT[iT][jT] = 0;
                }

            int[] massT = new int[20];
            for (iT = 0; iT < 20; iT++)
                massT[iT] = 0;

            for (iT = 0; iT < countT; iT++) { // заполнение первых двух строк
                twoDT[0][iT] = kolT;
                kolT++;
                if (iT == 0) {
                    twoDT[1][iT] = A;
                    massT[iT] = A % 2;
                } else {
                    if (A % 2 == 0) {
                        twoDT[1][iT] = A / 2;
                        A = A / 2;
                        massT[iT] = A % 2;

                    } else {
                        twoDT[1][iT] = (A - 1) / 2;
                        A = (A - 1) / 2;
                        massT[iT] = A % 2;

                    }
                }
            }
            twoDT[4][0] = ConsA;
            twoDT[5][0] = 0;

            int indexT = 0;

            for (jT = 1; jT < countT; jT++)
                for (iT = 2; iT < 6; iT++) {
                    if (iT == 2)
                        twoDT[iT][jT] = 2 * twoDT[iT + 2][jT - 1];
                    else if (iT == 3) {
                        twoDT[iT][jT] = (twoDT[iT + 1][jT - 1] * massT[indexT]) + twoDT[iT + 2][jT - 1];
                        indexT++;
                    } else if (iT == 4) {
                        if (twoDT[iT - 2][jT] >= M)
                            twoDT[iT][jT] = twoDT[iT - 2][jT] - M;
                        else
                            twoDT[iT][jT] = twoDT[iT - 2][jT];

                    } else if (iT == 5) {
                        if (twoDT[iT - 2][jT] >= M)
                            twoDT[iT][jT] = twoDT[iT - 2][jT] - M;
                        else
                            twoDT[iT][jT] = twoDT[iT - 2][jT];
                    }
                }


            Rezult = twoDT[5][countT - 1] + twoDT[4][countT - 1];
            if (Rezult > M)
            {
                Resh.append(" "+kolTab+") "+ConsA + "^2 ≡_("+ M +") "+ twoDT[4][countT-1] +" + "+ twoDT[5][countT-1]+" ≡_("+ M +") "+ Rezult + " - "+ M+" ≡_("+ M +") ");
                Rezult = Rezult - M;
                Resh.append(Rezult+" ;\n");
            }
            else
                Resh.append(" "+kolTab+") "+ConsA + "^2 ≡_("+ M +") "+ twoDT[4][countT-1] +" + "+ twoDT[5][countT-1]+" ≡_("+ M +") "+Rezult);

            //так как вы создали таблицу сложения удвоения, надо ее вывести и запомнить, сколько строк мы добавим, чтобы в конце можно было грамотно использовать.
            //прибавим 6 строк таблицы сложения-удвоения. Не забыть, что в конце -1 так как счет с 0!!!!
// реализация вывода
            TableLayout stk = (TableLayout) findViewById(R.id.table_main);


            for (iT = 0; iT < 6; iT++) {
                TableRow tbrow0 = new TableRow(this);

                for (jT = 0; jT <= countT; jT++) {
                    if (jT == 0) {  //пока индкес 0 - выводим названия столбцов, иначе выводим данные массива. В длину 6 строк. В ширину строки = счетчику
                        if (iT == 0) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("i");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        } else if (iT == 1) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("a");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        } else if (iT == 2) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("2b");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        } else if (iT == 3) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("C+b*R2");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        } else if (iT == 4) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("b");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        } else if (iT == 5) {
                            TextView tv0 = new TextView(this);
                            tv0.setText("c");
                            tv0.setTextColor(Color.WHITE);
                            tv0.setTextSize(17);
                            tv0.setGravity(Gravity.CENTER);
                            tbrow0.addView(tv0);
                        }
                    } else {
                        TextView tv0 = new TextView(this);
                        tv0.setText("  " + twoDT[iT][jT - 1] + "  ");
                        tv0.setTextColor(Color.WHITE);
                        tv0.setTextSize(17);
                        tv0.setGravity(Gravity.CENTER);
                        tbrow0.addView(tv0);
                    }
                }
                stk.addView(tbrow0);
                //

            }
            TableRow tbrow1 = new TableRow(this);
            TextView tv0 = new TextView(this);
            tv0.setText("");
            tbrow1.addView(tv0);
            stk.addView(tbrow1);


            return Rezult;
        }
    }


    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // АЛГОРИТМ НАЧАЛО


    public void onMyButtonClickAlgo2(View view) {

        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основани


        String S1 = perA.getText().toString();//строка для переменной а и тд..
        String S2 = perB.getText().toString();
        String S3 = perOs.getText().toString();

// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
        // КОНЕЦ ОБЪЯВЛЕНИЯ ВХОДНЫХ ДАННЫХ
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

        if (S1.length() == 0 || S2.length() == 0 || S3.length() == 0 || S1.startsWith("0") || S2.startsWith("0") || S3.startsWith("0")) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {
            kolTab=0;
            Resh = findViewById(R.id.Reshen); //вывод формулы
            TextView nameR = findViewById(R.id.name); //вывод введеных данны в форме формулы
            TextView Rez1 = findViewById(R.id.textRes);// Вывод слова: формула
            TextView RezFormul = findViewById(R.id.TextRes); //Вывод слова: главная таблица
            TextView RezFormul2 = findViewById(R.id.TextRes2); //Вывод слова: главная таблица

            TableLayout stk = (TableLayout) findViewById(R.id.table_main);
            stk.removeAllViews();
            TableLayout stk1 = (TableLayout) findViewById(R.id.table_main1);
            stk1.removeAllViews();
            nameR.setText(null);
            Rez1.setText(null);
            RezFormul.setText(null);
            RezFormul2.setText(null);
            Resh.setText(null);//обнуление поля вывода

// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

            Toast.makeText(this, "Считаем...", Toast.LENGTH_SHORT).show();

// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
            // НАЧАЛО РАССЧЕТА
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

            int a1 = Integer.parseInt(S2); //переменна B в число

            int count = 0;
            int Os = Integer.parseInt(S3);


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


            if (count > 19) {
                Toast.makeText(this, "Рассчет невозможен!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Сообщи разработчику код: 01", Toast.LENGTH_SHORT).show();
                //    mInfoTextView.append("Сообщи разработчику код: 001");
                Resh.append("Error 01\n\nВыход за рамки допустимого значения\nРешение ошибки: Уменьшить вводимые данные. Например разложить. Пример: 800 - 80 *10 ");
            } else {

                int i, j;
                int[][] massStepin = new int[4][10];

                // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // Редактирование - создание сначала таблицы степенной
                int a_2 = Integer.parseInt(S1);
                int b_2 = Integer.parseInt(S2);
                constA_1=a_2;
                massStepin[0][0] = 0;
                massStepin[1][0] = a_2;
                massStepin[2][0] = b_2;
                massStepin[3][0] = 1;
                int count_2 = 0;
                boolean chek_2 = true; //для выхода из цикла проверки длины
                i = 1;
                while (chek_2) {

                    if (a_2 > 1) {
                        if (a_2 % 2 == 0) {
                            count_2++;
                            a_2 = a_2 / 2;
                        } else {
                            count_2++;
                            a_2 = (a_2 - 1) / 2;
                        }
                    } else if (a_2 == 1) {
                        count_2++;
                        chek_2 = false;
                    }
                    massStepin[1][i] = a_2;
                    massStepin[0][i] = count_2;
                    i++;
                }

                Resh.setText(" Ищем: " + b_2 + " ^ " + constA_1 + " (mod "+ Os+" ) - строим таблицу;\n ");
int okrigl=0;
                okrigl=Math.round(Os/2);
                boolean booChek=true;
                for (i = 1; i < count_2; i++) {

                    if (massStepin[2][i - 1] * massStepin[2][i - 1] > Os) {
                            if ((massStepin[2][i - 1] > okrigl)  || (massStepin[2][i - 1] < 0)) {
                                if (massStepin[2][i - 1] < 0)
                                    massStepin[2][i - 1]= massStepin[2][i - 1] * massStepin[2][i - 1];
                                while (booChek) {
                                    if (massStepin[2][i - 1] > okrigl) {
                                massStepin[2][i - 1] = massStepin[2][i - 1] - Os;
                            }
                            else
                                booChek=false;
                        }
                    }
                        else {
                        massStepin[2][i] = TablSumm(massStepin[2][i - 1], Os);
                        if (massStepin[2][i] == -1)
                            finish();
                        //если найденное b(i) в степени 2 больше модуля, тогда посчитать эту степень с помощью таблицы сложения удвоения
                    } }else {
                        massStepin[2][i] = massStepin[2][i - 1] * massStepin[2][i - 1];
                    }
                    if (massStepin[1][i - 1] % 2 == 0)
                        massStepin[3][i] = massStepin[3][i - 1];
                    else massStepin[3][i] = massStepin[3][i - 1] * massStepin[2][i - 1];
                    if (massStepin[3][i] > Os) {
                        massStepin[3][i]= massStepin[3][i] - Os;
                    }

                }


                RezFormul.setText("Главная таблица");
                RezFormul2.setText("Таблица сложения удвоения");
                Rez1.setText("\nРассчеты");
                nameR.setText("Запись: R_" + Os + "(" + b_2 + " ^ " + constA_1 + ") = ?");

                // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
                // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
                // ВЫВОД СТЕПЕННОЙ ТАБЛИЦЫ
                // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //


                for (i = 0; i < 4; i++) {

                    TableRow tbrow0 = new TableRow(this);
                    {
                        for (j = 0; j <= count_2; j++) {
                            if (j == 0) {
                                if (i == 0) {
                                    TextView tv0 = new TextView(this);
                                    tv0.setText("i");
                                    tv0.setTextColor(Color.WHITE);
                                    tv0.setTextSize(17);
                                    tv0.setGravity(Gravity.CENTER);
                                    tbrow0.addView(tv0);
                                } else if (i == 1) {
                                    TextView tv0 = new TextView(this);
                                    tv0.setText("a");
                                    tv0.setTextColor(Color.WHITE);
                                    tv0.setTextSize(17);
                                    tv0.setGravity(Gravity.CENTER);
                                    tbrow0.addView(tv0);
                                } else if (i == 2) {
                                    TextView tv0 = new TextView(this);
                                    tv0.setText("b");
                                    tv0.setTextColor(Color.WHITE);
                                    tv0.setTextSize(17);
                                    tv0.setGravity(Gravity.CENTER);
                                    tbrow0.addView(tv0);
                                } else if (i == 3) {
                                    TextView tv0 = new TextView(this);
                                    tv0.setText("c");
                                    tv0.setTextColor(Color.WHITE);
                                    tv0.setTextSize(17);
                                    tv0.setGravity(Gravity.CENTER);
                                    tbrow0.addView(tv0);
                                }
                            } else {
                                TextView tv0 = new TextView(this);
                                tv0.setText("  " + massStepin[i][j - 1] + "  ");
                                tv0.setTextColor(Color.WHITE);
                                tv0.setTextSize(17);
                                tv0.setGravity(Gravity.CENTER);
                                tbrow0.addView(tv0);
                            }
                        }
                        stk1.addView(tbrow0);
                    }
                    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //


                }
                TableRow tbrow1 = new TableRow(this);
                TextView tv0 = new TextView(this);
                tv0.setText("");
                tbrow1.addView(tv0);
                stk1.addView(tbrow1);
                Resh.append("\n Имеем:  " + b_2 + " ^ " + constA_1 + "≡_("+ Os +")  "+ massStepin[2][count_2-1]+" * "+massStepin[3][count_2-1]+" = "+massStepin[2][count_2-1]*massStepin[3][count_2-1]+"\nЭто произведение можно решить сложением-удвоением, либо вручную\n");
            }
        }
    }
}

