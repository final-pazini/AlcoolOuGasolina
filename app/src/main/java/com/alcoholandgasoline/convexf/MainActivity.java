package com.alcoholandgasoline.convexf;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        String precAlcool = precoAlcool.getText().toString();
        String preGasolina = precoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precAlcool, preGasolina);

        if(camposValidados){

            double valorAlcool = Double.parseDouble(precAlcool);
            double valorGasolina = Double.parseDouble(preGasolina);

            double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");

            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }


        }else{
            textResultado.setText("Preencha os campos primeiro");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;

        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }

        return camposValidados;

    }

}