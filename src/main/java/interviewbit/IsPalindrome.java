package interviewbit;

public class IsPalindrome {
    public int isPalindrome(int A) {
        int rev = 0;
        int temp = A;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return A == rev ? 1 : 0;
    }

    public static void main(String[] args) {
        int A = 2147447412;
        System.out.println(new IsPalindrome().isPalindrome(A));
    }
}
