/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.pattern.matching;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author tsukanomon
 */
public class PatternMatching {

    /*Returns the lowest index, at which substring pattern begins in text or -1*/
    public static int findBrute(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        for (int i = 0; i <= n - m; i++) {//try every starting index within text
            int k = 0;
            while (k < m && text[i + k] == pattern[k]) { //compare the i+k positions with the pattern
                k++;
            }
            if (k == m) { //if the pattern matches, then return the index at which it started the matching
                return i;
            }
        }
        return -1;
    }

    /*Returns the lowest index, at which substring pattern begins in text or -1*/
    public static int findBoyerMoore(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) {
            return 0;
        }
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            last.put(text[i], -1);
        }
        for (int i = 0; i < m; i++) {
            last.put(pattern[i], i);
        }
        int i = m - 1;
        int k = m - 1;
        while (i < n) {
            if (text[i] == pattern[k]) {
                if (k == 0) {
                    return i;
                }
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(text[i]));
                k = m - 1;
            }
        }
        return -1;
    }

}
