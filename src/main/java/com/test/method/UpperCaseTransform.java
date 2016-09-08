package com.test.method;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.TemplateTransformModel;

public class UpperCaseTransform implements TemplateTransformModel {

	public Writer getWriter(Writer out, Map args) {
		return new UpperCaseWriter(out);
	}

	private class UpperCaseWriter extends Writer {

		private Writer out;

		UpperCaseWriter(Writer out) {
			this.out = out;
		}

		public void write(char[] cbuf, int off, int len) throws IOException {
			out.write(new String(cbuf, off, len).toUpperCase());
		}

		public void flush() throws IOException {
			out.flush();
		}

		public void close() {
		}
	}
}
