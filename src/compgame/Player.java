package compgame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Keitan
 */
import java.util.ArrayList;

public class Player {

    protected int points; // Points player has
    protected int kills; // # of Kills player has
    protected int moves; // # of moves player has left
    protected float multiplier; // # Dmg multiplier
    protected ArrayList<String> inventory = new ArrayList<>(); //Inventory 
    protected String[] items = {"", "", "", "", "", ""};

    public Player() {
        this.kills = 0;
        this.moves = 0;
        this.multiplier = 1;
    }

    protected void onTurn() {
        this.multiplier = 1;
        this.moves = 0;
        this.points += 5;

        if (this.kills % 5 == 0) { //if divisible by 5
            for (String item : this.items) {
                if (item.equals("Glass")) {
                    this.multiplier += 0.25;
                }
            }
        }

        if (this.kills % 10 == 0) { //if divisible by 5
            for (String item : this.items) {
                if (item.equals("Tooth")) {
                    this.multiplier += 1;
                }
            }
        }

        for (String item : this.items) {
            if (item.equals("Syringe")) {
                this.multiplier += 0.1;
            }
        }
    }

    protected void onKill(Enemy enemy) {
        this.kills += 1;

        switch (enemy.getName()) {
            case "Goblin" ->
                this.inventory.add("Syringe");
            case "Giant" ->
                this.inventory.add("Glass");
            case "Dragon" ->
                this.inventory.add("Tooth");
        }
    }

    public boolean equip(int inv_num, int equip_num) {
        // ERROR CHECKING 
        if (this.moves >= 3) {
            System.out.println("\u001B[31mUsed up all moves!");
            return false;
        }

        if (equip_num > 5 && equip_num < 0) {
            System.out.println("\u001B[31mitem # out of bounds!");
            return false;
        }

        if (inv_num >= 0 && inv_num < this.inventory.size()) {
            System.out.println("\u001B[31minventory slot is out of bounds!");
            return false;
        }

        //equiping the item
        if (!this.items[equip_num].equals("")) { //if equipment slot is not empty
            this.inventory.add(this.items[equip_num]); //put item back into inventory
        }

        this.items[equip_num] = this.inventory.get(inv_num); //replace slot with item specified from inventory
        this.inventory.remove(inv_num); //remove item out of inventory
        return true;

    }

    public boolean unequip(int equip_num) {
        //error check
        if (equip_num > 5 && equip_num < 0) {
            System.out.println("\u001B[31mitem # out of bounds!");
            return false;
        }

        if (this.items[equip_num].equals("")) {
            System.out.println("\u001B[31mitem slot empty!");
            return false;
        }

        //moving item to inventory
        this.inventory.add(this.items[equip_num]);
        this.items[equip_num] = "";

        //remove buffs
        switch (this.items[equip_num]) {
            case "Glass" -> {
                if (this.kills % 5 == 0) {
                    this.multiplier -= 0.25;
                }
            }
            case "Giant" -> {
                if (this.kills % 10 == 0) {
                    this.multiplier -= 1;
                }
            }
            case "Syringe" ->
                this.multiplier -= 0.1;
        }
        return true;
    }
    
    //(overwritten in subclass)
    public boolean attack(Enemy enemy){
        System.out.println("WHAT");
        return false;
    }
    
    public boolean castSpell(int cost, int spell, Enemy enemy){
        System.out.println("WHAT");
        return false;
    }
    
    public boolean castSpell(int cost, int spell, Enemy[] enemies){
        System.out.println("WHAT");
        return false;
    }
    

    public int getPoints() {
        return this.points;
    }

    public int getKills() {
        return this.kills;
    }

    public int getMoves() {
        return this.moves;
    }

    public double getMultiplier() {
        return this.multiplier;
    }

    public ArrayList<String> getInventory() {
        return this.inventory;
    }

    public String[] getItems() {
        return this.items;
    }

}
