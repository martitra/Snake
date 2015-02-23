package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public final class Mundo {
	public static final int TAMANO_MUNDO_ANCHO = 300;
	public static final int TAMANO_MUNDO_ALTO = 500;

	public final static Vector2 TAMANO_COCHES = new Vector2(20, 15);

    private Serpiente serpiente;
    private Manzana manzana;

	public static final Rectangle ZONAS_PERIGOSAS[] = {
			new Rectangle(0, 40, 300, 120), new Rectangle(0, 220, 300, 120),
			new Rectangle(0, 420, 300, 80) };
	public static final Rectangle ZONAS_SEGURAS[] = {
			new Rectangle(40, 420, 20, 60), new Rectangle(140, 420, 20, 60),
			new Rectangle(240, 420, 20, 60) };
	// AS PLATAFORMAS QUE ESTAN ENRIBA DA LAVA.

	public Mundo() {
        serpiente = new Serpiente(new Vector2(100, 20), new Vector2(15, 15), 100);
        manzana = new Manzana(new Vector2(0, 480), new Vector2(40, 20), 60f);
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }

    public Manzana getManzana() {
        return manzana;
    }
}
