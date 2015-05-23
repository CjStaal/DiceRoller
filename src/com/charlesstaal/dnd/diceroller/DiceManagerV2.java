/*
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.charlesstaal.dnd.diceroller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Charles Joseph Staal
 */
public class DiceManagerV2 {
    
    
    private List<Dice> diceList = new LinkedList();
    
    public DiceManagerV2(){
        
    }
    
    public void addADie(int sides){
        if(0 > sides && sides <= 100){
            diceList.add(new Dice(sides));
        }
    }
    
    public Map<String, Integer> roll(){
        Map<String, Integer> resultMap = new HashMap();
        diceList.stream().forEach((die) -> {
            resultMap.put(die.getType(), die.roll());
        });
        diceList.clear();
        return resultMap;
    }
}
