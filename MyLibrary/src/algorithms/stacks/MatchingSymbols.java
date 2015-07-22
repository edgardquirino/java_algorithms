/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.stacks;

import stacks.LinkedStack;
import stacks.Stack;

/**
 *
 * @author tsukanomon
 */
public class MatchingSymbols {

    public static boolean isMatched(String exp) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new LinkedStack<>();
        for (char c : exp.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(exp) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }

        }
        return buffer.isEmpty();
    }

    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf("<");
        while (j != -1) {
            int k = html.indexOf(">", j + 1);
            if (k == -1) {
                return false;
            }
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (!tag.substring(1).equals(buffer.pop())) {
                    return false;
                }

            }
            j = html.indexOf("<", k + 1);
        }
        return buffer.isEmpty();

    }

}
