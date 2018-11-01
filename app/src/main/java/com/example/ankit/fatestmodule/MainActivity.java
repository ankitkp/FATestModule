package com.example.ankit.fatestmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioButton r1, r2, r3;
    Button next;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        r1 = (RadioButton) findViewById(R.id.yes);
        r2 = (RadioButton) findViewById(R.id.no);
        r3 = (RadioButton) findViewById(R.id.some);
        next = (Button) findViewById(R.id.nextButton);
        //"Does your child respond when you call his/her name?"
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg1.getCheckedRadioButtonId();
                if(rg1.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(MainActivity.this,"Please select an option",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == R.id.yes) {
                        total = total + 5;
                    } else if (selectedId == R.id.no) {
                        total = total + 15;
                    } else if (selectedId == R.id.some) {
                        total = total + 10;
                    }
                    Intent i = new Intent(MainActivity.this, Q2.class);
                    Bundle extras = new Bundle();
                    extras.putString("qtotal", String.valueOf(total));
                    i.putExtras(extras);
                    startActivity(i);
                }
            }
        });

    }
}
  /*  public void nextQ(View v1)
    {

        rg1=(RadioGroup)findViewById(R.id.radioGroup);
        r1=(RadioButton)findViewById(R.id.yes);
        r2=(RadioButton)findViewById(R.id.no);
        r3=(RadioButton)findViewById(R.id.some);
        next=(Button)findViewById(R.id.nextButton);
        r1.setSelected(true);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.yes){
                    total=total+5;
                }else if(i==R.id.no){
                    total=total+15;
                }else{
                    total=total+10;
                }
            }
        });
        Intent i=new Intent(MainActivity.this,Q2.class);
        Bundle extras=new Bundle();
        extras.putString("qtotal",String.valueOf(total));
        i.putExtras(extras);
        startActivity(i);
    }*/

