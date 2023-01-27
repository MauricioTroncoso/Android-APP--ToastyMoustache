package com.example.toastymoustachebrotherhood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Pantalla Completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animaciones

        Animation animacionLogo1= AnimationUtils.loadAnimation(this,R.anim.animacionlogo1);
        Animation animacionLogo2= AnimationUtils.loadAnimation(this,R.anim.animacionlogo2);

        ImageView logo1 = (ImageView) findViewById(R.id.logo1);
        ImageView logo2=(ImageView) findViewById(R.id.logo2);

        logo1.setAnimation(animacionLogo1);
        logo2.setAnimation(animacionLogo2);

        //Tiempo del splash y salto a otra activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },8000);
    }

    @Override
    protected void onResume() {
        super.onResume();
    //iniciar la musica
        mp=MediaPlayer.create(this,R.raw.toastysplash);
        mp.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
       //pausar la musica al salir de la activity
        if(mp != null){
            mp.stop();
            mp.release();
            mp=null;
        }
    }

}