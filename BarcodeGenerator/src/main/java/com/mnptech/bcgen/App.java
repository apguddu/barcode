package com.mnptech.bcgen;

import java.io.File;
import java.io.IOException;

import com.mnptech.bcgen.util.BarcodeGenerator;

public class App {
   public static void main(String args[]) throws IOException{
	   BarcodeGenerator b = new BarcodeGenerator();
	   File f = b.getBarcodeFile();
   }
}
