package com.begonia.javassist.demo.evolve;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Updatable class.  DemoServer instantiates this class and calls
 * show() on the created object.
 */

public class WebPage {
    public void show(OutputStreamWriter out) throws IOException {
	Calendar c = new GregorianCalendar();
	out.write(c.getTime().toString());
	out.write("<P><A HREF=\"demo.html\">Return to the home page.</A>");
    }
}
