package com.wyc;

import com.cdivtc.BlogApplication;
import com.cdivtc.mapper.CrClassReportMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CrClassReportMapper crClassReportMapper;

	@Test
	public void test(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("start", 0);
		map.put("row", 3);
//		System.out.println(crClassReportMapper.findPageCount(map));
		System.out.println(crClassReportMapper.findPageCountAll().size());
	}

}
