package com.test.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.method.DateUtil;
import com.test.method.UpperCaseTransform;
import com.test.temp.pojo.Animal;
import com.test.temp.pojo.Author;
import com.test.temp.pojo.Book;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("serial")
public class TestFmServlet extends HttpServlet {
	private Configuration cfg = null;

	public void init() throws ServletException {
		cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");
	}
	
	public void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> root = new HashMap<>();
		root.put("title", "demo");
		root.put("message", "aaa");
		root.put("name", "bbb");
		Template t = cfg.getTemplate("first.ftl");
		response.setContentType("text/html; charset=" + t.getEncoding());
		Writer out = response.getWriter();
		try {
			t.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> context = new HashMap<>();
		context.put("title", "hello,小兄弟 <>");
		context.put("timer", new DateUtil());
		context.put("date", System.currentTimeMillis()+"");
		context.put("upcase", new UpperCaseTransform());
		List<String> list = new ArrayList<>();
		list.add("spring");
		list.add("summer");
		list.add("autumn");
		list.add("winter");
		context.put("sequence", list);
		
		Book book = new Book();
		Author author = new Author();
		author.setName("annlee");
		author.setAddress("nb");
		book.setName("struts2");
		book.setAuthor(author);
		context.put("info","struts");
		context.put("book", book); 
		
		List<Animal> aList = new ArrayList<>();
		Animal an = new Animal();
		an.setName("elephant");
		an.setSize("large");
		an.setHeight(1);
		aList.add(an);
		context.put("animals", aList);
		
		Map<String,Integer> m1 = new HashMap<>();
		m1.put("语文", 44);
		m1.put("数学", 59);
		
		Map<String,Integer> m2 = new HashMap<>();
		m1.put("英语", 99);
		m1.put("自然", 89);
		context.put("m1",m1);
		context.put("m2",m2);
		Template t = cfg.getTemplate("second.ftl");
		response.setContentType("text/html; charset=" + t.getEncoding());
		Writer out = response.getWriter();
		try {
			t.process(context, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost1(request, response);
	}

	public void destroy() {
		super.destroy();
	}
}