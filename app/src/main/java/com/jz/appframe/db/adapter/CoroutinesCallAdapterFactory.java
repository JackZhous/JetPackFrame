package com.jz.appframe.db.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import kotlinx.coroutines.Deferred;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author jackzhous
 * @package com.jz.appframe.db.adapter
 * @filename CoroutinesCallAdapterFactory
 * date on 2020/5/21 4:25 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class CoroutinesCallAdapterFactory extends CallAdapter.Factory {


    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if(getRawType(returnType) != Deferred.class){
            return null;
        }
        if (!(returnType instanceof ParameterizedType)) {
            throw new IllegalStateException(
                    "Deferred return type must be parameterized as Deferred<Foo> or Deferred<out Foo>");
        }
        //返回定义接口Deferred内部的泛型
        Type type = getParameterUpperBound(0, (ParameterizedType)returnType);
        return new CoroutinesCallAdapter(type);
    }
}
