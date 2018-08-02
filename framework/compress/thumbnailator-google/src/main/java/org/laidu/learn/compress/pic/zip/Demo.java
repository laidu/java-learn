package org.laidu.learn.compress.pic.zip;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.ImageFilter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-04-28 20:02.
 */
@Slf4j
public class Demo {


    /**
     *将透明背景设置为白色
     */
    public static class ThumbnailsImgFilter implements ImageFilter {
        @Override
        public BufferedImage apply(BufferedImage img) {
            int w = img.getWidth();
            int h = img.getHeight();
            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphic = newImage.createGraphics();
            //背景设置为白色
            graphic.setColor(Color.white);
            graphic.fillRect(0, 0, w, h);
            graphic.drawRenderedImage(img, null);
            graphic.dispose();
            return newImage;
        }
    }


    public static void main(String[] args) throws IOException {


        File fromPic = new File("/Users/laidu/IdeaProjects/java-learn/framework/compress/thumbnailator-google/src/main/resources/test.png");
        File toPic = new File("/Users/laidu/IdeaProjects/java-learn/framework/compress/thumbnailator-google/src/main/resources/test112.jpg");

        Thumbnails.of(fromPic).addFilter(new ThumbnailsImgFilter())
                .scale(1f)
                .outputFormat("jpg")
                .outputQuality(0.01f)
                .toFile(toPic);

        FileOutputStream outputStream = new FileOutputStream(new File(""));
        Thumbnails.of(fromPic).scale(1f).toOutputStream(outputStream);

    }

}