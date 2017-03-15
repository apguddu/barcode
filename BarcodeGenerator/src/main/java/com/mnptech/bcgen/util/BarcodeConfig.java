package com.mnptech.bcgen.util;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.tools.UnitConv;

public class BarcodeConfig {
	
    static String BARCODE_SUFFIX = "_"+ new java.util.Date().getTime();
	static String FILE_EXTENSION = ".png";
	
	static String BARCODE_FILE_NAME="bcode"+BARCODE_SUFFIX+FILE_EXTENSION;
	
	static final int dpi = 100;

	public static Code128Bean barcodeConfigProvider(){		
		
		Code128Bean barcode128Bean = new Code128Bean();
		
		barcode128Bean.setCodeset(Code128Constants.CODESET_B);
		barcode128Bean.setModuleWidth(UnitConv.in2mm(5.0f / dpi)); 
		barcode128Bean.doQuietZone(false);
		
		return barcode128Bean;		   
	}
	
}
