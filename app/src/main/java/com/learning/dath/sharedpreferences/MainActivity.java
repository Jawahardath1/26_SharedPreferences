package com.learning.dath.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText userpasswordInput;
    TextView outputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        userpasswordInput = findViewById(R.id.userpasswordInput);
        outputText = findViewById(R.id.outputText);

    }

    //Save User Information
    public void saveInfoClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username",usernameInput.getText().toString());
        editor.putString("userpassword",userpasswordInput.getText().toString());
        editor.apply();


        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
    }


    //Print out the saved Data
    public void dispalyInfoClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username","");
        String pwd  = sharedPref.getString("userpassword","");

        outputText.setText(name+" "+pwd);


    }





}
