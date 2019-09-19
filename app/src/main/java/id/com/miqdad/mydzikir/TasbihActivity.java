package id.com.miqdad.mydzikir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TasbihActivity extends AppCompatActivity {

    TextView tvDigit;
    Button btnPress, btnTahmid, btnReset;
    private int tambahAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);


        tvDigit = findViewById(R.id.tv_digit);
        btnPress = findViewById(R.id.btn_Press);
        btnTahmid = findViewById(R.id.btn_Tahmid);
        btnReset = findViewById(R.id.reset);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahAngka = 0;
                tvDigit.setText(String.valueOf(tambahAngka));
            }
        });


        btnTahmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TasbihActivity.this,TahmidActivity.class));
            }
        });


        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvDigit.setText(String.valueOf(tambahAngka));
                if (tambahAngka >= 33){
                    Toast.makeText(TasbihActivity.this,"Succes di tekan",Toast.LENGTH_SHORT).show();
                    btnTahmid.setVisibility(View.VISIBLE);
                }else{
                    tambahAngka = tambahAngka+1;
                    btnTahmid.setVisibility(View.GONE);
                }
                tvDigit.setText(String.valueOf(tambahAngka));
            }
        });


    }
}
