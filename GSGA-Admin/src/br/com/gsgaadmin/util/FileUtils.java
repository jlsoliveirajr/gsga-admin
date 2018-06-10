package br.com.gsgaadmin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	
	public static InputStream fileToInputStream(File file) {
		try {
			return new FileInputStream(file);
		}catch(Exception e) {
			LOGGER.error("ERRO", e);
		}
		
		return null;
	}

}
