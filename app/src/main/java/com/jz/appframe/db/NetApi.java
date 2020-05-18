package com.jz.appframe.db;

import android.os.Debug;

import com.jz.appframe.BuildConfig;
import com.jz.appframe.db.req.Request;
import com.jz.appframe.db.resp.Response;

import androidx.lifecycle.LiveData;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * @author jackzhous
 * @package com.jz.appframe.db
 * @filename NetApi
 * date on 2020/5/18 9:36 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface NetApi {

    @GET("test/login")
    LiveData<Response> test(Request request);


    final class Factory{
        static Retrofit  agent;

        public static Retrofit create(){
            if(agent == null){
                String url = BuildConfig.SERVER;
                agent =  new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                            .build();
            }

            return agent;
        }
    }
}
