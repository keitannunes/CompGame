/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgame;
/**
 *
 * @author Keitan
 */
public class Enemy {
    private String name; //Enemy name
    private int hp; //Enemy hitpoints
    Game parent;
    
    public Enemy(){
        this.hp = 10000;
        
        double rng = Math.random();
        if  (rng > 0.9){
            this.name = "Dragon";
        } else if (rng > 0.6) {
            this.name = "Giant";
        } else if (rng > 0.4) {
            this.name = "Goblin";
        } else if (rng > 0.2) {
            this.name = "Fish";
        } else {
            this.name = "Dog";
        }
    }
    
    public boolean isDead() {
        return this.hp <= 0;
    }
    
    public boolean damage(int dmg) {
        this.hp -= dmg;
        return this.hp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
    
}

