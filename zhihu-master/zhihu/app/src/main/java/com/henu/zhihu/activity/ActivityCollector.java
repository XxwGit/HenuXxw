package com.henu.zhihu.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 随大大 on 2017/4/23.
 */

public class ActivityCollector {

    public static List<Activity> activityList = new ArrayList<>();
    public static void addActivity(Activity activity){
        activityList.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAll(){
        for (Activity item:activityList) {
             if (!item.isFinishing()){
                 item.finish();
             }
        }
    }
}
