package todo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.dao.todoDAO;
import todo.dto.TodoDTO;
import todo.util.DB;

public class todoDAOImpl implements todoDAO {

	
	@Override
	public List<TodoDTO> list() throws Exception {
		Connection conn = DB.getConnection();
		String sql="select * from todo";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("zzzzzzzzzzzzz"+conn);
		
		//pstmt.setString(1, bid);
		rs = pstmt.executeQuery();
 
		List<TodoDTO> list = new ArrayList<TodoDTO>();

	      while (rs.next()) {
	    	  TodoDTO todoDTO= new TodoDTO();
	    	  todoDTO.set순번(rs.getInt("순번"));
	    	  todoDTO.set시간(rs.getString("시간"));
	    	  todoDTO.set할일(rs.getString("할일"));
	         
	         

	         list.add(todoDTO);
	      }
	      return list;

	} // viewBoard

	@Override
	public int insert(String todo, String time) throws Exception {
		Connection conn = DB.getConnection();
		String sql=" insert into todo (할일,시간)values ( ?,?)";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

	    	  pstmt.setString(1,todo);
	    	  pstmt.setString(2,time);

	    	  int rs = pstmt.executeUpdate();

	      return rs;
	}
	
	@Override
	public int delete(int 순서) throws Exception {
		Connection conn = DB.getConnection();
		String sql=" delete from todo where 순번=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

	    	  pstmt.setInt(1,순서);

	    	  	int rs = pstmt.executeUpdate();
	      return rs;
	}
	
	@Override
	public int deleteAll( ) throws Exception {
		Connection conn = DB.getConnection();
		String sql="truncate table todo;";
		PreparedStatement pstmt = conn.prepareStatement(sql);



	    	  	int rs = pstmt.executeUpdate();
	      return rs;
	}
	
	@Override
	public int idreturn() throws Exception {
		
		Connection conn = DB.getConnection();
		String sql2=" select 순번 from todo order by 순번 desc limit 1";
		PreparedStatement pstmt = conn.prepareStatement(sql2);
		ResultSet rs2=pstmt.executeQuery();
		int numm=0;
		if(rs2.next()) {
		numm= rs2.getInt("순번");
		}
		return numm;
	}
	
	
	
}
