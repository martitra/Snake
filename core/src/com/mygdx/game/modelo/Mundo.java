package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Vector2;

public final class Mundo {
	public static final int TAMANO_MUNDO_ANCHO = 300;
	public static final int TAMANO_MUNDO_ALTO = 500;

    private Serpiente serpiente;
    private Manzana manzana;

	public Mundo() {
        serpiente = new Serpiente(new Vector2(100, 20), new Vector2(15, 15), 100);
        manzana = new Manzana(new Vector2(0, 480), new Vector2(40, 20));
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }

    public Manzana getManzana() {
        return manzana;
    }
}
