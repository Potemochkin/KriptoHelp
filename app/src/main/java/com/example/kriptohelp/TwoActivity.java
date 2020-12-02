package com.example.kriptohelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void onMyClickExit(View view) {
        finish();
    }

    public void onMyClickWriteS(View view) {
        Toast.makeText(this, "Ожидайте...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://vk.com/seregapotemkin"))
        );
    }

    public void onMyClickWriteI(View view) {
        Toast.makeText(this, "Ожидайте...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://vk.com/sprat_in_a_tin"))
        );
    }
    public void onMyClickToOtvet(View view) {
        Toast.makeText(this, "Ожидайте...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://forms.gle/nZmwhS6euaSaAbY67"))
        );
    }

    public void onMyClickSave(View view) {
        Toast.makeText(this, "В разаботке", Toast.LENGTH_SHORT).show();
    }

}