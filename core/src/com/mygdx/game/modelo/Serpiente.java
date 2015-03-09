package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by dam201 on 22/01/2015 13:12.
 */
public class Serpiente {

    private float velocidade;
    private Array<Anel> aneis;
    private Vector2 tamano;
    private Vector2 posicion;
    public float velocidade_max;
    //public boolean arriba,abajo,derecha,izquierda;
    public boolean direccionMovimiento;//horizontal true

    public Serpiente(){
        iniciarAneis();
       // velocidade  = 10;
        this.velocidade_max = 0;
       // this.tamano = new Vector2(aneis.get(0).getTamano().x,aneis.get(aneis.size-1).getTamano().y);
       // this.posicion = new Vector2(aneis.get(0).getPosicion().x,aneis.get(aneis.size-1).getPosicion().y);
    }

    public void setDireccion(Integer direccion){
        direccionMovimiento = getDireccion();

        switch (direccion){
            case 4:
                if(direccionMovimiento) {
                    for (int i = aneis.size-1; i >= 0; i--) {
                        if (i==0){
                            Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                            Vector2 nuevo = new Vector2(pos.x-10,pos.y);
                            aneis.get(0).setPosicion(nuevo.x,nuevo.y);
                        }
                        else {
                            Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                            Vector2 penultimo = new Vector2(aneis.get(i-1).getPosicion());
                            aneis.get(i).setPosicion(penultimo.x,penultimo.y);
                            ultimo = penultimo;
                        }
                    }
                }

                break;
            case 6:
                if(direccionMovimiento) {
                    for (int i = aneis.size-1; i >= 0; i--) {
                        if (i==0){
                            Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                            Vector2 nuevo = new Vector2(pos.x+10,pos.y);
                            aneis.get(0).setPosicion(nuevo.x,nuevo.y);
                        }
                        else {
                            Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                            Vector2 penultimo = new Vector2(aneis.get(i-1).getPosicion());
                            aneis.get(i).setPosicion(penultimo.x,penultimo.y);
                            ultimo = penultimo;
                        }
                    }
                }
                break;
            case 8:
                if(!direccionMovimiento) {
                    for (int i = aneis.size-1; i >= 0; i--) {
                        if (i==0){
                            Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                            Vector2 nuevo = new Vector2(pos.x,pos.y+10);
                            aneis.get(0).setPosicion(nuevo.x,nuevo.y);
                        }
                        else {
                            Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                            Vector2 penultimo = new Vector2(aneis.get(i-1).getPosicion());
                            aneis.get(i).setPosicion(penultimo.x,penultimo.y);
                            ultimo = penultimo;
                        }
                    }
                }
                break;
            case 2:
                if(!direccionMovimiento) {
                    for (int i = aneis.size-1; i >= 0; i--) {
                        if (i==0){
                            Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                            Vector2 nuevo = new Vector2(pos.x,pos.y-10);
                            aneis.get(0).setPosicion(nuevo.x,nuevo.y);
                        }
                        else {
                            Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                            Vector2 penultimo = new Vector2(aneis.get(i-1).getPosicion());
                            aneis.get(i).setPosicion(penultimo.x,penultimo.y);
                            ultimo = penultimo;
                        }
                    }
                }
        }

        //mirar se direccion valida -> qeu pode ir para esa direccion
        //saber onde está comparado co segundo anel
        //mirar x e y
        //se non poñer a misma direccion

    }

    public boolean getDireccion(){
        Vector2 anel1 = aneis.get(0).getPosicion();
        Vector2 anel2 = aneis.get(1).getPosicion();

        if (anel1.x == anel2.x){
            //están en vertical
            direccionMovimiento = true;
//            if (anel1.x > anel2.x){
//                //va hacia la derecha
//                //no puede ir hacia la izquierda o derecha que ya va
//                derecha = true;
//                izquierda = false;
//                arriba = false;
//                abajo = false;
//
//            }
//            else{
//                //horizontal - izquierda
//                izquierda = true;
//                derecha = false;
//                arriba = false;
//                abajo = false;
//            }
        }
        else{
            //horizontal
            direccionMovimiento = false;
//            if(anel1.y > anel2.y){
//                //hacia arriba
//                arriba = true;
//                abajo = false;
//                izquierda = false;
//                derecha = false;
//            }
//            else {
//                //hacia abajo
//                abajo = true;
//                arriba = false;
//                derecha = false;
//                izquierda = false;
//            }
        }
        return direccionMovimiento;
    }

    public void iniciarAneis(){
        aneis = new Array<Anel>();
        aneis.add(new Anel(new Vector2(50,80),new Vector2(10,10), 10f));
        aneis.add(new Anel(new Vector2(50,70),new Vector2(10,10), 10f));
       /* aneis.add(new Anel(new Vector2(50,60),new Vector2(10,10), 10f));
        aneis.add(new Anel(new Vector2(50,50),new Vector2(10,10), 10f));
        aneis.add(new Anel(new Vector2(50,40),new Vector2(10,10), 10f));
        aneis.add(new Anel(new Vector2(50,30),new Vector2(10,10), 10f));
        aneis.add(new Anel(new Vector2(50,20),new Vector2(10,10), 10f));*/

    }

    public void anadirAnel(Anel novoAnel){
        aneis.add(novoAnel);
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }


    /**
     * Devolve a posicion
     *
     * @return posicion
     */
    public Vector2 getPosicion() {
        return posicion;
    }

    /**
     * Modifica a posición
     *
     * @param posicion
     *            : a nova posicion
     */
    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }

    /**
     * Modifica a posición
     *
     * @param x
     *            : nova posición x
     * @param y
     *            : nova posición y
     */
    public void setPosicion(float x, float y) {
        posicion.x = x;
        posicion.y = y;
    }

    /**
     * Devolve o tamaño
     *
     * @return tamano
     */
    public Vector2 getTamano() {
        return tamano;
    }

    /**
     * Modifica o tamano
     *
     * @param width
     *            : novo tamano de ancho
     * @param height
     *            : novo tamano de alto
     */
    public void setTamano(float width,
                          float height) {
        this.tamano.set(width, height);

    }

    public void setTamano(Vector2 tamano) {
        this.tamano = tamano;

    }

    /**
     * Devolve o rectángulo asociado
     *
     * @return rectangulo
     */
    public Rectangle getRectangulo() {
        return new Rectangle(
                getPosicion().x,
                getPosicion().y,
                getTamano().x,
                getTamano().y);
    }

    public void update(float delta) {
        // TODO Auto-generated method stub
        //coller direccion de
        //switch (direccion){
        //    Vector2 pos = new Vector2(aneis.get(0).getPosicion().x,aneis.get(0).getPosicion().y);
        //    aneis.get(i).getPosicion().x = pos.x;
        //    aneis.get(i).getPosicion().y = pos.y;

        //}

        //setPosicion(getPosicion().x + (velocidade.x + velocidadeMontado)
        //        * delta, getPosicion().y + velocidade.y * delta);
        for (int i=0;i<getAneis().size;i++){
           // setPosicion(getAneis().get(i).getPosicion().x + velocidade*delta,0);
            getAneis().get(i).update(delta);
           // System.out.println("Velocidade " + velocidade);
        }

    }

    public Array<Anel> getAneis() {
        return aneis;
    }
}
