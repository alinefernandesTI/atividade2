package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class contatosDasLavagens extends AppCompatActivity   {
    private Button button7;
    private TextView textView5;
    private List<Contatos> contatosList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiposde_lavagens);
        button7 = (Button) findViewById(R.id.button7);
        textView5 = (TextView) findViewById(R.id.textView5);


        TarefaQuatro tarefaQuatro = new TarefaQuatro();
        tarefaQuatro.execute("https://my-json-server.typicode.com/alinefernandesTI/atividade01/Contatos");

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contatosDasLavagens.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private class TarefaQuatro extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            contatosList = ConsumirJsonQuatro.jsonDados(s);
            exibirDados();
        }

        private void exibirDados() {
            if(contatosList != null){
                for(Contatos contatos : contatosList){
                    textView5.append("\nUnidade: "+contatos.getUnidade() +"\n" +contatos.getEndereco()+ "\n"+ "Numero: "+contatos.getNumero()+ "\n"+contatos.getEmail()+ "\n");
                }
            }
        }

    }
}