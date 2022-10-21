<%@page import="todo.dto.TodoDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="todo.dao.impl.todoDAOImpl"%>
<%@page import="todo.dao.todoDAO"%>
<%@page import="todo.service.todoservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.getParameter("todo");
request.getParameter("time");

todoservice todoservice = new todoDAOImpl();

todoservice.insert(request.getParameter("todo"),request.getParameter("time"));




System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+todoservice.idreturn());
Gson gson = new Gson();
int numm=todoservice.idreturn();

TodoDTO todoDTO= new TodoDTO();
todoDTO.set순번(numm);
todoDTO.set시간((String)request.getParameter("time"));
todoDTO.set할일((String)request.getParameter("todo"));


String result = gson.toJson(todoDTO);

out.print(result);

%>