package com.example.labdesenvolvimento.condominio;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ListCondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cond);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadConds();
    }

    public void loadConds(){
        new DownloadFromMyAPI().execute();
    }

    private class DownloadFromMyAPI extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://webtests.pe.hu/selectAll.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                /*urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.connect();*/

                int test = urlConnection.getResponseCode();

                String result = Util.webToString(urlConnection.getInputStream());

                return result;
            } catch (Exception e) {
                Log.e("Error", "Error ", e);
                return null;
                } finally{
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            List<Cond> conds = Util.convertJSONtoClube(s);
            if(conds != null){
                ArrayAdapter<Cond> condAdapter = new CondAdapter(ListCondActivity.this,R.layout.cond_item,conds);
                ListView listaCond = (ListView) findViewById(R.id.listConds);
                listaCond.setAdapter(condAdapter);
            }
        }
    }

}
