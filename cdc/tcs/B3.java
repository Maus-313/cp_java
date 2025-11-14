package cdc.tcs;

import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        sol();
    }

    static void sol(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        
        m = m/60;
        
        if(n > m){
            System.out.print(a*n);
        }else{
            System.out.print((a*n) + (b*(m-n)));
        }
    }
}