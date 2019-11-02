package com.kinsolutions.common.Service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	
	 
	@Override
	public String storeFile(MultipartFile file,String path) {
		FileOutputStream fileOutputStream = null;
		File uploadedFile = null;
        try {
          	 if(!new File(path).exists()) {        		 
        		 new File(path).mkdirs();
         	 } else {
        		 new File(path).delete();
        		 new File(path).mkdirs();
        	 }
        	 uploadedFile = new File(path, file.getOriginalFilename());
        	 uploadedFile.createNewFile();
             fileOutputStream = new FileOutputStream(uploadedFile);
             fileOutputStream.write(file.getBytes());
             fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uploadedFile.getName();
	}
 
}
