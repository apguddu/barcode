package com.mnptech.bcgen.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
          
           try(Stream<Path> paths = Files.walk(Paths.get("D:\\All_Barcodes"))) {
        	    paths.forEach(filePath -> {
        	    	try {
        	    	     String firstRemoteFile = "/Souvik/"+filePath.getFileName();
        	             InputStream inputStream = new FileInputStream(filePath.getFileName().toFile());
        	    	 
						 ftpClient.storeFile(firstRemoteFile, inputStream);
						 inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	    	
        	    });
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
