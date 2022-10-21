package todo.service;

import java.util.List;

import todo.dto.TodoDTO;

public interface todoservice {
	public List<TodoDTO> list() throws Exception;
	public int insert(String todo, String time) throws Exception  ;
	public int delete(int 순서) throws Exception ;
	public int deleteAll( ) throws Exception ;
	public int idreturn() throws Exception;
	
}
