import org.example.MyColor;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MyColorTest {

    private final String hexColor = "0x1FF0FF";

    private final MyColor c = MyColor.decode(hexColor);

    @Test
    public void testDecode(){
        assertEquals(31, c.getRed());
        assertEquals(240, c.getGreen());
        assertEquals(255, c.getBlue());
    }

    @Test
    public void testGetRGB(){
        assertEquals(2093311, c.getRGB());
    }

    @Test
    public void testRGBtoHSB(){
        float[] myHSBcode = new float[3];
        MyColor.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), myHSBcode);

        float hue = myHSBcode[0] * 360;
        float saturation = myHSBcode[1] * 100;
        float brightness = myHSBcode[2] * 100;

        assertEquals(184.01784f, hue);
        assertEquals(87.84314f, saturation);
        assertEquals(100.00f, brightness);
    }

    @Test
    public void testRGBtoCMYK(){
        float[] myCMYKcode = new float[4];
        MyColor.RGBtoCMYK(c.getRed(), c.getGreen(), c.getBlue(), myCMYKcode);

        float cyan = myCMYKcode[0];
        float magenta = myCMYKcode[1];
        float yellow = myCMYKcode[2];
        float key = myCMYKcode[3];

        assertEquals(0.8784314f, cyan);
        assertEquals(0.058823526f, magenta);
        assertEquals(0.0f, yellow);
        assertEquals(0.0f, key);
    }

    @Test
    public void testRGBtoHSL(){
        float[] myHSLcode = new float[3];
        MyColor.RGBtoHSL(c.getRed(), c.getGreen(), c.getBlue(), myHSLcode);

        float hue = myHSLcode[0];
        float saturation = myHSLcode[1] * 100;
        float lightness = myHSLcode[2] * 100;

        assertEquals(184.0f, hue);
        assertEquals(100.0f, saturation);
        assertEquals(56.078434f, lightness);
    }
}
