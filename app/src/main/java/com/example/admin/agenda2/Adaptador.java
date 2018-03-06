package com.example.admin.agenda2;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by admin on 27/11/2017.
 */

public class Adaptador implements ListAdapter {

    ArrayList<Contacto> listaContactos;
    Context context;

    public Adaptador(ArrayList<Contacto> listaContactos, Context context) {
        this.listaContactos = listaContactos;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return listaContactos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaContactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);

        //Relaccionas la vista dnd se introduce la informacion del contacto (la que despues se mete a la lista)
        View vista = inflater.inflate(R.layout.vista_contacto,viewGroup,false);
        TextView nbusqueda = (TextView)vista.findViewById(R.id.id_nombre);
        TextView nTelefono = (TextView)vista.findViewById(R.id.id_telefono);
        nbusqueda.setText(listaContactos.get(i).getNombre());
        nTelefono.setText(listaContactos.get(i).getTelefono());
        return vista;
    }

    @Override
    public int getItemViewType(int i) {
        return listaContactos.size();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return listaContactos.isEmpty();
    }
}
