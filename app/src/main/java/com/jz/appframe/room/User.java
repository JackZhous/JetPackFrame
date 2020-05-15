package com.jz.appframe.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author jackzhous
 * @package com.jz.appframe.room
 * @filename User
 * date on 2020/5/14 2:58 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "name")
    String name;

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
