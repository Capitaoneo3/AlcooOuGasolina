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

        boolean precoAlcoolValidado, precoGasolinaValidado;
        precoAlcoolValidado= validarOtextInputLayout(precoAlcool);
        precoGasolinaValidado= validarOtextInputLayout(precoGasolina);

        if(precoAlcoolValidado==false) {
            editPrecoAlcool.setError("este campo não pode estar vazio");
        }
        else if(precoGasolinaValidado==false){
            editPrecoGasolina.setError("este campo não pode estar vazio");
        }
        else {

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
        }
    }
    public int calculoAlcoolOuGasolina(String alcool, String gasolina){
        int valorResultado = stringParaInt(alcool) / stringParaInt(gasolina);
        if (valorResultado >= 0.7){
            return 2;
        }
        else return 1;
    }
    public boolean validarOtextInputLayout(String valorNoInput){
        if(valorNoInput==""||valorNoInput==null){
            //tratar como um erro do usuário.
            return true;
        }
        else return false;
    }
    public int stringParaInt(String stringParan){
        //CONVERTE INT PARA STRING ONDE DEVE SER USADO NO validarOtextInputLayout(String valorNoInput)
        Integer intParan= Integer.parseInt(stringParan);
        return intParan;
    }
}// álcool/gasolina >= 0.7 : melhor usar gasolina.