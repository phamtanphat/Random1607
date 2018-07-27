package com.ptp.phamtanphat.random1607;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtSomin, edtSomax;
    Button btnRandom, btnAddNumber;
    TextView txtKetqua;
    ArrayList<Integer> mangso = new ArrayList<>();
    String hienthi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSomax = findViewById(R.id.edittextSomax);
        edtSomin = findViewById(R.id.edittextSomin);
        btnRandom = findViewById(R.id.buttonRandom);
        txtKetqua = findViewById(R.id.textviewKetqua);
        btnAddNumber = findViewById(R.id.buttonAddNumber);


        btnAddNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smax = edtSomax.getText().toString();
                String smin = edtSomin.getText().toString();

                if (!smax.equals("") && !smin.equals("")) {
                    int somax = Integer.parseInt(smax);
                    int somin = Integer.parseInt(smin);

                    for (int i = somin; i <= somax; i++) {
                        mangso.add(i);
                    }
                }
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mangso.size() > 0){
                    Random random = new Random();
                    int index = random.nextInt(mangso.size());
                    int value = mangso.get(index);

                    if (mangso.size() == 1){
                        hienthi = String.valueOf(value);
                    }else {
                        hienthi = value + " - ";
                    }
                    txtKetqua.append(hienthi);
                    mangso.remove(index);
                }else {
                    Toast.makeText(MainActivity.this, "Het gia tri de random", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
