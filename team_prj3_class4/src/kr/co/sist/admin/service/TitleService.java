package kr.co.sist.admin.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class TitleService {
	public boolean fileUploadProcess( HttpServletRequest request ) throws IOException {
		boolean flag=false;
		String savePath="C:/dev/workspace/team_prj3_class4/WebContent/upload/";
		MultipartRequest mr=
				new MultipartRequest(request, savePath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		
		  /*String fileName = Util.nullOrEmptyToReplaceString(mr.getFilesystemName("File_url") ,"");*/  
		  String fileName = mr.getFilesystemName("File_url");
		    String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //����ð�
		    int i = -1;
		          i = fileName.lastIndexOf("."); // ���� Ȯ���� ��ġ
		          String realFileName = now + fileName.substring(i, fileName.length());  //����ð��� Ȯ���� ��ġ��
		    
		    File oldFile = new File(savePath + fileName);
		    File newFile = new File(savePath + realFileName); 
		    
		    oldFile.renameTo(newFile); // ���ϸ� ����
	
		    


			/*MemberVO mv=new MemberVO(
					mr.getParameter("name"), mr.getFilesystemName("upfile"), 
					mr.getParameter("loc"), 
					mr.getParameter("highschool"));*/
		
			/*try {
				//jdao.insertMember(mv);
				//request.setAttribute("inputData", mv);
				flag=true;
			}catch(DataAccessException das) {
				das.printStackTrace();
			}//end if
*/		return flag;
	}//fileUploadProcess
}
