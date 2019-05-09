package kr.co.sist.admin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.TeacherDAO;
import kr.co.sist.admin.domain.TeacherCareer;
import kr.co.sist.admin.domain.TeacherDetailDomain;
import kr.co.sist.admin.domain.TeacherDomain;
import kr.co.sist.admin.domain.TeacherLesson;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Component
public class TeacherService {

	@Autowired
	private TeacherDAO t_dao;
	
	public int totalCount() {
		int cnt=0;
		cnt=t_dao.teacherTotalCount();
		return cnt;
	}
	
			
		public List<TeacherDomain> selectAllTeacher(ListVO lvo){
			List<TeacherDomain> list=null;
			list=t_dao.selectAllTeacher(lvo);
			return list;
		}
			
		public JSONObject selectDeatailTeacher(String teacherName) {
			JSONObject json=new JSONObject();
			JSONArray json_arr=new JSONArray();
			JSONArray json_arr2=new JSONArray();
			TeacherDAO tdao=new TeacherDAO();
			TeacherDetailDomain tdd=tdao.selectTeacherDetail(teacherName);
			List<TeacherLesson> listLesson=null;
			List<TeacherCareer> listCareer=null;
			listLesson=tdao.selectLesson(teacherName);
			listCareer=tdao.selectCareer(teacherName);
			
		try {
			json.put("tId", tdd.getClientId());
			json.put("tCate", URLEncoder.encode(tdd.getCategory(),"UTF-8"));
			json.put("tName", URLEncoder.encode(tdd.getName(),"UTF-8"));
			json.put("tTName",URLEncoder.encode(tdd.getTeacherName(), "UTF-8"));
			json.put("tGender", tdd.getGender());
			json.put("tBirth", tdd.getBirth());
			json.put("tTel", tdd.getTel());
			json.put("tInputdate", tdd.getInputdate());
			json.put("tEmail", tdd.getEmail());
			json.put("tIntroduce", URLEncoder.encode(tdd.getIntroduce(),"UTF-8"));		

			
			JSONObject json_temp=null;
			JSONObject json_temp2=null;
			
			if(!listLesson.isEmpty()) {
				for(int i=0; i<listLesson.size();i++) {
					json_temp=new JSONObject();
					json_temp.put("lessonName", URLEncoder.encode(listLesson.get(i).getLname(), "UTF-8"));
					json_temp.put("lessonStatus", listLesson.get(i).getStatus());
					json_arr.add(json_temp);
					System.out.println("----------------------------------------- lesson : "+listLesson.get(i).getLname());
				}
			}
			
			json.put("lessonList", json_arr);
			
			if(!listCareer.isEmpty()) {
				for(int i=0; i<listCareer.size();i++) {
					json_temp2=new JSONObject();
					/*json_temp2.put("career", URLEncoder.encode(listCareer.get(i).getCareer(), "UTF-8"));*/
					json_temp2.put("career", URLEncoder.encode(listCareer.get(i).getCareer(), "UTF-8"));
					
					System.out.println("--------------------------------- career : "+listCareer.get(i));
					
					json_arr2.add(json_temp2);
				}
			}
			
			json.put("careerList", json_arr2);
			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return json;
		}
		
		public List<TeacherDomain> teacherOptionSearch(OptionSearchVO osvo){
			List<TeacherDomain> list=null;
			TeacherDAO tdao=TeacherDAO.getInstance();
			list=tdao.teacherOptionSearch(osvo);
			return list;
		}
			
		public static void main(String[] args) {
			TeacherService ts=new TeacherService();
//			ts.selectDeatailTeacher("백인재");
			OptionSearchVO osvo=new OptionSearchVO();
			osvo.setCurrentPage(1);
			osvo.setStartNum(1);
			osvo.setEndNum(10);
			osvo.setOption("t.teacher_name");
			osvo.setKeyword("백인재");
			ts.teacherOptionSearch(osvo);
		}
}
