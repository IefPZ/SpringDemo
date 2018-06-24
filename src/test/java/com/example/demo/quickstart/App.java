package com.example.demo.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //ApplicationContext cxt = new FileSystemXmlApplicationContext("D:\\WorkSpace\\projects\\demo\\src\\test\\java\\com\\example\\demo\\quickstart\\Spring-Common.xml");
        ApplicationContext cxt = new FileSystemXmlApplicationContext("/src/test/java/com/example/demo/quickstart/Spring-Common.xml");
        OutputHelper outputHelper = (OutputHelper) cxt.getBean("OutputHelper");
        outputHelper.generatorOutput();
    }
}
