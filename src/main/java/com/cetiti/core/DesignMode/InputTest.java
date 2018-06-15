package com.cetiti.core.DesignMode;

import com.cetiti.core.DesignMode.garnisher.LowerCaseInputStream;

import java.io.*;

public class InputTest {
    public static void main(String[] args){
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("readme1.txt")
                    )
            );

            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
