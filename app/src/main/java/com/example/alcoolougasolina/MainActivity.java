package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private EditText editPrecoAlcool,editPrecoGasolina;
   private TextView textResultado;
   public Button CalcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
         editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
         textResultado= findViewById(R.id.textResultado);
         CalcButton = findViewById(R.id.CalcButton);

         CalcButton.setOnClickListener(v -> {
              calcularPreco();
         } );


       // findViewById(R.id.CalcButton).setOnClickListener(actionHandle);
    }
  /*  View.OnClickListener actionHandle= new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.CalcButton:
                    calcularPreco();
                    break;

          *//*  case R.id.b_2:
                // act!
                break;*//*
            }
        }
    };*/

   public void calcularPreco(){//1  FRIST

    String precoAlcool;
    String precoGasolina;
    precoAlcool = editPrecoAlcool.getText().toString();
    precoGasolina = editPrecoGasolina.getText().toString();

      // Toast.makeText(this, precoGasolina, Toast.LENGTH_SHORT).show();
        if(precoAlcool.isEmpty()){
            editPrecoAlcool.setError("campo Vazio");
            return;
        }
        if (precoGasolina.isEmpty()){
            editPrecoGasolina.setError("campo vazio");
            return;
        }



        switch ( calculoAlcoolOuGasolina(precoAlcool, precoGasolina) ){
            case  1:
                textResultado.setText("Bah dai melhor usar Álcool CPX");
            break;
            case 2:
                textResultado.setText("Melhor usar Gasolina");
            break;

            default:
                textResultado.setText("Erro interno.");
            break;
        }

        editPrecoGasolina.setText("");
        editPrecoGasolina.setText("");

    }


    public boolean validarOtextInputLayout(String valorNoInput){//2
        if(valorNoInput.equals("")||valorNoInput==null){
            //tratar como um erro do usuário.
            return true;
        }

        else return false;
    }

    public int calculoAlcoolOuGasolina(String alcool, String gasolina){//3
        int valorResultado = stringParaInt(alcool) / stringParaInt(gasolina);
        if (valorResultado >= 0.7){
            return 2;//melhor usar gasolina
        }
        else return 1;
    }

    public int stringParaInt(String stringParan){//4
        //CONVERTE INT PARA STRING ONDE DEVE SER USADO NO validarOtextInputLayout(String valorNoInput)
        int intParan= Integer.parseInt(stringParan);
        return intParan;
    }
}                                               // álcool/gasolina >= 0.7 : melhor usar gasolina.