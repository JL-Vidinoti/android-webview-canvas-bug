package com.vidinoti.webviewcanvasbug.opengl;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.vidinoti.webviewcanvasbug.R;
import com.vidinoti.webviewcanvasbug.opengl.renderer.CubeGLRenderer;

public class WebViewToOpenGLActivity extends AppCompatActivity {

    private GLSurfaceView mGLSurfaceView;
    private GLWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview2opengl);

        ViewToGLRenderer viewToGlRenderer = new CubeGLRenderer(this);

        mGLSurfaceView = findViewById(R.id.gl_surface_view);
        mWebView = findViewById(R.id.web_view);

        mGLSurfaceView.setEGLContextClientVersion(2);
        mGLSurfaceView.setRenderer(viewToGlRenderer);

        mWebView.setViewToGLRenderer(viewToGlRenderer);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("http://static.vidinoti.com/clock/");
    }
}
