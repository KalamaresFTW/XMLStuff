/*
 */
package Extra;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author pcostoubi
 */
public class SimpleErrorHandler implements ErrorHandler{

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.err.println("Warning");
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.err.println("Error");
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("Fatal error");
    }
    
}
