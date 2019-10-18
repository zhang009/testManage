package com.test.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.ChapterTitle;
import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.Subject;
import com.test.po.TFQuestion;
import com.test.po.Course;
import com.test.pojo.SCQuestionData;
import com.test.pojo.CourseData;
import com.test.service.ChapterService;
import com.test.service.QuestionService;
import com.test.service.SubjectService;
import com.test.service.CourseService;





@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CourseService CourseService;
	
	@Autowired
	private ChapterService chapterService;
	
	/*删除题目*/
	@RequestMapping(value = "/deleteQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteQuestion(HttpServletRequest request){
		System.out.println("deleteQuestion:");
		String question=(String) request.getParameter("question");
		//String sid=(String) request.getParameter("subject");
		System.out.println(question);	
		Map<String, String> map=new HashMap<String, String>();
		if("scquestion".equals(question)){
			//删除单选题
			System.out.println("删除单选");
			String sc_id=(String) request.getParameter("id");
			boolean result=questionService.deleteSCQuestion(sc_id);
			if(result){
				map.put("result", "yes");
			}else{
				map.put("result", "no");
			}			
		}else if("mcquestion".equals(question)){
			//删除多选题
			System.out.println("删除多选");
			String mc_id=(String) request.getParameter("id");
			boolean result=questionService.deleteMCQuestion(mc_id);
			if(result){
				map.put("result", "yes");
			}else{
				map.put("result", "no");
			}
			
		}else if("tfquestion".equals(question)){
			//删除判断题
			System.out.println("删除判断选");
			String tf_id=(String) request.getParameter("id");
			boolean result=questionService.deleteTFQuestion(tf_id);
			if(result){
				map.put("result", "yes");
			}else{
				map.put("result", "no");
			}
			
		}else if("fbquestion".equals(question)){
			//删除填空题
			System.out.println("删除填空");
			String fb_id=(String) request.getParameter("id");
			boolean result=questionService.deleteFBQuestion(fb_id);
			if(result){
				map.put("result", "yes");
			}else{
				map.put("result", "no");
			}
			
		}else if("qaquestion".equals(question)){
			//删除简答题
			System.out.println("删除简答");
			String qa_id=(String) request.getParameter("id");
			boolean result=questionService.deleteQAQuestion(qa_id);
			if(result){
				map.put("result", "yes");
			}else{
				map.put("result", "no");
			}
		}
		return map;
		}
	
		/*修改题目*/
		@RequestMapping(value = "/updateQuestion.action",method = RequestMethod.GET)
		public String updateQuestion(HttpServletRequest request,Model model){
			System.out.println("updateQuestion:");
			String question=(String) request.getParameter("question");
			//String sid=(String) request.getParameter("subject");
			System.out.println(question);
			
			String jsp="";
			if("scquestion".equals(question)){
				//修改单选题
				System.out.println("修改单选");
				String sc_id=(String) request.getParameter("id");
				SCQuestion scquestion=questionService.selectSCQuestionById(sc_id);
				model.addAttribute("scquestion",scquestion);
				System.out.println("s"+scquestion.toString());
				jsp="updateSCQuestion";
			}else if("mcquestion".equals(question)){
				//修改多选题
				System.out.println("修改多选");
				String mc_id=(String) request.getParameter("id");
				MCQuestion mcquestion=questionService.selectMCQuestionById(mc_id);
				model.addAttribute("mcquestion",mcquestion);
				jsp="updateMCQuestion";
				
				
			}else if("tfquestion".equals(question)){
				//修改判断题
				System.out.println("修改判断");
				String tf_id=(String) request.getParameter("id");
				TFQuestion tfquestion=questionService.selectTFQuestionById(tf_id);
				model.addAttribute("tfquestion",tfquestion);
				jsp="updateTFQuestion";
				
				
			}else if("fbquestion".equals(question)){
				//修改填空题
				System.out.println("修改填空");
				String fb_id=(String) request.getParameter("id");
				FBQuestion fbquestion=questionService.selectFBQuestionById(fb_id);
				model.addAttribute("fbquestion",fbquestion);
				jsp="updateFBQuestion";
				
				
			}else if("qaquestion".equals(question)){
				//修改简答题
				System.out.println("修改简答");
				String qa_id=(String) request.getParameter("id");
				QAQuestion qaquestion=questionService.selectQAQuestionById(qa_id);
				model.addAttribute("qaquestion",qaquestion);
				jsp="updateQAQuestion";
				
				
			}
		return "updateSCQuestion";
	}	
	/*这个方法好像没有了，我也忘了*/
	@RequestMapping(value="/getQuestionBySubject.action",method = RequestMethod.GET)
	public String toQuestionList( HttpServletRequest request,Model model) {
		System.out.println("toQuestionList");
		/**/
		String sid=(String) request.getParameter("subject");
		List<SCQuestion> list=subjectService.getSCQuestionsBySub(sid);
		
		//将科目类别写入session	
		/*request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);*/
		return "SCQuestionAll";
	}
	
	/*根据学科id获取所有单选题*/
	@RequestMapping(value="/getSCQuestionAll.action",method = RequestMethod.POST)
	@ResponseBody
	public List<SCQuestion> toMain(HttpServletRequest request) {
		String subjectId=(String) request.getParameter("data");
		System.out.println("getSCQuestionAll");
		System.out.println("data:"+subjectId);
		
		List<SCQuestion> list=questionService.getAllSCQuestions(subjectId);
		/*model.addAttribute("SCQuestionList", list);*/
		System.out.println("list:"+list.toString());
		return list;
	}
	
	/*根据学科id获取所有多选题*/
	@RequestMapping(value="/getMCQuestionAll.action",method = RequestMethod.POST)
	@ResponseBody
	public List<MCQuestion> getMCQuestionAll(HttpServletRequest request) {
		String subjectId=(String) request.getParameter("data");
		System.out.println("getMCQuestionAll");
		System.out.println("data:"+subjectId);
		
		List<MCQuestion> list=questionService.getAllMCQuestions(subjectId);
		/*model.addAttribute("SCQuestionList", list);*/
		System.out.println("list:"+list.toString());
		return list;
	}
	/*根据学科id获取所有填空题*/
	@RequestMapping(value="/getFBQuestionAll.action",method = RequestMethod.POST)
	@ResponseBody
	public List<FBQuestion> getFBQuestionAll(HttpServletRequest request) {
		String subjectId=(String) request.getParameter("data");
		System.out.println("getFBQuestionAll");
		System.out.println("data:"+subjectId);
		
		List<FBQuestion> list=questionService.getAllFBQuestions(subjectId);
		/*model.addAttribute("SCQuestionList", list);*/
		System.out.println("list:"+list.toString());
		return list;
	}
	/*根据学科id获取所有判断题*/
	@RequestMapping(value="/getTFQuestionAll.action",method = RequestMethod.POST)
	@ResponseBody
	public List<TFQuestion> getTFQuestionAll(HttpServletRequest request) {
		String subjectId=(String) request.getParameter("data");
		System.out.println("getFBQuestionAll");
		System.out.println("data:"+subjectId);
		
		List<TFQuestion> list=questionService.getAllTFQuestions(subjectId);
		/*model.addAttribute("SCQuestionList", list);*/
		System.out.println("list:"+list.toString());
		return list;
	}
	
	/*根据学科id获取所有简答题*/
	@RequestMapping(value="/getQAQuestionAll.action",method = RequestMethod.POST)
	@ResponseBody
	public List<QAQuestion> getQAQuestionAll(HttpServletRequest request) {
		String subjectId=(String) request.getParameter("data");
		System.out.println("getQAQuestionAll");
		System.out.println("data:"+subjectId);
		
		List<QAQuestion> list=questionService.getAllQAQuestions(subjectId);
		/*model.addAttribute("SCQuestionList", list);*/
		System.out.println("list:"+list.toString());
		return list;
	}
	/*根据科目的id获取该科目下的所有课程列表*/
	@RequestMapping(value = "/getCourses.action",method = RequestMethod.POST)
	@ResponseBody
	public List<Course> getCourses(HttpServletRequest request){
		String s_id=(String)request.getParameter("data");
		System.out.println("toAddTestBook:"+s_id);
		
		List<Course> list=CourseService.getCoursesBySid(s_id);
		System.out.println("CourseList:"+list.toString());
		
		return list;
		
	}
	/*根据教课书的id所有的章节*/
	@RequestMapping(value = "/getChapters.action",method = RequestMethod.POST)
	@ResponseBody
	public List<ChapterTitle> getChapters(HttpServletRequest request){
		String c_id=request.getParameter("data");
		System.out.println("getChapters:"+c_id);
		
		List<ChapterTitle> list=chapterService.getChapterByTBid(c_id);
		System.out.println("CourseList:"+list.toString());
		return list;
		
	}
	/*添加课程*/
	@RequestMapping(value = "/addCourse.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addCourse(@RequestBody CourseData CourseData){
		
		System.out.println("addCourse:"+CourseData.toString());
		Map<String, String> map=new HashMap<String, String>();
		boolean result=this.CourseService.addCourseByBookData(CourseData);
		 if(result){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;		
	}
	/*添加单选题*/
	@RequestMapping(value = "/addSCQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addSCQuestion(@RequestBody SCQuestionData scquestionData){
		
		System.out.println("addSCQuestion:"+scquestionData.toString());
		Map<String, String> map=new HashMap<String, String>();
		int rt=questionService.saveSCQuestion(scquestionData);
		System.out.println(rt);
		 if(rt>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	/*修改单选题*/
	@RequestMapping(value = "/updateSCQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateSCQuestion(@RequestBody SCQuestionData scquestionData){
		
		System.out.println("addSCQuestion:"+scquestionData.toString());
		Map<String, String> map=new HashMap<String, String>();
		boolean rt=questionService.updateSCQuestion(scquestionData);
		System.out.println(rt);
		 if(rt){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	
	/*添加多选题*/
	@RequestMapping(value = "/addMCQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addMCQuestion(@RequestBody MCQuestion mcQuestion){
		
		System.out.println("addMCQuestion:"+mcQuestion.toString());
		Map<String, String> map=new HashMap<String, String>();
		int rt=questionService.saveMCQuestion(mcQuestion);
		System.out.println(rt);
		 if(rt>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	/*添加判断题*/
	@RequestMapping(value = "/addTFQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addTFQuestion(@RequestBody TFQuestion tfQuestion){
		
		System.out.println("addTFQuestion:"+tfQuestion.toString());
		Map<String, String> map=new HashMap<String, String>();
		int rt=questionService.saveTFQuestion(tfQuestion);
		System.out.println(rt);
		 if(rt>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	/*添加填空题*/
	@RequestMapping(value = "/addFBQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addFBQuestion(@RequestBody FBQuestion fbQuestion){
		
		System.out.println("addMCQuestion:"+fbQuestion.toString());
		Map<String, String> map=new HashMap<String, String>();
		int rt=questionService.saveFBQuestion(fbQuestion);
		System.out.println(rt);
		 if(rt>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	/*添加简答题*/
	@RequestMapping(value = "/addQAQuestion.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addQAQuestion(@RequestBody QAQuestion qaQuestion){
		
		System.out.println("addMCQuestion:"+qaQuestion.toString());
		Map<String, String> map=new HashMap<String, String>();
		int rt=questionService.saveQAQuestion(qaQuestion);
		System.out.println(rt);
		 if(rt>0){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}
		return map;
	}
	
/*-----------------------------------------------以下为转发*/
	
	/*转发到查询单选题页面*/
	@RequestMapping("/toAllSCQuestion.action")
	public String toAllSCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "SCQuestionAll";
		
	}
	
	/*转发到查询单选题页面*/
	@RequestMapping("/toMySCQuestion.action")
	public String toMySCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "mySCQuestion";
		
	}
	
	/*转发到查询多选题页面*/
	@RequestMapping("/toAllMCQuestion.action")
	public String toAllMCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "MCQuestionAll";
		
	}
	
	/*转发到wo的查询多选题页面*/
	@RequestMapping("/toMyMCQuestion.action")
	public String toMyMCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "myMCQuestion";
		
	}
	
	/*转发到查询填空题页面*/
	@RequestMapping("/toAllFBQuestion.action")
	public String toAllFBQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "FBQuestionAll";
		
	}
	
	/*转发到wo的查询填空页面*/
	@RequestMapping("/toMyFBQuestion.action")
	public String toMyFBQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "myFBQuestion";
		
	}
	/*转发到查询判断题页面*/
	@RequestMapping("/toAllTFQuestion.action")
	public String toAllTFQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "TFQuestionAll";
		
	}
	
	/*转发到我的判断页面*/
	@RequestMapping("/toMyTFQuestion.action")
	public String toMyTFQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "myTFQuestion";
	}
	
	/*转发到查询简答题页面*/
	@RequestMapping("/toAllQAQuestion.action")
	public String toAllQAQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "QAQuestionAll";
		
	}
	
	/*转发到我的简答题页面*/
	@RequestMapping("/toMyQAQuestion.action")
	public String toMyQAQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "myQAQuestion";
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	/*转发到单选题添加页面*/
	@RequestMapping("/toAddSCQuestion.action")
	public String toAddSCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "addSCQuestion";
		
	}
	/*转发到多选题添加页面*/
	@RequestMapping("/toAddMCQuestion.action")
	public String toAddMCQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "addMCQuestion";
		
	}
	/*转发到判断题添加页面*/
	@RequestMapping("/toAddTFQuestion.action")
	public String toAddTFQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "addTFQuestion";
		
	}
	/*转发到填空题添加页面*/
	@RequestMapping("/toAddFBQuestion.action")
	public String toAddFBQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "addFBQuestion";
		
	}
	/*转发到填空题添加页面*/
	@RequestMapping("/toAddQAQuestion.action")
	public String toAddQAQuestion(HttpServletRequest request,Model model){
		//System.out.println("toAddSCQuestion");
		List<Subject> subjectList=subjectService.getAllSubjects();
		
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		//System.out.println("list:"+subjectList.toString());
		return "addQAQuestion";
		
	}
	
	//////////////////////////////////////////////////////////////////////
	
	
	
}
