package interviewbit;

public class VerifyPrime {
    public int isPrime(int A) {
        long n = A;
        if (n < 2) return 0;
        int isPrime = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int A = 39601;
        System.out.println(new VerifyPrime().isPrime(A));
    }
}
