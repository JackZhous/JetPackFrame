package com.jz.appframe.model;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.model.base.BaseVModel;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

/**
 * @author jackzhous
 * @package com.jz.appframe.model
 * @filename UserViewModel
 * date on 2020/5/14 4:19 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class UserViewModel extends BaseVModel {
    @Inject
    public UserViewModel(@NotNull NetApi api) {
        super(api);
    }
}
