package com.mylivingtrip.app.activity.filterroundtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.mylivingtrip.app.R;

public class DemoActivity extends AppCompatActivity {


    Button mCloseButton;
    Button mOpenButton;
    MultiDirectionSlidingDrawer mDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_demo);

        mCloseButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                mDrawer.animateClose();
            }
        });

        mOpenButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v )
            {
                if( !mDrawer.isOpened() )
                    mDrawer.animateOpen();
            }
        });
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onContentChanged()
    {
        super.onContentChanged();
        mCloseButton = (Button) findViewById( R.id.button_open );
        mOpenButton = (Button) findViewById( R.id.button_open );
        mDrawer =  findViewById( R.id.drawer );
    }
}
