package com.example.labdesenvolvimento.condominio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class  MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectMainOpetion(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnInserir:
                intent = new Intent(this,InsertCondActivity.class);
                break;
            case R.id.btnListar:
                intent = new Intent(this,ListCondActivity.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}