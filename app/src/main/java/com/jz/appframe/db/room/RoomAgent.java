package com.jz.appframe.db.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author jackzhous
 * @package com.jz.appframe.db.room
 * @filename RoomAgent
 * date on 2020/5/14 2:55 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Database(entities = User.class, version = 1)
public abstract class RoomAgent extends RoomDatabase {
    public abstract UserDao userDao();


    private static RoomAgent agent;

    public static RoomAgent getInstance(Context context){
        if(agent == null){
            agent = Room.databaseBuilder(context, RoomAgent.class, "db")
//                        .addMigrations()
                        .build();
        }

        return agent;
    }

    /**
     * 数据库表结构变化，这里是注明表结构发生了怎么样的变化
     */
//    static final Migration migration1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("alter table user add column uid int not null default 0");
//        }
//    };
//
//    static final Migration migration2_3 = new Migration(2, 3) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("CREATE TABLE stu (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `score` INTEGER NOT NULL)");
//        }
//    };
//
//    static final Migration migration3_4 = new Migration(3, 4) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("insert into stu(name, score) values ('hhhh', 100)");
//            database.execSQL("insert into stu(name, score) values ('mumu', 99)");
//            database.execSQL("insert into stu(name, score) values ('aaaa', 10)");
//            database.execSQL("insert into stu(name, score) values ('bbbb', 40)");
//        }
//    };
}
