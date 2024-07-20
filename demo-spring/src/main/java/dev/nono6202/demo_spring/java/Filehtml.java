package dev.nono6202.demo_spring.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filehtml {
    public static void createhtml(String[] args,String content){
        String oriFilePath;
        String copyFilePath1 = "demo-spring\\src\\main\\resources\\templates\\" + content+".html";
        String copyFilePath2 = "demo-spring\\build\\resources\\main\\templates\\" + content+".html";
        if(charCount.countChar(content, '\\') == 0){
            oriFilePath = "demo-spring\\src\\main\\resources\\templates\\basic\\contentBasic.html";
            
            String filePath1 = "demo-spring\\src\\main\\resources\\templates\\"+content;
            String filePath2 = "demo-spring\\build\\resources\\main\\templates\\"+content;
            File file1 = new File(filePath1);
            File file2 = new File(filePath2);
            file1.mkdir(); file2.mkdir();
        }else{
            oriFilePath = "demo-spring\\src\\main\\resources\\templates\\basic\\postBasic.html";
        }

        File oriFile = new File(oriFilePath);
        File copyFile1 = new File(copyFilePath1);
        File copyFile2 = new File(copyFilePath2);
        try {
            
            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
            FileOutputStream fos1 = new FileOutputStream(copyFile1); //복사할파일
            FileOutputStream fos2 = new FileOutputStream(copyFile2);
            
            int fileByte = 0; 
            while((fileByte = fis.read()) != -1) {
                fos1.write(fileByte);
                fos2.write(fileByte);
            }
            fis.close();
            fos1.close();
            fos2.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletehtml(String[] args,String content){

        System.out.println(charCount.countChar(content, '\\'));
        if(charCount.countChar(content, '\\') == 0){
            String filePath1 = "demo-spring\\src\\main\\resources\\templates\\"+content;
            String filePath2 = "demo-spring\\build\\resources\\main\\templates\\"+content;
            File file1 = new File(filePath1);
            File file2 = new File(filePath2);
            file1.delete();
            file2.delete();
        }else{
            String deleteFilePath1 = "demo-spring\\src\\main\\resources\\templates\\" + content + ".html";
            String deleteFilePath2 = "demo-spring\\build\\resources\\main\\templates\\" + content + ".html";

            File deleteFile1 = new File(deleteFilePath1);               
            File deleteFile2 = new File(deleteFilePath2);

            if(deleteFile1.exists() && deleteFile2.exists()){
                deleteFile1.delete();
                deleteFile2.delete();
            }
        }
    }
}
