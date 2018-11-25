package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Categoria icono1,icono2,icono3,next,shor,nike,banner,logo,descri1,descri2,descri3,descri4,puntero;
    String mensaje;
    int valor=0,enviar=0;
    MainActivity puntero2;

    public Lienzo(Context context) {
        super(context);
        mensaje = "";
        icono1 = new Categoria(R.drawable.chama,80,600,this);
        icono2 = new Categoria(R.drawable.taque,450,600,this);
        icono3 = new Categoria(R.drawable.camisa,780,600,this);
        shor = new Categoria(R.drawable.iconos,1080,600,this);


        next = new Categoria(R.drawable.next,700,1400,this);
        descri1 = new Categoria(R.drawable.descri1,100,1400,this);
        descri2 = new Categoria(R.drawable.descri2,100,1400,this);
        descri3 = new Categoria(R.drawable.descri3,100,1400,this);
        descri4 = new Categoria(R.drawable.descri4,100,1400,this);
        nike = new Categoria(R.drawable.nike,0,0,this);
        logo = new Categoria(R.drawable.logo,450,45,this);
        banner = new Categoria(R.drawable.baner,0,600,this);
        //icono4 = new Categoria(R.drawable.negra,1200,600,this);
        puntero = null;
        puntero2 = (MainActivity) context;
        descri1.hacerVisible(false);
        descri2.hacerVisible(false);
        descri3.hacerVisible(false);
        descri4.hacerVisible(false);
    }


    public void onDraw(Canvas c){

        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(40);
        p.setColor(Color.RED);




        nike.pintar(c,p);
        logo.pintar(c,p);
        banner.pintar(c,p);
        icono1.pintar(c,p);
        icono2.pintar(c,p);
        icono3.pintar(c,p);
        shor.pintar(c,p);
        c.drawText(mensaje,700,1300,p);
        next.pintar(c,p);
        descri1.pintar(c,p);
        descri2.pintar(c,p);
        descri3.pintar(c,p);
        descri4.pintar(c,p);


    }

    public boolean onTouchEvent(MotionEvent e){
        float xp= e.getX();
        float yp=e.getY();
        mensaje="";
        //mensaje="no se ha tocado onjeto";

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(next.estaEnArea(xp,yp)&&valor!=0) {
                    if(enviar==1){
                        puntero = next;
                        Intent otraVen = new Intent(puntero2, Main2Activity.class);
                        puntero2.startActivity(otraVen);
                        //puntero2.startActivityForResult(otraVen, 9);
                    }
                    if(enviar==2){
                        puntero = next;
                        Intent otraVen = new Intent(puntero2, Main3Activity.class);
                        puntero2.startActivity(otraVen);
                        //puntero2.startActivityForResult(otraVen, 9);
                    }
                    if(enviar==3){
                        puntero = next;
                        Intent otraVen = new Intent(puntero2, Main4Activity.class);
                        puntero2.startActivity(otraVen);
                        //puntero2.startActivityForResult(otraVen, 9);
                    }
                    if(enviar==4){
                        puntero = next;
                        Intent otraVen = new Intent(puntero2, Main5Activity.class);
                        puntero2.startActivity(otraVen);
                        //puntero2.startActivityForResult(otraVen, 9);
                    }


                }else{
                    mensaje="Elige una categoria";
                }


                if(icono1.estaEnArea(xp,yp)){
                    valor =1;
                    enviar=1;
                    puntero=icono1;
                    mensaje="";
                    descri1.hacerVisible(true);
                    descri2.hacerVisible(false);
                    descri3.hacerVisible(false);
                    descri4.hacerVisible(false);
                }
                if(icono2.estaEnArea(xp,yp)){
                    valor=2;
                    enviar=2;
                    puntero=icono2;
                    mensaje="";
                    descri2.hacerVisible(true);
                    descri1.hacerVisible(false);
                    descri3.hacerVisible(false);
                    descri4.hacerVisible(false);
                }
                if(icono3.estaEnArea(xp,yp)){
                    valor=3;
                    enviar=3;
                    puntero=icono3;
                    mensaje="";
                    descri3.hacerVisible(true);
                    descri2.hacerVisible(false);
                    descri1.hacerVisible(false);
                    descri4.hacerVisible(false);

                }
                if(shor.estaEnArea(xp,yp)){
                    valor=4;
                    enviar=4;
                    puntero=shor;
                    mensaje="";
                    descri4.hacerVisible(true);
                    descri3.hacerVisible(false);
                    descri2.hacerVisible(false);
                    descri1.hacerVisible(false);

                }
                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==icono1){
                    icono1.mover(xp);
                    icono2.mover(xp+400);
                    icono3.mover(xp+800);
                    shor.mover(xp+1200);
                }
                if (puntero==icono2){
                    icono2.mover(xp);
                    icono1.mover(xp-400);
                    icono3.mover(xp+400);
                    shor.mover(xp+800);
                }
                if (puntero==icono3){
                    icono3.mover(xp);
                    icono1.mover(xp-800);
                    icono2.mover(xp-400);
                    shor.mover(xp+400);
                }
                if (puntero==shor){
                    shor.mover(xp);
                    icono1.mover(xp-1200);
                    icono2.mover(xp-800);
                    icono3.mover(xp-400);
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero=null;//para que se desactive la seleccion anterior
                break;
        }
        invalidate();
        return true;
    }



}
