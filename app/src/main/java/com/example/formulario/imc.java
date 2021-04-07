package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class imc extends AppCompatActivity implements View.OnClickListener {

     private TextView TvInformacion;
     private EditText txtPeso;
     private EditText txtAltura;
     private Button btnCalcular;
     private ImageView ImEstatus;
     private TextView TvResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        /*se instacia un iten*/
        Intent intent = getIntent(); /*obteniedo el inten que llego*/
        String nombre = intent.getStringExtra("nombreFormulario");
        String apellido = intent.getStringExtra("apellidoFormulario");
        String correo = intent.getStringExtra("correoFormulario");

        String mensaje = "hola" + nombre + " "+ apellido + "es un gusto tenerlo aqui su informe es:"+ correo;
        TvInformacion = findViewById(R.id.TvInformacion);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        ImEstatus = findViewById(R.id.ImEstatus);
        TvResultado = findViewById(R.id.TvResultado);

        /* se muestra el mensaje con los datos en el text view*/
         TvInformacion.setText(mensaje);

        btnCalcular.setOnClickListener(this);
        /*se implementa el metodo click al boton*/

    }

    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.btnCalcular)
        {

            Double peso = Double.parseDouble(txtPeso.getText().toString());
            Double Altura = Double.parseDouble(txtAltura.getText().toString());
            Double IMC = peso/(Altura*Altura);
            String mensaje = "Bajo peso";
            String mensaje1 = "Normal";
            String mensaje2 = "Sobre peso";
            String mensaje3 = "Obesidad";

            if(IMC <= 18.5)
            {
                /*se muestra el resultado del imc en el text view resultado*/
                TvResultado.setText("El IMC"+ " :"+redondear(IMC)+" : "+mensaje);
                ImEstatus.setImageResource(R.drawable.bajo_peso);


            }
             if (IMC >= 18.5 && IMC <= 24.9)
            {
                /*se muestra el resultado del imc en el text view resultado*/
                TvResultado.setText("El IMC"+ " :"+redondear(IMC)+" : "+mensaje1);
                ImEstatus.setImageResource(R.drawable.normal);


            }
            if (IMC >= 25.0 && IMC <= 29.9)
            {
                /*se muestra el resultado del imc en el text view resultado*/
                TvResultado.setText("El IMC"+ " :"+redondear(IMC)+" : "+mensaje2);
                ImEstatus.setImageResource(R.drawable.sobre_peso);


            }
             if (IMC >= 30.0)
            {
                /*se muestra el resultado del imc en el text view resultado*/
                TvResultado.setText("El IMC"+ " :"+redondear(IMC)+" : "+mensaje3);
                ImEstatus.setImageResource(R.drawable.obeso);

            }


        }// fin del if


    }
    public Double redondear(Double numero)
    {
        Double res;
        int valor =0;
        valor = (int)(numero*100);
        res = (double)valor/100;
        return res;
    }
}