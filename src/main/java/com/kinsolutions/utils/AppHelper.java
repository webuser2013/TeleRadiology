package com.kinsolutions.utils;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.web.multipart.MultipartFile;

public class AppHelper {
	
	
	public static String getFileExtension(String fileName) {
        try {
        	System.out.println("fileName??????"+fileName);
 			if(fileName != null && fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {				
				return fileName.substring(fileName.lastIndexOf(".")+1);
			}
 		} catch (Exception e) {
 			e.printStackTrace();
		}
        return null;
    }
	
	public static long getFileSize(MultipartFile file) {
        try {
        	return file.getSize();
  		} catch (Exception e) {
 			e.printStackTrace();
		}
        return 0;
    }
	
	public static byte[] getFileObject(String filePath) {
	   FileInputStream fileInputStream = null;
	   byte[] bytesArray = null;
 		try {
 			File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
            return bytesArray;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }	 	
      return null;
   }

}
