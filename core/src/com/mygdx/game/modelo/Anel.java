package com.mygdx.game.modelo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.dam201.AssetsXogo;

/**
 * Created by dam201 on 04/03/2015 14:40.
 */



public class Anel extends Personaxe {
    public Array aneis;
    public Texture textureAneis;

    public Anel(Vector2 posicion, Vector2 tamano, float velocidade_max) {
        super(posicion, tamano, velocidade_max);
        this.textureAneis = AssetsXogo.textureSnake;
    }

    public void iniciarAneis(){
        aneis = new Array<Anel>();
        for (int i=0;i<7;i++) {
            //aneis[i] = textureAneis;
        }

    }

    @Override
    public void update(float delta) {

    }
}
