package com.example.atividade2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJsonTresDois {
    public static List<Historico> jsonDados(String conteudo){
        try{

            List<Historico> geral = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i =0; i< jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                Historico historico = new Historico();

                historico.setData(jsonObject.getString("Data"));
                historico.setLavagem(jsonObject.getString("Lavagem"));
                historico.setValor(jsonObject.getString("valor"));

              if(historico.getLavagem().equals("Geral") || historico.getLavagem().equals("Geral com Cera")){
                    geral.add(historico);
                }

            }


            return  geral;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
