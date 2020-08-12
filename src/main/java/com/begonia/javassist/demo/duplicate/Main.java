package com.begonia.javassist.demo.duplicate;

import javassist.tools.reflect.Loader;

public class Main {
    public static void main(String[] args) throws Throwable {
	Loader cl = new Loader();
	cl.makeReflective("com.begonia.javassist.demo.duplicate.Ball",
			  "com.begonia.javassist.demo.duplicate.DuplicatedObject",
			  "javassist.tools.reflect.ClassMetaobject");
	cl.run("com.begonia.javassist.demo.duplicate.Viewer", args);
    }
}
