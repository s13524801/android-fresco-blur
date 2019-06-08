# android-fresco-blur

实现网易云音乐图片高斯模糊，请更新 [fresco](https://github.com/facebook/fresco) 版本，内部已实现 [BlurPostProcessor](https://github.com/facebook/fresco/blob/master/imagepipeline/src/main/java/com/facebook/imagepipeline/postprocessors/BlurPostProcessor.java)，使用方式如下：

```java
ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(SINGER_URL))
        .setPostprocessor(new BlurPostProcessor(10, this, 1))
        .build();

PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
        .setImageRequest(request)
        .setOldController(mBlurView.getController())
        .build();

mBlurView.setController(controller);
```

<img src="/art/Screenshot_2019-05-16_blur.png" alt="预览图" title="预览图" width="280" height="480" />
