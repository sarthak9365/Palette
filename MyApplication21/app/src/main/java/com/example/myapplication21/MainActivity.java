package com.example.myapplication21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity<gt, lt, pss> extends AppCompatActivity {

    private LinearLayout rootlayout,rootlayout1;
    private TextView textViewTitle,textViewTitle2,textViewTitle3,textViewTitle4,textViewTitle5,textViewTitle6;
    private TextView textViewBody;
    private ImageView imageView;

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;

    Palette palette;

    private int swatchnumber;
    private int color;
    private int bodytextcolor;
    private int titletextcolor;
    private int population;
    private float[] hsl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootlayout = findViewById(R.id.root_layout);
        rootlayout1=findViewById(R.id.root_layout_2);
        textViewTitle=findViewById(R.id.text_view_title);
        textViewTitle2=findViewById(R.id.text_view_title_2);
        textViewTitle3=findViewById(R.id.text_view_title_3);
        textViewTitle4=findViewById(R.id.text_view_title_4);
        textViewTitle5=findViewById(R.id.text_view_title_5);
        textViewBody=findViewById(R.id.text_view_body);
        imageView=findViewById(R.id.imageView_1);


        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
       // Palette.Swatch dominantswatc = palette.getDominantSwatch();
        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                vibrantSwatch=palette.getVibrantSwatch();
                lightVibrantSwatch=palette.getLightVibrantSwatch();
                darkVibrantSwatch=palette.getDarkVibrantSwatch();
                mutedSwatch=palette.getMutedSwatch();
                lightMutedSwatch=palette.getLightMutedSwatch();
                darkMutedSwatch=palette.getDarkMutedSwatch();

            }
        });



    }
    public void nextSwatch(View view){

    Palette.Swatch currentSwatch = null;

    switch (swatchnumber){

        case 0:
            currentSwatch=vibrantSwatch;
            //textViewTitle.setText("Vibrant");

            break;
        case 1:
            currentSwatch=lightVibrantSwatch;
            //textViewTitle.setText("lightvibrantSwatch");
            break;
        case 2:
            currentSwatch=darkVibrantSwatch;
            //textViewTitle.setText("darkvibrantSwatch");
            break;
        case 3:
            currentSwatch=mutedSwatch;
            //textViewTitle.setText("mutedSwatch");
            break;
        case 4:
            currentSwatch=lightMutedSwatch;
            //textViewTitle.setText("lightmutedSwatch");
            break;

        case 5:
            currentSwatch=darkMutedSwatch;
            //textViewTitle.setText("darkmutedSwatch");
            break;


    }
    if(currentSwatch!=null){
        //return the rgb value of color
        color=currentSwatch.getRgb();
        //return the Swatch's HSL value:
        hsl=currentSwatch.getHsl();
        //return the swatch's bodytextcolor
        bodytextcolor=currentSwatch.getBodyTextColor();
        //return the swatch's titletextcolor
        titletextcolor=currentSwatch.getTitleTextColor();
        //return the populaton of swatch's
        population=currentSwatch.getPopulation();
        //convert the rgb into string to show
        String color1 = String.valueOf(color);
        //convert the swatch hsl into string to show
        String color2=String.valueOf(hsl);
        //convert the bodytextcolor into string to show
        String color3=String.valueOf(bodytextcolor);
        //convert the titletextcolor into string to show
        String color4 = String.valueOf(titletextcolor);
        //convert the  population into string to show
        String color5 = String.valueOf(population);

        rootlayout.setBackgroundColor(currentSwatch.getRgb());
        rootlayout1.setBackgroundColor(currentSwatch.getRgb());
        textViewTitle.setText("RGB:"+color1);
        textViewTitle2.setText("HSL:"+color2);
        textViewTitle3.setText("BodyTextColor:"+color3);
        textViewTitle4.setText("TitleTextColor:"+color4);
        textViewTitle5.setText("Population:"+color5);
        //textViewTitle.setTextColor(currentSwatch.getTitleTextColor());
        textViewBody.setTextColor(currentSwatch.getBodyTextColor());

    }else{
        rootlayout.setBackgroundColor(Color.WHITE);
        rootlayout1.setBackgroundColor(Color.WHITE);
        textViewTitle.setTextColor(Color.RED);
        textViewBody.setTextColor(Color.RED);
    }
    if(swatchnumber<5){

        swatchnumber++;

    }else{
        swatchnumber=0;
    }


    }
}
