package kr.co.sist.user.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.user.dao.ClassRegistDAO;
import kr.co.sist.user.vo.ClassRegistVO;
import kr.co.sist.user.vo.LessonDowVO;
import kr.co.sist.user.vo.LoptVO;

@Component
public class ClassRegistService {

	@Autowired
	private ClassRegistDAO c_dao;

	public List<String> searchCategorys() {
		List<String> list = null;
		list = c_dao.selectCategorys();
		return list;
	}

	public JSONObject searchSubCategorys(String category) {
		JSONObject json = new JSONObject();
		JSONArray json_arr = new JSONArray();

		List<String> list = null;
		list = c_dao.selectSubCategorys(category);

		JSONObject json_temp = null;
		try {
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					json_temp = new JSONObject();
					json_temp.put("subCategoryName", URLEncoder.encode(list.get(i), "UTF-8"));
					json_arr.add(json_temp);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		json.put("subCategoryList", json_arr);

		return json;
	}

	public List<String> searchTeacherName(String id) {
		List<String> list = null;
		list = c_dao.selectTeacherName(id);
		return list;
	}

	public boolean addLesson(HttpServletRequest request) throws IOException {
		boolean flag = false;
		
		String fsl = File.separator;
		String root = request.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + "/upload" + fsl;
		String rootPath1 = root + "/upload/lessonBanner" + fsl;
		String rootPath2 = root + "/upload/lessonMain" + fsl;
		
		
		String savePath1 = "C:/Users/owner/git/class4/team_prj3_class4/WebContent/upload/lessonBanner/";
		String savePath2 = "C:/Users/owner/git/class4/team_prj3_class4/WebContent/upload/lessonMain/";
		//MultipartRequest mr = new MultipartRequest(request, savePath1, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		MultipartRequest mr = new MultipartRequest(request, rootPath1, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

		String formName="";
		String fileName = mr.getFilesystemName("topBannerImg");
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
		
		int i = -1;
		File oldFile = null;
		File newFile = null;
		Enumeration form = mr.getFileNames();
		String topBannerImgName = "";
		String mainBannerImgName = "";
		
		while (form.hasMoreElements()) {
			formName = (String)form.nextElement();
			fileName = mr.getFilesystemName(formName);
			
			//System.out.println("formName : "+formName);
			//System.out.println("fileName : "+fileName);
			
			if(fileName != null && formName.equals("topBannerImg")) {
				i = -1;
				i = fileName.lastIndexOf("."); // 파일 확장자 위치
				String realFileName = "tb_" + now + fileName.substring(i, fileName.length()); // 확장자 합치기
				
//				oldFile = new File(savePath1 + fileName);
//				newFile = new File(savePath1 + realFileName);
				oldFile = new File(rootPath1 + fileName);
				newFile = new File(rootPath1 + realFileName);
				
				oldFile.renameTo(newFile); // 파일명 변경
				topBannerImgName = realFileName;
			}else if(fileName != null && formName.equals("mainBannerImg")){
				i = -1;
				i = fileName.lastIndexOf("."); // 파일 확장자 위치
				String realFileName = "mb_" + now + fileName.substring(i, fileName.length()); // 확장자 합치기
				
//				oldFile = new File(savePath1 + fileName);
//				newFile = new File(savePath2 + realFileName);
				oldFile = new File(rootPath1 + fileName);
				newFile = new File(rootPath2 + realFileName);
				
				oldFile.renameTo(newFile); // 파일명 변경
				mainBannerImgName = realFileName;
			}
		}
		
		ClassRegistVO crvo = new ClassRegistVO(mr.getParameter("teacherProfile"), //
				mr.getParameter("mainCategory"), //
				mr.getParameter("subCategory"), //
				mr.getParameter("className"), //
				mr.getParameter("classSimpleInfo"), //
				mr.getParameter("classInfo"),  //
				mr.getParameter("classCurriculum"), //
				mr.getParameter("etc"), //
				mainBannerImgName, //
				topBannerImgName, //
				mr.getParameter("startDate"), //
				mr.getParameter("endDate"), //
				mr.getParameter("finDate"), //
				mr.getParameter("classAddr1"), //
				mr.getParameter("classAddr2"), //
				mr.getParameter("classTogether"), //
				Integer.parseInt( mr.getParameter("startHour") ) * 60 + Integer.parseInt( mr.getParameter("startMin") ), 
				Integer.parseInt( mr.getParameter("endHour") ) * 60 + Integer.parseInt( mr.getParameter("endMin") ), 
				Integer.parseInt( mr.getParameter("maxPerson") ), //
				Integer.parseInt( mr.getParameter("minPerson") ) );//
		//System.out.println("============"+crvo.toString());
		try {
			c_dao.insertLesson(crvo);
			String lcode = c_dao.selectNowLessonCode();
			//System.out.println("selectNowLessonCode : " + lcode);
			LessonDowVO ldvo = null;
			for(int j=0; j<mr.getParameterValues("chkWeek").length; j++) {
				ldvo = new LessonDowVO(lcode, mr.getParameterValues("chkWeek")[j]);
				//System.out.println("chkWeek : " + ldvo.toString());
				c_dao.insertLessonDow(ldvo);
			}
			LoptVO lvo = null;
			for(int j=0; j<mr.getParameterValues("include1").length; j++) {
				lvo = new LoptVO(mr.getParameterValues("include1")[j], lcode);
				//System.out.println("include1 : " + lvo.toString());
				c_dao.insertLopt(lvo);
			}
			
			//request.setAttribute("inputData", crvo);// model에 넣어서 넘길 것
			flag = true;
		} catch (DataAccessException das) {
			das.printStackTrace();
		}

		return flag;
	}// fileUploadProcess
	
	
	
}
