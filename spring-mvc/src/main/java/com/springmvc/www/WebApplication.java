package com.springmvc.www;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class WebApplication {


    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        tomcat.getConnector();

        Context context = tomcat.addWebapp("", "/Users/wangyongchun/www/study/java/framework-source-code/spring-mvc/src/main/webapp");
        StandardRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes","/Users/wangyongchun/www/study/java/framework-source-code/spring-mvc/target/classes", "/"));
        context.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
    }
}
