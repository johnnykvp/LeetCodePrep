class Solution {
    public boolean isAnagram(String s, String t) {
        /* Questions
        Anagram has the same letters of another word but rearranged differently? (Yes)
        */
        
        /* Approach
        if statement checks lengths are different
            return false
        sort both strings by converting to char array, then using Arrays.sort
        if statement checks strings are equal
            return true
        return false
        */
        
        /*
        if (s.length() != t.length()) {
            return false;
        }
        char[] sLetters = s.toCharArray();
        char[] tLetters = t.toCharArray();
        Arrays.sort(sLetters);
        Arrays.sort(tLetters);
        for (int i = 0; i < s.length(); i++) {
            if (sLetters[i] != tLetters[i]) {
                return false;
            }
        }
        return true;
        */
        
        /* Tests
        "ana", "naa" -> length 3 == length 3; sLetters = [a,a,n]; tLetters = [a,a,n];
        i = 0, a == a; i = 1, a == a; i = 2, n == n; -> return true
        */
        
        /* Optimize
        O(nlogn) runtime, use Java Arrays sort for sorting string letters
        O(n) space, created char arrays to store letters based on given string size
        
        if statement checks string lengths are different
            return false
        map stores letter, occurance
        for loop iterates through string length
            if statement checks map contains letter
                increment occurance of letter
            else
                add letter to map, with occurance 1
        for loop iterates through string length
            if statement checks map contains letter
                decrement occurance of letter
            else
                add letter to map, with occurance 1
        for each loop iterates through map letters
            if statement checks letter occurances != 0
                return false
        return true
        */
        
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> occurances = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (occurances.containsKey(s.charAt(i))) {
                int count = occurances.get(s.charAt(i)) + 1;
                occurances.replace(s.charAt(i), count);
            }
            else {
                occurances.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (occurances.containsKey(t.charAt(i))) {
                int count = occurances.get(t.charAt(i)) - 1;
                occurances.replace(t.charAt(i), count);
            }
            else {
                occurances.put(t.charAt(i), 1);
            }
        }
        for (char c : occurances.keySet()) {
            if (occurances.get(c) != 0) {
                return false;
            }
        }
        return true;
        
        /* Optimize
        O(n) runtime, iterate through separate for loops based on given string lengths
        O(1) space, created map to store letter occurances
        */
    }
}