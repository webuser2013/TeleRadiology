package com.kinsolutions.common.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	
	public String storeFile(MultipartFile file,String path);

}
