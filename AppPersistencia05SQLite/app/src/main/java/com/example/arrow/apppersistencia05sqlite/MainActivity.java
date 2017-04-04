package com.example.arrow.apppersistencia05sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNota;
    private ListView listViewNota;
    private Cursor cursor;
    private NotaDBHelper notasDBHelper;
    private SimpleCursorAdapter simpleCursorAdapterNotas;

    private Cursor cargarCursor() {
        SQLiteDatabase db = notasDBHelper.getReadableDatabase();
        Cursor cursor;

        String[] projection = {
                NotaContract.NotaEntry._ID,
                NotaContract.NotaEntry.TEXTO,
        };

        String sortOrder = NotaContract.NotaEntry._ID + " ASC";

        cursor = db.query(
                NotaContract.NotaEntry.TABLA,   // TABLA
                projection,                    // CAMPOS
                null,                         //WHERE
                null,                        // Argumentos Where
                null,                       // Group By
                null,                      // Having
                sortOrder                // ORDER
        );
        return cursor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNota = (EditText) findViewById(R.id.edit_text_nota);
        listViewNota = (ListView) findViewById(R.id.list_view_notas);

        notasDBHelper = new NotaDBHelper(this);


        cursor = cargarCursor();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            simpleCursorAdapterNotas = new SimpleCursorAdapter(
                    this,
                    android.R.layout.two_line_list_item,
                    cursor,
                    new String[]{NotaContract.NotaEntry.TEXTO, NotaContract.NotaEntry._ID},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
            );
        } else {
            simpleCursorAdapterNotas = new SimpleCursorAdapter(
                    this,
                    android.R.layout.two_line_list_item,
                    cursor,
                    new String[]{NotaContract.NotaEntry.TEXTO, NotaContract.NotaEntry._ID},
                    new int[]{android.R.id.text1, android.R.id.text2}
            );
        }


        listViewNota.setAdapter(simpleCursorAdapterNotas);

        listViewNota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteDatabase db = notasDBHelper.getWritableDatabase();
                Cursor cursorNotas = (Cursor) parent.getItemAtPosition(position);
                String texto = cursorNotas.getString(cursorNotas.getColumnIndex(NotaContract.NotaEntry.TEXTO));
                ContentValues values = new ContentValues();
                if (Character.isUpperCase(texto.charAt((0)))){
                    values.put(NotaContract.NotaEntry.TEXTO,texto.toLowerCase());
                }else{
                    values.put(NotaContract.NotaEntry.TEXTO,texto.toUpperCase());
                }

                String selection = NotaContract.NotaEntry._ID + " = ?";
                String[] selectionArgs = {Long.toString(id)};
                int count = db.update(NotaContract.NotaEntry.TABLA, values,selection, selectionArgs);

                simpleCursorAdapterNotas.changeCursor(cargarCursor());
            }
        });

        listViewNota.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteDatabase db = notasDBHelper.getWritableDatabase();

                String selection = NotaContract.NotaEntry._ID + " = ?";
                String[] selectionArgs = {Long.toString(id)};
                int count = db.delete(NotaContract.NotaEntry.TABLA, selection, selectionArgs);

                simpleCursorAdapterNotas.changeCursor(cargarCursor());

                return false;
            }
        });

        findViewById(R.id.button_guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = notasDBHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(NotaContract.NotaEntry.TEXTO, editTextNota.getText().toString());
                long newRowId = db.insert(NotaContract.NotaEntry.TABLA, null, values);

                simpleCursorAdapterNotas.changeCursor(cargarCursor());

                editTextNota.setText("");
            }
        });

    }
}
