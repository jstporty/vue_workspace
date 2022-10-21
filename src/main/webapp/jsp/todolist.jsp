<%@page import="todo.dto.TodoDTO"%>
<%@page import="todo.dao.impl.todoDAOImpl"%>
<%@page import="todo.service.todoservice"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
 todoservice todoservice = new todoDAOImpl();

 List<TodoDTO> todoDTO = todoservice.list();
 
 Gson gson = new Gson();
    
 String result = gson.toJson(todoDTO);
 
out.print(result);
	%>
	