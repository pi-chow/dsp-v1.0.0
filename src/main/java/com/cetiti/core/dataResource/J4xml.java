package com.cetiti.core.dataResource;

import com.cetiti.dsp.entity.JDBCProperties;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;

public class J4xml {

    public void createXml4Jdbc(JDBCProperties obj){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("dataSource");
        root.addAttribute("type","JDBC");
        Element driverEle = root.addElement("property");
        driverEle.addAttribute("name","driver");
        driverEle.addAttribute("value", obj.getDriverClassName());
        Element urlEle = root.addElement("property");
        urlEle.addAttribute("name","url");
        urlEle.addAttribute("value", obj.getUrl());
        Element userNameEle = root.addElement("property");
        userNameEle.addAttribute("name","username");
        userNameEle.addAttribute("value", obj.getUsername());
        Element passWordEle = root.addElement("property");
        passWordEle.addAttribute("name","password");
        passWordEle.addAttribute("value", obj.getPassword());
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        try {
            XMLWriter writer = new XMLWriter(format);
            writer.write(doc);
            writer.close();
            System.out.print(writer);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        J4xml xml = new J4xml();
        JDBCProperties obj = new JDBCProperties();
        obj.setDriverClassName("com.mysql.jdbc.Driver");
        obj.setUrl("jdbc:mysql://10.0.30.207:3306/pd_ods?useUnicode=true&characterEncoding=utf8&useSSL=false");
        obj.setUsername("root123");
        obj.setPassword("123.com");
        xml.createXml4Jdbc(obj);
    }
}
