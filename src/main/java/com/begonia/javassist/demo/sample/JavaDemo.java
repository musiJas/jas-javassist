package com.begonia.javassist.demo.sample;

import com.begonia.javassist.demo.StringBuffer;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaDemo {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {

       ClassPool  classPool=ClassPool.getDefault();
       CtClass ctClass= classPool.get("com.begonia.javassist.demo.Test");
       ctClass.setSuperclass(classPool.get("com.begonia.javassist.demo.StringHandler"));
       ctClass.setAttribute("result","hahahahahaha".getBytes());
       ctClass.writeFile();
       Class  cs= ctClass.toClass();
        try {
            StringBuffer sb= (StringBuffer) cs.newInstance();
            Field  field= cs.getField("temp");
            field.setAccessible(true);
            field.set(sb,"hello");
            Method  method= cs.getMethod("append",String.class);
            Object  obj=method.invoke(sb,"world");

            System.out.println(sb.toString());
            System.out.println(new String((String) obj));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /*byte[]  bytes=ctClass.toBytecode();
        System.out.println(new String(bytes,"utf-8"));*/


    }
}
