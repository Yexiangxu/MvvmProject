package com.lazyxu.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import static android.graphics.Color.WHITE;

/**
 * SurfaceView的工作方式是创建一个置于应用窗口之后的新窗口
 * 为什么使用 SurfaceView
 * 1.如果屏幕刷新频繁，onDraw方法会被频繁调用，会导致掉帧、页面卡顿。而SurfaceView采用了双缓冲技术，提高了绘制的速度，可以缓解这一现象。
 * 2.view的onDraw是运行在主线程中，会轻微阻塞主线程，对于需要频繁刷新页面的场景，会导致主线程阻塞，用户事件的响应速度下降，影响了用户的体验。而SurfaceView可以在自线程中更新UI，不会阻塞主线程，提高了响应速度。
 *
 * @Override public void onWindowFocusChanged(boolean hasFocus) {
 * super.onWindowFocusChanged(hasFocus);
 * if (hasFocus) {
 * for (int i = 0; i < mPaths.length - 1; i++) {
 * //这里跟assets/logo目录强依赖
 * mPaths[i] = String.format("%s/anim_splash%s.png", "logo", i + 1);
 * }
 * new Handler().postDelayed(new Runnable() {
 * @Override public void run() {
 * ppv.start(mPaths, ANIMI_TIME);
 * <p>
 * }
 * }, 1500);
 * }
 * }
 */
public class SplashPlayerView extends SurfaceView implements SurfaceHolder.Callback {
    // 用于控制SurfaceView
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private int mPlayFrame;
    private String[] mPaths;
    private int mFrameCount;
    //播放帧间隔
    private long mDelayTime;
    private PlayThread mPlayThread;
    private Paint paint = new Paint();
    private int size = 150;

    private OnPlayerListener mOnPlayerListener;

    public SplashPlayerView(Context context) {
        this(context, null);
    }

    public SplashPlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashPlayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.setFormat(PixelFormat.TRANSLUCENT);//设置背景透明
        setZOrderOnTop(true);
        mHolder.addCallback(this);
        paint = new Paint();
        paint.setColor(WHITE);
        paint.setStyle(Paint.Style.FILL);
        //创建画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setAntiAlias(true);
    }


    /**
     * 开始播放
     *
     * @param paths    动画文件
     * @param duration 动画总时长
     */
    public void start(String[] paths, long duration) {
        this.mPaths = paths;
        this.mFrameCount = paths.length;
        this.mDelayTime = duration / mFrameCount;
        //开启线程
        mPlayThread = new PlayThread();
        mPlayThread.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mPlayFrame = mFrameCount;
        try {
            if (mPlayThread != null) {
                mPlayThread.join();//等待thread执行完
            }
        } catch (InterruptedException e) {
            Log.e("PicturePlayerView", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private class PlayThread extends Thread {
        @Override
        public void run() {
            try {
                //如果还没有播放完所有帧
                while (mPlayFrame < mFrameCount) {
                    Bitmap bitmap = scaleImage(readBitmap(mPaths[mPlayFrame]), size, size);
                    drawBitmap(bitmap);
                    recycleBitmap(bitmap);
                    mPlayFrame++;
                    if (mPlayFrame == 1 && mOnPlayerListener != null) {
                        mOnPlayerListener.onFirstFrame();
                    }
                    //暂停间隔时间
                    SystemClock.sleep(mDelayTime);
                }
                if (mOnPlayerListener != null) {
                    mOnPlayerListener.onCompletePlay();
                }
            } catch (Exception e) {
                Log.e("PicturePlayerView", e.getMessage());
            }
        }
    }

    /**
     * 使用该图片解码方式速度较快
     */
    private Bitmap readBitmap(String path) throws IOException {
        return BitmapFactory.decodeStream(getResources().getAssets().open(path));
    }

    /**
     * 按新的宽高缩放图片
     */
    public static Bitmap scaleImage(Bitmap bm, int newWidth, int newHeight) {
        if (bm == null) {
            return null;
        }
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        if (!bm.isRecycled()) {
            bm.recycle();
        }
        return newbm;
    }

    /**
     * 3. 使用SurfaceView（使用SurfaceView又分为三步）
     * 1). SurfaceHolder.lockCanvas() 获得Canvas对象
     * 2). 在子线程中用 Canvas 进行绘制
     * 3). SurfaceHolder.unlockCanvasAndPost()将画布内容进行提交
     */

    private void drawBitmap(Bitmap bitmap) {
        Canvas canvas = mHolder.lockCanvas();//锁定画布
        // 清空画布
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        canvas.drawRect(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), paint);
        //将bitmap画到画布上
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        //解锁画布同时提交
        mHolder.unlockCanvasAndPost(canvas);
    }

    private static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public interface OnPlayerListener {
        void onFirstFrame();

        void onCompletePlay();
    }

    public OnPlayerListener getOnPlayerListener() {
        return mOnPlayerListener;
    }

    public void setOnPlayerListener(OnPlayerListener onPlayerListener) {
        mOnPlayerListener = onPlayerListener;
    }
}
