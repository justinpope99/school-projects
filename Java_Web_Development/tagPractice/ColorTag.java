package tagPractice;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColorTag extends SimpleTagSupport{
	
	private String foregroundColor;
	private String backgroundColor;
	
	public void setForegroundColor(String foregroundColor) {
		this.foregroundColor = foregroundColor;
	}
	
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<body bgcolor=\"" + backgroundColor + "\""
				+ "text=\""+ foregroundColor +"\"></body>");
		getJspBody().invoke(null);
	}
}
