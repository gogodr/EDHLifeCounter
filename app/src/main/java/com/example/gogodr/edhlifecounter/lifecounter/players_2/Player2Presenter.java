package com.example.gogodr.edhlifecounter.lifecounter.players_2;

import com.example.gogodr.edhlifecounter.models.Player;

import java.util.List;

/**
 * Created by gogodr on 8/19/2017.
 */

public class Player2Presenter implements IPlayer2Presenter {
    IPlayer2View view;
    Player2Interactor interactor;

    public Player2Presenter(IPlayer2View view) {
        this.view = view;
        this.interactor = new Player2Interactor();
    }

    @Override
    public void toggleState(int playerId) {
        interactor.toggleState(playerId, new IPlayer2Interactor.OnChangeState() {
            @Override
            public void changeState(List<Player> players) {
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    switch (player.getState()) {
                        case LIFE:
                            view.updateValue(i, "" + player.getLife());
                            break;
                        case POISON:
                            view.updateValue(i, "" + player.getPoison());
                            break;
                        case COMMANDER_DAMAGE:
                            view.updateValue(i, "C-" + players.get(player.getCommanderDamagePlayerId()).getCommanderDamage().get(i));
                            break;
                    }
                }
            }
        });
    }

    @Override
    public void add(int playerId, int amount) {
        interactor.add(playerId, amount, new IPlayer2Interactor.OnChangeValue() {
            @Override
            public void changeValue(int playerId, String value) {
                view.updateValue(playerId, value);
            }
        });
    }
}
