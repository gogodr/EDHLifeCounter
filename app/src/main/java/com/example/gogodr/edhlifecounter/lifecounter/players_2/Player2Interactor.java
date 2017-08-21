package com.example.gogodr.edhlifecounter.lifecounter.players_2;

import com.example.gogodr.edhlifecounter.models.Player;

import java.util.ArrayList;
import java.util.List;

import static com.example.gogodr.edhlifecounter.models.Player.State.COMMANDER_DAMAGE;
import static com.example.gogodr.edhlifecounter.models.Player.State.LIFE;
import static com.example.gogodr.edhlifecounter.models.Player.State.POISON;

/**
 * Created by gogodr on 8/20/2017.
 */

public class Player2Interactor implements IPlayer2Interactor {

    List<Player> players;

    public Player2Interactor() {
        players = new ArrayList<>();
        players.add(new Player(2));
        players.add(new Player(2));
    }

    @Override
    public void toggleState(int playerId, OnChangeState onChangeState) {
        Player.State state = players.get(playerId).getState();
        switch (state) {
            case LIFE:
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    player.setState(i == playerId ? POISON : COMMANDER_DAMAGE);
                    player.setCommanderDamagePlayerId(playerId);
                }
                break;
            case POISON:
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    player.setState(LIFE);
                    player.setCommanderDamagePlayerId(Player.NO_PLAYER_ID);
                }
                break;
            default:
                break;
        }
        onChangeState.changeState(players);

    }

    @Override
    public void add(int playerId, int amount, OnChangeValue onChangeValue) {
        Player player = players.get(playerId);
        String text = "";
        switch (player.getState()) {
            case LIFE:
                int life = player.getLife() + amount;
                player.setLife(life);
                text = "" + life;
                break;
            case POISON:
                int poison = player.getPoison() + amount;
                player.setPoison(poison);
                text = "" + poison;
                break;
            case COMMANDER_DAMAGE:
                Player pcd = players.get(player.getCommanderDamagePlayerId());
                List<Integer> cd = pcd.getCommanderDamage();
                int damage = cd.get(playerId) + amount;
                cd.set(playerId, damage);
                text = "C-" + damage;
                break;
        }
        onChangeValue.changeValue(playerId, text);
    }
}
