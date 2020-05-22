package com.jz.appframe.db.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
/**
 * @author jackzhous
 * @package com.jz.appframe.db.room
 * @filename UserDao
 * date on 2020/5/14 2:58 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Dao
public interface UserDao {

    /**
     * 1. 基础的增删改查方法
     */
//    @Query("SELECT * FROM user")
//    List<User> queryAllUser();
//
//    @Query("SELECT * FROM user where name = :name")
//    User queryUser(String name);
//
//    @Query("SELECT * FROM user where age IN (:agx)")
//    List<User> queryUserByAges(int[] agx);
//
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insetUser(User user);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertStu(Stu user);
//
//    @Query("SELECT * FROM stu")
//    List<Stu> queryAllStu();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertUsers(List<User> users);
//
//    @Query("select * from stu inner join user on stu.id = user.id order by score asc")
//    List<InnerResult> innerQuery();
//
//    @Query("select * from user left join stu on stu.id = user.id order by score asc")
//    List<InnerResult> leftQuery();
//
//    /**
//     * 删除原理是根据主键来删除的，所以千万要保证主键正确
//     * @param user
//     */
//    @Delete
//    void deleteUser(User user);
//
//
//    @Update
//    void updateUser(User user);

    /**
     * Rxjava调用，有利于线程切换
     */
    @Query("SELECT * FROM user")
    List<User> queryAllUser();
}
