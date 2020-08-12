package com.begonia.javassist.demo.sample;

import javassist.*;

import java.io.IOException;

public class JavaReflect {
    public static void main(String[] args) throws NotFoundException {
        ClassPool cp=    ClassPool.getDefault();
        ClassClassPath  path=new ClassClassPath(JavaReflect.class);
        cp.insertClassPath(path);
        CtClass  ctClass=cp.get("com.begonia.javassist.demo.StringHandler");
        CtMethod  ctMethod= ctClass.getDeclaredMethod("append");

        //CtMethod  ctMethod= ctClass.getDeclaredMethod("temp1");
        try {
           CtMethod  addTemp= CtNewMethod.copy(ctMethod,"addtemp",ctClass,null);
           ctClass.addMethod(addTemp);
           ctClass.writeFile();
            System.out.println("add  addtemp method  success...");
        } catch (CannotCompileException | IOException e) {
            e.printStackTrace();
        }


    }

}
