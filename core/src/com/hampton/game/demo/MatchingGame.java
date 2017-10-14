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
    Actor ninja;

    @Override
    public void initialize() {

    }

    @Override
    public void createActors() {
        backgroundColor = new Color(1, 1, 1, 1);
        tiles = new Actor[12];
        int i;
        for (i = 0; i < tiles.length; i++) {
           //  tiles.length;
        }

        ninja = ActorUtils.createActorFromImage("batgirl.jpg");

        ninja.setSize(ninja.getWidth()/3, ninja.getHeight()/3);
        ninja.setPosition(
                stage.getViewport().getScreenWidth()/2 - ninja.getWidth()/2,
                stage.getViewport().getScreenHeight()/2 - ninja.getHeight()/2);
        stage.addActor(ninja);
    }

    @Override
    public void setInputForActors() {
        ninja.addListener(new ActorGestureListener() {
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
            if(!ActorUtils.actorContainsPoint(ninja, touchPoint)) {
                ninja.clearActions();
                // Move to touched location in 3 seconds
                ninja.addAction(Actions.moveTo(
                        touchPoint.x - ninja.getWidth() / 2,
                        touchPoint.y - ninja.getHeight() / 2,
                        3,
                        Interpolation.circleOut));
            }
        }
    }
}
