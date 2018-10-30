# Introduction

to learn spring web mvc.

### 在spring mvc 中是WebApplicationContext, 继承了ApplicationContext ,就多了一个方法，获取ServletContext.

### hierarchy
 
-  在web.xml中 使用ContextLoaderListener配置RootWebApplicationContext.
-  dispatcherServlet 继承自RootWebApplicationContext。

可以只配置其中一个，就没有继承关系。父容器中注入不了子容器的组件。
优先注入自己容器内部的bean.

- 覆盖
DefaultListableBeanFactory.allowBeanDefinitionOverriding 默认允许覆盖

### mvc:annotation-driven
这个是必须的，用来启动springmvc的基础设施。

### context:annotation-config
<context:annotation-config/> only looks for annotations on beans in the same application context in which it is defined. This means that, if you put <context:annotation-config/> in a WebApplicationContext for a DispatcherServlet, it only checks for @Autowired beans in your controllers, and not your services.
The use of <context:component-scan> implicitly enables the functionality of <context:annotation-config>. There is usually no need to include the <context:annotation-config> element when using <context:component-scan>.


### process
![tomcat](tomcat.jpg)

来自[http://gearever.iteye.com/blog/1841586](http://gearever.iteye.com/blog/1841586)

```
Tomcat
  Server 一个tomcat实例
  |  1:n
  |-- service
         | 
         |-- connector 
         |       
         |-- executor
         |  request/response
         |-- engine
               |
               |-- host
               |-- context (web applications)

     
Spring
request -> Locale Resolver-> theme Resolver ->|Interceptors                | 
                                 ^            |      preHandle             |    
                                 |            |      -- MappingHandler --  |  ExceptionsChain             
                        View Resolver<-model<-|      postHandle            |     
                                              |      afterCompletion       |          
                                              |                            |
```

Note that postHandle is less useful with @ResponseBody and ResponseEntity methods for which the response is written and committed within the HandlerAdapter and before postHandle. That means it is too late to make any changes to the response, such as adding an extra header. For such scenarios, you can implement ResponseBodyAdvice and either declare it as an Controller Advice bean or configure it directly on RequestMappingHandlerAdapter. 