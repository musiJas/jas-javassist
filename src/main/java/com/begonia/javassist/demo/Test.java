package com.begonia.javassist.demo;
import javassist.*;

public class Test {
    public int f(int i) {
	return i + 1;
    }

    public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(Test.class);
		pool.insertClassPath(classPath);
		CtClass cc = pool.get("com.begonia.javassist.demo.Test");
	try {
	    cc.getDeclaredMethod("g");
	    System.out.println("g() is already defined in sample.Test.");
	}
	catch (NotFoundException e) {
	    /* getDeclaredMethod() throws an exception if g()
	     * is not defined in sample.Test.
	     */
	    CtMethod fMethod = cc.getDeclaredMethod("f");
	    CtMethod gMethod = CtNewMethod.copy(fMethod, "g", cc, null);
	    cc.addMethod(gMethod);
	    cc.writeFile();	// update the class file
	    System.out.println("g() was added.");
	}
    }
}
