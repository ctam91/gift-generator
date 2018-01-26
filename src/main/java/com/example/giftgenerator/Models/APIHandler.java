package com.example.giftgenerator.Models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/*
This class handles the information received from Amazon Product Advertising API
 */
public class APIHandler {

    public APIHandler() {
    }

    public static ArrayList<Listing> processAPI(String url){

        ArrayList<Listing> listings = new ArrayList<>();

        try
        {
            // Turn the string into a URL object
            URL urlObject = new URL(url);
            // Open the stream (which returns an InputStream):
            InputStream in = urlObject.openStream();

            InputSource inputSource = new InputSource(in);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputSource);
            doc.getDocumentElement().normalize();

            NodeList itemsList = doc.getElementsByTagName("Item");

            for (int result = 0; result < itemsList.getLength(); result++) {

                Node productNode = itemsList.item(result);

                if (productNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) productNode;
                    String details = eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent();

                    Node imageInformation = eElement.getElementsByTagName("LargeImage").item(0);
                    Element imageElement = (Element) imageInformation;
                    String imageURL = imageElement.getElementsByTagName("URL").item(0).getTextContent();

                    Node itemAttributes = eElement.getElementsByTagName("ItemAttributes").item(0);
                    Element titleElement = (Element) itemAttributes;
                    String title = titleElement.getElementsByTagName("Title").item(0).getTextContent();

                    Node offerSummary = eElement.getElementsByTagName("OfferSummary").item(0);
                    Element offer = (Element) offerSummary;
                    /*Node offerPrice = offer.getElementsByTagName("LowestUsedPrice").item(0);
                    if(offerPrice.getNodeValue()==null){
                        offerPrice = offer.getElementsByTagName("LowestNewPrice").item(0);
                    }
                    Element lowestPrice = (Element) offerPrice;
                    String price = lowestPrice.getElementsByTagName("FormattedPrice").item(0).getTextContent();
**/
                    Listing newListing = new Listing(details,imageURL,title);

                    listings.add(newListing);

                }
            }

        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return listings;
    }

}
