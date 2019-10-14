package br.com.digitalhouse.entregavel02.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.entregavel02.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imagemSplash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imagemSplash = findViewById(R.id.imageBurguer);

        imagemSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        },3000);
    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
