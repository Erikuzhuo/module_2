package ss14.bai_tap;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] numbers1 = {10,5,4,6,9,12,1,-1,-2,-50};
        int[] numbers2 = {10,5,4,6,9,12,1,-1,-2,-50};
        insertionSort(numbers1);
        insertionSort1(numbers2);
    }
    public static void insertionSort(int[] list){
        long startTime = System.nanoTime();
        for (int i = 0; i <list.length ; i++) {
            for (int j = i+1; j < list.length; j++) {
                if(list[i]>list[j]){
                    int temp = list[j];
                    list[j]=list[i];
                    list[i]=temp;
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(list));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration+" ns");
    }

    public static void insertionSort1(int[] array){
        long startTime = System.nanoTime();
        int pos, x;
        for(int i = 1; i < array.length; i++){
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1];
                pos--;
            }
            array[pos] = x;
        }
        System.out.println(Arrays.toString(array));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration+" ns");
    }
}
