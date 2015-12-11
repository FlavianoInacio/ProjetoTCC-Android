package com.example.flaviano.cadastroeconsultatcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nome,cpf,funcao,login,senha,qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        nome = (EditText)findViewById(R.id.editText);
        cpf = (EditText)findViewById(R.id.editText2);
        funcao = (EditText)findViewById(R.id.editText3);
        login = (EditText)findViewById(R.id.editText4);
        senha = (EditText)findViewById(R.id.editText5);
        qtd = (EditText)findViewById(R.id.editText6);
        ;


//Código do programa...

    }
    public void salvarUsuario(View view)
    {

        int qtds = Integer.parseInt(qtd.getText().toString());
        long tempoInicio = System.currentTimeMillis();
        Bancodedados bd = new Bancodedados(this);
        for (int i=0; i<qtds;i++){
            bd.insertUsuario(nome.getText().toString(),cpf.getText().toString(),funcao.getText().toString(),login.getText().toString(),senha.getText().toString());
        }

        System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
