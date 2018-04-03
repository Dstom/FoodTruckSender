package com.example.practica1.foodtrucksender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox gaseosa;
    Button btn_enviar;
    String pedido;
    String gaseos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gaseosa = (CheckBox)findViewById(R.id.chk_gaseosa);


        btn_enviar = (Button)findViewById(R.id.btn_envviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gaseosa.isChecked()){
                    gaseos = "Gaseosa PEPSE 1/2 litro";
                }else{
                    gaseos = "Sin Gaseosa";
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,pedido);
                sendIntent.putExtra("gaseosa",gaseos);
                sendIntent.setType("text/plain");
                if(null != sendIntent.resolveActivity(getPackageManager())){
                    startActivity(Intent.createChooser
                            (sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });

    }
    public void onClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.rbtn_ofertita:
                if(checked) pedido = "Ofertita Pollito 10 SO";
                break;
            case R.id.rbtn_oferton:
                if(checked) pedido = "Oferton Pollo 50 SO";
                break;

        }
    }
}
