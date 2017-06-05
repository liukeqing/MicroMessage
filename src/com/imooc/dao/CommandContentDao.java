package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.CommandContent;
import com.imooc.db.DBAccess;

public class CommandContentDao {
	public void insertBatchByJdbc(List<CommandContent> contentList){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micromessage","root","root");
			String insertSql = "insert into command_content(content,command_id) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(insertSql);
			for(CommandContent content: contentList){
				ps.setString(1, content.getContent());
				ps.setString(2, content.getCommandId());
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertBatch(List<CommandContent> contentList){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
			iCommandContent.insertBatch(contentList);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
}
