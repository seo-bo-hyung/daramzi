package com.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {
	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		System.out.println("getParameterValues 확인 ");
		if (values == null) {
			return null;

		}

		int count = values.length;

		String[] encodedValues = new String[count];

		for (int i = 0; i < count; i++) {

			encodedValues[i] = cleanXSS(values[i]);
		}

		return encodedValues;
	}

	public String getParameter(String parameter) {
		System.out.println("getParameter 확인 ");
		String value = super.getParameter(parameter);

		if (value == null) {

			return null;

		}

		return cleanXSS(value);

	}

	public String getHeader(String name) {
		System.out.println("getHeader 확인 ");
		String value = super.getHeader(name);

		if (value == null) {
			return null;
		}

		return cleanXSS(value);
	}

	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		System.out.println("cleanXSS 확인 ");
		System.out.println("value 확인 : " + value);
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");

		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");

		value = value.replaceAll("'", "& #39;");

		value = value.replaceAll("eval\\((.*)\\)", "");

		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

		value = value.replaceAll("script", "");

		System.out.println("최종 value 확인 : " + value);
		return value;

	}
}
