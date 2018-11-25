package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {


    boolean dato=true;
    int dat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo2(this));

        //final int  posicion = getIntent().getExtras().getInt("pos");

        //dat=posicion;

    }


    /*public int cambi0(){

        if(dat==1){
            return 1;
        }

        return 2;

    }*/


}
