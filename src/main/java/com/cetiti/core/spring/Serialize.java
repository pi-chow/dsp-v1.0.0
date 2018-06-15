package com.cetiti.core.spring;

import java.io.*;

public class Serialize implements Serializable {
    private static final long serialVersionUID = -1L;
    public int num = 1390;
    public static void main(String[] args){
        try {
            FileOutputStream fos = new FileOutputStream("D:\\zly7056\\Desktop\\readme.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Serialize serialize = new Serialize();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
