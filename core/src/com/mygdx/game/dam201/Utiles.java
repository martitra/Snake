package com.mygdx.game.dam201;

import com.badlogic.gdx.Gdx;

public class Utiles {
	
	private static final String LOG = "Snake";

	public static void imprimirLog(String clase, String metodo, String mensaxe){
		Gdx.app.log(LOG, clase+":" + metodo + ":" + mensaxe);//o noso log
	}
	
}
