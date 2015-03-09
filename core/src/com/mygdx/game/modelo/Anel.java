package com.mygdx.game.modelo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.dam201.AssetsXogo;

/**
 * Created by dam201 on 04/03/2015 14:40.
 */

public class Anel extends Personaxe {

    public Texture textureAneis;
    private Vector2 velocidade;

    public Anel(Vector2 posicion, Vector2 tamano, float velocidade_max) {
        super(posicion, tamano, velocidade_max);
        this.textureAneis = AssetsXogo.textureSnake;
       // velocidade = new Vector2(0,0);
        //setVelocidade_montado(0);
        //getRectangulo().setSize(tamano.x/2);
    }

    @Override
    public void update(float delta) {
        //setPosicion(getPosicion().x,getPosicion().y + (10 * delta));
    }


    public void update(float delta,Integer posicion) {
        if (posicion == null){

        }else{
            switch (posicion) {
                case 4:
                    setPosicion(getPosicion().x + (-10 * delta), getPosicion().y);
                    break;
                case 6:
                    setPosicion(getPosicion().x + (10 * delta), getPosicion().y);
                    break;
                case 8:
                    setPosicion(getPosicion().x, getPosicion().y + (10 * delta));
                    break;
                case 2:
                    setPosicion(getPosicion().x, getPosicion().y + (-10 * delta));
                    break;
                default:
                    setPosicion(getPosicion().x, getPosicion().y);
                    break;
            }
        }


        //setPosicion(getPosicion().x + (10 * delta),0);
        //setPosicion(getPosicion().x,getPosicion().y + (10 * delta));
    }

}
