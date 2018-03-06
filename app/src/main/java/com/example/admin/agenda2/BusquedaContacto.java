package com.example.admin.agenda2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BusquedaContacto extends Fragment{
    EditText buscarContacto;
    Button btnBuscar;
    ListView listadoC;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public BusquedaContacto() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BusquedaContacto newInstance(String param1, String param2) {
        BusquedaContacto fragment = new BusquedaContacto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listadoC = (ListView) getView().findViewById(R.id.id_lista_contactos);
        buscarContacto = (EditText) getView().findViewById(R.id.id_busqueda);
        btnBuscar = (Button) getView().findViewById(R.id.id_btn_buscar);

        ArrayList<Contacto> listaContactos = BaseDatos.mostrarTodosContactos(buscarContacto.getText().toString(),getContext());
        ListAdapter adaptador = new Adaptador(listaContactos,getContext());
        listadoC.setAdapter(adaptador);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Contacto> listaContactos = BaseDatos.buscarContacto(buscarContacto.getText().toString(),getContext());
                ListAdapter adaptador = new Adaptador(listaContactos,getContext());
                listadoC.setAdapter(adaptador);
            }
        });

        buscarContacto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Contacto> listaContactos = BaseDatos.buscarContacto(buscarContacto.getText().toString(),getContext());
                ListAdapter adaptador = new Adaptador(listaContactos,getContext());
                listadoC.setAdapter(adaptador);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_busqueda_contacto, container, false);
    }



}
