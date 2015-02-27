package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Vector2;

public class Manzana extends Personaxe {

	public Manzana(Vector2 posicion, Vector2 tamano) {
		super(posicion, tamano);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
        //teño que poñelo en random para colocalo dentro da pantalla
        setPosicion(getPosicion().x , getPosicion().y);
	}

}
