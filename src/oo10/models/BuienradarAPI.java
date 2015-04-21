package oo10.models;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class BuienradarAPI {

    private List<Weerstation> weerstations;

    public BuienradarAPI() {
        refresh();
    }

    public void refresh() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("http://xml.buienradar.nl/");

            NodeList nodes = document.getElementsByTagName("weerstation");

            weerstations = new ArrayList<>();
            for(int i = 0; i < nodes.getLength(); i++) {
                Weerstation weerstation = new Weerstation();
                Node node = nodes.item(i);
                NodeList childNodes = node.getChildNodes();
                for(int j = 0; j < childNodes.getLength(); j++) {
                    Node itemNode = childNodes.item(j);
                    if(itemNode.getNodeName().equals("stationnaam")) {
                        weerstation.stationnaam = itemNode.getFirstChild().getNodeValue();
                    } else if(itemNode.getNodeName().equals("stationcode")) {
                        weerstation.stationcode = Integer.parseInt(itemNode.getFirstChild().getNodeValue());
                    } else if(itemNode.getNodeName().equals("windrichting")) {
                        if(itemNode.getFirstChild() != null)
                            weerstation.windrichting = itemNode.getFirstChild().getNodeValue();
                    } else if(itemNode.getNodeName().equals("temperatuur10cm")) {
                        String temp = itemNode.getFirstChild().getNodeValue();
                        if(temp != null && !temp.equals("-"))
                            weerstation.temperatuur = Float.parseFloat(temp);
                    } else if(itemNode.getNodeName().equals("icoonactueel")) {
                        weerstation.icon = itemNode.getFirstChild().getNodeValue();
                    }
                }
                weerstations.add(weerstation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Weerstation> getWeerstations() {
        return weerstations;
    }

}
