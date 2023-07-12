package main.java.com.example.Leet.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sHash = this.toMap(s);
        HashMap<Character, Integer> tHash = this.toMap(t);

        if (t.length() != s.length()) {
            return false;
        }

        for (Map.Entry<Character, Integer> set: tHash.entrySet()) {
            if (!sHash.containsKey(set.getKey())) {
                return false;
            }

            if (!Objects.equals(set.getValue(), sHash.get(set.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public HashMap<Character, Integer> toMap(String s)
    {
        HashMap<Character, Integer> hashed = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!hashed.containsKey(c)) {
                hashed.put(c, 1);
            } else {
                hashed.put(c, hashed.get(c) + 1);
            }
        }

        return hashed;
    }
}
