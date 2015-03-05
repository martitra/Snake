package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by dam201 on 22/01/2015 13:12.
 */
public class Serpiente {

    private Vector2 velocidade;
    private float velocidadeMontado;
    private Array<Anel> aneis;
    private Vector2 tamano;
    private Vector2 posicion;
    public float velocidade_max;

    public Serpiente(Vector2 velocidade){
        this.velocidade = velocidade;
        iniciarAneis();
    }

    public void iniciarAneis(){
        aneis = new Array<Anel>();
        aneis.add(new Anel(new Vector2(20,20),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,40),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,80),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,100),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,120),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,140),new Vector2(20,20), 0f));
        aneis.add(new Anel(new Vector2(20,180),new Vector2(20,20), 0f));

    }

    public void anadirAnel(Anel novoAnel){
        aneis.add(novoAnel);
    }

    public void setVelocidadeX(float x) {
        velocidade.x = x;
    }

    public void setVelocidadeY(float y) {
        velocidade.y = y;
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

    //@Override
    public void update(float delta) {
        // TODO Auto-generated method stub

        setPosicion(getPosicion().x + (velocidade.x + velocidadeMontado)
                * delta, getPosicion().y + velocidade.y * delta);

    }
}
