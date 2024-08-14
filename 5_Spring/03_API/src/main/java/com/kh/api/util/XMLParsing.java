package com.kh.api.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void main(String[] args) {
		String serviceKey = "L6kAuNH9cshbOofaVUQ0yP2YLErUVNV4AixaDbTiAgDDmg8OvkSjPx9Ayj6uBXxEihEl%2B1oRc%2FpR8ihynEusIg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey
				+ "&numOfRows=396";

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("파싱할 데이터 수 : " + nList.getLength());

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("MAIN_TITLE : " + getTagatValue("MAIN_TITLE",  eElement));
					System.out.println("ADDR1 : " + getTagatValue("ADDR1", eElement));
					System.out.println("--------------------------------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getTagatValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

}
