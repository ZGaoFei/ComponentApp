#### 组件化开发

##### 组件化面临的问题

    1、组件模式和集成模式的转换
    
    2、组件之间AndroidManifest合并问题（区分组件模式和集成模式）
    
    3、全局Context的获取及组件数据初始化
    
    4、library依赖问题
    
    5、组件之间调用和通信
    
    6、组件之间资源名冲突
    
    说明：
        组件模式：开发模式，每个组件都是一个APP
        集成模式：发布模式，每个组件都是一个module
        开发过程中，可以对任意一个组件进行单独调试，因为每一个组件都是一个APP
        发布时，需要将各个组件都打包成aar集成进宿主APP中，一同打包进apk中
        
        
    注意：使用ARouter进行组件间通信，在每一个module的build.gradle中都需要添加以下内容
    
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ AROUTER_MODULE_NAME : project.getName() ]
            }
        }
       
       
##### 项目简介
    module名词            功能
    module_app            壳子module，负责组装各个module，运行的也是这个module
    app                   主module，主页等功能
    module_one            one模块功能，主页中第一个页面
    module_two            two模块功能，主页中第二个页面
    module_three          three模块功能，主页中第三个页面
    
    同时包含各个module中页面跳转和传值等相关操作
    
    
##### 相关操作
    
    两种方式获取fragment，首页tab也可以直接获取fragment，或者某个activity/fragment中添加一个fragment
    
    实现原理是通过路径扫描到相关的实现类（IApplicationDelegate、IViewDelegate的实现类），
    然后获取相关实现类的对象，调用相关方法
    
    1、实现IApplicationDelegate，并初始化相关的fragment，
    这种方式是主动添加的方式，即应用启动时伴随着fragment就已经初始化，
    适用于首页tab中添加的fragment
    
    2、实现IViewDelegate，并初始化相关的fragment，
    这种方式是没有在APP初始化时调用，是在需要是才进行相应的初始化操作，
    适用于某个activity/fragment需要加载fragment的情况
    
    此种方式可以直接替换为ARouter的方式来获取，（代码清爽多了）
    
##### 测试跳转传值和回传值

    one.fragment -> app.activity  跳转
    two.fragment -> one.activity  传值
    three.fragment -> two.activity 回传值
    app.activity 获取sp数据
    
    ARouter页面跳转方式：
    // 直接跳转
    ARouter.getInstance().build("/two/two").navigation(); 
    
    // 如startActivityResult效果
    ARouter.getInstance().build("/two/two").navigation(getBaseActivity(), 1); 
    
    // 携带参数的跳转
    ARouter.getInstance().build("/one/one").withString("name", "zgf").withString("age", "21").navigation();    
    需要在对应页面获取参数时在对应字段加上 @Autowired(name = "name") 
    @Autowired(name = "age")
    String age;
    
    // 动画跳转
    ARouter.getInstance().build("/one/one").withTransition(int,int).navigation();
    
    // URI跳转
    Uri testUriMix = Uri.parse("arouter://m.aliyun.com/test/activity2");
    ARouter.getInstance().build(testUriMix).withString("key1", "value1").navigation();
    
    
    注意：
        在对应的activity或者fragment中需要添加 @Route(path = "/one/one")，path路径必须两级
        
        在开发工程中可以定义一个ARouterManger类来管理相关的路径和一些操作
        
