package dev.nono6202.demo_spring.java;

public class charCount {
    public static long countChar(String str,char ch){
        return str.chars()
            .filter(c->c==ch)
            .count();
    } 

    public static String extract(String args[],String str){
        int idx = str.indexOf('\\');
        String title = str.substring(idx+2);
        System.out.println(title);
        return title;
    }
}
