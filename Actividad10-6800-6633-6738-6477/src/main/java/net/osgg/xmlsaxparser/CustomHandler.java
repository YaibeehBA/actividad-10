package net.osgg.xmlsaxparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {
	boolean bid = false;
	boolean bfirstName = false;
    boolean blastName= false;
    boolean bemailId = false;    
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("(starts element:" + qName + ")");
     
    	 if (qName.equalsIgnoreCase("ID")) {
         	bid = true;
         }
        if (qName.equalsIgnoreCase("firstName")) {
        	bfirstName = true;
        }
        if (qName.equalsIgnoreCase("lastName")) {
            blastName= true;
        }
        if (qName.equalsIgnoreCase("emailId")) {
            bemailId = true;
       
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("ends element:" + qName);
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
    	
    	 if (bid) {
             System.out.println("ID: " + new String(ch, start, length));
             bid = false;
         }
 	    
        if (bfirstName) {
            System.out.println("FirstName: " + new String(ch, start, length));
            bfirstName = false;
        }
        if (blastName) {
            System.out.println("LastName: " + new String(ch, start, length));
            blastName = false;
        }
       /* if (bemailId) {
            System.out.println("EmailId: " + new String(ch, start, length));
            bemailId= false;
        }*/
      
      
    }
    
}
