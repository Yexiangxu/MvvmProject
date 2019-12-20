package com.lazyxu.user.di

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.lazyxu.base.utils.AppConstants
import com.lazyxu.user.data.UserApiService
import com.lazyxu.user.data.UserRepository
import com.lazyxu.user.data.UserRepositoryImp
import com.lazyxu.user.data.db.AppDatabase
import com.lazyxu.user.data.db.AppDbHelper
import com.lazyxu.user.data.db.DbHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class UserAppModule {
    /**
     * @return UserRepository 供下面 provideUserUseCase 方法使用
     */
    @Singleton
    @Provides
    fun provideUserRepositoryImp(userRepositoryImp: UserRepositoryImp): UserRepository {
        return userRepositoryImp
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }


    /**
     * @return UserApiService 供FilmRepositoryImp中使用
     */
    @Singleton
    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }


        /**
     * @return UserUseCase 供接口调用
     */
//    @Singleton
//    @Provides
//    fun provideUserUseCase(userRepository: UserRepository): UserUseCase {
//        return UserUseCase(userRepository)
//    }

    @Provides
    @Singleton
    internal fun provideAppDataBase(application: Application): com.lazyxu.user.data.db.AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, AppConstants.DB_NAME)
                .fallbackToDestructiveMigration()//数据库的内容都被清空
                .addMigrations(MIGRATION_1_2)
                .build()
    }

    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            //此处对于数据库中的所有更新都需要写下面的代码
//            db.execSQL("ALTER TABLE Contact ADD COLUMN identity TEXT DEFAULT NULL")
//            db.execSQL("ALTER TABLE Contact ADD COLUMN isNioAuthorized INTEGER NOT NULL DEFAULT 0")
        }
    }
}


