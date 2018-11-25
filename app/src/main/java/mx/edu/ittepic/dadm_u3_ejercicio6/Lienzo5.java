package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo5 extends View {
    Articulo4 ic1,ic2,ic3,ic4,pshor1,pshor2,pshor3,pshor4,fondo,puntero,logo,compra1,compra2,compra3
            ,compra4,banerh;
    public Lienzo5(Context context) {
        super(context);
        fondo = new Articulo4(R.drawable.nik,0,0,this);
        logo = new Articulo4(R.drawable.logo,50,35,this);
        banerh = new Articulo4(R.drawable.banerho, 0, 450, this);

        //////////////////////////////////////////////////// short
        ic1 = new Articulo4(R.drawable.iconos,10,450,this);
        ic2 = new Articulo4(R.drawable.iconos2,10,950,this);
        ic3 = new Articulo4(R.drawable.iconos3,10,1350,this);
        ic4 = new Articulo4(R.drawable.iconos4,10,1750,this);

        pshor1 = new Articulo4(R.drawable.iconos,600,400,this);
        pshor2 = new Articulo4(R.drawable.iconos2,600,400,this);
        pshor3 = new Articulo4(R.drawable.iconos3,600,400,this);
        pshor4 = new Articulo4(R.drawable.iconos4,600,400,this);

        compra1 = new Articulo4(R.drawable.comprashor1, 500, 850, this);
        compra2 = new Articulo4(R.drawable.comprashor2, 500, 850, this);
        compra3 = new Articulo4(R.drawable.comprashor3, 500, 850, this);
        compra4 = new Articulo4(R.drawable.comprashor4, 500, 850, this);

        puntero=null;

        pshor1.hacerVisible(false);
        pshor2.hacerVisible(false);
        pshor3.hacerVisible(false);
        pshor4.hacerVisible(false);

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



        ic1.pintar(c,p);
        ic2.pintar(c,p);
        ic3.pintar(c,p);
        ic4.pintar(c,p);

        pshor1.pintar(c,p);
        pshor2.pintar(c,p);
        pshor3.pintar(c,p);
        pshor4.pintar(c,p);

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

                ///////////////////////////////////////////////////////Short
                if(ic1.estaEnArea(xp,yp)){
                    //valor =1;
                    puntero=ic1;
                    pshor1.hacerVisible(true);
                    pshor2.hacerVisible(false);
                    pshor3.hacerVisible(false);
                    pshor4.hacerVisible(false);

                    compra1.hacerVisible(true);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);
                }
                if(ic2.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ic2;
                    pshor1.hacerVisible(false);
                    pshor2.hacerVisible(true);
                    pshor3.hacerVisible(false);
                    pshor4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(true);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(false);
                }
                if(ic3.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ic3;
                    pshor1.hacerVisible(false);
                    pshor2.hacerVisible(false);
                    pshor3.hacerVisible(true);
                    pshor4.hacerVisible(false);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(true);
                    compra4.hacerVisible(false);
                }
                if(ic4.estaEnArea(xp,yp)){
                    //valor=2;
                    puntero=ic4;
                    pshor1.hacerVisible(false);
                    pshor2.hacerVisible(false);
                    pshor3.hacerVisible(false);
                    pshor4.hacerVisible(true);

                    compra1.hacerVisible(false);
                    compra2.hacerVisible(false);
                    compra3.hacerVisible(false);
                    compra4.hacerVisible(true);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                ////////////////////////////////////////////Short
                if (puntero==ic1){
                    ic1.mover(yp);
                    ic2.mover(yp+400);
                    ic3.mover(yp+800);
                    ic4.mover(yp+1200);
                }
                if (puntero==ic2){
                    ic2.mover(yp);
                    ic1.mover(yp-400);
                    ic3.mover(yp+400);
                    ic4.mover(yp+800);
                }
                if (puntero==ic3){
                    ic3.mover(yp);
                    ic1.mover(yp-800);
                    ic2.mover(yp-400);
                    ic4.mover(yp+400);
                }
                if (puntero==ic4){
                    ic4.mover(yp);
                    ic1.mover(yp-1200);
                    ic2.mover(yp-800);
                    ic3.mover(yp-400);
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
