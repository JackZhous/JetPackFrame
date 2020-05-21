package com.jz.appframe.db.adapter;

import com.jz.appframe.db.resp.ApiResponse;

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
public class LivedataCallAdapter<T> implements CallAdapter<T, LiveData<ApiResponse<T>>> {

    private Type responseType;

    public LivedataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<ApiResponse<T>> adapt(final Call<T> call) {

        return new LiveData<ApiResponse<T>>() {
            private AtomicBoolean stat = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                if(stat.compareAndSet(false, true)){
                    call.enqueue(new Callback<T>() {
                        @Override
                        public void onResponse(Call<T> call, Response<T> response) {
                            postValue(ApiResponse.Companion.<T>create(response));
                        }

                        @Override
                        public void onFailure(Call<T> call, Throwable t) {
                            postValue(ApiResponse.Companion.<T>create(t));
                        }
                    });
                }
            }
        };
    }
}
