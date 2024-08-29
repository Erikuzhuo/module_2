package ss2.bai_tap;

public class DisplayPrime2 {
    public static void main(String[] args) {
        int N = 3;
        int count = 1;
        boolean check = true;
        System.out.println("Nguyên Tố 1: 2");
        while (N < 100) {
            for (int i = 2; i < N; i++) {
                if (N % i != 0) {
                    check = true;
                } else {
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

