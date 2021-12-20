package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.click1);
        Button didit = (Button) findViewById(R.id.didit);

        View canvas = (View)findViewById(R.id.canvas);
        canvas.setOnClickListener(this::dismissKb);
        button.setOnClickListener(this::click);
        didit.setOnClickListener(this::congrats);



    }

    private void congrats(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.happy_hd_png);
        EditText name = (EditText) findViewById(R.id.editTextName);
        double usd;
        String amt = name.getText().toString();
        usd = Double.parseDouble(amt);
        TextView output = (TextView) findViewById(R.id.output);
        output.setText(String.valueOf(usd*2.7169)+" XCD");


    }

    private void dismissKb(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    public void click(View view){
        EditText name = (EditText) findViewById(R.id.editTextName);
        Toast.makeText(MainActivity.this, String.format("Hi there %s",name.getText()),Toast.LENGTH_LONG).show();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.plate);

    }
}