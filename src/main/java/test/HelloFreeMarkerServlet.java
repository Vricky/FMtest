package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloFreeMarkerServlet extends HttpServlet {

	private Configuration cfg = null;
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Map<String, String> root = new HashMap<String, String>();
		root.put("message", "hello world！");
		root.put("name", "java小强");
		Template t = cfg.getTemplate("test.ftl");
		response.setContentType("text/html;charset=" + t.getEncoding());
		Writer out = response.getWriter();
		
		try {
			t.process(root, out);
		} catch (TemplateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
		cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");
		
	}

}


/*public class HelloFreeMarkerServlet extends HttpServlet {  
15.    // 负责管理FreeMarker模板的Configuration实例  
16.    private Configuration cfg = null;  
17.    public void init() throws ServletException {  
18.        // 创建一个FreeMarker实例  
19.        cfg = new Configuration();  
20.        // 指定FreeMarker模板文件的位置  
21.        cfg.setServletContextForTemplateLoading(getServletContext(),  
22.                "/WEB-INF/templates");  
23.    }  
24.    @SuppressWarnings("unchecked")  
25.    public void doPost(HttpServletRequest request, HttpServletResponse response)  
26.            throws ServletException, IOException {  
27.        // 建立数据模型  
28.        Map root = new HashMap();  
29.        root.put("message", "hello world");  
30.        root.put("name", "java小强");  
31.        // 获取模板文件  
32.        Template t = cfg.getTemplate("test.ftl");  
33.        // 使用模板文件的Charset作为本页面的charset  
34.        // 使用text/html MIME-type  
35.        response.setContentType("text/html; charset=" + t.getEncoding());  
36.        Writer out = response.getWriter();  
37.        // 合并数据模型和模板，并将结果输出到out中  
38.        try {  
39.            t.process(root, out); // 往模板里写数据  
40.        } catch (TemplateException e) {  
41.            e.printStackTrace();  
42.        }  
43.    } */ 
















