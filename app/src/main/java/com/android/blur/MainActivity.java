package com.android.blur;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String SINGER_URL = "http://qukufile2.qianqian.com/data2/pic/f2026fa3d8bfdf502831207b2ba29769/264243117/264243117.jpg";

    private SimpleDraweeView mBlurView;
    private SimpleDraweeView mSingerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFresco();

        setContentView(R.layout.activity_main);

        mBlurView = findViewById(R.id.background_view);
        mSingerView = findViewById(R.id.singer_view);

        mSingerView.setImageURI(Uri.parse(SINGER_URL));

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(SINGER_URL))
                .setPostprocessor(new BlurPostProcessor(10, this, 1))
                .build();

        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setImageRequest(request)
                .setOldController(mBlurView.getController())
                .build();

        mBlurView.setController(controller);
    }

    private void initFresco() {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setBitmapsConfig(Bitmap.Config.ARGB_8888)
                .build();
        Fresco.initialize(this, config);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Fresco.shutDown();
    }
}
