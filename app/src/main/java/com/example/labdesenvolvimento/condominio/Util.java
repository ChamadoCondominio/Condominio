package com.example.labdesenvolvimento.condominio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Util {
    /**
     *Lê um arquivo da web via HTTP e converte o mesmo em String.
     *@param inputStream Stream do arquivo local no aplicativo
     *@return O arquivo convertido em String.
     */
    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static List<Cond> convertJSONtoClube(String jsonFile){
        List<Cond> Conds = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){
                Cond novoCond = new Cond();
                JSONObject localObj = mainObject.getJSONObject(i);
                long id = localObj.getLong("id_cond");
                String nome = localObj.getString("nome_cond");
                int apartamento = localObj.getInt("apartamento_cond");
                String bloco = localObj.getString("bloco_cond");
                novoCond.setID(id);
                novoCond.setNome(nome);
                novoCond.setApartamento(apartamento);
                novoCond.setBloco(bloco);
                Conds.add(novoCond);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Conds;
    }
}