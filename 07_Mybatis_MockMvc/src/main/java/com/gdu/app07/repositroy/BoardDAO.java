package com.gdu.app07.repositroy;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app07.domain.BoardDTO;

@Repository // 나를 스프링컨테이너에 Bean으로 만들어라
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; // DBConfig에 bean을 DAO가 사용할 수 있다. 
	
	
	private final String NS = "mybatis.mapper.board.";
	
	// 목록 반환 
	public List<BoardDTO> selectBoardList() {// 메소드 이름은 쿼리문에 ID를 그대로 메소드 이름으로 사용
		return sqlSessionTemplate.selectList(NS + "selectBoardList"); // mapper에 이름은 namespace를 적어준다. (파일지정)
		// 마이바티스 폴더 밑에 매퍼 폴더 밑에 보드.xml 밑에 selectBoardList 아이들을 가진 쿼리문을 호출 
	}
	
	// public 반환타입 메소드명(매개변수)
	// 매퍼에서 받아오는건 boardDTO 1개 -> 그대로 서비스에게 돌려줌 반환타입이 그래서 BOARDDTO 
	public BoardDTO selectBoardByNo(int boardNo) {
		// 호출할 쿼리문에 아이디, 전달하는 값
		return sqlSessionTemplate.selectOne(NS + "selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {
		return sqlSessionTemplate.insert(NS + "insertBoard", board);
	}
	
	public int updateBoard(BoardDTO board) {
		return sqlSessionTemplate.update(NS + "updateBoard", board);
	}
	
	public int deleteBoard(int boardNo) {
		return sqlSessionTemplate.delete(NS + "deleteBoard", boardNo);
	}
	
	
	
}
