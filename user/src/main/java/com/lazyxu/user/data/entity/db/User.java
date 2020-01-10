package com.lazyxu.user.data.entity.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Entity：数据库表的类，使用`tableName`定义表名
 * @PrimaryKey：主键(主键递增：PrimaryKey(autoGenerate = true))
 * @ColumnInfo(name ="id")：数据库表的列名
 * 注意：List<>不能简单使用，需要处理
 */

@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "username")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
