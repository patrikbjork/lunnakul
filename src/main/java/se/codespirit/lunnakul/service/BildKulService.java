package se.codespirit.lunnakul.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@Service
public class BildKulService {

    private BufferedImage img;
    private double pixval;
//    private PrintWriter prntwrt;
//    private FileWriter filewrt;

    /*public Img2Ascii() {
        try {
//            prntwrt = new PrintWriter(System.out);
//            prntwrt = new PrintWriter(filewrt = new FileWriter("/Users/patrik/Pictures/temp_skapat_210615/asciiart.txt",
//                    true));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    public void convertToAscii(InputStream inputStream, PrintWriter prntwrt) {
        try {
            img = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < img.getHeight(); i+=2) {
            for (int j = 0; j < img.getWidth(); j+=2) {
                Color pixcol = new Color(img.getRGB(j, i));
                pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol
                    .getGreen() * 0.11)));
                print(strChar(pixval), prntwrt);
            }
            try {
                prntwrt.println("");
                prntwrt.flush();
//                filewrt.flush();
            } catch (Exception ex) {
            }
        }
    }

    public String strChar(double g) {
        String str = " ";
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }

    public void print(String str, PrintWriter prntwrt) {
        try {
            prntwrt.print(str);
            prntwrt.flush();
//            filewrt.flush();
        } catch (Exception ex) {
        }
    }
}

class Img2Ascii {



    /*public static void main(String[] args) {
        Img2Ascii obj = new Img2Ascii();
        obj.convertToAscii("/Users/patrik/Pictures/temp_skapat_210615/FCLEEaCX0AI3avc.jpg");
//        obj.convertToAscii("hcdev.png");
    }*/
}
