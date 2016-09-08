package com.test.temp;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FirstTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setTemplateLoader(new ClassTemplateLoader(FirstTest.class, "/com/test/temp"));
		try {
			Template t = cfg.getTemplate("temp.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> context = new HashMap<String, Object>();

			context.put("message", "hello,小兄弟");

			t.process(context, writer);
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
