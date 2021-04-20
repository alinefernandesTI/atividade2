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

public class LavagensValores extends AppCompatActivity {

    private TextView textView;
    private Button button8;

    private List<Lavagens> lavagensList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavagens_valores2);
        textView = (TextView) findViewById(R.id.textView);
        button8 = (Button) findViewById(R.id.button8);


       TarefaTres tarefaTres = new TarefaTres();
        tarefaTres.execute("https://my-json-server.typicode.com/alinefernandesTI/atividade01/Lavagens");

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LavagensValores.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private class TarefaTres extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            lavagensList = ConsumirJson.jsonDados(s);
            exibirDados();
        }

        private void exibirDados() {
            if(lavagensList != null){
                for(Lavagens lavagens : lavagensList){
                    textView.append("\n Lavagem "+ lavagens.getNome()+ "\n"+lavagens.getValor()+ "\n");
                }
            }
        }


    }
}