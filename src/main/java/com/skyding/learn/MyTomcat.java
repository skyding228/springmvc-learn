package com.skyding.learn;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * created at 2018/10/31
 *
 * @author weichunhe
 */
public class MyTomcat {
    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
//        tomcat.setBaseDir("temp");
        tomcat.setPort(8088);
        String path = new File("target/springmvc-1.0-SNAPSHOT").getAbsolutePath();
        System.out.println(path);
        tomcat.addWebapp("/","E:\\intelljws\\springmvc\\target\\springmvc-1.0-SNAPSHOT.war");
//        Context ctx = tomcat.addContext("/t","E:/intelljws/springmvc/target/springmvc-1.0-SNAPSHOT/");
        tomcat.start();
        tomcat.getServer().await();

    }
}
