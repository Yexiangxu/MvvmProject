package com.lazyxu.user.data.db;

import com.lazyxu.user.data.entity.db.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * User: Lazy_xu
 * Data: 2019/08/06
 * Description:
 * FIXME
 */
public interface DbHelper {
    Observable<Boolean> insertUser(User user);
    Observable<User> queryUser();
}
