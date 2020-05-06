package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import org.json.*;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class MainActivity extends AppCompatActivity {

    JSONArray JArray = new JSONArray();
    JSONObject Jobject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //若需要權限，ask
        if (shouldAskPermissions()) {
            askPermissions();
        }

        getSupportActionBar().hide(); //隱藏title
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //隱藏title
        setContentView(R.layout.activity_main);


    }

    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    //動態詢問
    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }

    /**
     * 選手
     *
     *
     */
    public void person1(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發一");


    }

    public void person2(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發二");

    }

    public void person3(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發三");

    }

    public void person4(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發四");

    }

    public void person5(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發五");

    }

    public void person6(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "先發六");

    }

    public void person7(View v) throws JSONException {

        Jobject = new JSONObject();
        Jobject.put("person", "候補一");

    }


    public void finish(View v) throws  IOException {

        getString(JArray.toString());
        //Jobject.put("person", "候補二");

    }

    /**
     * 動作
     *
     *
     */

    public void action1(View v) throws JSONException {

        Jobject.put("action", "發球");

    }

    public void action2(View v) throws JSONException {

        Jobject.put("action", "接球");

    }


    public void action3(View v) throws JSONException {

        Jobject.put("action", "舉球");

    }

    public void action4(View v) throws JSONException {

        Jobject.put("action", "處理");

    }

    public void action5(View v) throws JSONException {

        Jobject.put("action", "吊球");

    }

    public void action6(View v) throws JSONException {

        Jobject.put("action", "扣球");

    }

    public void action7(View v) throws JSONException {

        Jobject.put("action", "攔網");

    }

    public void action8(View v) throws JSONException {

        Jobject.put("action", "其他");

    }

    /**
     * 結果
     *
     *
     */
    public void point1(View v) throws JSONException, IOException {

        Jobject.put("point", "得分");

        JArray.put(Jobject);


        Log.e("JsonArray給我出來", JArray.toString());
    }


    public void point2(View v) throws JSONException, IOException {


        Jobject.put("point", "失分");

        JArray.put(Jobject);


        Log.e("JsonArray給我出來", JArray.toString());
    }


    public void point3(View v) throws JSONException, IOException {

        Jobject.put("point", "失誤得分");

        JArray.put(Jobject);


        Log.e("JsonArray給我出來", JArray.toString());
    }


    public void point4(View v) throws JSONException, IOException {

        Jobject.put("point", "成功");

        JArray.put(Jobject);


        Log.e("JsonArray給我出來", JArray.toString());
    }


    public void point5(View v) throws JSONException, IOException {

        Jobject.put("point", "失誤");

        JArray.put(Jobject);


        Log.e("JsonArray給我出來", JArray.toString());
    }

    public void point6(View v) throws JSONException, IOException {

        Jobject.put("point", "無效");

        JArray.put(Jobject);

        Log.e("JsonArray給我出來", JArray.toString());
    }






    public void getString(String array) throws IOException {

        try {
            // FileOutputStream test = this.openFileOutput("test.json", Context.MODE_APPEND);


            //String path = Environment.getExternalStorageDirectory().getPath();
            //File hi = new File(path + "/" + "test11.json");

            String path = "/sdcard/DCIM/test.json";
            //寫檔
            File hi = new File(path);
            FileOutputStream test = new FileOutputStream(hi);
            test.write(array.getBytes());

            test.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
