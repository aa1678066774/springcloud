package com.tww.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.element.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: root
 * @description: pdf转图片
 * @author: weiweiTang
 * @create: 2019-09-22 11:05
 */
public class PdfToImage {
    public static void main(String[] args) throws IOException {
    }

    public static void pdfToImage(String sourcePath,String imgFilepath) throws IOException {
        File file = new File(sourcePath);
        String filename = file.getName().substring(0,file.getName().lastIndexOf("."));
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for(int i=0;i<pageCount;i++){
                BufferedImage image = renderer.renderImageWithDPI(i, 150);
                //          BufferedImage image = renderer.renderImage(i, 2.5f);
                ImageIO.write(image, "PNG", new File(imgFilepath+"\\"+filename+"_"+i+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
