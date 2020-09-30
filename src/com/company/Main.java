package com.company;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
	    int mas[][]=new int[3][3], sumstr[]=new int[3], sumstol[]=new int[3], nad=0, pod=0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    mas[i][j]=random.nextInt(50)-25;
                    if (i>j) pod+=mas[i][j];
                    if (i<j) nad+=mas[i][j];
                    if (mas[i][j]<0)
                        System.out.printf("%d\t",mas[i][j]);
                    else
                        System.out.printf(" %d\t",mas[i][j]);
                }
                System.out.print("\n");
            }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumstr[i] += mas[i][j];
                sumstol[i] += mas[j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if(sumstr[j]>sumstr[j+1]) {
                    int temp=sumstr[j+1];
                    sumstr[j+1]=sumstr[j];
                    sumstr[j]=temp;
                    for (int k = 0; k < 3; k++) {
                        temp=mas[j][k];
                        mas[j][k]=mas[j+1][k];
                        mas[j+1][k]=temp;
                    }
                }
                if(sumstol[j]>sumstol[j+1]) {
                    int temp=sumstol[j+1];
                    sumstol[j+1]=sumstol[j];
                    sumstol[j]=temp;
                    for (int k = 0; k < 3; k++) {
                        temp=mas[k][j];
                        mas[k][j]=mas[k][j+1];
                        mas[k][j+1]=temp;
                    }
                }
            }
        }
        System.out.printf("\nСумма над главной диагональю: %d\nСумма под главной диагональю: %d\n\n",nad,pod);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mas[i][j]<0)
                    System.out.printf("%d\t",mas[i][j]);
                else
                    System.out.printf(" %d\t",mas[i][j]);
            }
            System.out.print("\n");
        }
    }
}