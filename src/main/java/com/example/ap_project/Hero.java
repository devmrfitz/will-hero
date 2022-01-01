package com.example.ap_project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx.util.Pair;

import java.util.ArrayList;

public class Hero implements Positionable, Serializable, Jumpable {
    private ArrayList<Weapon> activeWeapons;
    private int distanceTravelled;
    private Node node;
    private Timeline jumpTimeline;
    private int coinsCollected;

    public Hero(Node _node) {
        node = _node;

        startJumping();

    }

    private void startJumping(){
        jumpTimeline = new Timeline();
        jumpTimeline.setCycleCount(1);
        jumpTimeline.setAutoReverse(false);
        final KeyValue up_key_value = new KeyValue(((ImageView)node).yProperty(), -100,
                Interpolator.EASE_OUT);
        final KeyFrame up_keyframe = new KeyFrame(Duration.millis(700), up_key_value);
        final KeyValue down_key_value = new KeyValue(((ImageView)node).yProperty(), 1000,
                Interpolator.EASE_IN);
        final KeyFrame down_keyframe = new KeyFrame(Duration.millis(7000), down_key_value);



        jumpTimeline.getKeyFrames().add(up_keyframe);
        jumpTimeline.getKeyFrames().add(down_keyframe);
        jumpTimeline.play();
    }


    public void jump(){
        if (jumpTimeline.getCurrentTime().greaterThanOrEqualTo(Duration.millis(700))) {
            jumpTimeline.setDelay(Duration.millis(0));
            jumpTimeline.playFromStart();
        }
    }

    public void die(){

    }

    public void resurrect(){

    }

    public void addWeapon(){

    }

    public void equipWeapon(){

    }

    public void moveForward(){

    }

    public ArrayList<Weapon> listWeapons(){
        return activeWeapons;
    }

    public void addCoins(int coins){

    }

    @Override
    public Pair<Double, Double> getPosition() {
        return null;
    }

    @Override
    public void setPosition(Pair<Double, Double> position) {

    }
}
