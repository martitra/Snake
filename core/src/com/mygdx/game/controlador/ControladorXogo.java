package com.mygdx.game.controlador;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.modelo.Anel;
import com.mygdx.game.modelo.Manzana;
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
    private Manzana manzana;
    public static boolean borrar = true;
    private Anel anel;
    float delay = 1; // seconds
    public static boolean ESQUERDA;
    public static boolean DEREITA=true;
    public static boolean ARRIBA;
    public static boolean ABAIXO;
    public int puntuacion;

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
        if (keys.get(Keys.DEREITA)&& !serpiente.esquerda) {
            //serpiente.setDireccion(6);
            //no puede girar a la izquierda
            DEREITA = true;
            ESQUERDA = ARRIBA = ABAIXO = false;
        }
        if (keys.get(Keys.ESQUERDA)&& !serpiente.dereita){
            //serpiente.setDireccion(4);
            //no puede girar a la derecha
            ESQUERDA =true;
            DEREITA = ARRIBA = ABAIXO = false;
        }
       /* if(!(keys.get(Keys.ESQUERDA)) && !(keys.get(Keys.DEREITA))) {
            //serpiente.setVelocidadeX(0);
        }*/

        if (keys.get(Keys.ARRIBA) && !serpiente.abaixo) {
            //serpiente.setDireccion(8);
            //no puede ir abajo
            ARRIBA = true;
            ESQUERDA = DEREITA = ABAIXO = false;
        }
        if (keys.get(Keys.ABAIXO) && !serpiente.arriba){
            //serpiente.setDireccion(2);
            //no puede ir arriba
            ABAIXO = true;
            ESQUERDA = ARRIBA = DEREITA = false;
        }
       /* if(!(keys.get(Keys.ARRIBA)) && !(keys.get(Keys.ABAIXO))) {
            //serpiente.setVelocidadeY(0);
        }*/
    }

    public ControladorXogo(Mundo meuMundo) {
        this.meuMundo = meuMundo;
        serpiente = meuMundo.getSerpiente();
        manzana = meuMundo.getManzana();
        puntuacion = 0;
    }

    private void controladorManzana(){
        //manzana.nuevaPosicion();
        //manzana.update();
    }

    private void controladorSerpiente(float delta){


        //for (int i=0;i<serpiente.getAneis().size;i++) {
        //System.out.println(serpiente.getAneis().size);
            //serpiente.update(delta);
            // Impedir que se mova fora dos límites da pantalla
            // para que no se vaya infinitamente hacia la izquierda o derecha
            if (serpiente.getAneis().get(0).getPosicion().x <= 0 ||
                    serpiente.getAneis().get(0).getPosicion().y <= 0) {
                //serpiente.getAneis().get(0).setPosicion(0, serpiente.getPosicion().y);
                serpiente.iniciarAneis();
                //morre a serpiente
            } else {
                if (serpiente.getAneis().get(0).getPosicion().x >= Mundo.TAMANO_MUNDO_ANCHO) {
                    serpiente.iniciarAneis();
                }
            }

            //para que no se vaya infinitamente hacia arriba o abajo
            if (serpiente.getAneis().get(0).getPosicion().y <= Controis.FONDO_NEGRO.height) {
                //serpiente.getAneis().get(i).setPosicion(serpiente.getAneis().get(i).getPosicion().x,
                //        Controis.FONDO_NEGRO.height);
                serpiente.iniciarAneis();
            } else {
                if (serpiente.getAneis().get(0).getPosicion().y >= Mundo.TAMANO_MUNDO_ALTO) {
                    //serpiente.getAneis().get(i).setPosicion(serpiente.getAneis().get(i).getPosicion().x,
                    //        Mundo.TAMANO_MUNDO_ALTO - serpiente.getAneis().get(i).getTamano().y);
                    serpiente.iniciarAneis();
                }
            }


        /*
            Cando o alien chega a nave, sálvase e inicializamos
        */

            if (Intersector.overlaps(serpiente.getAneis().get(0).getRectangulo(), meuMundo.getManzana().getRectangulo())) {
                //|| Intersector.overlaps(serpiente.getAneis().get(0).getRectangulo(), serpiente.getAneis().get(i).getRectangulo())) {
                //serpiente.setNumVidas(Serpiente.TIPOS_VIDA.SALVADO);
                //Audio.transporter_sfx.play();
                //serpiente.anadirAnel(new Anel(serpiente.getAneis().get(serpiente.getAneis().size).getPosicion(),));
                //serpiente.iniciarAneis();
                //meuMundo.getManzana().
                float posicionx = MathUtils.random(0, 25);
                float posiciony = MathUtils.random(0, 25);
                manzana.setPosicion(posicionx * 13, posiciony * 13);
                puntuacion += 1;
                borrar = false;
                System.out.println(puntuacion);

            }
       // }
        for (int i=0;i<serpiente.getAneis().size;i++) {
            //aquí para que no se toque a sí misma
        }




    }

    public void update(float delta){
        controladorManzana();
        controladorSerpiente(delta);
        procesarEntradas();
        serpiente.update(delta);

    }
}
