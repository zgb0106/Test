package com.neuedu.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RepeatInputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static String repeatInput(String message) {
        while (true) {
            System.out.println(message);
            String str = sc.next();
            if (StringUtil.isNotEmpty(str)){
                return str;
            }
        }
    }

    public static int getInputInt(String message) {

        while (true) {
            System.out.println("\033[32m"+message+"\033[0m");

            try {
               int m = sc.nextInt();
               return m;
            }catch (InputMismatchException e) {
                System.out.println(ConstantUtil.ERROR_INPUT_FAIL);
                sc = new Scanner(System.in);
            }
        }
    }

}
