package com.example.sghospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {
ListView show;
Button bView,bNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        show=findViewById(R.id.show);
        bView=findViewById(R.id.bView);
        bNext=findViewById(R.id.bNext);

        bView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HospitalData hospitalData=new HospitalData(MainActivity4.this);
                List<Models> models=hospitalData.getEveryone();
                ArrayAdapter customerAdapter = new ArrayAdapter<Models>(MainActivity4.this, android.R.layout.simple_list_item_1, models);
                show.setAdapter(customerAdapter);
            }
        });
     bNext.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(MainActivity4.this,MainActivity5.class);
             startActivity(intent);
         }
     });
    }
}