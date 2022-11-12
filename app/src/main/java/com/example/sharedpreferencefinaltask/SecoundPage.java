package com.example.sharedpreferencefinaltask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferencefinaltask.databinding.ActivityMainBinding;
import com.example.sharedpreferencefinaltask.databinding.ActivitySecoundPageBinding;

public class SecoundPage extends AppCompatActivity {
    ActivitySecoundPageBinding activitySecoundPageBinding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activitySecoundPageBinding = DataBindingUtil. setContentView(this,R.layout.activity_secound_page);
       sharedPreferences=getSharedPreferences("DataStorage",MODE_PRIVATE);
       editor = sharedPreferences.edit();
        String namedata = sharedPreferences.getString("Dataname","Enter Your name");
        String phonedata = sharedPreferences.getString("Datanumber","Enter your Location");

        activitySecoundPageBinding.username.setText(namedata);
        activitySecoundPageBinding.phone.setText(phonedata);

        activitySecoundPageBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = activitySecoundPageBinding.Mail.getText().toString();

                editor.putString("Datamail",mail);
                editor.commit();

                Toast.makeText(SecoundPage.this, "Data saved", Toast.LENGTH_SHORT).show();
            }
        });
        
       activitySecoundPageBinding.button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(SecoundPage.this,ThirdPage.class));

               Toast.makeText(SecoundPage.this, "Thirdpage", Toast.LENGTH_SHORT).show();
           }
       });
    }
}