package com.example.constantinozamora.daqazucar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


import org.w3c.dom.Text;

public class molienda extends AppCompatActivity {

    TextView valorM;
    TextView valorM2;
    TextView valorM3;
    TextView valorM4;

    Button BM;

    private Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molienda);

        customHandler.postDelayed(updateTimerThread, 500);

        BM=(Button)findViewById(R.id.buttonM);

        BM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimerThread, 0);
            }
        });
    }


    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            valorM = (TextView)findViewById(R.id.textValorM);
            valorM.setText(Double.toString(funciones.Val1[127]));

            valorM2 = (TextView)findViewById(R.id.textValorM2);
            valorM2.setText(Double.toString(funciones.Val2[127]));

            valorM3 = (TextView)findViewById(R.id.textValorM3);
            valorM3.setText(Double.toString(funciones.Val3[127]));

            valorM4 = (TextView)findViewById(R.id.textValorM4);
            valorM4.setText(Double.toString(funciones.Val4[127]));

            customHandler.postDelayed(this, 0);

        }

    };

}
