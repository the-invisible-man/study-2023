package Leet.Easy;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote n = new RansomNote();
        if (n.canConstruct("sdfsssdf", "dsfsdf")) {
            System.out.println("Can do");
        } else {
            System.out.println("No way, Jose");
        }
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] required = new int[26];

        for (char c: ransomNote.toCharArray()) {
            required[c - 'a']++;
        }

        for (char c: magazine.toCharArray()) {
            required[c - 'a']--;
        }

        for (int i = 0; i < required.length; i++) {
            if (required[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
