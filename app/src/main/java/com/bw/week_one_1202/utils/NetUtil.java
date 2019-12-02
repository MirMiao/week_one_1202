package com.bw.week_one_1202.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * 时间 :2019/12/2  9:03
 * 作者 :苗恒
 * 功能 :
 */
public class NetUtil {
    private static NetUtil netUtil=new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }
    //获取json
      @SuppressLint("StaticFieldLeak")
      public void getJson(final String httpUrl, final MyCallBack myCallBack){
         new AsyncTask<Void, Void, String>() {
             @Override
             protected void onPostExecute(String s) {
                 myCallBack.getjsonData(s);
                 Log.i("xxx",s);
             }

             @Override
             protected String doInBackground(Void... voids) {
                 String json="";
                 InputStream inputStream=null;
                 try {
                     URL url = new URL(httpUrl);
                     HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setRequestMethod("GET");
                     httpURLConnection.setReadTimeout(5000);
                     httpURLConnection.setConnectTimeout(5000);
                     httpURLConnection.connect();
                     Log.i("TAG",httpURLConnection.getResponseCode()+"");
                     if(httpURLConnection.getResponseCode()==200){
                          inputStream = httpURLConnection.getInputStream();
                         int len=-1;
                         byte[] bytes = new byte[1024];
                         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                          while ((len=inputStream.read(bytes))!=-1){
                             outputStream.write(bytes,0,len);
                          }
                         byte[] bytes1 = outputStream.toByteArray();
                          json = new String(bytes1);
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }finally {
                     if (inputStream != null) {
                         try {
                             inputStream.close();
                         } catch (IOException e) {

                         }
                     }
                 }
                 return json;
             }
         }.execute();
      }
      public interface MyCallBack{
        void getjsonData(String json);
      }
      @SuppressLint("StaticFieldLeak")
      public void getPhoto(final String httpUrl, final ImageView imageView){
           new AsyncTask<Void, Void, Bitmap>() {
               @Override
               protected void onPostExecute(Bitmap bitmap) {
                   imageView.setImageBitmap(bitmap);
               }
               @Override
               protected Bitmap doInBackground(Void... voids) {
                   Bitmap bitmap=null;
                   try {
                       URL url = new URL(httpUrl);
                       HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                       httpURLConnection.setRequestMethod("GET");
                       httpURLConnection.setReadTimeout(5000);
                       httpURLConnection.setConnectTimeout(5000);
                       httpURLConnection.connect();
                       if(httpURLConnection.getResponseCode()==200){
                           InputStream inputStream = httpURLConnection.getInputStream();
                            bitmap = BitmapFactory.decodeStream(inputStream);
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   return bitmap;
               }
           }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
