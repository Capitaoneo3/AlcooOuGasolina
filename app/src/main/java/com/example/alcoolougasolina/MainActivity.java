package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText editPrecoAlcool,editPrecoGasolina;
   private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
         editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
         textResultado= findViewById(R.id.textResultado);

    }

   public void calcularPreco(){
    String precoAlcool= editPrecoAlcool.getText().toString();
    String precoGasolina= editPrecoGasolina.getText().toString();
    precoAlcool="1";
    precoGasolina="1";
    int valorResultado= stringParaInt(precoAlcool)/stringParaInt(precoGasolina);
       System.out.println(valorResultado);
    }
    public int stringParaInt(String stringParan){
        Integer intParan= Integer.parseInt(stringParan);
        return intParan;
    }
}// álcool/gasolina >= 0.7 : melhor usar gasolina.