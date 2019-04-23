
/**
 * Write a description of class DieRoll here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.lang.Math;

public class DieRoll{
    public int dieSize;
    public int dieAmount;
    public int dieRolled;
    public int total;
    public int targetNum;
    public int minDie = 5;
    public int maxDie = 30;
    public int countOnes = 0;
    public ArrayList<Integer> rolls = new ArrayList<Integer>();
    
    public void setDie(int setDieSize, int setDieAmount, int setTargetNum){
    if(setDieSize == 4 || setDieSize == 6 || setDieSize == 8 || setDieSize == 10 || setDieSize == 12 || setDieSize == 20 || setDieSize == 10) {
    dieSize = setDieSize;
    } else {
    System.out.println("That is not a valid type of die. Valid sizes are: 4, 6, 8, 10, 12, 20, and 100. Please try again");
    }
    
    if(setDieAmount <= 10 && 0 < setDieAmount){
    dieAmount = setDieAmount;
    } else {
    System.out.println("That is not a valid amount of die. Please pick a value between 1 and 10.");
    }
    
    if(setTargetNum >= 5 || setTargetNum <= 30) {
    targetNum = setTargetNum;
    } else {
    System.out.println("That is not a valid target number. Please choose a number between 5 and 30.");
    }
}
    
    public void roll() { 
        rolls.clear();
        total = 0;
        for (int i = 0; i <= dieAmount; i++) {
        int rand = 1 + (int)(Math.random() * dieSize);
        dieRolled = rand;
        rolls.add(dieRolled);
        total += dieRolled;
    }
    //Checking all conditions of the dice roller
    //Less than 50% must be 1s or else roll is busy
    //If die rolled is same as die number, add next roll to its value
    for(int j = 0; j <= dieAmount; j++) {
        int roll = rolls.get(j);
        if(dieRolled == 1) {
            countOnes++;
            } else if(dieRolled == dieSize){
            total -= dieRolled;
            int rand = 1 + (int)(Math.random() * dieSize);
            dieRolled += rand;
            rolls.set(j, dieRolled);
            total += dieRolled;
            } else{
           
            } 
        if(countOnes >= dieAmount){
            System.out.println("This roll was a bust!");
            rolls.clear();
        }
    }
}
  
    public void showResults() {
        System.out.println("Your roll results came out to be: " +rolls);
        System.out.println("Your total for all rolls was " +total+ ".");
        if(total >= targetNum){
        System.out.println("You sucessfully reached your target number.");
        } else {
        System.out.println("You failed to reach your target number.");
        }
    }
}