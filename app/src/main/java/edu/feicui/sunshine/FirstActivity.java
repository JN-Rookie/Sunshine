package edu.feicui.sunshine;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.feicui.sunshine.utils.Constants;
import edu.feicui.sunshine.utils.SpUtils;

public class FirstActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Animation mAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mImageView = (ImageView) findViewById(R.id.iv_start);
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.alpha);
        mImageView.startAnimation(mAnimation);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
