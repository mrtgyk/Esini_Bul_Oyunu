package com.example.acer.mygame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

public class kart extends Button {
    boolean acikMi=false;
    boolean cevrilebilirmi=true;
    int arkaplanID;
    int onplanID=0;
    Drawable arka;
    Drawable on;

    public kart(Context context,int id) {

        super(context);
        setId(id);

        //Kartlar id numaralarına göre tanımlanıyor
        if(id%12==1)
            onplanID=R.drawable.c1;
        if(id%12==2)
            onplanID=R.drawable.c2;
        if(id%12==3)
            onplanID=R.drawable.c3;
        if(id%12==4)
            onplanID=R.drawable.c4;
        if(id%12==5)
            onplanID=R.drawable.c5;
        if(id%12==6)
            onplanID=R.drawable.c6;
        if(id%12==7)
            onplanID=R.drawable.c7;
        if(id%12==8)
            onplanID=R.drawable.c8;
        if(id%12==9)
            onplanID=R.drawable.c9;
        if(id%12==10)
            onplanID=R.drawable.c10;
        if(id%12==11)
            onplanID=R.drawable.c11;
        if(id%12==0)
            onplanID=R.drawable.c12;

        arkaplanID=R.drawable.back;
        arka= AppCompatDrawableManager.get().getDrawable(context,arkaplanID);
        on= AppCompatDrawableManager.get().getDrawable(context,onplanID);
        setBackground(arka);
    }

    public void cevir()
    {
        if(cevrilebilirmi)
        {
            if(!acikMi)
            {
                setBackground(on);
                acikMi=true;
            }else
            {
                setBackground(arka);
                acikMi=false;
            }
        }

    }
}
