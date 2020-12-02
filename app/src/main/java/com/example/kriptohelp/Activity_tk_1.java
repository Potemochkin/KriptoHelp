package com.example.kriptohelp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Activity_tk_1 extends AppCompatActivity {

    String S1, S2, S3; // Глобальные строки входных данных
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tk_1);
        Toast.makeText(this, "Ознакомься с правилами ввода!", Toast.LENGTH_SHORT).show();
    }
    public void onMyClickExit(View view) {
        finish();
    } //кнопка выхода

    public void decisionTaskOne(View view) // рассчет первого задания. Входные данные D(а,b)
    {
        if (S1.length() == 0 || S2.length() == 0  || S1.startsWith("0") || S2.startsWith("0") ) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вычисление 1 задания", Toast.LENGTH_SHORT).show();
          int  constA = Integer.parseInt(S1), constB = Integer.parseInt(S2);

                                            /* --------------------------------------------------------------------------------------------------------
                                            Начало рассчета рассширенного бинарного алгоритма Евклида
                                           ------------------------------------------------------------------------------------------------------------- */
            
        }
    }

    public void decisionTaskTwo(View view) // рассчет второго задания
    {
        if (S1.length() == 0 || S2.length() == 0 || S3.length() == 0 || S1.startsWith("0") || S2.startsWith("0") ) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вычисление 2 заадния", Toast.LENGTH_SHORT).show();
            int  constA = Integer.parseInt(S1), constB = Integer.parseInt(S2);

                                            /* --------------------------------------------------------------------------------------------------------
                                            Начало рассчета рассширенного бинарного алгоритма Евклида
                                           ------------------------------------------------------------------------------------------------------------- */

        }
    }

    public void decisionTaskThree(View view) // рассчет третьего задания
    {
        if (S1.length() == 0 || S2.length() == 0  || S1.startsWith("0") || S2.startsWith("0") ) {  //проверка на пустоту и подряд двух нулей.
            Toast.makeText(this, "Заполни исходные данные", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вычисление 3 задания", Toast.LENGTH_SHORT).show();
            int  constA = Integer.parseInt(S1), constB = Integer.parseInt(S2);

                                            /* --------------------------------------------------------------------------------------------------------
                                            Начало рассчета рассширенного бинарного алгоритма Евклида
                                           ------------------------------------------------------------------------------------------------------------- */

        }
    }

    public void Info(final View v) //информация о версии
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_tk_1.this);
        builder.setTitle("Пояснения к вводу")
                .setMessage("   1 ЗАДАНИЕ\nНеобходимо ввести модуль в поле 'Введи m'\n\n   2 ЗАДАНИЕ\nНеобходмо ввести число в поле 'Введи а', а модуль в поле 'Введи m'\n\n   3 ЗАДАНИЕ\nНеобходмсо ввести модуль в поле 'Введи m', 1 показатель степени в поле 'а1', 2 показатель в поле 'b1'. Основани степени 1 числа в поле 'Введи а', 2 числа в поле 'Введи b' ")
                .setCancelable(false)
                .setNegativeButton("Назад",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void OnClick(final View view) // действие при нажатии кнопки рассчета
    {
        EditText perA = findViewById(R.id.NamA);//переменная а
        EditText perB = findViewById(R.id.NamB);//переменная б
        EditText perOs = findViewById(R.id.NumOsnov);// основание
        String S1 = perA.getText().toString();//строка для переменной а и тд..
        String S2 = perB.getText().toString();
        String S3 = perOs.getText().toString();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.task_1:
                    {
                    decisionTaskOne(view);
                        break;
                    }
                    case R.id.task_2:
                    {
                        decisionTaskTwo(view);
                        break;
                    }
                    case R.id.task_3:
                    {
                        decisionTaskThree(view);
                        break;
                    }
                }
            }
        });
    }


}