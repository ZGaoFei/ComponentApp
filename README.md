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