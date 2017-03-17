package com.mnptech.bcgen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUploaderUtil {
   public void uploadBarcodeFile() throws IOException{
	  
	   String server = "localhost";
       int port = 21;
       String user = "muleusr1";
       String pass = "muleusr1";
        
             
       FTPClient ftpClient = new FTPClient();
       try {

           ftpClient.connect(server, port);
           ftpClient.login(user, pass);
          
           ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
           
           

           System.out.println("Start uploading first file");
          
             
           File folder = new File("D:\\All_Barcodes");
           File[] listOfFiles = folder.listFiles();
           String firstRemoteFile = "/Souvik/";
           
           for (int i = 0; i < listOfFiles.length; i++) {
        	      if (listOfFiles[i].isFile()) {
        	    	String fileName = listOfFiles[i].getName();
        	        System.out.println("File " + listOfFiles[i].getName());
        	        firstRemoteFile+= fileName;
        	        File firstLocalFile = new File(folder+"\\"+listOfFiles[i].getName());
        	        InputStream inputStream = new FileInputStream(firstLocalFile);
        	        ftpClient.storeFile(firstRemoteFile, inputStream);
        	      } 
        	}
          

   }catch(Exception e){
	  System.out.println(e);
     }	
   }
   
   public static void main(String args[]) throws IOException{
	   FTPUploaderUtil f = new FTPUploaderUtil();
	   f.uploadBarcodeFile();
   }
}
