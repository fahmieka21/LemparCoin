package com.example.fachmi_eka_pangestu_ti18d5;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LemparCoin extends Activity implements View.OnClickListener {
    private Button buttonLempar;
    private Button buttonUlangi;
    private Button buttonKeluar;
    private Random acak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acak = new Random();
        setContentView(R.layout.activity_lemparcoin);
        buttonLempar = (Button) findViewById(R.id.buttonlempar);
        buttonUlangi = (Button) findViewById(R.id.buttonUlang);
        buttonKeluar = (Button) findViewById(R.id.buttonKeluar);
        buttonLempar.setOnClickListener(this);
        buttonUlangi.setOnClickListener(this);
        buttonKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view==buttonLempar){

            Log.d("Click Event","Lempar Button DI Click");
            TextView Tv=(TextView)findViewById(R.id.textView1);
            ImageView Iv=(ImageView)findViewById(R.id.imageView1);

            if (acak.nextDouble() < 0.5) {
                Tv.setText("Kepala");
                Iv.setImageResource(R.drawable.head);
            } else {
                Tv.setText("Cross");
                Iv.setImageResource(R.drawable.tail);
            }

            buttonLempar.setVisibility(view.INVISIBLE);
            buttonUlangi.setVisibility(view.VISIBLE);
            buttonKeluar.setVisibility(view.VISIBLE);
        }

        else if (view==buttonUlangi){

            TextView Tv=(TextView)findViewById(R.id.textView1);
            ImageView Iv=(ImageView)findViewById(R.id.imageView1);

            buttonLempar.setVisibility(View.VISIBLE);
            buttonUlangi.setVisibility(view.INVISIBLE);
            buttonKeluar.setVisibility(view.INVISIBLE);

        }else if (view==buttonKeluar){
            this.finish();
        }
    }

}
