package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Articulo2 {

    private Bitmap icono;
    private float x,y;
    private boolean visible;

    public Articulo2(int resource, float _x, float _y, Lienzo3 l){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x = _x;
        y = _y;
        visible = true;
    }

    public void pintar(Canvas c, Paint p){
        if(visible)c.drawBitmap(icono,x,y,p);
    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp){ //xp y yp son del toque

        if (!visible) return false;

        float x2,y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if(yp>=y &&yp<=y2){
                return true;
            }
        }


        //metodo mover

        return false;
    }
    //para saber si se movio ocupamos eiste metodo

    public void mover(float yp){
        //x=xp-(icono.getWidth()/2);
         y=yp-(icono.getHeight()/2);

    }
}
