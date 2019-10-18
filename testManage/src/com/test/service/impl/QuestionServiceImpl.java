package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.FBQuestionDao;
import com.test.dao.MCQuestionDao;
import com.test.dao.QAQuestionDao;
import com.test.dao.SCQuestionDao;
import com.test.dao.TFQuestionDao;
import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.SCQuestionData;
import com.test.service.QuestionService;
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	SCQuestionDao scQuestionDao;
	
	@Autowired
	MCQuestionDao mcQuestionDao;
	
	@Autowired
	TFQuestionDao tfQuestionDao;
	
	@Autowired 
	FBQuestionDao fbQuestionDao;
	
	@Autowired 
	QAQuestionDao qaQuestionDao;
	/*添加单选题*/
	@Override
	public int  saveSCQuestion(SCQuestionData scQuestionData) {
		
		
		Integer subject=scQuestionData.getSc_subject();
		String opint=scQuestionData.getSc_point();
		String stem=scQuestionData.getSc_stem();
		String option=scQuestionData.getSc_option();
		String answer=scQuestionData.getSc_answer();
		String analysis=scQuestionData.getSc_analysis();
		Integer c_id=scQuestionData.getSc_c_id();
		Integer ct_id=scQuestionData.getSc_ct_id();
		String username="admin";
		SCQuestion scQuestion=new SCQuestion(subject,opint,stem,option,answer,analysis,username,c_id,ct_id);
		return scQuestionDao.saveSCQuestion(scQuestion);
	}
	/*添加多选题*/
	@Override
	public int saveMCQuestion(MCQuestion mcQuestion) {
		String username="admin";
		mcQuestion.setMc_t_name(username);
		return mcQuestionDao.saveMCQuestion(mcQuestion);
	}
	/*添加填空题*/
	@Override
	public int saveFBQuestion(FBQuestion fbQuestion) {
		String username="admin";
		fbQuestion.setFb_t_name(username);
		
		return fbQuestionDao.saveFBQuestion(fbQuestion);
		
	}
	/*添加判断题*/
	@Override
	public int saveTFQuestion(TFQuestion tfQuestion) {
		String username="admin";
		tfQuestion.setTf_t_name(username);
		return tfQuestionDao.saveTFQuestion(tfQuestion);
	}

	/*添加简答题*/
	@Override
	public int saveQAQuestion(QAQuestion qaQuestion) {
		String username="admin";
		qaQuestion.setQa_t_name(username);
		return qaQuestionDao.saveQAQuestion(qaQuestion);
	}
	/*添加单选题*/
	@Override
	public List<SCQuestion> getAllSCQuestions(String subjectId) {

		Integer s_id=Integer.valueOf(subjectId);
		List<SCQuestion> list=scQuestionDao.getSCQuestionsBySub(s_id);
		
		return list;
	}
	@Override
	public List<MCQuestion> getAllMCQuestions(String subjectId) {
		Integer s_id=Integer.valueOf(subjectId);
		List<MCQuestion> list=mcQuestionDao.getMCQuestionsBySub(s_id);
		return list;
	}
	@Override
	public List<TFQuestion> getAllTFQuestions(String subjectId) {
		Integer s_id=Integer.valueOf(subjectId);
		List<TFQuestion> list=tfQuestionDao.getTFQuestionsBySub(s_id);
		
		return list;
	}
	@Override
	public List<FBQuestion> getAllFBQuestions(String subjectId) {
		Integer s_id=Integer.valueOf(subjectId);
		List<FBQuestion> list=fbQuestionDao.getFBQuestionsBySub(s_id);
		return list;
	}
	@Override
	public List<QAQuestion> getAllQAQuestions(String subjectId) {
		Integer s_id=Integer.valueOf(subjectId);
		List<QAQuestion> list=qaQuestionDao.getQAQuestionsBySub(s_id);
		
		return list;
	}
	@Override
	public boolean deleteSCQuestion(String id) {
		Integer sc_id=Integer.valueOf(id);
		
		if(scQuestionDao.deleteById(sc_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteQAQuestion(String id) {
		Integer qa_id=Integer.valueOf(id);
		
		if(qaQuestionDao.deleteById(qa_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteFBQuestion(String id) {
		Integer fb_id=Integer.valueOf(id);
		if(fbQuestionDao.deleteById(fb_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteTFQuestion(String id) {
		Integer tf_id=Integer.valueOf(id);
		if(tfQuestionDao.deleteById(tf_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteMCQuestion(String id) {
		Integer mc_id=Integer.valueOf(id);
		if(mcQuestionDao.deleteById(mc_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateQAQuestion(String id) {
		Integer qa_id=Integer.valueOf(id);
		if(qaQuestionDao.updateById(qa_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateFBQuestion(String id) {
		Integer fb_id=Integer.valueOf(id);
		if(fbQuestionDao.updateById(fb_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateTFQuestion(String id) {
		Integer tf_id=Integer.valueOf(id);
		if(tfQuestionDao.updateById(tf_id)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateMCQuestion(String id) {
		Integer mc_id=Integer.valueOf(id);
		if(mcQuestionDao.updateById(mc_id)>0){
			return true;
		}
		return false;
	}
	
	@Override
	public SCQuestion selectSCQuestionById(String id) {
		Integer sc_id=Integer.valueOf(id);
		
		SCQuestion scQuestion=(SCQuestion) scQuestionDao.selectById(sc_id);
		return scQuestion;
	}
	@Override
	public MCQuestion selectMCQuestionById(String id) {
		Integer mc_id=Integer.valueOf(id);
		MCQuestion mcQuestion=mcQuestionDao.selectById(mc_id);
		return null;
	}
	@Override
	public TFQuestion selectTFQuestionById(String id) {
		Integer sc_id=Integer.valueOf(id);
		return null;
	}
	@Override
	public FBQuestion selectFBQuestionById(String id) {
		Integer sc_id=Integer.valueOf(id);
		return null;
	}
	@Override
	public QAQuestion selectQAQuestionById(String id) {
		Integer sc_id=Integer.valueOf(id);
		return null;
	}
	@Override
	public boolean updateSCQuestion(SCQuestionData scQuestionData) {
		Integer subject=scQuestionData.getSc_subject();
		String opint=scQuestionData.getSc_point();
		String stem=scQuestionData.getSc_stem();
		String option=scQuestionData.getSc_option();
		String answer=scQuestionData.getSc_answer();
		String analysis=scQuestionData.getSc_analysis();
		Integer c_id=scQuestionData.getSc_c_id();
		Integer ct_id=scQuestionData.getSc_ct_id();
		String username="admin";
		SCQuestion scQuestion=new SCQuestion(subject,opint,stem,option,answer,analysis,username,c_id,ct_id);
		if( scQuestionDao.updateSCQuestion(scQuestion)>0){
			return false;
		}
		return false;
	}

	

}
