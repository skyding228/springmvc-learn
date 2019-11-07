# BeanFactory
常用的
ListableBeanFactory
ConfigurableListableBeanFactory
HierarchicalBeanFactory
AutowireCapableBeanFactory
# ApplicationContext
AbstractApplicationContext
--> GenericApplicationContext
-->-->AnnotationConfigApplicationContext

-->AbstractRefreshableApplicationContext
-->-->AbstractXmlApplicationContext
-->-->-->ClassPathXmlApplicationContext
-->-->-->FileSystemXmlApplicationContext

## 主要逻辑refresh
### prepareRefresh()
初始化配置属性，替换占位符等
### refreshBeanFactory
由子类进行实现(AbstractRefreshableApplicationContext)
配置是否可以覆盖bean定义，是否允许循环依赖
注册bean定义到DefaultListableBeanFactory，存在map里面，beanDefinitionMap

### prepareBeanFactory
准备BeanFactory 
添加一些默认的BeanPostProcessor ，这个按照添加顺序执行，跟一起顺序机制无关
屏蔽一些依赖注入的类型，*Aware
配置有关环境类型的注入对象

----
至此所有的bean定义已经加载完，并且没有初始化任何的bean

可以注册一点默认的BeanPostProcessor, 比如Web相关的

### invokeBeanFactoryPostProcessors
此时初始化正式开始，先执行所有的BeanFactoryPostProcessor

### registerBeanPostProcessors
初始化并注册BeanPostProcessor，这会在所有一般的Bean之前执行

### 其他一些初始化
```javascript
// Initialize message source for this context.
initMessageSource();

// Initialize event multicaster for this context.
initApplicationEventMulticaster();

// Initialize other special beans in specific context subclasses.
onRefresh();

// Check for listener beans and register them.
registerListeners();
```

### finishBeanFactoryInitialization
初始化单例对象
构造器、Prototype循环依赖无法解决
设置依赖就通过三级缓存来解决
这三级缓存分别指：解决循环依赖

 singletonFactories ： 单例对象工厂的cache （还没开始创建，为了解决循环依赖会放入创建放入进去）
 earlySingletonObjects ：提前暴光的单例对象的Cache 。【用于检测循环引用，与singletonFactories互斥】（创建中）
 singletonObjects：单例对象的cache （创建完成）


### finishRefresh
发布完成事件

# 问题
- 依赖什么时候检查的？
类相关的是注册bean定义的时候就已经识别出来了
- 怎么创建的bean？
