package com.example.gogodr.edhlifecounter.models;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gogodr on 8/19/2017.
 */

public class Player {
    public static int NO_PLAYER_ID = 99;
    public static enum State {
        LIFE,
        POISON,
        COMMANDER_DAMAGE
    }

    private String name;
    private int life;
    private int poison;
    private State state;
    private List<Integer> commanderDamage;
    private int commanderDamagePlayerId;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Player(int players) {
        this.name = "";
        this.life = 40;
        this.poison = 0;
        this.state = Player.State.LIFE;
        this.commanderDamagePlayerId = NO_PLAYER_ID;
        switch (players) {
            case 2:
                this.commanderDamage = Arrays.asList(21, 21);
                break;
            case 3:
                this.commanderDamage = Arrays.asList(21, 21, 21);
                break;
            case 4:
                this.commanderDamage = Arrays.asList(21, 21, 21, 21);
                break;
            case 5:
                this.commanderDamage = Arrays.asList(21, 21, 21, 21, 21);
                break;
            case 6:
                this.commanderDamage = Arrays.asList(21, 21, 21, 21, 21, 21);
                break;
        }
    }

    public int getCommanderDamagePlayerId() {
        return commanderDamagePlayerId;
    }

    public void setCommanderDamagePlayerId(int commanderDamagePlayerId) {
        this.commanderDamagePlayerId = commanderDamagePlayerId;
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

    public List<Integer> getCommanderDamage() {
        return commanderDamage;
    }

    public void setCommanderDamage(List<Integer> commanderDamage) {
        this.commanderDamage = commanderDamage;
    }
}
