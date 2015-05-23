/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.charlesstaal.dnd.diceroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Charles Joseph Staal
 */
public class Dice {

    private Map<Integer, Integer> diceMap = new HashMap();

    public Dice() {

    }

    /**
     * This method adds a roll in to the diceMap to be rolled.
     *
     * @param diceType "D6", "D10", etc. It is not case sensitive.
     * @param rolls How many times to roll this specific die.
     * @throws Exception If the type of die is not supported.
     */
    public void addRoll(String diceType, int rolls) throws Exception {
        diceType = diceType.toUpperCase();
        int sides = 0;
        switch (diceType) {
            case "D4":
                sides = 4;
                break;
            case "D6":
                sides = 6;
                break;
            case "D8":
                sides = 8;
                break;
            case "D10":
                sides = 10;
                break;
            case "D12":
                sides = 12;
                break;
            case "D20":
                sides = 20;
                break;
            case "D00":
                sides = 100;
                break;
            default:
                throw new Exception("Dice type not supported.");
        }
        this.diceMap.put(sides, rolls);
    }

    /**
     * Rolls the dice in diceMap.
     *
     * @return A Map that has the key (the type of die), and the value (a List
     * of integers for the results of each roll of that dice).
     */
    public Map<String, List<Integer>> roll() {
        Map<String, List<Integer>> resultMap = new HashMap();
        List<Integer> values = new ArrayList();
        for (int sides : this.diceMap.keySet()) {
            for (int rolls = 0; rolls < this.diceMap.get(sides); rolls++) {
                Random randomGenerator = new Random();
                values.add(randomGenerator.nextInt(sides) + 1);
            }
            resultMap.put("D" + Integer.toString(sides), values);
            values.clear();
        }
        this.diceMap.clear();
        return resultMap;
    }
}
