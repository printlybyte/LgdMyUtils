package com.lgd.lgdmyutilsx;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/22.
 * gradlew clean build bintrayUpload -PbintrayUser=liuguodong -PbintrayKey=d652e01d8dcbae3f8c2eb7689759926ab6ab4e1d -PdryRun=false
 */

public class SuperUtils {
    private Context mContext;

    public SuperUtils(Context context) {
        mContext = context;
    }
    /**
     *@Author: liuguodong
     *@Date: 2018/1/22 16:40
     * 普通
     */
    public  void showToastOrdinary(String msg){
        if (!TextUtils.isEmpty(msg)){
            Toast.makeText(mContext, ""+msg, Toast.LENGTH_SHORT).show();
        }
    }

}
