package com.jz.appframe.db.adapter;


import com.jz.appframe.db.resp.JResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author jackzhous
 * @package com.jz.appframe.db
 * @filename LiveDataCallAdapterFactory
 * date on 2020/5/18 10:51 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if(getRawType(returnType) != LiveData.class){
            return null;
        }
        Type type = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class rawType = getRawType(type);
        if(rawType != JResponse.class){
            throw new IllegalArgumentException("type must be a resource");
        }

        if(!(type instanceof ParameterizedType)){
            throw new IllegalArgumentException("resource must be paramterized");
        }
        type = getParameterUpperBound(0, (ParameterizedType) type);
        return new LivedataCallAdapter<Object>(type);
    }
}
