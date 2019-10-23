# Servlet 4.0 的主要新功能
https://www.ibm.com/developerworks/cn/java/j-javaee8-servlet4/index.html 
- 服务器推送和全新API，可以在运行时动态发现servlet映射。
服务器推送是最直观的 HTTP/2 强化功能，通过 PushBuilder 接口在 servlet 中公开。服务器推送功能还在 JavaServer Faces API 中实现，并在 RenderResponsePhase 生命周期内调用，以便 JSF 页面可以利用其增强性能。

全新 servlet 映射发现接口 HttpServletMapping 使框架能够获取有关激活给定 servlet 请求的 URL 信息。这可能对框架尤为有用，这些框架需要这一信息来运行内部工作。

## 服务器推送
```text
PushBuilder pushBuilder = request.newPushBuilder();
 
if (pushBuilder != null) {
   pushBuilder.path("images/hero-banner.jpg").push();
   pushBuilder.path("css/menu.css").push();
   pushBuilder.path("js/marquee.js").push();
}
```

## 运行时获取servlet 信息
```text
@WebServlet({"/path/*", "*.ext"})
public class ServletMapping extends HttpServlet {
 
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) 
                         throws IOException {
 
        HttpServletMapping mapping = request.getHttpServletMapping();
        String mapping = mapping.getMappingMatch().name();
        String value = mapping.getMatchValue();
        String pattern = mapping.getPattern();
        String servletName = mapping.getServletName();
   }
 
}
```

# java 8 新特性

## JSON Binding API

- 定义了规范，添加实现依赖
```xml
        <!-- https://mvnrepository.com/artifact/javax.json/javax.json-api -->
        <dependency>
            <groupId>javax.json</groupId>
            <artifactId>javax.json-api</artifactId>
            <version>1.1.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/javax.json.bind/javax.json.bind-api -->
        <dependency>
            <groupId>javax.json.bind</groupId>
            <artifactId>javax.json.bind-api</artifactId>
            <version>1.0</version>
        </dependency>
```
https://www.ibm.com/developerworks/cn/java/j-whats-new-in-javaee-8/index.html