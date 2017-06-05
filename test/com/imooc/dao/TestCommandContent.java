package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.junit.Test;

import com.imooc.bean.CommandContent;

public class TestCommandContent {
	
	public static void main(String[] args) {
		
		CommandContentDao commandContentDao = new CommandContentDao();
		List<CommandContent> contentList = new ArrayList<>();
		CommandContent content = new CommandContent();
		content.setCommandId("1");
		content.setContent("你好");
		CommandContent content1 = new CommandContent();
		content1.setCommandId("2");
		content1.setContent("我是谁");
		CommandContent content2 = new CommandContent();
		content2.setCommandId("3");
		content2.setContent("还须问");
		
		contentList.add(content);
		contentList.add(content1);
		contentList.add(content2);
		commandContentDao.insertBatch(contentList);
	}
	
}
