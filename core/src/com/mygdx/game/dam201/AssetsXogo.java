package com.mygdx.game.dam201;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class AssetsXogo {
	public static Texture textureSnake;
	public static Texture textureFondo;
	public static Texture textureManzana;
	public static Texture textureControisFrechas;
	public static Texture texturePausa;
	public static Texture textureSair;

	public static void cargarTexturas() {
		FileHandle imageFileHandle;

        imageFileHandle = Gdx.files
                .internal("Texturas/controles.png");
        textureControisFrechas = new Texture(imageFileHandle);

        imageFileHandle = Gdx.files
                .internal("Texturas/pausa.png");
        texturePausa = new Texture(imageFileHandle);

        imageFileHandle = Gdx.files
                .internal("Texturas/stop.png");
        textureSair = new Texture(imageFileHandle);

        imageFileHandle = Gdx.files
                .internal("Texturas/serpiente.png");
        textureSnake = new Texture(imageFileHandle);

        imageFileHandle = Gdx.files
                .internal("Texturas/serpiente.png");
        textureManzana = new Texture(imageFileHandle);
	}

	public static void liberarTexturas() {
		textureSnake.dispose();
        textureManzana.dispose();
		textureControisFrechas.dispose();

	}
}
