package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String input = "<<<==>>>>>======<<<<=<<<>>><>=<<<<>>><<";
        List<Integer> characterCount = new ArrayList();
        List<Character> character = new ArrayList();
        populateArrays(characterCount, character, input);
        aggregate(character, characterCount);
        System.out.println(character);
        System.out.println(characterCount);

        int maxIndex = findTheIndexOfMax(characterCount);
    }

    private static int findTheIndexOfMax(List<Integer> arr) {
        if (arr.size() == 0) {
            return -1;
        }

        int max = arr.get(0);
        int maxIndex = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                maxIndex = i;
                max = arr.get(i);
            }
        }

        return maxIndex;
    }



    private static void populateArrays(List<Integer> characterCount, List<Character> character, String input) {
        char[] inputArr = input.toCharArray();
        char temp = inputArr[0];
        int count = 0;
        for (char in : inputArr) {
            if (temp == in) {
                count++;
            } else {
                if (temp != '=') {
                    character.add(temp);
                    characterCount.add(count);

                }
                temp = in;
                count = 1;
            }

        }
        character.add(temp);
        characterCount.add(count);


        System.out.println(character);
        System.out.println(characterCount);
    }

    private static void aggregate(List<Character> character, List<Integer> characterCount) {
        int size = character.size();
        int max = characterCount.get(0);
        int temp = 0;

        for (int i = 0; i < character.size() - 1; i++) {
            if (character.get(i) == character.get(i + 1)) {
                character.remove(i);
                temp = characterCount.remove(i+1);
                temp += characterCount.remove(i);
                characterCount.add(i , temp);
            }
        }
    }

    private static int findMinVal(List<Integer> charCount, List<Character> input, int maxIndex) {
        if
    }


    private static int createExpression(List<Character> character, List<Integer> characterCount) {
        int inputValForNext = characterCount.get(character.size() - 1), max = 0;
        for (int i = character.size() - 1; i >= 0; i--) {
            System.out.println("Index = " + i);
            char temp = character.get(i);
            int occurence = characterCount.get(i);
            switch (temp) {
                case '>':
                    inputValForNext = occurence + 1;
                    max = max > inputValForNext ? max : inputValForNext;
                    break;
                case '<':
//                    max = max > occurence
                    inputValForNext = inputValForNext - occurence;
                    max = max > inputValForNext ? max : inputValForNext;
                    break;
                case '=':
                    inputValForNext = inputValForNext;
                    max = max == 0 ? 1 : max;

            }


        }
        return max;
    }

}
