package com.mygdx.game.modelo;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Manzana{

    protected Vector2 posicion;
    protected Vector2 tamano;
    private Rectangle rectangulo;
    private float altura = 10;
    private float anchura = 10;
    float posicionx;
    float posiciony;

    public Manzana(Vector2 posicion) {
		this.posicion = posicion;
        this.tamano = new Vector2(altura,anchura);
        rectangulo = new Rectangle(posicion.x,posicion.y, tamano.x,tamano.y);
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
                10,
                10);
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

        posicionx = MathUtils.random(0,25);
        posiciony = MathUtils.random(0,25);
        setPosicion(posicionx*13,posiciony*13);
        //setPosicion(0,0);
	}

}
