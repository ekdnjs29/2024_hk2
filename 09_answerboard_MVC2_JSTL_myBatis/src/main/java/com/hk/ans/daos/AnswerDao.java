package com.hk.ans.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.ans.config.SqlMapConfig;
import com.hk.ans.dtos.AnswerDto;

public class AnswerDao extends SqlMapConfig{

	private String nameSpace="com.hk.ans.";
	
	//1.글목록 조회하기
	public List<AnswerDto> getAllList(String pnum){
		List<AnswerDto> list=new ArrayList<>();
		
		SqlSession sqlSession=null;//쿼리 실행을 위한 객체
		
		try {
			//sqlSession객체를 구하려면 openSession()을 통해서 얻어온다.
			//sqlSession객체를 구함: true-autocommit설정
			sqlSession=getSqlSessionFactory().openSession(true);
			list=sqlSession.selectList(nameSpace+"boardlist",pnum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//페이지수 구하기
	public int getPCount() {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.selectOne(nameSpace+"getpcount");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count;
	}
	
	//새글 추가하기: insert문 실행
	public boolean insertBoard(AnswerDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			//파라미터 타입: DTO, Array, Map, String, int
			//insert(쿼리ID이름, 파라미터)<---전달할 파라미터 개수가 여러개일경우 
			//                            하나의 객체에 담아서 전달해야 함
			count=sqlSession.insert(nameSpace+"insertboard", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
}



