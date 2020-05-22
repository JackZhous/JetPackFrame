package com.jz.appframe.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ViewModelKey
 * date on 2020/5/22 7:08 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@MustBeDocumented
@Target(
        ElementType.METHOD
)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
