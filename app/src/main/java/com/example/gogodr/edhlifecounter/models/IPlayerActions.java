package com.example.gogodr.edhlifecounter.models;

/**
 * Created by gogodr on 8/19/2017.
 */

public interface IPlayerActions {
    void add(int playerId, int amount);
    void toggleState(int playerId);
}
