package com.example.admin.agenda2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by admin on 27/11/2017.
 */

public class BaseDatos {

    static SQLiteOpenHelper sq;

     public static SQLiteDatabase start(Context c){
         sq = new SQLiteOpenHelper(c,"agendaContactos",null,1) {
             @Override
             public void onCreate(SQLiteDatabase sqLiteDatabase) {
                 String tabla_contactos="CREATE TABLE `Contactos` (\n" +
                         "`nombre` TEXT,\n" +
                         "`telefono` TEXT\n" +
                         ");";
                 sqLiteDatabase.execSQL(tabla_contactos);
             }

             @Override
             public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

             }
         };
         SQLiteDatabase bbdd = sq.getWritableDatabase();
         return bbdd;
     }

     public static void insertarContacto(Contacto c,Context context){
        String nombre = c.getNombre();
        String telefono = c.getTelefono();
        String insertar = "Insert into Contactos (nombre,telefono) values ('"+nombre+"','"+telefono+"');";

        SQLiteDatabase bbdd = start(context);
        bbdd.execSQL(insertar);
     }

     public static ArrayList<Contacto> mostrarTodosContactos(String busqueda, Context context){
        ArrayList <Contacto> listaContactos = new ArrayList<>();
        String todo = "select nombre,telefono from Contactos";

        SQLiteDatabase bbdd=start(context);
        Cursor cursor = bbdd.rawQuery(todo,null);

        while(cursor.moveToNext()){
            String n = cursor.getString(0);
            String t = cursor.getString(1);
            Contacto contacto = new Contacto(n,t);
            listaContactos.add(contacto);
        }
        return listaContactos;
    }
    public static ArrayList<Contacto> buscarContacto(String busqueda,Context context){
        ArrayList <Contacto> listaContactos = new ArrayList<>();
        String selectNombre = "select nombre,telefono from Contactos where nombre LIKE ?";

        SQLiteDatabase bbdd=start(context);
        String[] datos = {"%"+busqueda+"%"};
        Cursor cursor = bbdd.rawQuery(selectNombre,datos);

        while(cursor.moveToNext()){
            String n = cursor.getString(0);
            String t = cursor.getString(1);
            Contacto contacto = new Contacto(n,t);
            listaContactos.add(contacto);
        }
        return listaContactos;
    }
}
