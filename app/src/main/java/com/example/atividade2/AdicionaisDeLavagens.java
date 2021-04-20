package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdicionaisDeLavagens extends AppCompatActivity {
    TextView textView2;
    Button button6;

    private List<Adicionais> adicionaisList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionais_de_lavagens);
        textView2 = (TextView) findViewById(R.id.textView2);
        button6 = (Button)  findViewById(R.id.button6);

        Tarefa tarefa = new Tarefa();
        tarefa.execute("https://my-json-server.typicode.com/alinefernandesTI/atividade01/Adicionais");

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdicionaisDeLavagens.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private class Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            adicionaisList = ConsumirJsonDois.jsonDados(s);
            exibirDados();
        }

        private void exibirDados() {
            if(adicionaisList != null){
                for(Adicionais adicionais : adicionaisList){
                    textView2.append( "\nAdicional "+ adicionais.getTipo()+ "\n"+adicionais.getValor()+ "\n");
                }
            }
        }

    }
}