package com.example.convertisseur;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {
        RadioButton d, e;
        TextView m, r;
        EditText p;
        Button btn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            d = findViewById(R.id.radioButton);
            e = findViewById(R.id.radioButton2);
            m = findViewById(R.id.textView);
            r = findViewById(R.id.textView2);
            p = findViewById(R.id.editTextText);
            btn = findViewById(R.id.button);

            d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        m.setText("Entre le montant en DA :");
                    }
                }
            });

            e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        m.setText("Entre le montant en Euro :");
                    }
                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertir();
                }
            });
        }

        public void convertir() {
            if (d.isChecked()) {
                String Ps = p.getText().toString();
                double ex = 0.005;

                if (!Ps.isEmpty()) {
                    float PdDZD = (float) Double.parseDouble(Ps);
                    float PdE = (float) (PdDZD * ex);
                    r.setText(String.valueOf((float) PdE) + " €");
                } else {
                    Toast.makeText(this, "Please enter amount in DA ! " , Toast.LENGTH_LONG).show();
                }
            } else if (e.isChecked()) {
                String Ps = p.getText().toString();
                double ex = 200;

                if (!Ps.isEmpty()) {
                    float PdDZD = (float) Double.parseDouble(Ps);
                    float PdE = (float) (PdDZD * ex);
                    r.setText(String.valueOf((float) PdE) + " Da");
                } else {
                    Toast.makeText(this, "Please enter amount in Euro! " , Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this, "Please Check one option ! " , Toast.LENGTH_LONG).show();
            }

        }
    }