package com.neuedu.utils;

public class PrintUtil {
    public static void printWelcome(int row,String message) {
        int col = 100;
        int startCount = (col-(message.length() - message.length()/10)*2 + getEnglishCharCount(message))/2;
        for (int i = 0;i<row;i++) {
            if (i  == row/ 2) {
                for (int j = 0;j <startCount;j++){
                    System.out.print("\033[36;1m"+"*"+"\033[0m");
                }
                System.out.print("\033[34;4m"+message+"\033[0m");
                for (int j = 0;j <startCount;j++){
                    System.out.print("\033[36;1m"+"*"+"\033[0m");
                }
                System.out.println();
            }else {
                for (int j = 0;j < col;j++) {
                    System.out.print("\033[36;1m"+"*"+"\033[0m");
                }
                System.out.println();
            }
        }
    }

    private static  int getEnglishCharCount(String str){
        int count = 0;
        for (int i =0;i <str.length();i++) {
           if (str.charAt(i) < 255){
               count++;
           }
        }
        return count;
    }
}
