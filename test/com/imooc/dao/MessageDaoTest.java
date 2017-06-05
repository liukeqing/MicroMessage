package com.imooc.dao;

import org.junit.Test;

public class MessageDaoTest {
	
	@Test
	public void testQueryMessageList() {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList(null);
	}
}
