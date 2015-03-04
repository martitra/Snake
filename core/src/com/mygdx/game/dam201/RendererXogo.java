package com.mygdx.game.dam201;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.StringBuilder;
import com.mygdx.game.modelo.Serpiente;
import com.mygdx.game.modelo.Controis;
import com.mygdx.game.modelo.Mundo;
import com.mygdx.game.modelo.Manzana;

/**
	 * Debuxa todos os elementos gráficos da pantalla
	 * 
	 * @author Marta
	 */

public class RendererXogo implements InputProcessor {
	
	private OrthographicCamera camara2d;

    private BitmapFont bitmapFont;
    private StringBuilder sbuffer;

	private Texture grafico;
	private SpriteBatch spriteBatch;

    private ShapeRenderer shapeRenderer;
    private boolean debugger = false;

    private Mundo meuMundo;
    Serpiente serpiente;
    Manzana manzana;

    private Vector3 temporal;
	
	public RendererXogo(Mundo mundo){
        this.meuMundo = mundo;
        serpiente = mundo.getSerpiente();
        manzana = mundo.getManzana();
        //

        //
		camara2d = new OrthographicCamera();
		//grafico = new Texture(Gdx.files.internal("badlogic.jpg"));
		spriteBatch = new SpriteBatch();

        //bitmapFont = new BitmapFont();
        sbuffer = new StringBuilder();
        sbuffer.append("Marta");

        shapeRenderer = new ShapeRenderer();
        temporal = new Vector3();
        Gdx.input.setInputProcessor(this);
	}

    private void debuxarControis(){

        // fondo negro
        //spriteBatch.draw(AssetsXogo.texturePuntoNegro,
        //        Controis.FONDO_NEGRO.x,
        //        Controis.FONDO_NEGRO.y,
        //        Controis.FONDO_NEGRO.width,
        //        Controis.FONDO_NEGRO.height);

        //Control direccion
        spriteBatch.draw(AssetsXogo.textureControisFrechas,
                Controis.CONTROL.x,
                Controis.CONTROL.y,
                Controis.CONTROL.width,
                Controis.CONTROL.height);

        //
        spriteBatch.draw(AssetsXogo.texturePausa,
                Controis.CONTROL_PAUSE.x,
                Controis.CONTROL_PAUSE.y,
                Controis.CONTROL_PAUSE.width,
                Controis.CONTROL_PAUSE.height);

        //
        spriteBatch.draw(AssetsXogo.textureSair,
                Controis.CONTROL_SAIR.x,
                Controis.CONTROL_SAIR.y,
                Controis.CONTROL_SAIR.width,
                Controis.CONTROL_SAIR.height);

    }

    private void debuxarSnake(){
        spriteBatch.draw(AssetsXogo.textureSnake, serpiente.getPosicion().x,
                serpiente.getPosicion().y, serpiente.getTamano().x,
                serpiente.getTamano().y);
    }

    //private void debuxarNave(){
    //    spriteBatch.draw(AssetsXogo.textureNave, manzana.getPosicion().x,
    //            manzana.getPosicion().y, manzana.getTamano().x, manzana.getTamano().y);
    //}

    private void debuxarFondo(){
        spriteBatch.draw(AssetsXogo.textureFondo, 0,0,
                Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
    }

//    private void debuxarVidas() {
//        Texture textura;
//        int posX = Controis.POSVIDAS;
//        for (Serpiente.TIPOS_VIDA vida : meuMundo.getSerpiente().getNumVidas()){
//            if (vida == Serpiente.TIPOS_VIDA.MUERTO){
//                textura = AssetsXogo.textureAlienDead;
//            } else if (vida == Serpiente.TIPOS_VIDA.SALVADO){
//                textura = AssetsXogo.textureAlienRescue;
//            } else{
//                textura = AssetsXogo.textureSnake;
//            }
//            spriteBatch.draw(textura, posX, 0, 10, 10);
//            posX += 12;
//        }
//    }


    /**
     * tempo que pasa entre un frame e o siguiente
     * @param delta
     */
	public void render(float delta){
		Gdx.gl.glClearColor(171/255f, 203/255f, 153/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.begin();//entre begin e end todos os metodos de dibujo
		//spriteBatch.draw(AssetsXogo.textureAlien, temporal.x,temporal.y,15,15);

        //debuxarFondo();

        //debuxarNave();
        debuxarSnake();//poñer o serpiente aquí para que se superpoña por encima do mundo
        //debuxarControis();
        //debuxarVidas();
       // spriteBatch.setColor(Color.YELLOW);
        //spriteBatch.draw(AssetsXogo.textureAlien,100,100,15,15);

        //spriteBatch.setColor(Color.BLUE);
        //spriteBatch.draw(AssetsXogo.textureAlien,200,100,15,15);


        //bitmapFont.setColor(Color.RED);
        //bitmapFont.setScale(10);
        //bitmapFont.draw(spriteBatch,"TEXTO ESCALADO A 10 VECES O SEU TAMAÑO", 0, 250);


		spriteBatch.end();

  
        if (debugger){
            debugger();
        }
	}

    private void debugger() {
        //shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //shapeRenderer.setColor(Color.BLUE);
        //shapeRenderer.rect(100,100,15,15);
        //shapeRenderer.setColor(Color.CYAN);
        //shapeRenderer.rect(200,100,15,15);
        //shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.end();

    }

    public void resize(int width, int height){
		camara2d.setToOrtho(false,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
		camara2d.update();//hay que actualizar para poner el ancho y alto

		spriteBatch.setProjectionMatrix(camara2d.combined);
        shapeRenderer.setProjectionMatrix(camara2d.combined);
	}
	
	public void dispose(){
		Gdx.input.setInputProcessor(null);
        spriteBatch.dispose();
        //AssetsXogo.liberarTexturas();
        //bitmapFont.dispose();
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
        temporal.set(screenX,screenY,0);
        camara2d.unproject(temporal);
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

    public OrthographicCamera getCamara2d() {
        return camara2d;
    }
}
