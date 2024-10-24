package org.example;
import java.awt.*;

public class ColorConverter {
    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";

        Color c = Color.decode(hexColor);

        float[] hsbCode = new float [3];

        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);

        System.out.println("Boja u HEX formatu: 0X" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));
        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());
        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");



        MyColor myColor = MyColor.decode(hexColor);

        float[] myHSBcode = new float[3];
        float[] myCMYKcode = new float[4];
        float[] myHSLcode = new float[3];

        MyColor.RGBtoHSB(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myHSBcode);
        MyColor.RGBtoCMYK(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myCMYKcode);
        MyColor.RGBtoHSL(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myHSLcode);


        System.out.println("\nColor in HEX format: 0x" +
                Integer.toHexString(myColor.getRGB() & 0x00FFFFFF));
        System.out.println("Color in RGB format: " + myColor.getRed() + ", " +
                myColor.getGreen() + ", " + myColor.getBlue());
        System.out.println("Color in HSB format: " + String.format("%.02f", myHSBcode[0] * 360)
                + "°, " + String.format("%.02f", myHSBcode[1] * 100) + "%, " +
                String.format("%.02f",myHSBcode[2] * 100) + "%");
        System.out.println("Color in CMYK format: Cyan = " +
                String.format("%.02f", myCMYKcode[0] * 100) + " Magenta = " +
                String.format("%.02f", myCMYKcode[1] * 100) + " Yellow = " +
                String.format("%.02f", myCMYKcode[2] * 100) + " Black = " +
                String.format("%.02f", myCMYKcode[3] * 100));
        System.out.println("Color in HSL format: " + String.format("%.02f", myHSLcode[0])
                + "°, " + String.format("%.02f", myHSLcode[1] * 100) + "%, " +
                String.format("%.02f", myHSLcode[2] * 100) + "%");
        System.out.println("Color in HSL format: " +  myHSLcode[0]
                + "°, "  + myHSLcode[1] * 100 + "%, " +
               myHSLcode[2] * 100 + "%");

    }
}