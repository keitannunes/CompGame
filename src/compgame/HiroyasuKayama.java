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
public class HiroyasuKayama extends Player {
    public HiroyasuKayama() {
        super.points = 20;
    }
    
    public boolean attack(Enemy enemy){
        if (super.moves >= 3) {
            System.out.println("Used up all moves!");
            return false;
        }
        
        if (enemy.damage(Math.round(super.multiplier * 1000))) { //check if enemy died when dealing dmg
            super.onKill(enemy);
        }
        
        super.points += 10;
        super.moves += 1;
        return true;
    }
    
    public boolean castSpell(int spell, int cost, Enemy enemy) { //Single target spells
        
        if (super.moves >= 3) {
            System.out.println("Used up all moves!");
        }
        double rng = Math.pow(Math.random(),2);
        boolean success = false; //if spell successfully hit
        boolean kill = false; //if spell killed enemy
        switch (spell) {
            case 2 -> {
                
            }
        }
    }
    
}
