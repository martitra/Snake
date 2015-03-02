package com.mygdx.game.modelo;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Manzana{

    /** Posición */
    protected Vector2 posicion;
    /** Tamaño */
    protected Vector2 tamano;
    private Rectangle rectangulo;
    private float altura = 20;
    private float anchura = 20;

	public Manzana(Vector2 posicion, Vector2 tamano) {
		this.posicion = posicion;
        this.tamano = tamano;
        rectangulo = new Rectangle(posicion.x,posicion.y, tamano.x,tamano.y);
        rectangulo.setWidth(anchura);
        rectangulo.setHeight(altura);
	}

    /**
     * Actualiza a posición do
     * rectángulo asociado á forma do gráfico
     *
     */
    public void actualizarRectangulo() {
        rectangulo.x = posicion.x;
        rectangulo.y = posicion.y;
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


	public void update() {
		// TODO Auto-generated method stub
        //teño que poñelo en random para colocalo dentro da pantalla
        //setPosicion(MathUtils.random();
	}

}
