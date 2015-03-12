package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.controlador.ControladorXogo;

import java.util.ArrayList;

/**
 * Created by dam201 on 22/01/2015 13:12.
 */
public class Serpiente {

    private float velocidade;
    private Array<Anel> aneis;
    private Anel anel;
    private Vector2 tamano;
    private Vector2 posicion;
    public float velocidade_max;
    public Integer direccion;
    //public boolean arriba,abajo,derecha,izquierda;
    public boolean direccionMovimiento;//horizontal true
    public boolean arriba;
    public boolean abaixo;
    public boolean dereita;
    public boolean esquerda;
    private ControladorXogo controladorXogo;

    public Serpiente(){
        iniciarAneis();
        //ControladorXogo.DEREITA = true;
       // velocidade  = 10;
        this.velocidade_max = 0;
        //esquerda = true;

       // this.tamano = new Vector2(aneis.get(0).getTamano().x,aneis.get(aneis.size-1).getTamano().y);
       // this.posicion = new Vector2(aneis.get(0).getPosicion().x,aneis.get(aneis.size-1).getPosicion().y);
    }

    public void setDireccion(Integer direccion){
        direccionMovimiento = getDireccion();
        switch (direccion){
            case 4:
                if(direccionMovimiento) {//vai en horizontal
                    this.direccion = 4;
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
                    this.direccion = 6;
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
                    this.direccion = 8;
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
                    this.direccion = 2;
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
            if (anel1.x > anel2.x){
                //direccion = 6;
            }
            else{
                //direccion=4;

            }
        }
        else{
            //horizontal
            direccionMovimiento = false;
            if(anel1.y > anel2.y){
                //direccion = 8;

            }
            else {
               //direccion = 2;

            }
        }
        return direccionMovimiento;
    }

    public void iniciarAneis(){
        aneis = new Array<Anel>();
        aneis.add(new Anel(new Vector2(50,80)));
        aneis.add(new Anel(new Vector2(50,75)));
        aneis.add(new Anel(new Vector2(50,70)));
        aneis.add(new Anel(new Vector2(50,65)));
        aneis.add(new Anel(new Vector2(50,60)));
        aneis.add(new Anel(new Vector2(50,55)));
        aneis.add(new Anel(new Vector2(50,50)));

    }

    public void anadirAnel(float x,float y){
        aneis.add(new Anel(new Vector2(x,y)));
        System.out.println("pos x: "+x);
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
        direccionMovimiento = getDireccion();
        //for (int i=0;i<getAneis().size;i++){
        //    getAneis().get(i).update(delta);
            //System.out.println("Velocidade " + ControladorXogo.ESQUERDA+ControladorXogo.DEREITA);
       // }
        if (ControladorXogo.ESQUERDA){
            if (direccionMovimiento || ControladorXogo.ESQUERDA) {
                //for (int i = 0; i < getAneis().size; i++) {
                //    getAneis().get(i).update(delta);
                //}
                //System.out.println("Esquerda");
                //anel.update(delta);
                //aneis.add(new Anel(new Vector2(aneis.get(aneis.size - 1).getPosicion().x - 1,
                //aneis.get(aneis.size - 1).getPosicion().y),new Vector2(20,20),velocidade));

                //aneis.get(0).setPosicion(aneis.get(0).getPosicion().x-(float)0.1,aneis.get(0).getPosicion().y);
                for (int i = aneis.size - 1; i >= 0; i--) {
                    if (i == 0) {
                        Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                        Vector2 nuevo = new Vector2(pos.x - 5, pos.y);
                        aneis.get(0).setPosicion(nuevo.x, nuevo.y);

                    } else {
                        Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                        Vector2 penultimo = new Vector2(aneis.get(i - 1).getPosicion());
                        aneis.get(i).setPosicion(penultimo.x, penultimo.y);
                        ultimo = penultimo;
                    }
                }
            }

           //anadirAnel(getAneis().get(0).getPosicion().x-10,getAneis().get(0).getPosicion().y);

        }
        if (ControladorXogo.DEREITA){
            if (direccionMovimiento || ControladorXogo.DEREITA){
                //System.out.println("dereita");
                //snake.add(new Vector2(snake.get(snake.size - 1).x + 1, snake.get(snake.size - 1).y));
                for (int i = aneis.size-1; i >= 0; i--) {
                    if (i==0){
                        Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                        Vector2 nuevo = new Vector2(pos.x+5,pos.y);
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
            //anadirAnel(getAneis().get(0).getPosicion().x+10,getAneis().get(0).getPosicion().y);
           // System.out.println("Pos: " +getAneis().get(0).getPosicion().x);
        }
        if (ControladorXogo.ARRIBA){
            if (!direccionMovimiento || ControladorXogo.ARRIBA) {
                //System.out.println("arriba");
                //snake.add(new Vector2(snake.get(snake.size - 1).x, snake.get(snake.size - 1).y + 1));
                for (int i = aneis.size - 1; i >= 0; i--) {
                    if (i == 0) {
                        Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                        Vector2 nuevo = new Vector2(pos.x, pos.y + 5);
                        aneis.get(0).setPosicion(nuevo.x, nuevo.y);
                    } else {
                        Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                        Vector2 penultimo = new Vector2(aneis.get(i - 1).getPosicion());
                        aneis.get(i).setPosicion(penultimo.x, penultimo.y);
                        ultimo = penultimo;
                    }
                }
            }

            //anadirAnel(getAneis().get(0).getPosicion().x,getAneis().get(0).getPosicion().y+10);
        }
        if (ControladorXogo.ABAIXO){
            if (!direccionMovimiento || ControladorXogo.ABAIXO) {
                //System.out.println("abaixo");
                //snake.add(new Vector2(snake.get(snake.size - 1).x, snake.get(snake.size - 1).y - 1));
                for (int i = aneis.size - 1; i >= 0; i--) {
                    if (i == 0) {
                        Vector2 pos = new Vector2(aneis.get(0).getPosicion());
                        Vector2 nuevo = new Vector2(pos.x, pos.y - 5);
                        aneis.get(0).setPosicion(nuevo.x, nuevo.y);
                    } else {
                        Vector2 ultimo = new Vector2(aneis.get(i).getPosicion());
                        Vector2 penultimo = new Vector2(aneis.get(i - 1).getPosicion());
                        aneis.get(i).setPosicion(penultimo.x, penultimo.y);
                        ultimo = penultimo;
                    }
                }
            }
            //anadirAnel(getAneis().get(0).getPosicion().x,getAneis().get(0).getPosicion().y-10);
        }
        if (ControladorXogo.borrar){
            //aneis.removeIndex(aneis.size-1);

        }

    }

    public Array<Anel> getAneis() {
        return aneis;
    }
}
