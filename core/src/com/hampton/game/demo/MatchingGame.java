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
import com.hampton.game.GameScreen;
import com.hampton.game.utils.ActorUtils;

/**
 * Created by turnerd on 10/13/17.
 */
public class MatchingGame extends GameScreen {

    private Actor [] tiles;
    private float xMove;
    private float yMove;
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



        int i;
        /*
           for (i = 0; i < tiles.length; i++) {
               int xPos = 10 + (i % 6) * 10;
               int yPos = 10 + (i / 6) * 10;
           }
         */

<<<<<<< HEAD
        batgirl = ActorUtils.createActorFromImage("batgirl.jpg");
            // change the width and length back to 3 (14, 18).
        batgirl.setSize(batgirl.getWidth()/3, batgirl.getHeight()/3);
        batgirl.setPosition(
                // change these numbers back to 2 (7)
                stage.getViewport().getScreenWidth()/2 - batgirl.getWidth()/2,
                stage.getViewport().getScreenHeight()/2 - batgirl.getHeight()/2);
        stage.addActor(batgirl);
=======

        tiles = ActorUtils.createActorFromImage("bear.png");

        tiles.setSize(tiles.getWidth()/3, tiles.getHeight()/3);
        tiles.setPosition(
                stage.getViewport().getScreenWidth()/2 - tiles.getWidth()/2,
                stage.getViewport().getScreenHeight()/2 - tiles.getHeight()/2);
        stage.addActor(tiles);
>>>>>>> 2a0bb735d27f1eb2f1535f784c5b7f61551477f9
    }

    @Override
    public void setInputForActors() {
<<<<<<< HEAD
        batgirl.addListener(new ActorGestureListener() {
=======
        tiles.addListener(new ActorGestureListener() {
>>>>>>> 2a0bb735d27f1eb2f1535f784c5b7f61551477f9
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                // Stop any other actions

            }
        });
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
