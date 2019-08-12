package com.vidinoti.webviewcanvasbug;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.vidinoti.webviewcanvasbug.bitmap.WebViewToBitmapActivity;
import com.vidinoti.webviewcanvasbug.opengl.WebViewToOpenGLActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the demo where the webview is rendered to a Bitmap (ImageView)
        findViewById(R.id.webViewToBitmapButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebViewToBitmapActivity.class));
            }
        });

        // Start the demo where the webview is rendered to an OpenGL texture
        findViewById(R.id.webViewToOpenGlButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebViewToOpenGLActivity.class));
            }
        });
    }
}
