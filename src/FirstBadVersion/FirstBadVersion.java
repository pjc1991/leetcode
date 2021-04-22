package FirstBadVersion;

public class FirstBadVersion {
    public static void main(String[] args) {

        int badVersion = 1702766719;
        int n = 2126753390;
        Solution solution = new Solution();
        solution.badVersion = badVersion;

        int answer = solution.firstBadVersion(n);
        System.out.println("Input { Bad Version : " + badVersion + ", N : " + n + " } ");
        System.out.println("Answer { Bad Version : " + answer + " } ");
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl{
    int badVersion = 0;
    public boolean isBadVersion(int version){
        return (version >= this.badVersion);
    }
    
    
}
class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long begin = 0;
        long end = n;
        while(begin < end){
            boolean downward = isBadVersion((int) ((begin + end) / 2));
            if (downward){
                end = (begin + end) / 2;
            } else {
                begin = (begin + end) / 2 + 1;
            }

        }
        return (int) begin;
    }
}