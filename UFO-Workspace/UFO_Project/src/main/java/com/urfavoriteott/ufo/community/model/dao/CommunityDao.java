package com.urfavoriteott.ufo.community.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.urfavoriteott.ufo.common.model.vo.PageInfo;
import com.urfavoriteott.ufo.community.model.vo.Community;
import com.urfavoriteott.ufo.cs.model.vo.Notice;

@Repository
public class CommunityDao {

	/**
	 * 커뮤니티 게시글의 총 개수를 구하는 메소드 - 작성자 : 황혜진 
	 * @param sqlSession
	 * @return
	 */
	public int selectCommunityListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("communityMapper.selectCommunityListCount");
	}

	/**
	 * 커뮤니티 리스트 조회 메소드(관리자 + 회원) - 작성자 : 황혜진
	 * @param sqlSession
	 * @param pi
	 * @return
	 */
	public ArrayList<Community> selectCommunityList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
      
		RowBounds rowBounds = new RowBounds(offset, limit);		
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectCommunityList", null, rowBounds);
	}

	/**
	 * 커뮤니티 게시글 작성 메소드 - 작성자 : 황혜진
	 * @param sqlSession
	 * @param c : 작성할 커뮤니티 게시글의 정보
	 * @return
	 */
	public int insertCommunity(SqlSessionTemplate sqlSession, Community c) {
		
		return sqlSession.insert("communityMapper.insertCommunity", c);
	}
	
	/**
	 * 커뮤니티 게시글 조회수 증가 메소드(관리자 + 회원) - 작성자 : 황혜진
	 * @param sqlSession
	 * @param comNo : 조회수 증가할 커뮤니티 게시글 번호
	 * @return
	 */
	public int communityIncreaseCount(SqlSessionTemplate sqlSession, int comNo) {
		
		return sqlSession.update("communityMapper.communityIncreaseCount", comNo);
	}
	
	/**
	 * 커뮤니티 게시글 상세조회 메소드(관리자 + 회원) - 작성자 : 황혜진
	 * @param sqlSession
	 * @param comNo : 상세조회할 커뮤니티 게시글 번호
	 * @return
	 */
	public Community selectCommunity(SqlSessionTemplate sqlSession, int comNo) {
		
		return sqlSession.selectOne("communityMapper.selectCommunity", comNo);
	}
	
}