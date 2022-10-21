<%@page import="todo.dto.TodoDTO"%>
<%@page import="todo.dao.impl.todoDAOImpl"%>
<%@page import="todo.service.todoservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


System.out.println("딜리트 ㅌㅋ"+request.getParameter("num"));
int index= Integer.parseInt(request.getParameter("num"));

//int index2= Integer.parseInt(request.getParameter("순번"));



todoservice todoservice =new todoDAOImpl();

TodoDTO  todoDTO = new TodoDTO();


todoservice.delete(index);


%>