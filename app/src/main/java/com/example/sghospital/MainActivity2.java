package com.example.sghospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button bSubmit,bGO;
EditText edName,edAge,edAddress,edPhone,edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bSubmit=findViewById(R.id.bSubmit);
        bGO=findViewById(R.id.bGO);
        edName=findViewById(R.id.edName);
        edAge=findViewById(R.id.edAge);
        edAddress=findViewById(R.id.edAddress);
        edPhone=findViewById(R.id.edPhone);
        edEmail=findViewById(R.id.edEmail);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Models models;
                try {
                    models = new Models(edName.getText().toString(), edAge.getText().toString(), edAddress.getText().toString(), edPhone.getText().toString(), edEmail.getText().toString());
                    Toast.makeText(MainActivity2.this,models.toString(), Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(MainActivity2.this, "error creating ", Toast.LENGTH_SHORT).show();
                   models=new Models("error","error","error","error","error");
                }
                boolean success;
                try(HospitalData hospitalData=new HospitalData(MainActivity2.this)){
                    success = hospitalData.addOne(models);
                }
                Toast.makeText(MainActivity2.this, "Successful"+success, Toast.LENGTH_SHORT).show();

            }
        });
        bGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}