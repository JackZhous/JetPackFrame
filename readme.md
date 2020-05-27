# app快速开发框架

集成了JetPack库的ViewModule、LiveData、Room以及kotlin协程等

## 框架说明

视图层以及ViewModule部分采用java语言编写
底层网络访问加入采用kotlin协程处理，但是大部分网络相关仍是java实现
各个模块之间采用dagger-android依赖注入，降低模块之间耦合以及部分模板代码

## 使用步骤

### 第一步 创建自己的ViewModule并把他加入到Dagger的ViewModuleModel模块
```java

public class UserViewModel extends BaseVModel {

    @Inject
    public UserViewModel(NetApi api) {
        super(api);
    }

}

@Module
abstract class ViewModuleModel {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel provideUserModel(UserViewModel model);

    @Binds
    abstract ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory);
}
```

### 第二步 添加Activity中除ViewModule以外的依赖（可省略）
```java
@Module
abstract class MainModule {
    @Provides
    static UserDao provideUserDao(RoomAgent activity){
        return activity.userDao();
    }
}

abstract class AllActivityModule {
//如果某一个类需要提供其他出ViewModuel意外的依赖，可以创建一个Module，如下
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivityInjector();

}
```

### 第三部  创建Activity继承BaseActivity<具体的ViewModule>

```java
public class TestActivity extends BaseActivity<UserViewModel> {
    @Override
    protected Class<UserViewModel> getViewModelClass() {
        return UserViewModel.class;
    }
}
```

__这一步，在Activity里面无须自己去定义UserViewModule成员变量，已经在父类BaseActivity中定义好了，直接使用定义好的就行了__

如果某个你定义的Activity没有使用ViewModule，直接在getViewModelClass返回空即可



### 第四步  在自己编写的ViewModule中编写自己的业务逻辑即可

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

以上四个步骤，有很多类已经为你生成了，使用时只需要在相关类里面添加方法即可其他相关细节问题，请看项目工程代码;
