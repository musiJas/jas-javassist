package com.begonia.javassist.demo;

public class StringHandler {

    private  String [] charset;
    private  int   lengh;
    private  String  result;
    public   String  temp;

    public  StringHandler(){

    }
    public  String  append(String  st){
        java.lang.StringBuffer  stringBuffer=new java.lang.StringBuffer();
        return  stringBuffer.append(result).append(st).toString();
    }

    public  String  setResult(String  ts){
        this.result=ts;
        return  result;
    }

    public String[] getCharset() {
        return charset;
    }

    public void setCharset(String[] charset) {
        this.charset = charset;
    }

    public int getLengh() {
        return lengh;
    }

    public void setLengh(int lengh) {
        this.lengh = lengh;
    }

    public String getResult() {
        return result;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
