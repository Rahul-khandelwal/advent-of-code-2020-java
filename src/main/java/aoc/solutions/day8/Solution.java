package aoc.solutions.day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author in-rahul.khandelwal
 */
public class Solution {

    public static void main(String[] args) {
        part2_updateInstruction();
    }

    private static void part1_accValue() {
        long accValue = 0l;
        int index = 0;

        var input = input();

        while (index < input.size()) {
            if (input.get(index).visited) {
                break;
            }

            input.get(index).visited = true;
            if (input.get(index).instruction.equals("acc")) {
                accValue += input.get(index).num;
                index++;
            } else if (input.get(index).instruction.equals("jmp")) {
                index += input.get(index).num;
            } else {
                index++;
            }
        }

        System.out.println(accValue);
    }

    private static void part2_updateInstruction() {
        var input = input();

        for (int i = 0 ; i < input.size() ; i++) {
            input.forEach(v -> v.visited = false);
            long accValue = 0l;
            int index = 0;
            boolean loop = false;

            while (index < input.size()) {
                if (input.get(index).visited) {
                    loop = true;
                    break;
                }

                var instruction = input.get(index).instruction;
                if (index == i) {
                    switch (instruction) {
                        case "jmp": {
                            instruction = "nop";
                            break;
                        }
                        case "nop": {
                            instruction = "jmp";
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }

                input.get(index).visited = true;
                if (instruction.equals("acc")) {
                    accValue += input.get(index).num;
                    index++;
                } else if (instruction.equals("jmp")) {
                    index += input.get(index).num;
                } else {
                    index++;
                }
            }

            if (!loop) {
                System.out.println(accValue);
                break;
            }
        }
    }

    private static  List<Instruction> input() {
        String strInput = "jmp +1\n" +
                            "acc -18\n" +
                            "acc +19\n" +
                            "acc +19\n" +
                            "jmp +202\n" +
                            "acc +15\n" +
                            "acc +42\n" +
                            "acc +30\n" +
                            "acc -7\n" +
                            "jmp +535\n" +
                            "acc +31\n" +
                            "acc +9\n" +
                            "jmp +581\n" +
                            "nop +501\n" +
                            "acc +44\n" +
                            "acc +18\n" +
                            "acc -4\n" +
                            "jmp +545\n" +
                            "acc +9\n" +
                            "acc +5\n" +
                            "nop -2\n" +
                            "acc +3\n" +
                            "jmp +475\n" +
                            "acc -10\n" +
                            "acc +14\n" +
                            "acc +29\n" +
                            "nop +471\n" +
                            "jmp +470\n" +
                            "acc +2\n" +
                            "nop +375\n" +
                            "acc +31\n" +
                            "acc +6\n" +
                            "jmp +420\n" +
                            "acc -1\n" +
                            "acc +2\n" +
                            "nop +185\n" +
                            "jmp +490\n" +
                            "acc +2\n" +
                            "jmp +317\n" +
                            "nop +282\n" +
                            "jmp +457\n" +
                            "acc +37\n" +
                            "jmp +254\n" +
                            "acc +19\n" +
                            "jmp +436\n" +
                            "jmp +458\n" +
                            "acc -7\n" +
                            "acc -2\n" +
                            "acc -17\n" +
                            "jmp +454\n" +
                            "acc +37\n" +
                            "jmp +212\n" +
                            "acc +6\n" +
                            "acc +5\n" +
                            "acc -7\n" +
                            "jmp +104\n" +
                            "acc +5\n" +
                            "nop +134\n" +
                            "acc +46\n" +
                            "jmp +541\n" +
                            "acc +4\n" +
                            "acc +46\n" +
                            "acc +18\n" +
                            "jmp -53\n" +
                            "acc +10\n" +
                            "jmp +285\n" +
                            "acc +39\n" +
                            "acc +34\n" +
                            "nop +109\n" +
                            "acc +47\n" +
                            "jmp +32\n" +
                            "jmp +1\n" +
                            "jmp +143\n" +
                            "acc +36\n" +
                            "jmp +429\n" +
                            "acc +45\n" +
                            "acc +22\n" +
                            "jmp -59\n" +
                            "acc +0\n" +
                            "acc +23\n" +
                            "acc +30\n" +
                            "acc -7\n" +
                            "jmp -45\n" +
                            "acc +46\n" +
                            "acc +31\n" +
                            "jmp +164\n" +
                            "acc +37\n" +
                            "acc +34\n" +
                            "acc +40\n" +
                            "acc -1\n" +
                            "jmp +246\n" +
                            "nop -46\n" +
                            "acc +2\n" +
                            "acc +31\n" +
                            "jmp +221\n" +
                            "nop +413\n" +
                            "jmp -51\n" +
                            "acc -14\n" +
                            "jmp +145\n" +
                            "acc +1\n" +
                            "nop +77\n" +
                            "jmp +131\n" +
                            "jmp +370\n" +
                            "nop +513\n" +
                            "acc +7\n" +
                            "jmp +476\n" +
                            "acc +22\n" +
                            "acc +37\n" +
                            "acc +44\n" +
                            "jmp +334\n" +
                            "acc +9\n" +
                            "acc -1\n" +
                            "acc +5\n" +
                            "acc +27\n" +
                            "jmp +351\n" +
                            "acc +31\n" +
                            "jmp +220\n" +
                            "nop -61\n" +
                            "acc +34\n" +
                            "jmp +504\n" +
                            "nop +471\n" +
                            "acc +6\n" +
                            "acc +48\n" +
                            "jmp -17\n" +
                            "jmp +217\n" +
                            "acc +13\n" +
                            "acc +0\n" +
                            "acc +25\n" +
                            "jmp +144\n" +
                            "acc -5\n" +
                            "acc +17\n" +
                            "nop +341\n" +
                            "jmp -26\n" +
                            "acc -10\n" +
                            "acc +34\n" +
                            "jmp +168\n" +
                            "nop -16\n" +
                            "acc -6\n" +
                            "acc -10\n" +
                            "acc +38\n" +
                            "jmp +30\n" +
                            "acc -2\n" +
                            "acc -14\n" +
                            "jmp +419\n" +
                            "acc +40\n" +
                            "acc -17\n" +
                            "acc +27\n" +
                            "acc +8\n" +
                            "jmp +101\n" +
                            "nop +370\n" +
                            "acc +2\n" +
                            "acc -10\n" +
                            "acc -7\n" +
                            "jmp +224\n" +
                            "nop +437\n" +
                            "acc +42\n" +
                            "acc +50\n" +
                            "acc +39\n" +
                            "jmp +81\n" +
                            "jmp +11\n" +
                            "jmp +143\n" +
                            "acc +6\n" +
                            "acc +46\n" +
                            "jmp -107\n" +
                            "acc +13\n" +
                            "jmp -109\n" +
                            "acc +5\n" +
                            "jmp +1\n" +
                            "jmp +467\n" +
                            "jmp -159\n" +
                            "nop +421\n" +
                            "jmp +243\n" +
                            "acc +44\n" +
                            "nop +412\n" +
                            "acc -6\n" +
                            "acc +13\n" +
                            "jmp +56\n" +
                            "acc -12\n" +
                            "acc +18\n" +
                            "jmp +313\n" +
                            "nop +151\n" +
                            "acc +5\n" +
                            "acc +49\n" +
                            "jmp +120\n" +
                            "acc +46\n" +
                            "acc +23\n" +
                            "nop -122\n" +
                            "acc +21\n" +
                            "jmp -55\n" +
                            "acc -15\n" +
                            "jmp -115\n" +
                            "acc +19\n" +
                            "nop +116\n" +
                            "acc +32\n" +
                            "acc +21\n" +
                            "jmp +16\n" +
                            "acc +27\n" +
                            "acc +32\n" +
                            "jmp +359\n" +
                            "acc +16\n" +
                            "acc +18\n" +
                            "acc +15\n" +
                            "jmp +54\n" +
                            "nop +182\n" +
                            "acc +4\n" +
                            "jmp +361\n" +
                            "acc +4\n" +
                            "acc +38\n" +
                            "acc +49\n" +
                            "jmp -94\n" +
                            "jmp +428\n" +
                            "acc +0\n" +
                            "acc +9\n" +
                            "jmp +224\n" +
                            "jmp +82\n" +
                            "nop +57\n" +
                            "acc +6\n" +
                            "jmp +1\n" +
                            "jmp +144\n" +
                            "jmp +20\n" +
                            "jmp +265\n" +
                            "jmp +402\n" +
                            "nop +114\n" +
                            "acc -12\n" +
                            "acc -11\n" +
                            "acc +1\n" +
                            "jmp +412\n" +
                            "nop -163\n" +
                            "acc +50\n" +
                            "acc +1\n" +
                            "acc -9\n" +
                            "jmp -20\n" +
                            "acc +10\n" +
                            "acc +6\n" +
                            "jmp +323\n" +
                            "acc +10\n" +
                            "jmp +1\n" +
                            "acc +42\n" +
                            "jmp +46\n" +
                            "acc +35\n" +
                            "acc +31\n" +
                            "jmp -139\n" +
                            "jmp +129\n" +
                            "jmp -193\n" +
                            "acc -4\n" +
                            "nop +247\n" +
                            "nop -163\n" +
                            "acc +25\n" +
                            "jmp -26\n" +
                            "acc +34\n" +
                            "acc +26\n" +
                            "acc +40\n" +
                            "jmp +220\n" +
                            "acc -6\n" +
                            "acc +6\n" +
                            "jmp +311\n" +
                            "acc +0\n" +
                            "acc +14\n" +
                            "acc +41\n" +
                            "acc +6\n" +
                            "jmp +284\n" +
                            "acc +32\n" +
                            "jmp -13\n" +
                            "nop +157\n" +
                            "acc -4\n" +
                            "acc +47\n" +
                            "jmp -146\n" +
                            "acc +34\n" +
                            "acc +6\n" +
                            "nop +196\n" +
                            "acc +5\n" +
                            "jmp +268\n" +
                            "acc -8\n" +
                            "jmp -176\n" +
                            "acc +34\n" +
                            "acc +17\n" +
                            "jmp +1\n" +
                            "jmp +114\n" +
                            "acc +32\n" +
                            "acc +39\n" +
                            "nop +313\n" +
                            "acc +38\n" +
                            "jmp -237\n" +
                            "jmp -273\n" +
                            "acc +21\n" +
                            "acc +26\n" +
                            "acc +31\n" +
                            "jmp -231\n" +
                            "acc +17\n" +
                            "jmp -105\n" +
                            "nop +333\n" +
                            "nop +17\n" +
                            "jmp +11\n" +
                            "acc -9\n" +
                            "acc +2\n" +
                            "jmp -162\n" +
                            "acc +3\n" +
                            "acc +0\n" +
                            "nop +318\n" +
                            "jmp +215\n" +
                            "acc +14\n" +
                            "acc +32\n" +
                            "jmp -196\n" +
                            "jmp +33\n" +
                            "acc -6\n" +
                            "acc +45\n" +
                            "acc +27\n" +
                            "jmp -166\n" +
                            "acc -1\n" +
                            "jmp -25\n" +
                            "acc +0\n" +
                            "acc +4\n" +
                            "acc -14\n" +
                            "acc +0\n" +
                            "jmp -115\n" +
                            "nop +118\n" +
                            "acc +28\n" +
                            "nop +175\n" +
                            "acc +45\n" +
                            "jmp -97\n" +
                            "jmp +78\n" +
                            "jmp -284\n" +
                            "acc +35\n" +
                            "nop -248\n" +
                            "acc -18\n" +
                            "acc -6\n" +
                            "jmp -308\n" +
                            "jmp -95\n" +
                            "acc -2\n" +
                            "acc +0\n" +
                            "jmp +255\n" +
                            "acc +7\n" +
                            "jmp -24\n" +
                            "acc +17\n" +
                            "acc +20\n" +
                            "jmp -220\n" +
                            "jmp +172\n" +
                            "acc +40\n" +
                            "acc +39\n" +
                            "acc +19\n" +
                            "jmp -238\n" +
                            "nop +44\n" +
                            "nop -99\n" +
                            "nop +238\n" +
                            "jmp +195\n" +
                            "acc -14\n" +
                            "acc +36\n" +
                            "acc +40\n" +
                            "acc -11\n" +
                            "jmp -65\n" +
                            "nop -54\n" +
                            "nop +47\n" +
                            "acc -11\n" +
                            "jmp +18\n" +
                            "jmp +98\n" +
                            "jmp +252\n" +
                            "nop -1\n" +
                            "acc +1\n" +
                            "acc +10\n" +
                            "jmp -4\n" +
                            "jmp -319\n" +
                            "jmp -46\n" +
                            "acc -8\n" +
                            "acc +50\n" +
                            "acc +43\n" +
                            "jmp -174\n" +
                            "acc +22\n" +
                            "acc +4\n" +
                            "acc +32\n" +
                            "acc -6\n" +
                            "jmp +73\n" +
                            "acc +8\n" +
                            "jmp -31\n" +
                            "acc +16\n" +
                            "nop +11\n" +
                            "acc +26\n" +
                            "jmp -98\n" +
                            "acc -11\n" +
                            "acc +40\n" +
                            "jmp +101\n" +
                            "acc +28\n" +
                            "acc +30\n" +
                            "acc -16\n" +
                            "acc +7\n" +
                            "jmp +239\n" +
                            "jmp -179\n" +
                            "acc +47\n" +
                            "acc +15\n" +
                            "acc +42\n" +
                            "acc +26\n" +
                            "jmp +30\n" +
                            "acc +17\n" +
                            "acc +3\n" +
                            "acc -5\n" +
                            "nop -98\n" +
                            "jmp -236\n" +
                            "acc +2\n" +
                            "jmp +196\n" +
                            "acc +39\n" +
                            "acc -14\n" +
                            "acc +36\n" +
                            "acc +49\n" +
                            "jmp +189\n" +
                            "jmp +235\n" +
                            "acc +27\n" +
                            "acc -2\n" +
                            "acc +16\n" +
                            "acc +40\n" +
                            "jmp -81\n" +
                            "acc -5\n" +
                            "acc +17\n" +
                            "acc -1\n" +
                            "jmp +1\n" +
                            "jmp -129\n" +
                            "nop -171\n" +
                            "acc +47\n" +
                            "jmp +169\n" +
                            "acc -16\n" +
                            "acc -5\n" +
                            "jmp +172\n" +
                            "nop -84\n" +
                            "acc +8\n" +
                            "acc +40\n" +
                            "acc +43\n" +
                            "jmp -33\n" +
                            "acc +39\n" +
                            "nop -12\n" +
                            "jmp +53\n" +
                            "acc +36\n" +
                            "jmp -270\n" +
                            "acc +17\n" +
                            "acc -1\n" +
                            "jmp -255\n" +
                            "acc +0\n" +
                            "acc -12\n" +
                            "jmp -371\n" +
                            "jmp -216\n" +
                            "acc +45\n" +
                            "acc -18\n" +
                            "acc +23\n" +
                            "acc -17\n" +
                            "jmp -37\n" +
                            "jmp -386\n" +
                            "nop -302\n" +
                            "acc -19\n" +
                            "acc -16\n" +
                            "jmp -297\n" +
                            "acc -18\n" +
                            "acc -7\n" +
                            "acc +17\n" +
                            "acc +17\n" +
                            "jmp -173\n" +
                            "jmp +114\n" +
                            "acc +4\n" +
                            "acc +19\n" +
                            "nop -296\n" +
                            "jmp -36\n" +
                            "acc -18\n" +
                            "acc -14\n" +
                            "acc +6\n" +
                            "nop -27\n" +
                            "jmp -101\n" +
                            "acc +15\n" +
                            "nop -407\n" +
                            "jmp +44\n" +
                            "acc -18\n" +
                            "acc -6\n" +
                            "acc +33\n" +
                            "acc +36\n" +
                            "jmp +80\n" +
                            "acc +43\n" +
                            "jmp +73\n" +
                            "acc -2\n" +
                            "acc +7\n" +
                            "acc +4\n" +
                            "jmp -10\n" +
                            "acc +46\n" +
                            "nop -49\n" +
                            "acc +7\n" +
                            "jmp +65\n" +
                            "acc +24\n" +
                            "jmp +144\n" +
                            "acc +13\n" +
                            "acc +26\n" +
                            "jmp -351\n" +
                            "jmp +1\n" +
                            "acc +34\n" +
                            "nop +62\n" +
                            "jmp -363\n" +
                            "acc -4\n" +
                            "acc -5\n" +
                            "jmp +23\n" +
                            "jmp +82\n" +
                            "acc -7\n" +
                            "acc -7\n" +
                            "acc +15\n" +
                            "jmp -468\n" +
                            "acc +7\n" +
                            "nop -423\n" +
                            "jmp -178\n" +
                            "nop -425\n" +
                            "acc +23\n" +
                            "jmp -181\n" +
                            "acc +6\n" +
                            "acc -11\n" +
                            "jmp -321\n" +
                            "acc +3\n" +
                            "jmp -122\n" +
                            "acc +12\n" +
                            "jmp +44\n" +
                            "acc -5\n" +
                            "acc -16\n" +
                            "acc +16\n" +
                            "jmp -281\n" +
                            "acc +33\n" +
                            "acc -4\n" +
                            "acc +15\n" +
                            "jmp +9\n" +
                            "jmp +63\n" +
                            "acc +35\n" +
                            "nop -12\n" +
                            "acc +25\n" +
                            "acc -10\n" +
                            "jmp -452\n" +
                            "acc +1\n" +
                            "jmp -148\n" +
                            "acc +8\n" +
                            "acc +40\n" +
                            "acc +48\n" +
                            "jmp +2\n" +
                            "jmp -315\n" +
                            "nop -325\n" +
                            "acc -4\n" +
                            "acc +16\n" +
                            "acc -4\n" +
                            "jmp -369\n" +
                            "acc +21\n" +
                            "acc +3\n" +
                            "jmp -153\n" +
                            "nop -25\n" +
                            "acc +0\n" +
                            "jmp -84\n" +
                            "acc +32\n" +
                            "jmp +19\n" +
                            "acc -18\n" +
                            "acc -1\n" +
                            "jmp -385\n" +
                            "jmp +1\n" +
                            "jmp -357\n" +
                            "acc -13\n" +
                            "acc -13\n" +
                            "jmp -360\n" +
                            "jmp -393\n" +
                            "acc +4\n" +
                            "nop -102\n" +
                            "jmp -316\n" +
                            "jmp -248\n" +
                            "acc +4\n" +
                            "nop -487\n" +
                            "jmp -339\n" +
                            "acc +3\n" +
                            "jmp -190\n" +
                            "acc +24\n" +
                            "acc +31\n" +
                            "jmp -166\n" +
                            "jmp -482\n" +
                            "acc +22\n" +
                            "acc +32\n" +
                            "jmp -290\n" +
                            "acc +22\n" +
                            "acc +48\n" +
                            "acc +5\n" +
                            "acc -6\n" +
                            "jmp -330\n" +
                            "nop -203\n" +
                            "acc +7\n" +
                            "acc +1\n" +
                            "jmp -287\n" +
                            "acc +15\n" +
                            "acc +3\n" +
                            "jmp -230\n" +
                            "acc +37\n" +
                            "nop -162\n" +
                            "jmp +33\n" +
                            "jmp -147\n" +
                            "acc +16\n" +
                            "acc +39\n" +
                            "acc +49\n" +
                            "jmp -560\n" +
                            "acc +26\n" +
                            "jmp +26\n" +
                            "jmp -283\n" +
                            "jmp -486\n" +
                            "acc -9\n" +
                            "jmp +1\n" +
                            "acc +25\n" +
                            "acc +1\n" +
                            "jmp -514\n" +
                            "acc +46\n" +
                            "jmp -166\n" +
                            "acc -5\n" +
                            "acc +35\n" +
                            "nop -204\n" +
                            "jmp -175\n" +
                            "nop -30\n" +
                            "nop +11\n" +
                            "jmp -400\n" +
                            "acc +15\n" +
                            "acc -7\n" +
                            "acc -1\n" +
                            "jmp +18\n" +
                            "acc +31\n" +
                            "acc +16\n" +
                            "acc +43\n" +
                            "acc +33\n" +
                            "jmp -260\n" +
                            "acc +1\n" +
                            "acc +23\n" +
                            "acc +25\n" +
                            "acc -1\n" +
                            "jmp -200\n" +
                            "acc -15\n" +
                            "jmp -314\n" +
                            "jmp -238\n" +
                            "jmp -75\n" +
                            "jmp -192\n" +
                            "acc +30\n" +
                            "jmp -525\n" +
                            "acc -14\n" +
                            "jmp +17\n" +
                            "acc +7\n" +
                            "acc +9\n" +
                            "acc -6\n" +
                            "nop -312\n" +
                            "jmp -559\n" +
                            "acc +28\n" +
                            "jmp -305\n" +
                            "jmp -239\n" +
                            "acc +0\n" +
                            "acc -5\n" +
                            "acc +9\n" +
                            "jmp -471\n" +
                            "nop -327\n" +
                            "acc -5\n" +
                            "acc -19\n" +
                            "jmp -496\n" +
                            "acc +17\n" +
                            "jmp +1\n" +
                            "jmp +1\n" +
                            "acc +29\n" +
                            "jmp +1";

        return Arrays.stream(strInput.split("\n"))
                .map(line -> line.trim())
                .map(line -> {
                    String[] tokens = line.split(" ");
                    return new Instruction(tokens[0], Integer.parseInt(tokens[1]));
                })
                .collect(Collectors.toList());
    }

    private static class Instruction {
        private final String instruction;
        private final int num;
        private Boolean visited;

        public Instruction(String instruction, int num) {
            this.instruction = instruction;
            this.num = num;
            this.visited = false;
        }
    }
}
