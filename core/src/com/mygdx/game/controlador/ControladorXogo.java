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
    public static boolean ESQUERDA;
    public static boolean DEREITA=true;
    public static boolean ARRIBA;
    public static boolean ABAIXO;
    public static int puntuacion;
    public static int MAXTIME = 5;
    public static boolean FINXOGO = false;

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

    private void controladorSerpiente(float delta){
        //System.out.println(serpiente.getAneis().size);
            //serpiente.update(delta);
            // Impedir que se mova fora dos límites da pantalla
            // para que no se vaya infinitamente hacia la izquierda o derecha
            if (serpiente.getAneis().get(0).getPosicion().x <= 0 ||
                    serpiente.getAneis().get(0).getPosicion().y <= 0) {
                //serpiente.getAneis().get(0).setPosicion(0, serpiente.getPosicion().y);
                //serpiente.iniciarAneis();
                FINXOGO = true;
                //morre a serpiente
            } else {
                if (serpiente.getAneis().get(0).getPosicion().x >= Mundo.TAMANO_MUNDO_ANCHO) {
                    //serpiente.iniciarAneis();
                    FINXOGO = true;
                }
            }

            //para que no se vaya infinitamente hacia arriba o abajo
            if (serpiente.getAneis().get(0).getPosicion().y <= Controis.FONDO_NEGRO.height) {
                //serpiente.getAneis().get(i).setPosicion(serpiente.getAneis().get(i).getPosicion().x,
                //        Controis.FONDO_NEGRO.height);
                //serpiente.iniciarAneis();
                FINXOGO = true;
            } else {
                if (serpiente.getAneis().get(0).getPosicion().y >= Mundo.TAMANO_MUNDO_ALTO) {
                    //serpiente.getAneis().get(i).setPosicion(serpiente.getAneis().get(i).getPosicion().x,
                    //        Mundo.TAMANO_MUNDO_ALTO - serpiente.getAneis().get(i).getTamano().y);
                    //serpiente.iniciarAneis();
                    FINXOGO = true;

                }
            }

        /*
            Cando a maza se come
        */
        for (int i=0;i<serpiente.getAneis().size;i++) {
            if (Intersector.overlaps(serpiente.getAneis().get(0).getRectangulo(), meuMundo.getManzana().getRectangulo()) ||
                    Intersector.overlaps(serpiente.getAneis().get(i).getRectangulo(),meuMundo.getManzana().getRectangulo())){
                //|| Intersector.overlaps(serpiente.getAneis().get(0).getRectangulo(), serpiente.getAneis().get(i).getRectangulo())) {
                //serpiente.setNumVidas(Serpiente.TIPOS_VIDA.SALVADO);
                //Audio.transporter_sfx.play();
                //serpiente.anadirAnel(new Anel(serpiente.getAneis().get(serpiente.getAneis().size).getPosicion(),));
                //serpiente.iniciarAneis();
                //meuMundo.getManzana().
                float posicionx = MathUtils.random(15, 51);
                float posiciony = MathUtils.random(15, 51);
                manzana.setPosicion(posicionx*5, posiciony*5);
                System.out.println("pos x:"+posicionx+"pos y:"+posiciony);
                puntuacion += 1;
                System.out.println(puntuacion);
                serpiente.anadirAnel(serpiente.getAneis().get(serpiente.getAneis().size-1).getPosicion().x,
                        serpiente.getAneis().get(serpiente.getAneis().size-1).getPosicion().y);

            }
        }
        for (int i=1;i<serpiente.getAneis().size;i++) {
            //aquí para que no se toque a sí misma
            if (Intersector.overlaps(serpiente.getAneis().get(0).getRectangulo(),serpiente.getAneis().get(i).getRectangulo())){
                //serpiente.iniciarAneis();
                FINXOGO = true;
            }
        }
    }

    public void update(float delta){
        controladorSerpiente(delta);
        procesarEntradas();
        System.out.println(MAXTIME);
        if (MAXTIME==5){
            serpiente.update(delta);
            MAXTIME = 0;
        }
        MAXTIME++;


    }
}
