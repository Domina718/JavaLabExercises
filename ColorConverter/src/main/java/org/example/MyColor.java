package org.example;


public class MyColor {
    private int red;
    private int green;
    private int blue;

    public MyColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public static MyColor decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new MyColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    public int getRGB() {
        String rgb = Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
        return Integer.parseInt(rgb,16);
    }

    public static float[] RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

    public static void RGBtoCMYK(int red, int green, int blue, float[] cmykValues){

        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;

        float k = 1.0f - Math.max(r, Math.max(g, b));
        float c = (1f-r-k) / (1f-k);
        float m = (1f-g-k) / (1f-k);
        float y = (1f-b-k) / (1f-k);

        cmykValues[0] = c;
        cmykValues[1] = m;
        cmykValues[2] = y;
        cmykValues[3] = k;
    }

    public static void RGBtoHSL(int red, int green, int blue, float[] hslValues){

        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;

        float max = Math.max(r,Math.max(r,b));
        float min = Math.min(r,Math.min(r,b));
        float delta = max - min;

        float h = 0;
        float s = 0;
        float l = (max + min) / 2;

        if ( delta == 0 ){
            // gray color
            h = 0;
            s = 0.0f;
        }
        else
        {
            // get saturation value
            s = ( l <= 0.5 ) ? ( delta / ( max + min ) ) : ( delta / ( 2 - max - min ) );

            // get hue value
            float hue;

            if ( r == max )
            {
                hue = ( ( g - b ) / 6 ) / delta;
            }
            else if ( g == max )
            {
                hue = ( 1.0f / 3 ) + ( ( b - r ) / 6 ) / delta;
            }
            else
            {
                hue = ( 2.0f / 3 ) + ( ( r - g ) / 6 ) / delta;
            }

            // correct hue if needed
            if ( hue < 0 )
                hue += 1;
            if ( hue > 1 )
                hue -= 1;

            h = (int) ( hue * 360 );
        }

        hslValues[0] = h;
        hslValues[1] = s;
        hslValues[2] = l;
    }
}
