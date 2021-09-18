package com.sahar.task_coding_sahar;

import java.util.HashMap;
import java.util.Map;

/**
 * The program for calculating how many times letter in given sentence appears.
 * It gives numbers either for vowels or for consonants based on program input.
 * <p>
 * The first parameter can be 'vowels' or 'consonants'
 * The second parameter is the sentence to be analyzed.
 * <p>
 * Task: Refactor this code to be production ready and create appropriate unit tests.
 *
 * @param: args a String array with length 2
 * @return: a Map, alphabets als key and count of alphabets als value
 */
public class TextAnalyzer {

    public static Map<String, Integer> analyse(String[] args) {
        HashMap<String, Integer> alphabetMap = new HashMap<>();
        String input = "";
        int numA = 0;
        int numE = 0;
        int numI = 0;
        int numO = 0;
        int numU = 0;

        if (args.length == 2) {
            //vowels ExAmPle
            if (args[0].equals("vowels")) {
                input = args[1];
                char[] chars = input.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    System.out.println(chars[i]);
                    if (chars[i] == 'a' || chars[i] == 'A')
                        numA++;
                    if (chars[i] == 'e' || chars[i] == 'E')
                        numE++;
                    if (chars[i] == 'i' || chars[i] == 'I')
                        numI++;
                    if (chars[i] == 'o' || chars[i] == 'O')
                        numO++;
                    if (chars[i] == 'u' || chars[i] == 'U')
                        numU++;
                }
                alphabetMap.put("A", numA);
                alphabetMap.put("E", numE);
                alphabetMap.put("I", numI);
                alphabetMap.put("O", numO);
                alphabetMap.put("U", numU);

                System.out.println("Letter 'A' appears " + numA + " times");
                System.out.println("Letter 'E' appears " + numE + " times");
                System.out.println("Letter 'I' appears " + numI + " times");
                System.out.println("Letter 'O' appears " + numO + " times");
                System.out.println("Letter 'U' appears " + numU + " times");

                //consonants ExAmPle
            } else if (args[0].equals("consonants")) {
                input = args[1];
                char[] chars = input.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != 'a'
                            && chars[i] != 'A'
                            && chars[i] != 'e'
                            && chars[i] != 'E'
                            && chars[i] != 'i'
                            && chars[i] != 'I'
                            && chars[i] != 'o'
                            && chars[i] != 'O'
                            && chars[i] != 'u'
                            && chars[i] != 'U'
                    ) {
                        String stringCharacter = String.valueOf(chars[i]).toUpperCase();
                        if (alphabetMap.containsKey(stringCharacter)) {
                            Integer num = alphabetMap.get(stringCharacter);
                            num++;
                            alphabetMap.put(stringCharacter, num);
                        } else {
                            alphabetMap.put(stringCharacter, 1);
                        }
                    }
                }
                alphabetMap.entrySet().forEach(entrySet -> {
                    System.out.println("Letter '" + entrySet.getKey() + "' appears " + entrySet.getValue() + " times");
                });
            }
        }
        return alphabetMap;
    }

}
