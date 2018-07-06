package cs1302.p2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import cs1302.effects.Artsy;


public class MyArtsy implements Artsy {

    @Override
    public BufferedImage doCheckers(BufferedImage src1, BufferedImage src2, int size) {
	return src1;
    } // doCheckers

    @Override
    public BufferedImage doHorizontalStripes(BufferedImage src1, BufferedImage src2, int height) {
      System.out.println("in doHorizontal");
      BufferedImage a = src1;
      BufferedImage b = src2;
      BufferedImage c = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
      int mult = 300/height;
      int rgb;
      int rgb2;
      for(int rows=0; rows<mult; rows++){
        for(int r=0; r<300; r++){
          for(int w=0; w<300-rows*height;w++){
             if(rows%2 == 0){
             rgb = src1.getRGB(r, w);
             c.setRGB(r,w,rgb);
             }else{
            
             rgb2 = src2.getRGB(r, w);
             c.setRGB(r,w,rgb2);     
             }
            }
          } 
        }
       
	return c;
    } // doHorizontalStripes

    @Override
    public BufferedImage doRotate(BufferedImage src, double degrees) {
    BufferedImage b = src;
    AffineTransform transform = new AffineTransform();
    transform.rotate(0.0175*degrees, b.getWidth()/2, b.getHeight()/2);
    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    b = op.filter(src, null);
    System.out.println("in doRotate");
	return b;
    } // doRotate

    @Override
    public BufferedImage doVerticalStripes(BufferedImage src1, BufferedImage src2, int width) {
      System.out.println("in doVertical");
      BufferedImage a = src1;
      BufferedImage b = src2;
      BufferedImage c = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
      int mult = 300/width;
      int rgb;
      int rgb2;
      for(int cols=0; cols<mult; cols++){
        for(int r=0; r<300; r++){
          for(int w=0; w<300-cols*width;w++){
             if(cols%2 == 0){
             rgb = src1.getRGB(r, w);
             c.setRGB(w,r,rgb);
             }else{
            
             rgb2 = src2.getRGB(r, w);
             c.setRGB(w,r,rgb2);     
             }
            }
          } 
        }
      
	return c;
    } // doVerticalStripes

} // MyArtsy


