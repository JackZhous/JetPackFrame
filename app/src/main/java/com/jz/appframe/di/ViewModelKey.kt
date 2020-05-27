package com.jz.appframe.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @package com.jz.appframe.di
 * @filename ViewModelKey
 * date on 2020/5/27 11:46 AM
 * @author jackzhous
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@MustBeDocumented
@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)