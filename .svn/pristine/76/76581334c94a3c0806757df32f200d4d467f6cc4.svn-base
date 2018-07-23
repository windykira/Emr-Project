package com.haoze.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;


/**
 * 此类中封装一些常用的文件操作。
 * 所有方法都是静态方法，不需要生成此类的实例，
 * 为避免生成此类的实例，构造方法被申明为private类型的。
 */

public class MyFileUtil {
  /**
   * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
   */
  private MyFileUtil() {

  }

	/**
	 * write file
	 *
	 * @param path
	 * @param name
	 * @param content
	 * @return return false if content is empty, true otherwise
	 * @throws RuntimeException if an error occurs while operator FileWriter
	 */
	public static boolean writeFile(String path, String name, String content) {
		if(content==null||"".equals(content)) {
			return false;
		}
		File file = new File(path);
		if(!file.exists()) {
			if(file.mkdirs()) {
			}
		}
		file = new File(path+name);
		if(file.exists()) {
			name = name+"_dup";//stupid code
			file = new File(path+name);
		}

//		FileWriter fw = null;
//		BufferedWriter out = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(content);
			osw.flush();
//			fw = new FileWriter(file);
//			out = new BufferedWriter(fw);
//			out.write(content, 0, content.length());
//			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * write file
	 *
	 * @param path
	 * @param content
	 * @return return false if content is empty, true otherwise
	 * @throws RuntimeException if an error occurs while operator FileWriter
	 */
	public static boolean rewriteFile(String path, String content) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = new FileOutputStream(path);
			osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(content);
			osw.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
     * read file to string 
     * 
     * @param filePath
     * @return if file not exist, return null, else return content of file
     */
    public static String readFile(String filePath) {
    	InputStreamReader isr = null;
    	StringBuilder sb = new StringBuilder();
    	try {
        	isr = new InputStreamReader(new FileInputStream(filePath),"UTF-8");
        	int len;
        	char[] buf = new char[1024];
        	while ((len=isr.read(buf))!=-1){
        		sb.append(buf);
        		buf=new char[1024];
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return sb.toString();
    }

	public static String resolveFile(String filePath){

		InputStreamReader isr = null;
		StringBuilder sb = new StringBuilder();
		Resource resource = new ClassPathResource(filePath);
		try {

			File file = resource.getFile();
			isr = new InputStreamReader(new FileInputStream(file),"UTF-8");
			int len;
			char[] buf = new char[1024];
			while ((len=isr.read(buf))!=-1){
				sb.append(buf);
				buf=new char[1024];
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}