package com.example.gogodr.edhlifecounter.models;

import java.util.ArrayList;

/**
 * Created by gogodr on 8/19/2017.
 */

public class Player {

    public static enum State {
        LIFE,
        POISON,
        COMMANDER_DAMAGE
    }

    private String name;
    private int life;
    private int poison;
    private State state = Player.State.LIFE;

    private ArrayList<Integer> commanderDamage;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Player(String name, int life, int poison, ArrayList<Integer> commanderDamage) {
        this.name = name;
        this.life = life;
        this.poison = poison;
        this.commanderDamage = commanderDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public ArrayList<Integer> getCommanderDamage() {
        return commanderDamage;
    }

    public void setCommanderDamage(ArrayList<Integer> commanderDamage) {
        this.commanderDamage = commanderDamage;
    }
}
