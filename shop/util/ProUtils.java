package com.shop.util;

import javax.servlet.http.Part;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class ProUtils {

    //生成商品ID
    public static String getId(){
        String str = String.valueOf(System.currentTimeMillis());
        Random random = new Random();
        int i=random.nextInt(100);
        if (i<10){
            str += "0"+i;
        }else{
            str += i;
        }
        return str;
    }

    //字符串类型转换为日期类型
    public static Date converseStringToDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            java.util.Date parse = simpleDateFormat.parse(str);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    //拿到图片名称
    public static String getFileName(Part part){
        String fileName = part.getSubmittedFileName();
        //创建UUID
        UUID uuid = UUID.randomUUID();
        InputStream is = null;
        OutputStream os = null;
        String str = uuid+fileName;
        try {
            is = part.getInputStream();
            os = new FileOutputStream("C:\\imgs\\"+str);
            int buffer = 0;
            byte[] bs = new byte[1024];
            while ((buffer = is.read(bs)) != -1){
                os.write(bs,0,buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
