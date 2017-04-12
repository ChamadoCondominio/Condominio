package com.example.labdesenvolvimento.condominio;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;



public class CondAdapter extends ArrayAdapter<Cond> {
    private List<Cond> conds;
    private int layout;

    public CondAdapter(Context context, int resource, List<Cond> conds){
        super(context,resource,conds);
        this.conds = conds;
        layout = resource;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        View localView = contentView;

        if(localView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout,null);
        }

        Cond cond = conds.get(position);

        if(cond != null){
            TextView textID = (TextView) localView.findViewById(R.id.textID);
            TextView textNome = (TextView) localView.findViewById(R.id.textNome);
            TextView textApartamento = (TextView) localView.findViewById(R.id.textApartamento);
            TextView textBloco = (TextView) localView.findViewById(R.id.textBloco);

            if(textID != null){
                textID.setText(String.valueOf(cond.getID()));
            }
            if(textNome != null){
                textNome.setText(cond.getNome());
            }
            if(textApartamento != null){
                textApartamento.setText(cond.getApartamento());
            }
            if(textBloco != null){
                textBloco.setText(String.valueOf(cond.getBloco()));
            }
        }
        return localView;
    }
}