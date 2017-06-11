package com.example.acer.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView skor,hata,isim;
        int skr,ht;
        isim=(TextView)findViewById(R.id.textView4);
        skor=(TextView)findViewById(R.id.textView5);
        hata=(TextView)findViewById(R.id.textView6);

        Intent i=getIntent();
        String ad=i.getStringExtra("isim");
        skr=i.getIntExtra("skor",0);
        ht=i.getIntExtra("hata",0);

        isim.setText("TEBRİKLER "+ad);
        skor.setText("Skor: "+skr);
        hata.setText("Hata: "+ht);


    }
}
