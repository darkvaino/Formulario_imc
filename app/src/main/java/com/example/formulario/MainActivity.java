package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // creando variables
        private EditText txtnombre;
        private EditText txtapellido;
        private EditText txtcorreo;
        private Button btnaceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enlazando la parte visual con la parte logica
        setContentView(R.layout.activity_main);
        txtnombre = findViewById(R.id.txtnombre);
        txtapellido = findViewById(R.id.txtapellido);
        txtcorreo = findViewById(R.id.txtcorreo);
        btnaceptar = findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(this);//implemente este elemento aca =(this)
    }

    @Override
    public void onClick(View v) {
        //si la vista dodne se activo el clic cualquier clic ques e acciones llega a este metodo
        //v.getId() es el ellemnto que entra por parametro y se captura con el get
        if(v.getId() == R.id.btnaceptar)
        {
            //se crear variables para capturara los datos
            // a esta variable nombre  agreguele este elemento
            String nombre = txtnombre.getText().toString();// se captura  el nombre  y se convierte el dato a string
            String apellido = txtapellido.getText().toString();
            String correo = txtcorreo.getText().toString();

            //validar los elemento creados ahi arriba
                //si nombre esta vacio (isEmpty)
            if (nombre.isEmpty())
            {
                CustomToastView.makeErrorToast(this,"Error al validar el nombre",R.layout.custom_toast).show();
                return;
            }//fin del if
            if (apellido.isEmpty())
            {
                CustomToastView.makeInfoToast(this,"Error al validar el apellido",R.layout.custom_toast).show();
                return;
            }
            if(!validarcorreo(correo))
            {
                CustomToastView.makeWarningToast(this,"Error al validar el Correo",R.layout.custom_toast).show();
                return;
            }

            /*moverse de una activity a otro*/
            /*crear una intencion del   punto a(this)este elemento  a  punto b*/
            Intent miintent = new Intent(this,imc.class);
            /*mandar datos de una actividad a otra*/
            miintent.putExtra("nombreFormulario",nombre);
            miintent.putExtra("apellidoFormulario",apellido);
            miintent.putExtra("correoFormulario",correo);
            startActivity(miintent);

        }//fin del primer if



    }//fin onclick

    //crear metodo isvalisEmail
    private Boolean validarcorreo(String correo)
    {
        //validar un correo
        //crearmos un patter= expresion regulares
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        //cxrear el returno de e este elemento
        return pattern.matcher(correo).matches(); // aca dira si el correoe s valido o es invalido

    }

}