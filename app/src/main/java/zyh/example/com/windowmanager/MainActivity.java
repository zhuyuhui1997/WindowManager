package zyh.example.com.windowmanager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button mButton=new Button(this);
        mButton.setText("close the activity");
        mButton.setTextColor(Color.BLACK);
        mButton.setBackgroundColor(0x80ff0000);
        final WindowManager windowManager=(WindowManager) getSystemService(Context.WINDOW_SERVICE);
        final WindowManager.LayoutParams layoutParams=new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
        , ViewGroup.LayoutParams.WRAP_CONTENT,0,0, PixelFormat.TRANSPARENT);
        layoutParams.flags= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|WindowManager.LayoutParams
                .FLAG_SHOW_WHEN_LOCKED;
        layoutParams.gravity= Gravity.LEFT|Gravity.TOP;
        layoutParams.x=100;
        layoutParams.y=200;
        layoutParams.type= WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        windowManager.addView(mButton,layoutParams);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }
}
