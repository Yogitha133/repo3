package com.example.myapplication102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name;
    TextView password;
    public static final String mypreference ="mypref";
    public static final String Name= "namekey";
    public static final String Password="passwordkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextView) findViewById(R.id.etName);
        password=(TextView) findViewById(R.id.etpassword);
        sharedpreferences= getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedpreferences.contains(Name))
        {
            name.setText(sharedpreferences.getString (Name,""));
        }
        if(sharedpreferences.contains(Password)){
            password.setText(sharedpreferences.getString(Password,""));} }

    public void Save(View view) {
        String n =name.getText().toString();
        String p=password.getText().toString();
        SharedPreferences.Editor editor= sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Password,p);
        editor.commit();
    }
    public void clear (View view){
        name=(TextView) findViewById(R.id.etName);password=(TextView) findViewById(R.id.etpassword);
        name.setText("");
        password.setText("");
    }

    public void Get(View view){
        name= (TextView) findViewById(R.id.etName);
        password= (TextView) findViewById(R.id.etpassword);
        sharedpreferences= getSharedPreferences(mypreference,Context.MODE_PRIVATE);

        if(sharedpreferences.contains(Name))
        {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if(sharedpreferences.contains(Password))
        {
            password.setText(sharedpreferences.getString(Password,""));
        }
    }

}

