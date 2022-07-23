/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgame;

/**
 *
 * @author keita
 */
public class Game {

    private Enemy[] enemies = new Enemy[2];
    private Player player;
    private int turn; //turn # (1-100)

    public Game(int character) throws Exception {
        switch (character) {
            case 1 -> {
                player = new HiroyasuKayama();
            }
            case 2 -> {
                // player = new ShinSuzuma();
            }
            default -> {
                throw new Exception("Character int has to be either 1 or 2!");
            }
        }
        this.turn = 1;
        this.enemies[0] = new Enemy();
        this.enemies[1] = new Enemy();
    }
    
    public void endTurn() {
        
        if (this.turn++ > 100) {
            return;
        }
        
        //respawn enemy if dead       
        for (int i = 0; i < enemies.length; i++){
            if (enemies[i].isDead()){
                enemies[i] = new Enemy();
            }
        }
        this.player.onTurn();
    }
    
    public boolean isDone() {
        return this.turn > 100;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTurn() {
        return turn;
    }
    
}
