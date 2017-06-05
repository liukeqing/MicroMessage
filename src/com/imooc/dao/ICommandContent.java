package com.imooc.dao;

import java.util.List;

import com.imooc.bean.CommandContent;

public interface ICommandContent {
	public void insertBatch(List<CommandContent> contentList);
}
