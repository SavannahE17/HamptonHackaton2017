package com.hampton.game.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Array;
import com.hampton.game.GameScreen;
import com.hampton.game.utils.ActorUtils;

/**
 * Created by turnerd on 10/13/17.
 */
public class MatchingGame extends GameScreen {

    private Actor [] tiles;

    private Actor tilesUp;
    private Actor tilesUp1;
    private Actor pictureUp;
    private Actor pictureUp1;
    int state = 0;



    private Array<Actor> pictures;

    private float xMove;
    private float yMove;
    // ????private String tileMatch;
    private final float MAX_MOVE = 10;
    private Actor batgirl;

    @Override
    public void initialize() {

    }

    @Override
    public void createActors() {
        backgroundColor = new Color(.8726f, .6372f, .2718f, 1);
        tiles = new Actor[12];

        pictures = new Array<Actor>(12);
        for (int i=0; i < tiles.length; i++){
            tiles [i] = ActorUtils.createActorFromImage("tile.jpeg");
        }


        pictures.add(ActorUtils.createActorFromImage("batgirl.png"));
        pictures.add(ActorUtils.createActorFromImage("spiderman.png"));
        pictures.add(ActorUtils.createActorFromImage("captainamerican.png"));
        pictures.add(ActorUtils.createActorFromImage("bear.png"));
        pictures.add(ActorUtils.createActorFromImage("ladybug.png"));
        pictures.add(ActorUtils.createActorFromImage("pig.png"));

        pictures.add(ActorUtils.createActorFromImage("batgirl.png"));
        pictures.add(ActorUtils.createActorFromImage("spiderman.png"));
        pictures.add(ActorUtils.createActorFromImage("captainamerican.png"));
        pictures.add(ActorUtils.createActorFromImage("bear.png"));
        pictures.add(ActorUtils.createActorFromImage("ladybug.png"));
        pictures.add(ActorUtils.createActorFromImage("pig.png"));
        //pictures.shuffle();


        int i;

           for (i = 0; i < tiles.length; i++) {
               int xPos = 210 + (i % 6) * 210;
               int yPos = 210 + (i / 6) * 210;
               tiles[i].setPosition(xPos, yPos);
               stage.addActor(tiles[i]);

               pictures.get(i).setPosition(xPos, yPos);
               pictures.get(i).setSize(tiles[i].getWidth(), tiles[i].getHeight());
               pictures.get(i).setVisible(false);
               pictures.get(i).setTouchable(Touchable.disabled);
               stage.addActor(pictures.get(i));

           }
        /*batgirl = ActorUtils.createActorFromImage("batgirl.png");
        // change the width and length back to 3 (14, 18).
        batgirl.setSize(batgirl.getWidth()/14, batgirl.getHeight()/18);
        batgirl.setPosition(
                // change these numbers back to 2 (7)
                stage.getViewport().getScreenWidth()/7 - batgirl.getWidth()/7,
                stage.getViewport().getScreenHeight()/7 - batgirl.getHeight()/7);
        stage.addActor(batgirl);*/
    }

    @Override
    public void setInputForActors() {
        for (int i = 0; i < tiles.length; i++) {
            final int index = i;
            tiles[i].addListener(new ActorGestureListener() {
                @Override
                public void touchDown(InputEvent event, float x, float y, int pointer, int button) {



                    if (state == 0) {
                        tilesUp = tiles[index];
                        pictures.get(index).setVisible(true);
                        //tilesUp1 = tiles[index];

                        state = 1;
                        pictureUp = pictures.get(index);

                    } else if (state == 1) {
                        state = 2;
                        tilesUp1 = tiles[index];
                        pictureUp1 = pictures.get(index);
                        pictures.get(index).setVisible(true);
                    }
                    else {

                    state  = 0;
                        String name1 = pictureUp.getName();
                        String name2 = pictureUp1.getName();
                        if (name1.equals(name2)) {
                            pictureUp.setVisible(false);
                            pictureUp1.setVisible(false);
                            tilesUp.setVisible(false);
                            tilesUp1.setVisible(false);
                        } else {//pictureUp.setVisible(true);

                           // tilesUp1.setVisible(false);
                            pictureUp.setVisible(false);
                            //tilesUp.setVisible(true);
                            pictureUp1.setVisible(false);
                            //tilesUp1.setVisible(true);
                        }

                    }
                    //tiles[index].setVisible(false);

                }
            });

        }
    }

        /*for ( Actor pictures: stageActors()){
            if (pictures.getName()= != null && pictures.getName().equals("bear.png");
            pictures.remove();
        } */


    @Override
    public void setActionsForActors() {
    }

    @Override
    protected void calledEveryFrame() {
       // if(Gdx.input.isTouched()){

       // }

    }
}
