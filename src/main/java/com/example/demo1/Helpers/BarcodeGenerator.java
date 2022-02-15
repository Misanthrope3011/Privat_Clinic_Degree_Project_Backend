package com.example.demo1.Helpers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.util.Random;


@Getter
@Setter
@AllArgsConstructor
public class BarcodeGenerator {

    public BufferedImage generateEAN13BarcodeImage() throws Exception {
        EAN13Writer barcodeWriter = new EAN13Writer();
        StringBuilder barcode = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            barcode.append((int)(Math.random() * 10) % 10);
        }

        int odd = 0;
        int even = 0;

        for (int i = 0; i < barcode.length(); i++) {
            if(i % 2 == 0)
                even += Integer.parseInt(String.valueOf(barcode.charAt(i)));
            else
                odd += Integer.parseInt(String.valueOf(barcode.charAt(i)));
        }

        barcode.append((10 - ((3 * odd + even) % 10)) % 10);

        BitMatrix bitMatrix = barcodeWriter.encode(barcode.toString(), BarcodeFormat.EAN_13, 300, 150);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
