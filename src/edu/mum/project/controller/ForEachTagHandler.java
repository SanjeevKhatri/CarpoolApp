package edu.mum.project.controller;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTagHandler extends SimpleTagSupport {
	String foreColor;
	String text;
	
	System.out.println("-11111111111111111111111111111111111111111");

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (foreColor != null)
			out.write(String.format("<span style='color:%s'>%s</span>", foreColor, text));
		else
			out.write(String.format("<span>%s</span>", text));
	}

	// Setters
	public void setForeColor(String foreColor) {
		this.foreColor = foreColor;
		System.out.println("11111111111111111111111111111111111111111");
	}

	public void setText(String text) {
		this.text = text;
	}

}