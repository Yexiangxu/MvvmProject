package com.lazyxu.base.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * User: xuyexiang
 * Date: 2019/06/12
 * Description:
 * FIXME 同时保存多个值最好最后统一apply
 */
public class SpUtilDelete {
    private static final String DEFAULT_STRING_VALUE = "";
    private static final int DEFAULT_INT_VALUE = -1;
    private static final double DEFAULT_DOUBLE_VALUE = -1d;
    private static final float DEFAULT_FLOAT_VALUE = -1f;
    private static final long DEFAULT_LONG_VALUE = -1L;
    private static final boolean DEFAULT_BOOLEAN_VALUE = false;

    private static Application mApplication;
    private volatile static SharedPreferences sharedPreferences;

    public static void init(Application application) {
        mApplication = application;
        if (sharedPreferences == null) {
            synchronized (SpUtilDelete.class) {
                if (sharedPreferences == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
                }
            }
        }
    }

    public static void put(String key, Object value) {
        Logger.i("statictest=方法");
        if (sharedPreferences == null) {
            throw (new NullPointerException("SpUtil必须在application中进行init初始化"));
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        editor.apply();
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, DEFAULT_STRING_VALUE);
    }

    public static String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public static int getInt(String key) {
        return sharedPreferences.getInt(key, DEFAULT_INT_VALUE);
    }


    public static int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public static double getDouble(String key) {
        if (!contains(key)) {
            return DEFAULT_DOUBLE_VALUE;
        }
        return Double.longBitsToDouble(getLong(key));
    }

    public static double getDouble(String key, double defaultValue) {
        if (!contains(key)) {
            return defaultValue;
        }
        return Double.longBitsToDouble(getLong(key));
    }

    public static float getFloat(String key) {
        return sharedPreferences.getFloat(key, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public static long getLong(String key) {
        return sharedPreferences.getLong(key, DEFAULT_LONG_VALUE);
    }

    public static long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN_VALUE);
    }

    public static boolean getBoolean(String what, boolean defaultBoolean) {
        return sharedPreferences.getBoolean(what, defaultBoolean);
    }

    public  static void remove(String... keys) {
        if (keys != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            for (String key : keys) {
                editor.remove(key);
            }
            editor.apply();
        }
    }

    public static void clear() {
        sharedPreferences.edit().clear().apply();
    }

    /**
     * 保存对象
     */
    public static boolean putObject(String key, Serializable ser) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = mApplication.openFileOutput(key, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ser);
            oos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public static void deleteObject(String key) {
        String filePath = mApplication.getFilesDir().getPath() + "/" + key;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 读取对象
     */
    public static Serializable getObject(String key) {
        if (!isExistDataCache(key)) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = mApplication.openFileInput(key);
            ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
            // 反序列化失败 - 删除缓存文件
            if (e instanceof InvalidClassException) {
                File data = mApplication.getFileStreamPath(key);
                data.delete();
            }
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * 判断缓存是否存在
     */
    public static boolean isExistDataCache(String key) {
        if (mApplication == null) {
            return false;
        }
        boolean exist = false;
        File data = mApplication.getFileStreamPath(key);
        if (data.exists()) {
            exist = true;
        }
        return exist;
    }

    private static boolean contains(final String key) {
        return sharedPreferences.contains(key);
    }
}

