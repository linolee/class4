package kr.co.sist.admin.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class TitleService {
	public boolean fileUploadProcess( HttpServletRequest request ) throws IOException {
		boolean flag=false;
		MultipartRequest mr=new MultipartRequest(request, 
				"C:/dev/workspace/team_prj3_class4/WebContent/upload/",
						1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			/*MemberVO mv=new MemberVO(
					mr.getParameter("name"), mr.getFilesystemName("upfile"), 
					mr.getParameter("loc"), 
					mr.getParameter("highschool"));*/
		
			try {
				//jdao.insertMember(mv);
				//request.setAttribute("inputData", mv);
				flag=true;
			}catch(DataAccessException das) {
				das.printStackTrace();
			}//end if
		return flag;
	}//fileUploadProcess
}
