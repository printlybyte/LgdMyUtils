package com.lgd.lgdmyutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lgd.lgdmyutilsx.loadingbutton.ActionProcessButton;
import com.lgd.lgdmyutilsx.loadingbutton.ProgressGenerator;

public class LoadingActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener{
    public static final String EXTRAS_ENDLESS_MODE = "EXTRAS_ENDLESS_MODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
//        final EditText editEmail = (EditText) findViewById(R.id.editEmail);
//        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final ActionProcessButton btnSignIn = (ActionProcessButton) findViewById(R.id.btnSignIn);
            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);//tumblr加载样式
//            btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);//直线加载样式
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSignIn);
                btnSignIn.setEnabled(false);
//                editEmail.setEnabled(false);
//                editPassword.setEnabled(false);
            }
        });
    }

    @Override
    public void onComplete() {
        Toast.makeText(this, R.string.Loading_Complete, Toast.LENGTH_LONG).show();

    }
}
