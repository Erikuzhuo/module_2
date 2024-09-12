package ss4.bai_tap.StopWatch;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Trả lời 1 để bắt đầu");
        int test = Integer.parseInt(sc.nextLine());

        if (test == 1) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            System.out.println("Thời gian bắt đầu: " + stopWatch.getStartTime());
            int[] array = new int[100000];
            Random random = new Random();
            for (int i = 0; i < 100000; i++) {
                array[i] = random.nextInt(100000);
            }

            selectionSort(array);

            stopWatch.end();
            System.out.println("Thời gian kết thúc: " + stopWatch.getEndTime() + "\n Tổng thời gian trôi qua: " + getElapsedTime(stopWatch) + " ms");
        }
    }

    public static long getElapsedTime(StopWatch sW) {
        long startTime = sW.getStartTime().toNanoOfDay() / 1000000;
        long endTime = sW.getEndTime().toNanoOfDay() / 1000000;
        return endTime - startTime;
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
