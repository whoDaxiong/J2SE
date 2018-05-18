package com;
import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;

import java.util.*; 

import org.xml.sax.helpers.DefaultHandler;
public class xmlSAX {
	public static void main(String arg[]){
		Customers customers = null;
		try{
			Unmarshaller handler = new Unmarshaller();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			File file = new File("customer.xml");
			saxParser.parse(file, handler);
			customers = handler.getCustomers();
		}catch(Throwable t){
			t.printStackTrace();
		}
		System.out.println(customers);
	}
	
}

class Customers{
	private Vector customers;
	public Customers(){
		customers = new Vector();//容纳多个customer的向量
	}
	public void addCustomer(Customer customer){//添加一个customer向量
		customers.add(customer);
	}
	public String toString(){
		String newline = System.getProperty("Line.separator");
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i<customers.size();i++)
		{
			buf.append(customers.elementAt(i)).append(newline);
		}
		return buf.toString();
	}
}
class Customer{
	private String id;
	private String name;
	private String address;
	public String getAddress(){
		return address;
	}
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	public void setAddress(String string){
		address = string;
	}
	public void setId(String string){
		id = string;
	}
	public void setName(String string){
		name = string;
	}
	public String toString(){
		return "Customer:ID="+id+"address:"+address+"name:"+name;
	}
}

//SAX处理器类
class Unmarshaller extends DefaultHandler{
	private Customers customers;
	private Stack stack;
	private boolean isStackReadyForText;
	private Locator locator;
	public void Unmarshaller(){
		stack = new Stack();
		isStackReadyForText = false;
	}
	public Customers getCustomers(){
		return customers;
	}
	public void setDocumentLocator(Locator rhs){
		locator = rhs;
	}
	public void srartElement(String uri,String qName,String sName,Attributes attrs){//attributes from org.sax...
		isStackReadyForText = false;
		if(sName.equals("customers")){
			stack.push(new Customers());
		}
		else if(sName.equals("customer")){
			stack.push(new Customer());
		}
		else if(
				sName.equals("id")
				||sName.equals("name")
				||sName.equals("address")){
					stack.push(new StringBuffer());
					isStackReadyForText = true;
		}else{
			
		}
		
	}
	
	public void endElement(String namespaceURI,String qName,String sName){
		isStackReadyForText = false;
		Object temp = stack.pop();
		if(sName.equals("customers")){
			customers = (Customers)temp;
		}
		else if(sName.equals("customer")){
			((Customers)stack.peek()).addCustomer((Customer)temp);//////////////////(Customer)temp
		}
		else if(sName.equals("id")){
			((Customer)stack.peek()).setId(temp.toString());
		}else if(sName.equals("name")){
			((Customer)stack.peek()).setName(temp.toString());
		}else if(sName.equals("address")){
			((Customer)stack.peek()).setAddress(temp.toString());
		}
	}
	
	public void characters(char[] data,int start,int length){
		if(isStackReadyForText==true){
			((StringBuffer)stack.peek()).append(data,start,length);
		}else{
			
		}
	}
}




















