package com.mnptech.bcgen.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class BarcodeGenerator {
	
	String BARCODE_SUFFIX = "_"+Calendar.getInstance().getTimeInMillis();
	String FILE_EXTENSION = ".png";
	
	String BARCODE_FILE_NAME="bcode"+BARCODE_SUFFIX+FILE_EXTENSION;
   
	public File getBarcodeFile() throws IOException{
		File outputFile = new File("D:/"+BARCODE_FILE_NAME);
		OutputStream out = new FileOutputStream(outputFile);
		BitmapCanvasProvider canvasProvider = null;
		try 
		  {
			  Code128Bean barcode128Bean = BarcodeConfig.barcodeConfigProvider(); 
		      canvasProvider = new BitmapCanvasProvider(out, "image/x-png", BarcodeConfig.dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

		      barcode128Bean.generateBarcode(canvasProvider,"73123");

		      canvasProvider.finish();
		  } 
		  finally 
		  {
		      out.close();
		  }
		return outputFile;
	}
	
		
}
