package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCActivity extends AppCompatActivity {

    TextView txtResultado, txtImc, txtPeso, txtAltura;
    ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);

        txtResultado = findViewById(R.id.txtIMCResultado);
        txtAltura = findViewById(R.id.txtAlturaResultado);
        txtPeso = findViewById(R.id.txtPesoResultado);
        imgResultado = findViewById(R.id.imgIMC);
        txtImc = findViewById(R.id.txtTipoImc);

        Calcular();
    }

    public void Calcular()
    {
        Bundle bundle = getIntent().getExtras();

        double valorAltura = bundle.getDouble("altura");
        double valorPeso = bundle.getDouble("peso");

        double imc =  valorPeso / Math.pow(valorAltura, 2);

        txtAltura.setText(String.valueOf(valorAltura));
        txtPeso.setText(String.valueOf(valorPeso));
        txtResultado.setText("IMC: " + String.format("%.2f", imc));

        if (imc <= 18.5)
        {
            imgResultado.setImageResource(R.drawable.abaixo);
            txtImc.setText("Abaixo do Peso");
        }
        else if (imc < 25)
        {
            imgResultado.setImageResource(R.drawable.ideal);
            txtImc.setText("Peso Ideal");
        }
        else if(imc < 30)
        {
            imgResultado.setImageResource(R.drawable.acima);
            txtImc.setText("Acima do Peso");
        }
        else if (imc < 35)
        {
            imgResultado.setImageResource(R.drawable.obesidade);
            txtImc.setText("Obesidade Grau I");
        }
        else if (imc < 40)
        {
            imgResultado.setImageResource(R.drawable.severa);
            txtImc.setText("Obesidade Grau II (Severa)");
        }
        else
        {
            imgResultado.setImageResource(R.drawable.morbida);
            txtImc.setText("Obesidade Grau III (Mórbida)");
        }
    }
}