package ReverseString;
public class ReverseString {
    public static void main(String[] args) {

        // simple test case 
        char [] s = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(s);
        
        System.out.println(s);


    }
}

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;

        // only loop half of the array
        for (int i = 0;i<length/2;i++){
            // swap front and back chars
            char front = s[i];
            // be careful that the last index is the length -1
            char back = s[length - 1 - i];
            s[i] = back;
            s[length - 1 - i] = front;
        }
    }
}