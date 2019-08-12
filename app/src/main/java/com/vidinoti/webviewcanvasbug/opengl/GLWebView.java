package com.vidinoti.webviewcanvasbug.opengl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.webkit.WebView;

public class GLWebView extends WebView {

    private ViewToGLRenderer mViewToGLRenderer;

    // default constructors

    public GLWebView(Context context) {
        super(context);
        init();
    }

    public GLWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GLWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
    }


    @Override
    public void onDraw(Canvas canvas) {
        //returns canvas attached to gl texture to draw on
        Canvas glAttachedCanvas = mViewToGLRenderer.onDrawViewBegin();
        if (glAttachedCanvas != null) {
            //translate canvas to reflect view scrolling
            float xScale = glAttachedCanvas.getWidth() / (float) canvas.getWidth();
            glAttachedCanvas.scale(xScale, xScale);
            glAttachedCanvas.translate(-getScrollX(), -getScrollY());
            //draw the view to provided canvas
            super.onDraw(glAttachedCanvas);
        }
        // notify the canvas is updated
        mViewToGLRenderer.onDrawViewEnd();
    }

    public void setViewToGLRenderer(ViewToGLRenderer viewTOGLRenderer) {
        mViewToGLRenderer = viewTOGLRenderer;
    }
}
