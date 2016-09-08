package com.test.temp;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.method.DateUtil;
import com.test.method.UpperCaseTransform;
import com.test.temp.pojo.Animal;
import com.test.temp.pojo.Author;
import com.test.temp.pojo.Book;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SecondTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setTemplateLoader(new ClassTemplateLoader(SecondTest.class, "/com/test/temp"));
		try {
			Template t = cfg.getTemplate("second.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> context = new HashMap<String, Object>();

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
			t.process(context, writer);
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
