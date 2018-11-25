package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Articulo2 icon1,icon2,icon3,icon4,ptaque,ptaque2,ptaque3,ptaque4,fondo,logo,puntero,compra1,compra2,compra3
            ,compra4,banerh;

    public Lienzo3(Context context) {
        super(context);
        fondo = new Articulo2(R.drawable.nik,0,0,this);
        logo = new Articulo2(R.drawable.logo,50,35,this);
        banerh = new Articulo2(R.drawable.banerho, 0, 450, this);
        ////////////////////////////////////////taquetes
        icon1 = new Articulo2(R.drawable.taque,10,450,this);
        icon2 = new Articulo2(R.drawable.taquete2,10,950,this);
        icon3 = new Articulo2(R.drawable.taque3,10,1350,this);
        icon4 = new Articulo2(R.drawable.taquete4,10,1750,this);

        ptaque = new Articulo2(R.drawable.taque,600,400,this);
        ptaque2 = new Articulo2(R.drawable.taquete2,600,400,this);
        ptaque3 = new Articulo2(R.drawable.taque3,600,400,this);
        ptaque4 = new Articulo2(R.drawable.taquete4,600,400,this);

        compra1 = new Articulo2(R.drawable.comprazapato1, 500, 850, this);
        compra2 = new Articulo2(R.drawable.comprazapato2, 500, 850, this);
        compra3 = new Articulo2(R.drawable.comprazapato3, 500, 850, this);
        compra4 = new Articulo2(R.drawable.comprazapato4, 500, 850, this);

        puntero=null;
        ptaque.hacerVisible(false);
        ptaque2.hacerVisible(false);
        ptaque3.hacerVisible(false);
        ptaque4.hacerVisible(false);

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


        icon1.pintar(c,p);
        icon2.pintar(c,p);
        icon3.pintar(c,p);
        icon4.pintar(c,p);

        ptaque.pintar(c,p);
        ptaque2.pintar(c,p);
        ptaque3.pintar(c,p);
        ptaque4.pintar(c,p);

        compra1.pintar(c,p);
        compra2.pintar(c,p);
        compra3.pintar(c,p);
        compra4.pintar(c,p);


    }

    //icono2.pintar(c,p);
    //icono3.pintar(c,p);
    //icono4.pintar(c,p);


    public boolean onTouchEvent(MotionEvent e){
        float xp= e.getX();
        float yp=e.getY();
        //mensaje="no se ha tocado onjeto";

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:



                //////////////////////////////////////////////////////// taquetes
                if(icon1.estaEnArea(xp,yp)){
                    //valor =1;
                    puntero=icon1;
                    ptaque.hacerVisible(true);
                    ptaque2.hacerVisible(false);
                    ptaque3.hacerVisible(false);
                    ptaque4.hacerVisible(false);

                    compra1.hacerVisible(true);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);

                }
                if(icon2.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=icon2;
                    ptaque.hacerVisible(false);
                    ptaque2.hacerVisible(true);
                    ptaque3.hacerVisible(false);
                    ptaque4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(true);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);

                }
                if(icon3.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=icon3;
                    ptaque.hacerVisible(false);
                    ptaque2.hacerVisible(false);
                    ptaque3.hacerVisible(true);
                    ptaque4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(true);
                    compra4.hacerVisible(false);

                }
                if(icon4.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=icon4;
                    ptaque.hacerVisible(false);
                    ptaque2.hacerVisible(false);
                    ptaque3.hacerVisible(false);
                    ptaque4.hacerVisible(true);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(true);
                }

                break;

            case MotionEvent.ACTION_MOVE:

                ///////////////////////////////////////////taquetes
                if (puntero==icon1){
                    icon1.mover(yp);
                    icon2.mover(yp+400);
                    icon3.mover(yp+800);
                    icon4.mover(yp+1200);
                }
                if (puntero==icon2){
                    icon2.mover(yp);
                    icon1.mover(yp-400);
                    icon3.mover(yp+400);
                    icon4.mover(yp+800);
                }
                if (puntero==icon3){
                    icon3.mover(yp);
                    icon1.mover(yp-800);
                    icon2.mover(yp-400);
                    icon4.mover(yp+400);
                }
                if (puntero==icon4){
                    icon4.mover(yp);
                    icon1.mover(yp-1200);
                    icon2.mover(yp-800);
                    icon3.mover(yp-400);
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
