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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<String> carbs = Arrays.asList("Rice","Potatoes","Pasta","Breadfruit");
    List<String> protein = Arrays.asList("Beef","Fish","Chicken","Saltfish");
    List<String> vegetables = Arrays.asList("Lettuce","Tomatoes","Broccoli","Cauliflower", "Carrot","Olive");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getPlate = (Button) findViewById(R.id.getPlate);


        getPlate.setOnClickListener(this::getPlate);
        View canvas = (View)findViewById(R.id.canvas);
        canvas.setOnClickListener(this::dismissKb);
        rollFood();





    }

    private void rollFood(){
        TextView proteinView = (TextView) findViewById(R.id.protein);
        TextView carbView = (TextView) findViewById(R.id.carbs);
        TextView vegetableView = (TextView) findViewById(R.id.vegetables);
        Random rand = new Random();
        String randomProtein = protein.get(rand.nextInt(protein.size()));
        String randomCarb = carbs.get(rand.nextInt(carbs.size()));
        String randomVegetable = vegetables.get(rand.nextInt(vegetables.size()));
        proteinView.setText(randomProtein);
        carbView.setText(randomCarb);
        vegetableView.setText(randomVegetable);

    }
    private void makeSalad(){

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

    public void getPlate(View view){
        EditText name = (EditText) findViewById(R.id.editTextName);
        Toast.makeText(MainActivity.this, String.format("Hi there %s",name.getText()),Toast.LENGTH_LONG).show();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.plate);
        rollFood();

    }
}