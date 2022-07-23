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

    public boolean attack(Enemy enemy) {
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
            return false;
        }
        if (super.points < cost) {
            System.out.println("Insufficient points!");
            return false;
        }
        
        double rng = Math.pow(Math.random(), 2);
        boolean kill = false; //if spell killed enemy
        
        switch (spell) {
            case 1 -> {
                System.out.println("This spell deals damage to 2 enemies!");
                return false;
            }
            case 2 -> {
                if (cost / 10 > rng) {
                    kill = enemy.damage(Math.round(super.multiplier * 2000));
                } else {
                    System.out.println("Failed RNG roll!");
                    return false;
                }
            }
            case 3 -> {
                if (cost / 50 > rng) {
                    kill = enemy.damage(Math.round(super.multiplier * 9999));
                }
            }
            default -> {
                System.out.println("Spell value out of bounds!");
                return false;
            }
        }
        if (kill) {
            super.onKill(enemy);
        }
        super.points -= cost;
        super.moves += 1;
        return true;
    }

    public boolean castSpell(int spell, int cost, Enemy[] enemies) {     
        if (enemies.length != 2) {
            System.out.println("Enemies array should only contain 2 enemies!");
            return false;
        }
        if (super.points < cost) {
            System.out.println("Insufficient points!");
            return false;
        }
        
        double rng = Math.pow(Math.random(), 2);
        
        switch (spell) {
            case 1 -> {
                if (cost / 10 > rng) {
                    for (Enemy enemy : enemies) {
                        if (enemy.damage(Math.round(super.multiplier * 1000))){ //deal damage and check for kill
                            super.onKill(enemy);
                        }
                    }
                } else {
                    System.out.println("Failed RNG roll!");
                    return false;
                }
            }
            case 2,3 -> {
                System.out.println("This spell deals damage to 1 enemy!");
                return false;
            }
            default -> {
                System.out.println("Spell value out of bounds!");
                return false;
            }
        }
        
        super.points -= cost;
        super.moves += 1;
        return true;
    }
}
