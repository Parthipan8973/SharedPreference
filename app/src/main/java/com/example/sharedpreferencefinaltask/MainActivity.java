package com.example.sharedpreferencefinaltask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferencefinaltask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String name,number,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityMainBinding = DataBindingUtil. setContentView(this,R.layout.activity_main);

       sharedPreferences = getSharedPreferences("DataStorage",MODE_PRIVATE);
       editor = sharedPreferences.edit();


       activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               name = activityMainBinding.username.getText().toString();
               number=activityMainBinding.phone.getText().toString();
               location=activityMainBinding.location.getText().toString();

               String strng = name+"\n"+number+"\n"+location;
               editor.putString("Dataname", name);
               editor.putString("Datanumber", number);
               editor.putString("Dataslocation", location);
               editor.putString("Alldata",strng);

               editor.commit();
               Toast.makeText(MainActivity.this, "Your data is saved", Toast.LENGTH_SHORT).show();
           }
       });

       activityMainBinding.button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               startActivity(new Intent(MainActivity.this,SecoundPage.class));
               Toast.makeText(MainActivity.this, "Next Page", Toast.LENGTH_SHORT).show();

           }
       });


    } 
}