package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Articulo icono1, icono2, icono3, icono4, prueba, produ2, produ3, produ4, logo, fondo, puntero, banerh, compra1,compra2,compra3
            ,compra4;
    Main2Activity punte;


    public Lienzo2(Context context) {
        super(context);

        ////////////////////////////sudaderas
        icono1 = new Articulo(R.drawable.chama, 10, 450, this);
        icono2 = new Articulo(R.drawable.chama2, 2, 850, this);
        icono3 = new Articulo(R.drawable.chama3, 2, 1250, this);
        icono4 = new Articulo(R.drawable.chama4, 2, 1650, this);
        fondo = new Articulo(R.drawable.nik, 0, 0, this);
        logo = new Articulo(R.drawable.logo, 380, 25, this);
        banerh = new Articulo(R.drawable.banerho, 0, 450, this);


        prueba = new Articulo(R.drawable.chama, 600, 400, this);
        produ2 = new Articulo(R.drawable.chama2, 600, 400, this);
        produ3 = new Articulo(R.drawable.chama3, 600, 400, this);
        produ4 = new Articulo(R.drawable.chama4, 600, 400, this);

        compra1 = new Articulo(R.drawable.compra1, 500, 850, this);
        compra2 = new Articulo(R.drawable.comprasueter2, 500, 850, this);
        compra3 = new Articulo(R.drawable.comprasueter3, 500, 850, this);
        compra4 = new Articulo(R.drawable.comprasueter4, 500, 850, this);



        /////////////////////////////////////////////////////////

        punte = (Main2Activity) context;
        puntero = null;

        prueba.hacerVisible(false);
        produ2.hacerVisible(false);
        produ3.hacerVisible(false);
        produ4.hacerVisible(false);

        compra1.hacerVisible(false);
        compra2.hacerVisible(false);
        compra3.hacerVisible(false);
        compra4.hacerVisible(false);

        //final int  posicion = punte.getIntent().getExtras().getInt("pos");
        //val=posicion;
    }


    public void onDraw(Canvas c) {
        super.onDraw(c);

        Paint p = new Paint();

        p.setTextSize(100);
        p.setColor(Color.RED);
        fondo.pintar(c, p);
        logo.pintar(c, p);

        banerh.pintar(c,p);

        icono1.pintar(c, p);
        icono2.pintar(c, p);
        icono3.pintar(c, p);
        icono4.pintar(c, p);

        prueba.pintar(c, p);
        produ2.pintar(c, p);
        produ3.pintar(c, p);
        produ4.pintar(c, p);

        compra1.pintar(c,p);
        compra2.pintar(c,p);
        compra3.pintar(c,p);
        compra4.pintar(c,p);
        ///////////////////////////


        //icono2.pintar(c,p);
        //icono3.pintar(c,p);
        //icono4.pintar(c,p);

    }


    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        //mensaje="no se ha tocado onjeto";

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if (icono1.estaEnArea(xp, yp)) {
                    //valor =1;
                    puntero = icono1;
                    prueba.hacerVisible(true);
                    produ2.hacerVisible(false);
                    produ3.hacerVisible(false);
                    produ4.hacerVisible(false);

                    compra1.hacerVisible(true);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);

                } else if (icono2.estaEnArea(xp, yp)) {
                    //valor=2;
                    puntero = icono2;
                    prueba.hacerVisible(false);
                    produ2.hacerVisible(true);
                    produ3.hacerVisible(false);
                    produ4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(true);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);

                } else if (icono3.estaEnArea(xp, yp)) {
                    //valor=2;
                    puntero = icono3;
                    produ2.hacerVisible(false);
                    produ3.hacerVisible(true);
                    produ4.hacerVisible(false);
                    prueba.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(true);
                    compra4.hacerVisible(false);

                } else if (icono4.estaEnArea(xp, yp)) {
                    //valor=2;
                    puntero = icono4;
                    produ2.hacerVisible(false);
                    produ3.hacerVisible(false);
                    prueba.hacerVisible(false);
                    produ4.hacerVisible(true);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(true);

                }


                break;

            case MotionEvent.ACTION_MOVE:

                //////////////////////////////////////////sudadaderas
                if (puntero == icono1) {
                    icono1.mover(yp);
                    icono2.mover(yp + 400);
                    icono3.mover(yp + 800);
                    icono4.mover(yp + 1200);
                }
                if (puntero == icono2) {
                    icono2.mover(yp);
                    icono1.mover(yp - 400);
                    icono3.mover(yp + 400);
                    icono4.mover(yp + 800);
                }
                if (puntero == icono3) {
                    icono3.mover(yp);
                    icono1.mover(yp - 800);
                    icono2.mover(yp - 400);
                    icono4.mover(yp + 400);
                }
                if (puntero == icono4) {
                    icono4.mover(yp);
                    icono1.mover(yp - 1200);
                    icono2.mover(yp - 800);
                    icono3.mover(yp - 400);
                }


                //////////////////////////////////////////

                break;

            case MotionEvent.ACTION_UP:
                puntero = null;//para que se desactive la seleccion anterior
                break;
        }
        invalidate();
        return true;
    }

}
