package com.example.sharedpreferencefinaltask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferencefinaltask.databinding.ActivityThirdPageBinding;

public class ThirdPage extends AppCompatActivity {
    ActivityThirdPageBinding activityThirdPageBinding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThirdPageBinding = DataBindingUtil.setContentView(this,R.layout.activity_third_page);
        sharedPreferences=getSharedPreferences("DataStorage",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        activityThirdPageBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String add1 = sharedPreferences.getString("Alldata","null");
                String add2 = sharedPreferences.getString("Datamail","null");

                String Alldatas = add1+"\n"+add2;

                activityThirdPageBinding.textView4.setText(Alldatas);

                Toast.makeText(ThirdPage.this, "Show Your Details", Toast.LENGTH_SHORT).show();
            }
        });

        activityThirdPageBinding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThirdPage.this,MainActivity.class));

            }
        });


    }
}