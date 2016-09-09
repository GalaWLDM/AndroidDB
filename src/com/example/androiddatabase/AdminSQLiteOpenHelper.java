package com.example.androiddatabase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//Editado por William Leonardo Dueñas Mora - 20131049490

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table votantes(dni integer primary key, nombre text, colegio text, nromesa integer)");
        db.execSQL("create table productos(codigo integer primary key, nombre text, descripcion text, unidades integer, valor integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists productos");
        db.execSQL("create table productos(codigo integer primary key, nombre text, descripcion text, unidades integer, valor integer)");
    }    
}