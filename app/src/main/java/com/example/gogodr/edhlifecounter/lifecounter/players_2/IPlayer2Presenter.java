package com.example.gogodr.edhlifecounter.lifecounter.players_2;

import com.example.gogodr.edhlifecounter.models.Player;

/**
 * Created by gogodr on 8/19/2017.
 */

public interface IPlayer2Presenter {
    void toggleState(int playerId);
    void add(int playerId, int amount);
}
