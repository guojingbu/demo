package com.jingbu.androidutils;

import android.os.Environment;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadUtils {
    private static final String TAG = "DownLoadUtils";
    private OkHttpClient mOkHttpClient;
    private static LoadUtils instance;

    private LoadUtils() {
        mOkHttpClient = new OkHttpClient();
    }

    public static LoadUtils getInstance() {
        if (instance == null) {
            instance = new LoadUtils();
        }
        return instance;
    }

    public void donwnloadFile(String url, final DownloadCallback callback) {
        Request request = new Request.Builder().url(url).addHeader("Accept-Encoding", "identity").build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @SuppressWarnings("resource")
            @Override
            public void onResponse(Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    is = response.body().byteStream();
                    long current = 0;
                    long total = response.body().contentLength();
                    LogUtils.i("guojingbu", "数据大小：total = " + total);
                    File file = new File(SDPath, "test.txt");
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        current += len;
                        fos.write(buf, 0, len);
                        callback.onprogress(total, current);
                    }
                    fos.flush();
                    callback.onSuccess(file);
                    LogUtils.i("guojingbu", "文件下载成功");
                } catch (Exception e) {
                    callback.onFailure(e);
                    LogUtils.i("guojingbu", "文件下载失败");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(e);
                LogUtils.i("guojingbu", "onFailure");
            }
        });
    }

    public interface DownloadCallback {

        void onSuccess(File file);

        void onFailure(Exception e);

        void onprogress(long total, long current);
    }

    public static String readInputStream(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            is.close();
            baos.close();
            // 或者用这种方法
            byte[] result = baos.toByteArray();
            // return new String(result);
            return new String(result, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return "获取失败";
        }
    }
}
