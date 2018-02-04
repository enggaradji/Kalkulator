package com.example.piewgarts.kalkulatorremed;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ETbil1, ETbil2;
    Button bthitung;
    TextView pre, fpb, kpk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETbil1 = (EditText) findViewById(R.id.Bil1);
        ETbil2 = (EditText) findViewById(R.id.Bil2);
        bthitung = (Button) findViewById(R.id.bthitung);
        pre = (TextView) findViewById(R.id.preText);
        fpb = (TextView) findViewById(R.id.fText);
        kpk = (TextView) findViewById(R.id.kText);
        bthitung.setOnClickListener(this);

    }

    public void onClick(View view) {
        hitungFPBKPK();
    }

    protected void hitungFPBKPK() {
        try {
            // do something
            int bill1 = Integer.parseInt(ETbil1.getText().toString());
            int bill2 = Integer.parseInt(ETbil2.getText().toString());
            int x, y, z;
            if(bill1>bill2){
                x=bill1;
                y=bill2;
            }
            else{
                x = bill2;
                y = bill1;
            }

            do {
                z = x % y;
                x = y;
                y = z;
            }
            while (z != 0);

            int FPB = x;
            int KPK = (bill1 * bill2) / FPB;

            String preText, FText, KText;
            FText = Integer.toString(FPB);
            KText = Integer.toString(KPK);
            if (z == 0) {

                fpb.setVisibility(View.VISIBLE);
                fpb.setText("FPB: " + FText);
                kpk.setVisibility(View.VISIBLE);
                kpk.setText("KPK: " + KText);

            } else {
                preText = "bilangan " + Integer.toString(bill1) + " dan " +
                        Integer.toString(bill2) + " tidak memiliki FPB " +
                        "dan tidak memiliki KPK";
                pre.setText(preText);
            }
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Input bilangan tidak sesuai");
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
