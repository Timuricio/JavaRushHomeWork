package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Timur on 29.03.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes b) throws IllegalArgumentException{

        if (b==ImageTypes.BMP)
            return new BmpReader();
        else if (b==ImageTypes.JPG)
            return new JpgReader();
        else if (b==ImageTypes.PNG)
            return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
