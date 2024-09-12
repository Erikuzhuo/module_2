package ss4.bai_tap.StopWatch;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Trả lời 1 để bắt đầu");
        int test = Integer.parseInt(sc.nextLine());
        if(test==1){
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            System.out.println("Thời gian bắt đầu: "+stopWatch.getStartTime());
            System.out.println("Trả lời 0 để dừng: ");
            int check = Integer.parseInt(sc.nextLine());
            if(check==0){
                stopWatch.end();
                System.out.println("Thời gian kết thúc: "+stopWatch.getEndTime()+"\n Tổng thời gian trôi qua: "+getElapsedTime(stopWatch)+" ms");
            }
        }
    }
    public static long getElapsedTime(StopWatch sW){
        long startTime = sW.getStartTime().toNanoOfDay()/1000000;
        long endTime = sW.getEndTime().toNanoOfDay()/1000000;
        return endTime - startTime;
    }
}
