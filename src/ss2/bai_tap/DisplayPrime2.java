package ss2.bai_tap;

public class DisplayPrime2 {
    public static void main(String[] args) {
        int N = 2;
        int count = 0;
        while (N < 100) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                System.out.println("Nguyên Tố " + count + ": " + N);
            }
            N++;
        }
    }
}

