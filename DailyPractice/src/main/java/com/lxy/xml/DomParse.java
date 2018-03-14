package com.lxy.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.Iterator;

/**
 * Created by liuyl on 2018/3/2.
 */
public class DomParse {
    public static void main(String[] args) {
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File("F:\\worksplace\\javaproject\\DailyPractice\\src\\main\\resources\\demo.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Element element = bookStore.element("book");
            Iterator iterable = element.elementIterator();
            while (iterable.hasNext()){
                Element element1 = (Element) iterable.next();
                System.out.println(element.getStringValue());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
