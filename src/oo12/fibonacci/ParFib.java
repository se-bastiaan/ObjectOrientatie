package oo12.fibonacci;

public class ParFib implements Runnable {

    private final int number;
    private int result;

    public ParFib(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            int n = 6; // Calculate fibonacci of n
            ParFib p = new ParFib(n);
            Thread t = new Thread(p);
            t.start();
            t.join();

            System.out.println(p.result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int fib(int n) {
        int prev1 = 0, prev2 = 1;
        for (int i = 0; i < n; i++) {
            int savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    @Override
    public void run() {
        if (number < 2) {
            result = number;
            return;
        }

        try {
            ParFib p1 = new ParFib(number - 2);
            Thread t1 = new Thread(p1);
            t1.start();

            int fib2 = fib(number - 1);

            t1.join();

            result = p1.result + fib2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
