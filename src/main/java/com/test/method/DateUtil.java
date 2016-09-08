package com.test.method;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class DateUtil implements TemplateMethodModel {

	public String exec(List args) throws TemplateModelException {
		SimpleDateFormat mydate = new SimpleDateFormat((String)args.get(0));
        return mydate.format(new Date(Long.parseLong((String)args.get(1))));
    }

}