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

    private Map<Integer, Integer> rollMap = new HashMap();

    public Dice() {

    }

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
        this.rollMap.put(sides, rolls);
    }

    public Map<String, List<Integer>> roll() {
        Map<String, List<Integer>> resultMap = new HashMap();
        List<Integer> values = new ArrayList();
        for (int sides : this.rollMap.keySet()) {
            for (int rolls = 0; rolls < this.rollMap.get(sides); rolls++) {
                Random randomGenerator = new Random();
                values.add(randomGenerator.nextInt(sides) + 1);
            }
            resultMap.put("D" + Integer.toString(sides), values);
            values.clear();
        }
        this.rollMap.clear();
        return resultMap;
    }
}
