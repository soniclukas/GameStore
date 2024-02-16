package pl.pabianczyklukasz.project.fib;

public class Fibonacci {
    static int fibonacci(int n) {
        int start0 = 0;
        int start1 = 1;
        int result = 0;
        //kolejne elementy ciagu = 0,1,1,2,3,5
        for(int i = 2; i < n; i++) {
            result = start0 + start1;
            start0 = start1;
            start1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
    }
}
