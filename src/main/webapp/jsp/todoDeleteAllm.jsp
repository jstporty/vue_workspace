<%@page import="todo.dao.impl.todoDAOImpl"%>
<%@page import="todo.service.todoservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
todoservice todoservice= new todoDAOImpl();

todoservice.deleteAll();


%>