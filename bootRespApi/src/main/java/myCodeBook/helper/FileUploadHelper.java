package myCodeBook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



public class FileUploadHelper {

	 public final String DIR_PATH = new ClassPathResource("static/image").getFile().getAbsolutePath();

	 public FileUploadHelper() throws IOException{}
	 
	 public boolean uploadFileHelper(MultipartFile file) {
		 boolean flag = false;
		 try {
		 Files.copy(file.getInputStream(),Paths.get(DIR_PATH+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		  flag=true;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return flag;
	 }


}
