package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public final class Mundo {
	public static final int TAMANO_MUNDO_ANCHO = 260;
	public static final int TAMANO_MUNDO_ALTO = 260;

    private Serpiente serpiente;
    private Manzana manzana;

	public Mundo() {
        serpiente = new Serpiente();
        manzana = new Manzana(new Vector2(0,0));
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }

    public Manzana getManzana() {
        return manzana;
    }
}
