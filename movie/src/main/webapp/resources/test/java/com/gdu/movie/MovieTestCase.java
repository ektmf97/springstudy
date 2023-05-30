package com.gdu.movie;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.app04.domain.BoardDTO;
import com.gdu.app04.repository.BoardDAO;
import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

// JUnit4
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 메소드명의 알파벳순으로 테스트를 수행한다.
public class MovieTestCase {

	
	@Autowired
	private MovieMapper movieMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieTestCase.class);
	
	
	@Test
	public void 영화목록테스트() {
		List<MovieDTO> list = movieMapper.getAllMovies();
		LOGGER.debug(list.toString());
		assertEquals(1, list.size()); 
	}
	
}
