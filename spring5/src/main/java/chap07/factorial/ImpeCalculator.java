package chap07.factorial;

public class ImpeCalculator implements Calculator {

    @Override
    public long factorial(long num) {
        long result = 1;
        for (long i = 1; i <= num; i++) {
            result *= i;
        }
        System.out.println("zzzzzz"+result);
        return result;
    }
}
