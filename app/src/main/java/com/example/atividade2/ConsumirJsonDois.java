package com.example.atividade2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJsonDois {
    public static List<Adicionais> jsonDados(String conteudo){
        try{
            List<Adicionais> adicionaisList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i =0; i< jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                Adicionais adicionais = new Adicionais();

                adicionais.setTipo(jsonObject.getString("tipo"));
                adicionais.setValor(jsonObject.getString("valor"));

                adicionaisList.add(adicionais);



            }

            return adicionaisList;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
