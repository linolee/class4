package kr.co.sist.admin.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.admin.vo.CategoryImgVO;

@Component
public class TitleService {
	
	public boolean titleImgUpload(HttpServletRequest request) throws IOException{
		boolean flag=false;
		String savePath="C:/Users/sist/git/class4/team_prj3_class4/WebContent/upload/title/";
		/*String savePath="C:/Users/in112/git/class4/team_prj3_class4/WebContent/upload/category/";*/
		/*MultipartRequest mr=new MultipartRequest(request, savePath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());*/
		MultipartRequest mr=new MultipartRequest(request, savePath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		 String fileName = mr.getFilesystemName("file");
		 String titleImageNumber = mr.getParameter("titleNumber");
		 
		    int i = -1;
		    i = fileName.lastIndexOf("."); // ���� Ȯ���� ��ġ
		    String realFileName = "titleImg"+titleImageNumber+fileName.substring(i, fileName.length());  // Ȯ���� ��ġ��

		    File tempFile=new File(savePath+"titleImg"+titleImageNumber+fileName.substring(i, fileName.length()));
		    
		    // ���� ������ �����Ѵٸ� ����
		    if(tempFile.exists()) {
		    	tempFile.delete();
		    }
		    
		    File newFile = new File(savePath + realFileName);
		    File oldFile = new File(savePath + fileName);
		    
		    oldFile.renameTo(newFile); // ���ϸ� ����
		    
		    flag=true;
		    
		return flag;
	}//fileUploadProcess
	
}
