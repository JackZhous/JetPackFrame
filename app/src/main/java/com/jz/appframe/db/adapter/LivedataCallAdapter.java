package com.jz.appframe.db.adapter;


import android.text.TextUtils;

import com.jz.appframe.db.resp.ApiErrorResponse;
import com.jz.appframe.db.resp.JResponse;
import com.jz.appframe.util.AppConfig;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author jackzhous
 * @package com.jz.appframe.db
 * @filename LivedataCallAdapter
 * date on 2020/5/18 11:08 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LivedataCallAdapter<T> implements CallAdapter<JResponse<T>, LiveData<JResponse<T>>> {

    private Type responseType;

    public LivedataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<JResponse<T>> adapt(final Call<JResponse<T>> call) {

        return new LiveData<JResponse<T>>() {
            private AtomicBoolean stat = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                if(stat.compareAndSet(false, true)){
                    call.enqueue(new Callback<JResponse<T>>() {
                        @Override
                        public void onResponse(Call<JResponse<T>> call, Response<JResponse<T>> response) {
                            if(response.isSuccessful()){
                                if(response.body().getCode() == AppConfig.WEB_SUCCESS){
                                    postValue(response.body());
                                    return;
                                }
                                throw new ApiErrorResponse(response.body().getCode(), response.body().getMessage());

                            }
                            throw new ApiErrorResponse(response.code(), response.message() );
                        }

                        @Override
                        public void onFailure(Call<JResponse<T>> call, Throwable t) {
                            throw new ApiErrorResponse(-1, TextUtils.isEmpty(t.getMessage()) ? "unknown http error" : t.getMessage());
                        }
                    });
                }
            }
        };
    }
}
