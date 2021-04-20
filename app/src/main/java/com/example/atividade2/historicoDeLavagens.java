package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class historicoDeLavagens extends AppCompatActivity {
    private TextView textView6;
    private  Button button9;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    private Button button5;

    private List<Historico> ducha = new ArrayList<>();
    private List<Historico> expressa = new ArrayList<>();
    private List<Historico> geral = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_de_lavagens);
        textView6 = (TextView) findViewById(R.id.textView6);
        button9 = (Button)findViewById(R.id.button9);
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.tipoLav);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                textView.setText("Lavagem: "+ radioButton.getText());
                TarefaTres tarefaTres = new TarefaTres();
                tarefaTres.execute("https://my-json-server.typicode.com/alinefernandesTI/atividade01/Historico");
                textView6.setText("");

            }
        });




        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(historicoDeLavagens.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }
    private class TarefaTres extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            if(radioButton.getText().equals("Ducha")){
                ducha = ConsumirJsonTres.jsonDados(s);
                exibirDados();

            }else if(radioButton.getText().equals("Expressa")){
                expressa = ConsumirJsonTresUm.jsonDados(s);
                exibirDadosUm();

            }else{
                geral = ConsumirJsonTresDois.jsonDados(s);
                exibirDadosDois();

            }



        }

        private void exibirDados() {
            if(ducha != null){
                for(Historico historico : ducha){
                        textView6.append("\n"+"Lavagem "+  historico.getLavagem()+"\n"+historico.getData() + "\n"+historico.getValor()+ "\n");

                }
            }
        }
        private void exibirDadosUm() {
            if(expressa != null){
                for(Historico historico : expressa){
                    textView6.append("\n"+"Lavagem "+  historico.getLavagem()+"\n"+historico.getData() + "\n"+historico.getValor()+ "\n");

                }
            }
        }
        private void exibirDadosDois() {
            if(geral != null){
                for(Historico historico : geral){
                    textView6.append("\n"+"Lavagem "+  historico.getLavagem()+"\n"+historico.getData() + "\n"+historico.getValor()+ "\n");

                }
            }
        }

    }
}