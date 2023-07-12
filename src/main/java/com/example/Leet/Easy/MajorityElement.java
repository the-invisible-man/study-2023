package main.java.com.example.Leet.Easy;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public static void main(String[] args) {

    }
    public String addBinary(String a, String b) {
        char carry = '0';
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        String output = "";

        int aCharPoint = aChars.length - 1;
        int bCharPoint = bChars.length - 1;

        int calc;

        while (aCharPoint >= 0 || bCharPoint >= 0) {
            char binA = aCharPoint >= 0 ? aChars[aCharPoint] : '0';
            char binB = bCharPoint >= 0 ? bChars[bCharPoint] : '0';

            calc = binA + binB + carry;

            if (calc == 144) {
                output = "0" + output;
                carry = '0';
            } else if (calc == 145) {
                output = "1" + output;
                carry = '0';
            } else if (calc == 146) {
                output = "0" + output;
                carry = '1';
            } else if (calc == 147) {
                output = "1" + output;
                carry = '1';
            }

            aCharPoint--;
            bCharPoint--;
        }

        if (carry == '1') {
            output = "1" + output;
        }

        return output;
    }
}
