package com.mogu61.Netty.string;

public class string
{
    public static void main(String[] args) {

            String a = "asdfqwertdwsdtyh";
            String [] s = a.split("d");
            String c =a.split("d")[0];
            for(String b :s){
                System.out.println(b);
            }

        System.out.println(c);

    }
}
