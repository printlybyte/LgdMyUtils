package com.lgd.lgdmyutilsx;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/22.
 * gradlew clean build bintrayUpload -PbintrayUser=liuguodong -PbintrayKey= -PdryRun=false
 */

public class SuperUtils {
    private Context mContext;

    public SuperUtils(Context context) {
        mContext = context;
    }

    public  void showToastOrdinary(String msg){
        if (!TextUtils.isEmpty(msg)){
            Toast.makeText(mContext, ""+msg, Toast.LENGTH_SHORT).show();
        }
    }

}
