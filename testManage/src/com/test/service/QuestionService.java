package com.test.service;

import java.util.List;

import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.SCQuestionData;


public interface QuestionService {

	public int saveSCQuestion(SCQuestionData scQuestionData);  //插入单选试题，用实体作为参数
	
	public int saveMCQuestion(MCQuestion mcQuestion);  //插入多选题，用实体作为参数
	
	public int saveFBQuestion(FBQuestion fbQuestion);  //插入填空题，用实体作为参数
	
	public int saveTFQuestion(TFQuestion tfQuestion);  //插入判断题，用实体作为参数
	
	public int saveQAQuestion(QAQuestion qaQuestion);  //插入简答题，用实体作为参数
	
	public List<SCQuestion> getAllSCQuestions(String subjectId);//获取所有的单选题
	
	public List<MCQuestion> getAllMCQuestions(String subjectId);//获取所有的多选题
	
	public List<TFQuestion> getAllTFQuestions(String subjectId);//获取所有的判断题
	
	public List<FBQuestion> getAllFBQuestions(String subjectId);//获取所有的填空题
	
	public List<QAQuestion> getAllQAQuestions(String subjectId);//获取所有的简答题

	public boolean deleteSCQuestion(String sc_id);//删除单选题

	public boolean deleteQAQuestion(String qa_id);//删除简答题

	public boolean deleteFBQuestion(String fb_id);//删除填空题

	public boolean deleteTFQuestion(String tf_id);//删除判断题

	public boolean deleteMCQuestion(String mc_id);//删除多选题

	public boolean updateQAQuestion(String qa_id);

	public boolean updateFBQuestion(String fb_id);

	public boolean updateTFQuestion(String tf_id);

	public boolean updateMCQuestion(String mc_id);

	public boolean updateSCQuestion(SCQuestionData scquestionData);
	
	public SCQuestion selectSCQuestionById(String sc_id);

	public MCQuestion selectMCQuestionById(String mc_id);

	public TFQuestion selectTFQuestionById(String tf_id);

	public FBQuestion selectFBQuestionById(String fb_id);

	public QAQuestion selectQAQuestionById(String qa_id);
	
	
}
