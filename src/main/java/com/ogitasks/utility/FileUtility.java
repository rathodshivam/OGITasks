//package com.ogitasks.utility;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.UUID;
//
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.divergentsl.vardan.bean.ImageBean;
//import com.divergentsl.vardan.config.Translator;
//import com.ogitasks.exception.GenricException;
//
//@Component
//public class FileUtility {
//
//	@Value("${file.path}")
//	private String filePath;
//
//	static final Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);
//
//	public String upload(MultipartFile multipartFile) throws IOException {
//		if (AppUtility.isEmpty(multipartFile)) {
//			throw new GenricException("File not exist");
//		}
//
//		// if (AppUtility.isEmpty(folder)) {
//		// throw new GenricException("File type not exist");
//		// }
//
//		File dir = new File(filePath);
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//
//		byte[] bytes = multipartFile.getBytes();
//
//		String originalFilename = multipartFile.getOriginalFilename();
//		String extendsion = originalFilename.substring(originalFilename.lastIndexOf('.'));
//
//		String filename = UUID.randomUUID().toString() + extendsion;
//
//		File file = new File(dir.getAbsolutePath() + File.separator + filename);
//		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
//		bufferedOutputStream.write(bytes);
//		bufferedOutputStream.close();
//
//		return filename;
//	}
//
//	public boolean delete(String filename) {
//		if (AppUtility.isEmpty(filename)) {
//			throw new GenricException("File name or type not exist");
//		}
////		String filePath = "/home/hp/Ravi/client_project/nuadthai/images/";
//		File file = new File(filePath + File.separator + filename);
//		if (!file.isFile()) {
//			throw new GenricException("File not exist");
//		}
//		return file.delete();
//	}
//
//	public File getFile(String filename, String type) {
//		if (AppUtility.isEmpty(filename) || AppUtility.isEmpty(type)) {
//			throw new GenricException("File name or type not exist");
//		}
//
//		File file = new File(filePath + File.separator + type + File.separator + filename);
//		if (!file.isFile()) {
//			throw new GenricException("File not exist");
//		}
//
//		return file;
//	}
//
//	public String uploadImage(ImageBean imageBean) {
//		if (AppUtility.isEmpty(imageBean) || AppUtility.isEmpty(imageBean.getImage())
//				|| AppUtility.isEmpty(imageBean.getFileName())) {
//			throw new GenricException(Translator.toLocale("FILE_NOT_EXIST"));
//		}
//		try {
//			byte[] fileInByte = Base64.decodeBase64(imageBean.getImage());
//			String extension = imageBean.getFileName().substring(imageBean.getFileName().lastIndexOf(".") + 1);
//			String fileName = imageBean.getImageId() + "." + extension;
//			File file = new File(filePath);
//			if (!file.exists()) {
//				file.mkdirs();
//			}
//			File newFile = new File(filePath + File.separator + fileName);
//			OutputStream outputStream = new FileOutputStream(newFile);
//			outputStream.write(fileInByte);
//			outputStream.close();
//			return fileName;
//		} catch (Exception ex) {
//			throw new GenricException(ex.getMessage());
//		}
//
//	}
//}
