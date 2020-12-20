package com.example.kriptohelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Exit(View v) //Выход из приложения
    {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage("")
                .setCancelable(false)
                .setPositiveButton("Выйти", new DialogInterface.OnClickListener(){
                    @Override

                    public void onClick (DialogInterface dialog, int which) {
                        finish();
                    }
                } )
                .setNegativeButton("Предумать", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("             Уже уходишь?");
        alert.show();
    }

    public void Info(final View v) //информация о версии
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("О программе")
                .setMessage("Ведущий разработчик:\n                              Потемкин Сергей\nПомощники:\n                              Вершинин Иван\n                              Кочанов Сергей\n\nВерсия:                        4.0.2b.t\"\n\n                       Что нового:\n1. Частичное добавление ТК-2\n\n~ У пользователей возможны ошибки отображения элементов из-за размера экрана\n")
                .setCancelable(false)
                .setPositiveButton("Подробнее",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            newFormInfo(v);
                            }
                        })
                .setNegativeButton("Назад",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onMyClick(View view) {
        Toast.makeText(this, "Переход на скачивание...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://drive.google.com/drive/folders/1lRu0HJjffbdURh-xZjqj-LjL-RSReyfU?usp=sharing"))
        );
    }

    public void newFormInfo(View view) { //переход на новую форму информации
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }

    public void newForm_algo_1(View view) { //переход на новую форму алгоритм 1
        Intent intent = new Intent(this, Activity_algoritm_1.class);
        startActivity(intent);
    }

    public void newForm_algo_2(View view) { //переход на новую форму алгоритм 2
        Intent intent = new Intent(this, Activity_algoritm_2.class);
        startActivity(intent);
    }

    public void newForm_algo_3(View view) { //переход на новую форму алгоритм 3
        Intent intent = new Intent(this, Activity_algoritm_3.class);
        startActivity(intent);
    }
    public void newForm_tk_1(View view) { //переход на новую форму текущий контроль 1
        Intent intent = new Intent(this, Activity_tk_1.class);
        startActivity(intent);
    }
}