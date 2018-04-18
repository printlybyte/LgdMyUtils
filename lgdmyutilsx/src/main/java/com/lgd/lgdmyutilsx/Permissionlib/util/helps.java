package com.lgd.lgdmyutilsx.Permissionlib.util;

/**
 * Created by Administrator on 2018/4/18.
 *
 *
 *
 *
 *
 */
//import android.Manifest;
//import android.app.AlertDialog;
//import android.app.Service;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//import java.util.Arrays;
//import java.util.List;
//
//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:gravity="center_horizontal"
//        android:orientation="vertical">
//
//<TextView
//        android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_marginTop="20dp"
//                android:text="在Activity中申请权限"
//                android:textSize="18dp" />
//
//<LinearLayout
//        android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:orientation="horizontal">
//
//<Button
//            android:id="@+id/btn_click1"
//                    android:layout_width="0dp"
//                    android:layout_height="wrap_content"
//                    android:layout_margin="10dp"
//                    android:layout_marginTop="20dp"
//                    android:layout_weight="1"
//                    android:text="申请单个权限" />
//
//<Button
//            android:id="@+id/btn_click"
//                    android:layout_width="0dp"
//                    android:layout_height="wrap_content"
//                    android:layout_margin="10dp"
//                    android:layout_marginTop="20dp"
//                    android:layout_weight="1"
//                    android:text="申请多个权限" />
//</LinearLayout>
//
//<TextView
//        android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_marginTop="20dp"
//                android:text="在Service中申请权限"
//                android:textSize="18dp" />
//
//<Button
//        android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_margin="10dp"
//                android:layout_marginTop="20dp"
//                android:onClick="startPermissionService"
//                android:text="启动Service" />
//
//<TextView
//        android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_marginTop="20dp"
//                android:text="在Fragment中申请权限"
//                android:textSize="18dp" />
//
//<FrameLayout
//        android:id="@+id/fl_container"
//                android:layout_width="match_parent"
//                android:layout_height="0dp"
//                android:layout_weight="1" />
//
//
//</LinearLayout>
//
//
//
//
//
//
//        package com.ninetripods.aopermission;
//
//import android.Manifest;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.ninetripods.aopermission.permissionlib.annotation.NeedPermission;
//import com.ninetripods.aopermission.permissionlib.annotation.PermissionCanceled;
//import com.ninetripods.aopermission.permissionlib.annotation.PermissionDenied;
//import com.ninetripods.aopermission.permissionlib.bean.CancelBean;
//import com.ninetripods.aopermission.permissionlib.bean.DenyBean;
//import com.ninetripods.aopermission.permissionlib.util.SettingUtil;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button btn_click;
//    private Button btn_click1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initViews();
//        initEvents();
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fl_container, new PermissionFragment());
//        transaction.commitAllowingStateLoss();
//    }
//
//    private void initViews() {
//        btn_click = (Button) findViewById(R.id.btn_click);
//        btn_click1 = (Button) findViewById(R.id.btn_click1);
//    }
//
//
//    private void initEvents() {
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callPhone();
//            }
//        });
//        btn_click1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callMap();
//            }
//        });
//    }
//
//    /**
//     * 申请多个权限
//     */
//    @NeedPermission(value = {Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA}, requestCode = 10)
//    public void callPhone() {
//        Toast.makeText(this, "电话、相机权限申请通过", Toast.LENGTH_SHORT).show();
//    }
//
//    /**
//     * 申请单个权限
//     */
//    @NeedPermission(value = {Manifest.permission.ACCESS_FINE_LOCATION}, requestCode = 0)
//    private void callMap() {
//        Toast.makeText(this, "定位权限申请通过", Toast.LENGTH_SHORT).show();
//    }
//
//    /**
//     * 权限被拒绝
//     *
//     * @param bean DenyBean
//     */
//    @PermissionDenied
//    public void dealPermission(DenyBean bean) {
//        if (bean == null) return;
//        Toast.makeText(this, "requestCode:" + bean.getRequestCode()
//                + ",Permissions: " + Arrays.toString(bean.getDenyList().toArray()), Toast.LENGTH_SHORT).show();
//        List<String> denyList = bean.getDenyList();
//        switch (bean.getRequestCode()) {
//            case 10:
//                //多个权限申请返回结果
//                StringBuilder builder = new StringBuilder();
//                for (int i = 0; i < denyList.size(); i++) {
//                    if (Manifest.permission.CALL_PHONE.equals(denyList.get(i))) {
//                        builder.append("电话");
//                    } else if (Manifest.permission.CAMERA.equals(denyList.get(i))) {
//                        builder.append("相机");
//                    }
//                }
//                builder.append("权限被禁止，需要手动打开");
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage(builder)
//                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                                SettingUtil.go2Setting(MainActivity.this);
//                            }
//                        })
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .create().show();
//
//                break;
//            case 0:
//                //单个权限申请返回结果
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("定位权限被禁止，需要手动打开")
//                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                                SettingUtil.go2Setting(MainActivity.this);
//                            }
//                        })
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .create().show();
//                break;
//            default:
//                break;
//        }
//    }
//
//    /**
//     * 权限被取消
//     *
//     * @param bean CancelBean
//     */
//    @PermissionCanceled
//    public void dealCancelPermission(CancelBean bean) {
//        Toast.makeText(this, "requestCode:" + bean.getRequestCode(), Toast.LENGTH_SHORT).show();
//    }
//
//    /**
//     * 在Service中申请权限
//     *
//     * @param view
//     */
//    public void startPermissionService(View view) {
//        Intent intent = new Intent(this, PermissionService.class);
//        startService(intent);
//    }
//
//}
//
//
//
//
//
//
//
//package com.ninetripods.aopermission;
//
//        import android.Manifest;
//        import android.app.AlertDialog;
//        import android.content.DialogInterface;
//        import android.os.Bundle;
//        import android.support.annotation.Nullable;
//        import android.support.v4.app.Fragment;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.Toast;
//
//        import com.ninetripods.aopermission.permissionlib.annotation.NeedPermission;
//        import com.ninetripods.aopermission.permissionlib.annotation.PermissionCanceled;
//        import com.ninetripods.aopermission.permissionlib.annotation.PermissionDenied;
//        import com.ninetripods.aopermission.permissionlib.bean.CancelBean;
//        import com.ninetripods.aopermission.permissionlib.bean.DenyBean;
//        import com.ninetripods.aopermission.permissionlib.util.SettingUtil;
//
//
//public class PermissionFragment extends Fragment {
//
//    private Button btn_permission;
//
//    public PermissionFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_permission, container, false);
//        btn_permission = (Button) view.findViewById(R.id.btn_permission);
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        btn_permission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestPermission();
//            }
//        });
//    }
//
//    @NeedPermission(value = {Manifest.permission.CALL_PHONE})
//    private void requestPermission() {
//        Toast.makeText(getActivity(), "电话权限申请通过", Toast.LENGTH_SHORT).show();
//    }
//
//    @PermissionDenied
//    public void dealDenyPermission(DenyBean bean) {
//        Toast.makeText(getActivity(), "电话权限申请被禁止", Toast.LENGTH_SHORT).show();
//        new AlertDialog.Builder(getActivity())
//                .setTitle("提示")
//                .setMessage("电话权限被禁止，需要手动打开")
//                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        SettingUtil.go2Setting(getActivity());
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .create().show();
//    }
//
//    @PermissionCanceled
//    public void dealCancelPermission(CancelBean bean) {
//        Toast.makeText(getActivity(), "电话权限申请被取消", Toast.LENGTH_SHORT).show();
//    }
//}
//
//
//
//
//
//
//
//
//
//package com.ninetripods.aopermission;
//
//        import android.Manifest;
//        import android.app.Service;
//        import android.content.Intent;
//        import android.os.Handler;
//        import android.os.IBinder;
//        import android.widget.Toast;
//
//        import com.ninetripods.aopermission.permissionlib.annotation.NeedPermission;
//        import com.ninetripods.aopermission.permissionlib.annotation.PermissionCanceled;
//        import com.ninetripods.aopermission.permissionlib.annotation.PermissionDenied;
//        import com.ninetripods.aopermission.permissionlib.bean.CancelBean;
//        import com.ninetripods.aopermission.permissionlib.bean.DenyBean;
//        import com.ninetripods.aopermission.permissionlib.util.SettingUtil;
//
//
//public class PermissionService extends Service {
//
//    public PermissionService() {
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                requestCamera();
//            }
//        }, 500);
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @NeedPermission(value = {Manifest.permission.CAMERA})
//    private void requestCamera() {
//        Toast.makeText(PermissionService.this, "相机权限已经被同意", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @PermissionDenied
//    public void deniedCallBack(DenyBean bean) {
//        Toast.makeText(PermissionService.this, "相机权限已经被禁止", Toast.LENGTH_SHORT).show();
//        SettingUtil.go2Setting(PermissionService.this);
//    }
//
//    @PermissionCanceled
//    public void canceledCallBack(CancelBean bean) {
//        Toast.makeText(PermissionService.this, "相机权限已经被取消", Toast.LENGTH_SHORT).show();
//    }
//}











//<?xml version="1.0" encoding="utf-8"?>
//<manifest xmlns:android="http://schemas.android.com/apk/res/android"
//        package="com.ninetripods.aopermission">
//
//<uses-permission android:name="android.permission.CALL_PHONE" />
//<uses-permission android:name="android.permission.CAMERA" />
//<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
//
//<application
//        android:allowBackup="true"
//                android:icon="@mipmap/ic_launcher"
//                android:label="@string/app_name"
//                android:roundIcon="@mipmap/ic_launcher_round"
//                android:supportsRtl="true"
//                android:theme="@style/AppTheme">
//<activity android:name=".MainActivity">
//<intent-filter>
//<action android:name="android.intent.action.MAIN" />
//
//<category android:name="android.intent.category.LAUNCHER" />
//</intent-filter>
//</activity>
//
//<service
//            android:name=".PermissionService"
//                    android:enabled="true"
//                    android:exported="true"/>
//</application>
//
//</manifest>
public class helps {
}

