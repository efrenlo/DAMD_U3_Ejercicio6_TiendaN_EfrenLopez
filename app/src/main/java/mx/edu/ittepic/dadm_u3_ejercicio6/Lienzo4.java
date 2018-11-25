package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo4 extends View {
    Articulo3 ico1,ico2,ico3,ico4,puntero,logo,fondo,pcami1,pcami2,pcami3,pcami4,compra1,compra2,compra3
            ,compra4,banerh;
    public Lienzo4(Context context) {
        super(context);

        fondo = new Articulo3(R.drawable.nik,0,0,this);
        logo = new Articulo3(R.drawable.logo,50,35,this);
        banerh = new Articulo3(R.drawable.banerho, 0, 450, this);
        ///////////////////////////////////////////////////////////////////camisas

        ico1 = new Articulo3(R.drawable.camisa,20,450,this);
        ico2 = new Articulo3(R.drawable.camisa2,20,850,this);
        ico3 = new Articulo3(R.drawable.camisa3,20,1250,this);
        ico4 = new Articulo3(R.drawable.camisa4,20,1650,this);

        pcami1 = new Articulo3(R.drawable.camisa,600,400,this);
        pcami2 = new Articulo3(R.drawable.camisa2,600,400,this);
        pcami3 = new Articulo3(R.drawable.camisa3,600,400,this);
        pcami4 = new Articulo3(R.drawable.camisa4,600,400,this);

        compra1 = new Articulo3(R.drawable.comprazapato1, 500, 850, this);
        compra2 = new Articulo3(R.drawable.comprazapato2, 500, 850, this);
        compra3 = new Articulo3(R.drawable.comprazapato3, 500, 850, this);
        compra4 = new Articulo3(R.drawable.comprazapato4, 500, 850, this);

        puntero=null;


        pcami1.hacerVisible(false);
        pcami2.hacerVisible(false);
        pcami3.hacerVisible(false);
        pcami4.hacerVisible(false);

        compra1.hacerVisible(false);
        compra2.hacerVisible(false);
        compra3.hacerVisible(false);
        compra4.hacerVisible(false);
    }
    public void onDraw(Canvas c){
        super.onDraw(c);

        Paint p = new Paint();

        p.setTextSize(100);
        p.setColor(Color.RED);
        fondo.pintar(c,p);
        logo.pintar(c,p);

        banerh.pintar(c,p);

        ///////////////////////////

        ico1.pintar(c,p);
        ico2.pintar(c,p);
        ico3.pintar(c,p);
        ico4.pintar(c,p);

        pcami1.pintar(c,p);
        pcami2.pintar(c,p);
        pcami3.pintar(c,p);
        pcami4.pintar(c,p);

        compra1.pintar(c,p);
        compra2.pintar(c,p);
        compra3.pintar(c,p);
        compra4.pintar(c,p);




        //icono2.pintar(c,p);
        //icono3.pintar(c,p);
        //icono4.pintar(c,p);

    }


    public boolean onTouchEvent(MotionEvent e){
        float xp= e.getX();
        float yp=e.getY();
        //mensaje="no se ha tocado onjeto";

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:



                ///////////////////////////////////////////////////////camisas
                if(ico1.estaEnArea(xp,yp)){
                    //valor =1;
                    puntero=ico1;
                    pcami1.hacerVisible(true);
                    pcami2.hacerVisible(false);
                    pcami3.hacerVisible(false);
                    pcami4.hacerVisible(false);

                    compra1.hacerVisible(true);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);


                }
                if(ico2.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ico2;
                    pcami1.hacerVisible(false);
                    pcami2.hacerVisible(true);
                    pcami3.hacerVisible(false);
                    pcami4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(true);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);


                }
                if(ico3.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ico3;
                    pcami1.hacerVisible(false);
                    pcami2.hacerVisible(false);
                    pcami3.hacerVisible(true);
                    pcami4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(true);
                    compra4.hacerVisible(false);


                }
                if(ico4.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ico4;
                    pcami1.hacerVisible(false);
                    pcami2.hacerVisible(false);
                    pcami3.hacerVisible(false);
                    pcami4.hacerVisible(true);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(true);


                }


                break;

            case MotionEvent.ACTION_MOVE:



                /////////////////////////////////////camisas
                if (puntero==ico1){
                    ico1.mover(yp);
                    ico2.mover(yp+400);
                    ico3.mover(yp+800);
                    ico4.mover(yp+1200);
                }
                if (puntero==ico2){
                    ico2.mover(yp);
                    ico1.mover(yp-400);
                    ico3.mover(yp+400);
                    ico4.mover(yp+800);
                }
                if (puntero==ico3){
                    ico3.mover(yp);
                    ico1.mover(yp-800);
                    ico2.mover(yp-400);
                    ico4.mover(yp+400);
                }
                if (puntero==ico4){
                    ico4.mover(yp);
                    ico1.mover(yp-1200);
                    ico2.mover(yp-800);
                    ico3.mover(yp-400);
                }

                //////////////////////////////////////////

                break;

            case MotionEvent.ACTION_UP:
                puntero=null;//para que se desactive la seleccion anterior
                break;
        }
        invalidate();
        return true;
    }
}
