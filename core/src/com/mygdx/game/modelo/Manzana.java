package com.mygdx.game.modelo;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Manzana{

    protected Vector2 posicion;
    protected Vector2 tamano;
    private Rectangle rectangulo;
    private float altura = 5;
    private float anchura = 5;
    public float posicionx;
    public float posiciony;

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

    public void nuevaPosicion(){

        posicionx = MathUtils.random(10,51);
        posiciony = MathUtils.random(10,51);
        Manzana manzana = new Manzana(new Vector2(posicionx,posiciony));
        //manzana.setPosicion(posicionx*13,posiciony*13);
    }

	public void update() {
		// TODO Auto-generated method stub
        //teño que poñelo en random para colocalo dentro da pantalla


        //setPosicion(0,0);
	}

}
