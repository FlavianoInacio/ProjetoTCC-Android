package com.example.flaviano.cadastroeconsultatcc;

/**
 * Created by FLAVIO on 16/11/2015.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Bancodedados {
    private static final String DATABASE_NAME = "banco.db";
    private static final int DATABASE_VERSION = 9;
    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStmt;
    //private SQLiteStatement updateStmt;
    //private SQLiteStatement deleteStmt;

    private static final String INSERTUSER = "insert into users (nome,cpf,funcao,login,senha) values (?,?,?,?,?)";

    //private static final String UPDATESTATUSMSG = "update mensagem set status = ? where idMensagem = ?";
    //private static final String DELETEDMSG = "delete from mensagem where id = ?";

    public Bancodedados(Context context) {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);

        this.db = openHelper.getWritableDatabase();

    }

    public long insertUsuario(String nome,String cpf,String funcao,String login,String senha) {
        this.insertStmt = this.db.compileStatement(INSERTUSER);
        this.insertStmt.bindString(1, nome);
        this.insertStmt.bindString(2, cpf);
        this.insertStmt.bindString(3, funcao);
        this.insertStmt.bindString(4, login);
        this.insertStmt.bindString(5, senha);
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //Date date = new Date();
        return this.insertStmt.executeInsert();
    }

  public List<Usuario> buscarLembretes() {
        List listaLembretes = new ArrayList<Usuario>();
        Cursor cursor = this.db.query("users", new String[]{"id","nome","cpf","funcao","login","senha"}, null, null, "id", null, "id asc");

        if (cursor.moveToFirst()) {
            do {
                Usuario le = new Usuario();
                //user.setIdUser(cursor.getInt(cursor.getColumnIndex("idUser")));
                le.setId(cursor.getInt(cursor.getColumnIndex("id")));
                le.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
                le.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                le.setFuncao(cursor.getString(cursor.getColumnIndex("funcao")));
                le.setLogin(cursor.getString(cursor.getColumnIndex("login")));
                le.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
                listaLembretes.add(le);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return listaLembretes;
    }




    private static class OpenHelper extends SQLiteOpenHelper {
        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(" CREATE TABLE users( "
                        + "id INTEGER PRIMARY KEY autoincrement, "
                        + "nome TEXT,"
                        + "cpf TEXT, "
                        + "funcao TEXT, "
                        + "login TEXT, "
                        + "senha TEXT )");

            }catch(Exception e)
            {
                e.getMessage();
            }

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Example", "Upgrading database, this will drop tables and recreate.");
            db.execSQL("DROP TABLE users");
            onCreate(db);
        }
    }
}
