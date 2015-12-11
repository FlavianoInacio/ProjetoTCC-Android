package com.example.flaviano.cadastroeconsultatcc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        long tempoInicio = System.currentTimeMillis();
        Bancodedados banco = new Bancodedados(this);
        List<Usuario> le = banco.buscarLembretes();

        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,le);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
