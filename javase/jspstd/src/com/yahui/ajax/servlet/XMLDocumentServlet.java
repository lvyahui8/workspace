package com.yahui.ajax.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("serial")
public class XMLDocumentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");
		PrintWriter out = resp.getWriter();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			String data[] = {"北京","上海","永州","深圳"};
			Element allarea = doc.createElement("allarea");
			for(int i=0;i<data.length;i++){
				Element area = doc.createElement("area");
				Element id = doc.createElement("id");
				Element title = doc.createElement("title");
				id.setTextContent(""+(i+1));
				title.setTextContent(data[i]);
				area.appendChild(id);
				area.appendChild(title);
				allarea.appendChild(area);
			}
			doc.appendChild(allarea);
			//输出
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(bos);
			tf.transform(source, result);
			System.out.println(bos);
			out.print(bos);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
