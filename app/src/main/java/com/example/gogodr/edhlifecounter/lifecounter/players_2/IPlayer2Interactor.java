package com.example.gogodr.edhlifecounter.lifecounter.players_2;

import com.example.gogodr.edhlifecounter.models.Player;

import java.util.List;

/**
 * Created by gogodr on 8/20/2017.
 */

public interface IPlayer2Interactor {
    interface OnChangeState{
        void changeState(List<Player> players);
    }
    interface OnChangeValue{
        void changeValue(int playerId, String value);
    }
    void toggleState(int playerId, OnChangeState onChangeState);
    void add(int playerId, int amount, OnChangeValue onChangeValue);
}
