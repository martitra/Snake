package com.mygdx.game.modelo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.dam201.AssetsXogo;

/**
 * Created by dam201 on 04/03/2015 14:40.
 */



public class Anel extends Personaxe {
    public Array<Anel> aneis;
    public Texture textureAneis;

    public Anel(Vector2 posicion, Vector2 tamano, float velocidade_max) {
        super(posicion, tamano, velocidade_max);
        this.textureAneis = AssetsXogo.textureSnake;
    }

    @Override
    public void update(float delta) {

    }
}
