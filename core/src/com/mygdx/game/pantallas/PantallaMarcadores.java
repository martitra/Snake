package com.mygdx.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controlador.ControladorXogo;
import com.mygdx.game.dam201.MeuXogoGame;
import com.mygdx.game.modelo.Serpiente;
import com.mygdx.game.modelo.Mundo;

public class PantallaMarcadores implements Screen, InputProcessor {

    private MeuXogoGame meuXogoGame;
    private PantallaXogo pantallaXogo;
    private OrthographicCamera camara2d;
    private SpriteBatch spriteBatch;
    private static Texture fondo;
    private BitmapFont bitMapFont;
    private String mazas = "Mazas ";
    private Preferences preferences;
    private Integer puntuacion = 0;

    public PantallaMarcadores(){
        bitMapFont = new BitmapFont();
        camara2d = new OrthographicCamera();
        spriteBatch = new SpriteBatch();
        fondo = new Texture(Gdx.files.internal("Texturas/pantallapause.jpg"));
        preferences = Gdx.app.getPreferences("marcadores");
        //almacenadas, as gardadas en preferencias(numvidassalvadas)
        puntuacion = preferences.getInteger("manzanas_comidas", 0);
    }

    /*
    Constructor a chamar desde pantalla Presentación
     */
    public PantallaMarcadores(MeuXogoGame meuXogoGame) {
        this();
        this.meuXogoGame = meuXogoGame;

        mazas = mazas.concat(String.valueOf(puntuacion));
        /*
        si vimos de pantallaXogo
        guardar a mellor punci&oacute;n e mostrar a tua puntuaci&oacute;n e as demais
        senon, vimos de pantallaPresentacion
        e solo mostrarmos a mellor puntuaci&oacute;n.
        */
    }

    /*
    Construcotr a chamar desde pantalla Xogo con finxogo
     */
    public PantallaMarcadores(MeuXogoGame meuXogoGame, PantallaXogo pantallaXogo){
        this();
        this.meuXogoGame = meuXogoGame;
        this.pantallaXogo = pantallaXogo;

        //Serpiente serpiente = pantallaXogo.getMundo().getSerpiente();
        Integer mazasComidas = ControladorXogo.puntuacion;
        if (mazasComidas > puntuacion){
            mazasComidas =puntuacion ;
            preferences.putInteger("mazas_comidas",puntuacion);
            preferences.flush();//para actualizar
            mazas = mazas.concat("Nuevo Record!! ");
        }
        mazas = mazas.concat(String.valueOf(puntuacion));
        //vidasSalvadas = "Vidas Salvadas: "+String.valueOf(alien.getNumVidasSalvadas());
        //vidasMortas = "Vidas Mortas: "+String.valueOf(alien.getNumVidasMortas());
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        meuXogoGame.setScreen(new PantallaPresentacion(meuXogoGame));
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(fondo,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);

        bitMapFont.draw(spriteBatch,"MARCADORES", 50, 450);
        bitMapFont.draw(spriteBatch, mazas, 50, 350);
        //bitMapFont.draw(spriteBatch, vidasMortas, 50, 350);

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();
        spriteBatch.setProjectionMatrix(camara2d.combined);
        spriteBatch.disableBlending();
    }

    @Override
    public void pause() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        spriteBatch.dispose();
        fondo.dispose();
    }
}
