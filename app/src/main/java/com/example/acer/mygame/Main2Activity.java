package com.example.acer.mygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int SonKart=0;
    int skor=0;
    int hata=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i=getIntent();
        GridLayout grid=(GridLayout)findViewById(R.id.grid);
        final TextView kullaniciya_mesaj=(TextView)findViewById(R.id.textView);
        kart kartlar[]=new kart[24];
        final String isim=i.getStringExtra("mesaj");

        for(int j=1;j<=24;j++)
        {
            kartlar[j-1]=new kart(this,j); //Kartlar oluşturuldu
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k=(kart)v; //View karta çevriliyor
                    k.cevir();

                    if(SonKart>0){
                        final kart k2=(kart)findViewById(SonKart); //Son kart aktarıldı
                        if(k2.onplanID==k.onplanID && k2.getId()!=k.getId()) //Eslesme kontrol ediliyor
                        {
                            Button u=(Button)findViewById(k2.getId());
                            u.setClickable(false);
                            Button y=(Button)findViewById(k.getId());
                            y.setClickable(false);

                            k2.cevrilebilirmi=false;
                            k.cevrilebilirmi=false;
                            skor++;
                            kullaniciya_mesaj.setText("Eşleşme Doğru!");

                            if(skor==12)
                            {
                                Intent i =new Intent(Main2Activity.this,Main3Activity.class);
                                i.putExtra("hata",hata);
                                i.putExtra("skor",skor);
                                i.putExtra("isim",isim);
                                startActivity(i);
                            }
                        }else
                        {
                            Handler h=new Handler(); //Bekleme özelliği oluşturuluyor
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();

                                }
                            },500);
                            hata++;
                            kullaniciya_mesaj.setText("Yanlış Eşletirme Yaptın "+ isim);
                        }
                        SonKart=0;
                    }else
                    {
                        SonKart=k.getId();
                    }
                }
            });
        }

        //Kartları karıştırma İşlemi
        for(int j=0;j<24;j++)
        {
            int rastgele=(int)(Math.random()*24);
            kart k=kartlar[rastgele];
            kartlar[rastgele]=kartlar[j];
            kartlar[j]=k;
        }
        for(int j=0;j<24;j++)
        {
            grid.addView(kartlar[j]);
        }

    }
}
