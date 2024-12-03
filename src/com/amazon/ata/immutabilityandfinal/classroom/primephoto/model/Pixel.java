package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

// Make this class immutable:
// (1) declare class as final
// (2) declare instance variables final
// (3) check constructors for reference parameters and replace assignments with defensive copying
// (4) make sure any references returned are defensive returns
// (5) ensure that there are no setters in the class
// (6) modify existing code so no instance variables are changed

/**
 * Represents a single point in an image. Each pixel has a location in the image, and an associated RGB color.
 */
public final class Pixel {
    private final int x;
    private final int y;
    private final RGB rgb;

    public Pixel(int x, int y, RGB rgb) {
        this.x = x;
        this.y = y;
        this.rgb = new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());

//        this.rgb = rgb;
        // constructor is receiving a reference to an rgb object ... make a defensive copy
    }


    public RGB getRGB() {
//        return rgb;
        // constructor is receiving a reference to an rgb object ... make a defensive copy

        return new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, rgb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pixel pixel = (Pixel) obj;

        return pixel.x == this.x && pixel.y == this.y &&
           Objects.equals(pixel.rgb, this.rgb);
    }
}
