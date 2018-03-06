package com.example.admin.agenda2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NuevoContacto extends Fragment {
    EditText nuevoNombre,nuevoTelefono;
    Button btnguardar;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    public NuevoContacto() {
        // Required empty public constructor
    }

    public static NuevoContacto newInstance(String param1, String param2) {
        NuevoContacto fragment = new NuevoContacto();
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

        nuevoNombre = (EditText)getView().findViewById(R.id.id_nombreNuevo);
        nuevoTelefono = (EditText)getView().findViewById(R.id.id_telefonoNuevo);
        btnguardar = (Button)getView().findViewById(R.id.id_btn_guardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nuevoNombre.getText().toString();
                String t = nuevoTelefono.getText().toString();
                Contacto c = new Contacto(n,t);
                BaseDatos.insertarContacto(c,getContext());
                Toast.makeText(getActivity().getApplicationContext(),"Contacto añadido",Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo_contacto, container, false);
    }

}
