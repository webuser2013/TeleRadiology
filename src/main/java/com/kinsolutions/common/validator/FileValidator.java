package com.kinsolutions.common.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.utils.AppHelper;

@Component
public class FileValidator {

	public boolean isPdfFileFormat(MultipartFile file) {
		 try {
			 String fileExt = AppHelper.getFileExtension(file.getOriginalFilename());
			 if(fileExt.equalsIgnoreCase(AppConstants.FILE_PO_EXT)){
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}

	public boolean isFileSizeExceed(MultipartFile file) {
		 try {
			 long fizeSize = AppHelper.getFileSize(file);
 			 if(fizeSize > 0 && fizeSize <= 5242880){
				 return false;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return true;
	}

}
