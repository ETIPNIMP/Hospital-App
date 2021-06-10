package com.example.sghospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
Button bMP,bSP,bFP;
TextView tM,tS,tF;
EditText edManual,edSemi,edFull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bMP=findViewById(R.id.bMP);
        bSP=findViewById(R.id.bSP);
        bFP=findViewById(R.id.bFP);
        tM=findViewById(R.id.textView3);
        tS=findViewById(R.id.textView4);
        tF=findViewById(R.id.textView5);
        edManual=findViewById(R.id.edManual);
        edSemi=findViewById(R.id.edSemi);
        edFull=findViewById(R.id.edFull);
        bMP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double manual=Double.parseDouble(String.valueOf(edManual.getText()));
                int book=250;
                if(manual==25000){
                    Toast.makeText(MainActivity3.this, "Successfully Bed Booked", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Thanks For trust ", Toast.LENGTH_LONG).show();
                   book--;
                    tM.setText("Total Manual Bed Available :"+book);
                    Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity3.this, "Enter perfect Amount ", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Perfect Amount is 25000 ", Toast.LENGTH_LONG).show();
                }
            }
        });
        bSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double semi=Double.parseDouble(String.valueOf(edSemi.getText()));
                int Semi=150;
                if(semi==60000){
                    Toast.makeText(MainActivity3.this, "Successfully Bed Booked", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Thanks For trust ", Toast.LENGTH_LONG).show();
                    Semi--;
                    tS.setText("Total Semi Electric Bed Booked :"+Semi);
                    Intent go=new Intent(MainActivity3.this,MainActivity4.class);
                    startActivity(go);
                }else{
                    Toast.makeText(MainActivity3.this, "Enter perfect Amount ", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Perfect Amount is 60000 ", Toast.LENGTH_LONG).show();
                }
            }
        });
        bFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double full=Double.parseDouble(String.valueOf(edFull.getText()));
                int Full=120;
                if(full==80000){
                    Toast.makeText(MainActivity3.this, "Successfully Bed Booked", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Thanks For trust ", Toast.LENGTH_LONG).show();
                    Full--;
                    tF.setText("Total Full Electric Bed Booked :"+Full);
                    Intent next=new Intent(MainActivity3.this,MainActivity4.class);
                    startActivity(next);
                }else{
                    Toast.makeText(MainActivity3.this, "Enter perfect Amount ", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity3.this, "Perfect Amount is 80000 ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}