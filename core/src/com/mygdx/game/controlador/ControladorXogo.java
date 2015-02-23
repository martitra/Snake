package com.mygdx.game.controlador;

import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.modelo.Serpiente;
import com.mygdx.game.modelo.Controis;
import com.mygdx.game.modelo.Mundo;

import java.util.HashMap;

/**
 * Created by dam201 on 28/01/2015 14:08 14:08.
 */
public class ControladorXogo {
    private Mundo meuMundo;
    private Serpiente serpiente;

    public enum Keys {
        ESQUERDA, DEREITA, ARRIBA, ABAIXO
    }

    HashMap<Keys,Boolean> keys =
            new HashMap<Keys, Boolean>();
    {
        keys.put(Keys.ESQUERDA, false);
        keys.put(Keys.DEREITA, false);
        keys.put(Keys.ARRIBA, false);
        keys.put(Keys.ABAIXO, false);
    }

    public void pulsarTecla(Keys tecla) {
        keys.put(tecla, true);
    }

    public void liberarTecla(Keys tecla) {
        keys.put(tecla, false);
    }


    private void procesarEntradas(){
        if (keys.get(Keys.DEREITA)) {
            serpiente.setVelocidadeX(serpiente.velocidade_max);
        }
        if (keys.get(Keys.ESQUERDA)){
            serpiente.setVelocidadeX(-serpiente.velocidade_max);
        }
        if(!(keys.get(Keys.ESQUERDA)) && !(keys.get(Keys.DEREITA))) {
            serpiente.setVelocidadeX(0);
        }

        if (keys.get(Keys.ARRIBA)) {
            serpiente.setVelocidadeY(serpiente.velocidade_max);
        }
        if (keys.get(Keys.ABAIXO)){
            serpiente.setVelocidadeY(-serpiente.velocidade_max);
        }
        if(!(keys.get(Keys.ARRIBA)) && !(keys.get(Keys.ABAIXO))) {
            serpiente.setVelocidadeY(0);
        }
    }

    public ControladorXogo(Mundo meuMundo) {
        this.meuMundo = meuMundo;
        serpiente = meuMundo.getSerpiente();
    }

    private void controladorManzana(float delta){
        meuMundo.getManzana().update(delta);
    }

    private void controladorSerpiente(float delta){

        serpiente.update(delta);

        // Impedir que se mova fora dos límites da pantalla
        // para que no se vaya infinitamente hacia la izquierda o derecha
        if (serpiente.getPosicion().x <=0) {
            serpiente.setPosicion(0, serpiente.getPosicion().y);
        } else {
            if (serpiente.getPosicion().x >= Mundo.TAMANO_MUNDO_ANCHO
                    - serpiente.getTamano().x){
                serpiente.setPosicion(Mundo.TAMANO_MUNDO_ANCHO
                        - serpiente.getTamano().x, serpiente.getPosicion().y);
            }
        }

        //para que no se vaya infinitamente hacia arriba o abajo
        if(serpiente.getPosicion().y <= Controis.FONDO_NEGRO.height){
            serpiente.setPosicion(serpiente.getPosicion().x,
                    Controis.FONDO_NEGRO.height);
        }else{
            if(serpiente.getPosicion().y >= Mundo.TAMANO_MUNDO_ALTO
                    -serpiente.getTamano().y){
                serpiente.setPosicion(serpiente.getPosicion().x,
                        Mundo.TAMANO_MUNDO_ALTO - serpiente.getTamano().y);
            }
        }

        /*
            Cando o alien chega a nave, sálvase e inicializamos
        */
        if (Intersector.overlaps(meuMundo.getManzana().getRectangulo(), serpiente.getRectangulo())){
            serpiente.setNumVidas(Serpiente.TIPOS_VIDA.SALVADO);
            //Audio.transporter_sfx.play();
            serpiente.inicializarAlien();
        }
    }

    public void update(float delta){
        controladorManzana(delta);
        controladorSerpiente(delta);
        procesarEntradas();
    }
}
