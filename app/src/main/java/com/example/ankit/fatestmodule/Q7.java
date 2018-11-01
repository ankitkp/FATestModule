package com.example.vipulagarwal.fatestmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Q7 extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton r1, r2, r3;
    Button next;
    float total, mytotal;//datatype changed to float
    float percent;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q7);
        result=(TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String preval = extras.getString("qtotal");
        mytotal = Integer.parseInt(preval);
        percent=(mytotal/60)*100;
        //Toast.makeText(Q7.this,"percent is"+percent,Toast.LENGTH_LONG).show();
        if(percent>=70)
            result.setText("High Level Autism, Access Level 1 Modules. Percent:"+percent);
        else if (percent>=50)
            result.setText("Medium Level Autism, Access Level 2 Modules. Percent:"+percent);
        else
            result.setText("Low level Autism, Access Level 3 Modules. Percent:"+percent);
    }
}
