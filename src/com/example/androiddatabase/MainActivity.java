package com.example.androiddatabase;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Editado por William Leonardo Dueñas Mora - 20131049490

public class MainActivity extends Activity {

    private EditText et1, et2, et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.activity_main, menu);
        return true;
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = et1.getText().toString();
        String nombre = et2.getText().toString();
        String descripcion = et3.getText().toString();
        String unidades = et4.getText().toString();
        String valor = et5.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("codigo", dni);
        registro.put("nombre", nombre);
        registro.put("descripcion", colegio);
        registro.put("unidades", nromesa);
        registro.put("valor", nromesa);

        bd.insert("votantes", null, registro);
        bd.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");

        Toast.makeText(this, "Se registraron los daros del Producto",
                Toast.LENGTH_SHORT).show();
    }

    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = et1.getText().toString();

        Cursor fila = bd.rawQuery(
                "select nombre,descripcion,unidades  from productos where codigo=" + codigo, null);

        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe un producto con dicho codigo",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String dni = et1.getText().toString();

        int cant = bd.delete("productos", "codigo=" + codigo, null);
        bd.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");

        if (cant == 1)
            Toast.makeText(this, "Se borr� el producto con dicho codigo",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el porducto con dicho codigo",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = et1.getText().toString();
        String nombre = et2.getText().toString();
        String descripcion = et3.getText().toString();
        String unidades = et4.getText().toString();
        String valor = et5.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombre);
        registro.put("descripcion", descripcion);
        registro.put("unidades", unidades);

        int cant = bd.update("productos", registro, "codigo=" + codigo, null);
        bd.close();

        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe el porducto con dicho codigo",
                    Toast.LENGTH_SHORT).show();
    }

}