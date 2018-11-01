package com.example.vipulagarwal.fatestmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Q05 extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton r1, r2, r3;
    Button next;
    int total, mytotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q05);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        r1 = (RadioButton) findViewById(R.id.yes);
        r2 = (RadioButton) findViewById(R.id.no);
        r3 = (RadioButton) findViewById(R.id.some);
        next = (Button) findViewById(R.id.button);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String preval = extras.getString("qtotal");
        mytotal = Integer.parseInt(preval);
        //Toast.makeText(Q2.this,"totsl is"+mytotal,Toast.LENGTH_SHORT).show();
        //"5.	Does s/he have behavioral issues?"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg1.getCheckedRadioButtonId();
                if(rg1.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Q05.this,"Please select an option",Toast.LENGTH_LONG).show();
                }
                else {
                    if (selectedId == R.id.yes) {
                        total = mytotal + 15;
                    } else if (selectedId == R.id.no) {
                        total = mytotal + 5;
                    } else if (selectedId == R.id.some) {
                        total = mytotal + 10;
                    }
                    Intent i = new Intent(Q05.this, Q06.class);
                    Bundle ex1 = new Bundle();
                    ex1.putString("qtotal", String.valueOf(total));
                    i.putExtras(ex1);
                    startActivity(i);
                }
            }
        });
    }
}
