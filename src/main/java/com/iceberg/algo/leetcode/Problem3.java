package com.iceberg.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int maxSize = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap();

        for (int i=0; i< chars.length; i++) {
            char aChar = chars[i];
            Integer idx = map.get(aChar);
            if (idx != null) {
                if (map.size() > maxSize) {
                    maxSize = map.size();
                }
                for (int j = start; j<=idx; j++) {
                    map.remove(chars[j]);
                }
                start = idx+1;
            }
            map.put(aChar, i);
        }
        if (map.size() > maxSize) {
            maxSize = map.size();
        }
        return maxSize;
    }

    public static void main(String[] args) {

    }
}
