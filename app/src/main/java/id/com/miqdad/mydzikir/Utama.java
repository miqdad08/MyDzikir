package id.com.miqdad.mydzikir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Utama extends AppCompatActivity {
    Button dPagi, dPetang, dsShalat, dHarian, aAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        dPagi = findViewById(R.id.dPagi);
        dPetang = findViewById(R.id.dPetang);
        dsShalat = findViewById(R.id.dsShalat);
        dHarian = findViewById(R.id.dHarian);
        aAbout = findViewById(R.id.about);


        dPetang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Utama.this,DetailActivity.class);
                intent.putExtra("KEY", "petang");
                startActivity(intent);

            }
        });

        dPagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Utama.this,DetailActivity.class);
                intent.putExtra("KEY", "pagi");
                startActivity(intent);

            }
        });

        dsShalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Utama.this,TasbihActivity.class);
                startActivity(intent);

            }
        });

        dHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Utama.this,DetailActivity.class);
                intent.putExtra("KEY", "doa");
                startActivity(intent);
            }
        });

        aAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Utama.this,AboutActivity.class));
            }
        });


    }
}
