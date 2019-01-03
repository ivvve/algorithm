package _1901._03;

import java.util.Arrays;

/**
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
 *
 *  Three 1's => 1000 points
 *  Three 6's =>  600 points
 *  Three 5's =>  500 points
 *  Three 4's =>  400 points
 *  Three 3's =>  300 points
 *  Three 2's =>  200 points
 *  One   1   =>  100 points
 *  One   5   =>   50 point
 * A single die can only be counted once in each roll. For example, a "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 *
 * Example scoring
 *
 *  Throw       Score
 *  ---------   ------------------
 *  5 1 3 4 1   50 + 2 * 100 = 250
 *  1 1 1 3 1   1000 + 100 = 1100
 *  2 4 4 5 4   400 + 50 = 450
 */
public class GreedIsGood {
    public static int greedy(int[] dice){
        int result = 0;

        int numberOf1 = howManyNumberInArray(dice, 1);
        int numberOf2 = howManyNumberInArray(dice, 2);
        int numberOf3 = howManyNumberInArray(dice, 3);
        int numberOf4 = howManyNumberInArray(dice, 4);
        int numberOf5 = howManyNumberInArray(dice, 5);
        int numberOf6 = howManyNumberInArray(dice, 6);

        if (numberOf1 < 3) {
            result += 100*numberOf1;
        } else if (numberOf1 >= 3) {
            result += 1000 + 100*(numberOf1 - 3);
        }

        if (numberOf5 < 3) {
            result += 50*numberOf5;
        } else if (numberOf5 >= 3) {
            result += 500 + 50*(numberOf5 - 3);
        }

        if (numberOf2 >= 3)
            result += 200;
        if (numberOf3 >= 3)
            result += 300;
        if (numberOf4 >= 3)
            result += 400;
        if (numberOf6 >= 3)
            result += 600;

        return result;
    }

    public static int howManyNumberInArray(int[] dice, int target) {
        return (int) Arrays.stream(dice).filter(number -> number == target).count();
    }
}
