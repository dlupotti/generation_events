package com.generation.events.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class StorageService {
	
	private FileOutputStream output;
	private BufferedOutputStream bufferOutput;
	
	private File file;
	
	public String getExtensionFile(File file) {
		String name = file.getName();
		int n = name.lastIndexOf('.');
		if (n > 0) {
		    return name.substring(n+1);
		}
		return "-1";
	}
	
	public String getExtensionFile(MultipartFile file) {
		String suffix = file.getContentType();
		suffix = suffix.substring(suffix.indexOf("/")+1);
		return suffix;
	}
	
	private void init(String path) throws FileNotFoundException {
		file = new File(path);
		output = new FileOutputStream(file);
		bufferOutput = new BufferedOutputStream(output);
	}
	
	public void write(String path, MultipartFile file) throws IOException {
		this.init(path);
		bufferOutput.write(file.getBytes());
		bufferOutput.close();
	}
	
	public void renameFile(String oldPath, String newPath) throws IOException {
		file = new File(oldPath);
		File newFile = new File(newPath);
		
		FileUtils.moveFile(file, newFile);

	}
	
	public void deleteFile(String path) throws IOException {
		file = new File(path);
		
		FileUtils.forceDelete(file);
		
	}

}
