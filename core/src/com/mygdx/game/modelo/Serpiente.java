package com.mygdx.game.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by dam201 on 22/01/2015 13:12.
 */
public class Serpiente extends Personaxe {

    private Vector2 velocidade;
    private float velocidadeMontado;
    private Array anel;

    public Serpiente(Vector2 posicion, Vector2 tamano, float velocidade_max, Array aneis){
        super(posicion, tamano, velocidade_max);
        this.anel = aneis;
        velocidade = new Vector2(0,0);
        setVelocidade_montado(0);
        getRectangulo().setSize(tamano.x/2);
        this.anel = aneis;
    }

    public void inicializarSnake() {
        setPosicion(100, 20);
        setVelocidade_montado(0);
        setVelocidadeX(0);
        setVelocidadeY(0);
        setTamano(15, 15);
        getRectangulo().setSize(tamano.x / 2);
    }

    @Override
    public void actualizarRectangulo() {

        getRectangulo().x = getPosicion().x + getTamano().x / 4;
        getRectangulo().y = getPosicion().y + getTamano().y / 4;

    }

    public float getVelocidade_montado() {
        return velocidadeMontado;
    }

    public void setVelocidade_montado(float velocidade_montado) {
        this.velocidadeMontado = velocidade_montado;
    }

    public float getVelocidadeX() {
        return velocidade.x;
    }

    public float getVelocidadeY() {
        return velocidade.y;
    }

    public void setVelocidadeX(float x) {
        velocidade.x = x;

    }

    public void setVelocidadeY(float y) {
        velocidade.y = y;
    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub

        setPosicion(getPosicion().x + (velocidade.x + velocidadeMontado)
                * delta, getPosicion().y + velocidade.y * delta);

    }
}
