package Week_01.PlusOne;

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i --){
            int currentDigits = (digits[i] + 1) % 10;
            digits[i] = currentDigits;
            if (currentDigits != 0){
                return digits;
            }
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
