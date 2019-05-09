package kr.co.sist.admin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LecturePermitDAO;
import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.service.detailClassService;

@Component
public class LecturePermitService {

	@Autowired
	private LecturePermitDAO lp_dao;
	@Autowired
	private detailClassService dcs;
	
	// 1. 전체 게시물 수 얻기
		public int totalCount() {
			int cnt = 0;
			cnt = lp_dao.selectTotalCount();
			return cnt;
		}

	public List<LecturePermitDomain> selectLecturePermit(ListVO lvo){
		List<LecturePermitDomain> list=null;
		list=lp_dao.selectLecturePermit(lvo);
		return list;
	}
	
	public JSONObject lecturePermitDetail(String lcode) {
		JSONObject json=new JSONObject();
		
		Summary summary=null;
		Star star=null;
		List<String> career,optlist,noptlist=null;
		DetailContents detailc=null;
		Addr addr=null;
		
		summary=dcs.searchSummary(lcode);
		star=dcs.searchStar(lcode);
		career=dcs.searchCareer(lcode);
		optlist=dcs.searchOpt(lcode);
		noptlist=dcs.searchNoOpt();
		detailc=dcs.searchDeContents(lcode);
		
		addr=dcs.searchAddr(lcode);
		
		
		////// -/-**-*--**-*/--*//**/*/*/*/*/*/*/*/*------ //////
		try {
			
			json.put("lname", URLEncoder.encode(summary.getLname(), "UTF-8"));
			if(null!=summary.getLintro()) {
				json.put("lintro", URLEncoder.encode(summary.getLintro(), "UTF-8"));
			}
			if(null!=summary.getImg()) {
				json.put("img", URLEncoder.encode(summary.getImg(), "UTF-8"));
			}
			json.put("teacher_name", URLEncoder.encode(summary.getTeacher_name(), "UTF-8"));
			json.put("address", URLEncoder.encode(summary.getAddress(), "UTF-8"));
			json.put("class_time", summary.getClass_time());
			json.put("max_member", summary.getMax_member());
			if(null!=summary.getBanner_img()) {
				json.put("banner_img", summary.getBanner_img());
			}
			
			// 경력사항
			JSONArray careerArray=new JSONArray();
			if(!career.isEmpty()) {
				for(int i=0;i<career.size();i++) {
					careerArray.add(URLEncoder.encode(career.get(i), "UTF-8"));
				}
			}
			json.put("career", careerArray);
			
			// 포함사항
			JSONArray optListArray=new JSONArray();
			if(!optlist.isEmpty()) {
				for(int i=0;i<optlist.size();i++) {
					optListArray.add(URLEncoder.encode(optlist.get(i), "UTF-8"));
				} // for
			} // if
			json.put("optList", optListArray);
			
			// 불포함사항
			JSONArray noptListArray=new JSONArray();
			if(!noptlist.isEmpty()) {
				for(int i=0;i<noptlist.size();i++) {
					noptListArray.add(URLEncoder.encode(noptlist.get(i), "UTF-8"));
				}
			}
			json.put("noptList", noptListArray);
			
			json.put("detailAddress", URLEncoder.encode(detailc.getAddress(), "UTF-8"));
			
			if(null!=detailc.getContents()) {
				json.put("detailContents", URLEncoder.encode(detailc.getContents(), "UTF-8"));
			}
			
			if(null!=detailc.getCurriculum()) {
				json.put("detailCurriculum", URLEncoder.encode(detailc.getCurriculum(), "UTF-8"));
			}
			
			if(null!=detailc.getOthers()) {
				json.put("detailOthers",  URLEncoder.encode(detailc.getOthers(), "UTF-8"));
			}
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} // catch
		
		return json;
	}
	
}
