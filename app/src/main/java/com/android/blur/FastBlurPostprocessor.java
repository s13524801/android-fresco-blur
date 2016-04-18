package com.android.blur;

import android.graphics.Bitmap;

import com.enrique.stackblur.NativeBlurProcess;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class FastBlurPostprocessor extends BasePostprocessor {
	
    private float mRadius;
    
    public FastBlurPostprocessor(float blurRadius) {
        this.mRadius = blurRadius;
    }

    public void process(Bitmap bitmap) {
    	try {
            bitmap.setHasAlpha(true);
    		NativeBlurProcess blur = new NativeBlurProcess();
    		blur.blur(bitmap, mRadius);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public String getName() {
        return "FastBlurPostprocessor";
    }
}