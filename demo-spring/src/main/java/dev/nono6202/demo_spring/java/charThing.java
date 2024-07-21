package dev.nono6202.demo_spring.java;

import java.util.List;
import java.util.ArrayList;

public class charThing {
    public static long countChar(String str,char ch){
        return str.chars()
            .filter(c->c==ch)
            .count();
    } 

    public static String extract(String args[],String str){
        int idx = str.indexOf('\\');
        String title = str.substring(idx+2);
        //System.out.println(title);
        return title;
    }

    public static boolean annihilating(String args[],String string){
        List<String> list = new ArrayList<>(){{
            add("\\"); add("\'"); add("\""); add("<"); add(">"); 
            add(" "); add("/");

            add("void"); add("null"); add("Null");
        }};

        for(int i=0;i<list.size();i++){
            if(string.contains(list.get(i))){
                return true;
            }
        }

        return false;
    }
}
