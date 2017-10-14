package com.hampton.game.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
<<<<<<< HEAD
    private Actor [] tilesUp;
    private Actor [] pictureUp;
=======
    private Array<Actor> pictures;
>>>>>>> 8a8e89fd0145ee781e8c442f4b3620e59d38eeb5
    private float xMove;
    private float yMove;
    // ????private String tileMatch;
    private final float MAX_MOVE = 10;
    private Actor batgirl;

    @Override
    public void initialize() {
        createActors();
    }

    @Override
    public void createActors() {
        backgroundColor = new Color(1, 1, 1, 1);
        tiles = new Actor[12];

        pictures = new Array<Actor>(12);
        for (int i=0; i < tiles.length; i++){
            tiles [i] = ActorUtils.createActorFromImage("tile.jpeg");
        }


        pictures.add(ActorUtils.createActorFromImage("batgirl.png"));
        pictures.add(ActorUtils.createActorFromImage("spiderman.jpg"));
        pictures.add(ActorUtils.createActorFromImage("captainamerican.jpg"));
        pictures.add(ActorUtils.createActorFromImage("bear.png"));
        pictures.add(ActorUtils.createActorFromImage("ladybug.png"));
        pictures.add(ActorUtils.createActorFromImage("pig.png"));

        pictures.add(ActorUtils.createActorFromImage("batgirl.png"));
        pictures.add(ActorUtils.createActorFromImage("spiderman.jpg"));
        pictures.add(ActorUtils.createActorFromImage("captainamerican.jpg"));
        pictures.add(ActorUtils.createActorFromImage("bear.png"));
        pictures.add(ActorUtils.createActorFromImage("ladybug.png"));
        pictures.add(ActorUtils.createActorFromImage("pig.png"));



        int i;

           for (i = 0; i < tiles.length; i++) {
               int xPos = 210 + (i % 6) * 210;
               int yPos = 210 + (i / 6) * 210;
               tiles[i].setPosition(xPos, yPos);
               stage.addActor(tiles[i]);
           }
        batgirl = ActorUtils.createActorFromImage("batgirl.png");
        // change the width and length back to 3 (14, 18).
        batgirl.setSize(batgirl.getWidth()/14, batgirl.getHeight()/18);
        batgirl.setPosition(
                // change these numbers back to 2 (7)
                stage.getViewport().getScreenWidth()/7 - batgirl.getWidth()/7,
                stage.getViewport().getScreenHeight()/7 - batgirl.getHeight()/7);
        stage.addActor(batgirl);
    }

    @Override
    public void setInputForActors() {
        for (int i = 0; i < tiles.length; i++) {
            final int index = i;
            tiles[i].addListener(new ActorGestureListener() {
                @Override
                public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    pictures[index].setVisible(true);

                }
            });
        }

       // if ( int tilesUp; tiles.length; i++ ){
            //(tilesUp && pictureUp = )


      //  }
    }

    @Override
    public void setActionsForActors() {
    }

    @Override
    protected void calledEveryFrame() {
        if(Gdx.input.isTouched()) {
            // input.getY sets 0 as the top but actors use 0 for the bottom so we have to flip it
            Vector2 touchPoint = new Vector2(
                    Gdx.input.getX(),
                    stage.getViewport().getScreenHeight() - Gdx.input.getY());
            // Only move to the point if we didn't click on the ninja
            if(!ActorUtils.actorContainsPoint(batgirl, touchPoint)) {
                batgirl.clearActions();
                // Move to touched location in 3 seconds
                batgirl.addAction(Actions.moveTo(
                        touchPoint.x - batgirl.getWidth() / 2,
                        touchPoint.y - batgirl.getHeight() / 2,
                        3,
                        Interpolation.circleOut));
            }
        }
    }
}
