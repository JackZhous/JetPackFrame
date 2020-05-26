# app快速开发框架

集成了JetPack库的ViewModule、LiveData、Room以及kotlin协程等

## 框架说明

视图层以及ViewModule部分采用java语言编写
底层网络访问加入采用kotlin协程处理，但是大部分网络相关仍是java实现
各个模块之间采用dagger-android依赖注入，降低模块之间耦合以及部分模板代码

## 使用步骤

1. 创建Activity继承BaseActivity
```java

public class TestActivity extends BaseActivity {
    @Inject
    TestViewModle modle;

}
```

2. 在di的路径下的AllActivityModule添加部分模板类代码
```java
    //TestMoudle是为TestActivity类需要注入的实例提供，如上面的TestViewModle
    @ContributesAndroidInjector(modules = TestModule.class)
    abstract TestActivity testActivityInjector();

```

3. 编写TestViewModle继承BaseVModel即可，编写响应的访问接口
```java
public class TestViewModle extends BaseVModel {
    //loginData为需要返回到Activity的LiveData
    public MutableLiveData<RespLogin> loginData = new MutableLiveData<>();
    public TestViewModle(@NotNull NetApi api) {
        super(api);
    }


    public void login1(String phone, String code){
        if(isEmpty(phone, "[0-9]{11}", "手机号不允许为空", "手机号必须为11位")
                || isEmpty(code, "验证码不能为空")){
            return;
        }
        asynCorotines(new ReqLogin(phone, code), (it) -> getApi().login(it), loginData);
    }
}
```

其他相关细节问题，请看项目工程代码
