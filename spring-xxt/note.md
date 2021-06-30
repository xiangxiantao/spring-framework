spring 启动时内建的BeanPostProcessor

1. ApplicationContextAwareProcessor，这是容器中添加的第一个BeanPostProcessor
2. ApplicationListenerDetector
3. LoadTimeWeaverAwareProcessor

ApplicationContextAwareProcessor的作用： 判断bean是否实现了下面的Aware接口，如果实现了，这把相应的内建bean或单例对象赋给该bean

    1. EnvironmentAware -> applicationContext.getEnvironment()
    2. EmbeddedValueResolverAware -> embeddedValueResolver
    3. ResourceLoaderAware -> applicationContext
    4. ApplicationEventPublisherAware -> applicationContext
    5. MessageSourceAware -> applicationContext
    6. ApplicationContextAware -> applicationContext
    7. ApplicationStartupAware -> applicationContext.getApplicationStartup()

在DefaultBeanFactory构造器中：

ignoreDependencyInterface(BeanNameAware.class);

ignoreDependencyInterface(BeanFactoryAware.class);

ignoreDependencyInterface(BeanClassLoaderAware.class);

在prepareBeanFactory方法中：

beanFactory.ignoreDependencyInterface(EnvironmentAware.class);

beanFactory.ignoreDependencyInterface(EmbeddedValueResolverAware.class);

beanFactory.ignoreDependencyInterface(ResourceLoaderAware.class);

beanFactory.ignoreDependencyInterface(ApplicationEventPublisherAware.class);

beanFactory.ignoreDependencyInterface(MessageSourceAware.class);

beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);

beanFactory.ignoreDependencyInterface(ApplicationStartupAware.class);

ignoreDependencyInterface表示在正常的依赖过程中忽略这些接口，这些接口会由单独的处理机制进行处理

resolvableDependencies： 容器内建bean

beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);

beanFactory.registerResolvableDependency(ResourceLoader.class, this);

beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);

beanFactory.registerResolvableDependency(ApplicationContext.class, this);

容器内部单例对象

beanFactory.registerSingleton(ENVIRONMENT_BEAN_NAME, getEnvironment());

beanFactory.registerSingleton(SYSTEM_PROPERTIES_BEAN_NAME, getEnvironment().getSystemProperties());

beanFactory.registerSingleton(SYSTEM_ENVIRONMENT_BEAN_NAME, getEnvironment().getSystemEnvironment());

beanFactory.registerSingleton(APPLICATION_STARTUP_BEAN_NAME, getApplicationStartup());
