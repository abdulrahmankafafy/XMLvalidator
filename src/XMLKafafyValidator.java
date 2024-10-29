import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

public class XMLKafafyValidator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("XML Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea xmlInputArea = new JTextArea();
        xmlInputArea.setLineWrap(true);
        xmlInputArea.setWrapStyleWord(true);

        JButton validateButton = new JButton("Validate XML");
        JLabel resultLabel = new JLabel(" ");

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(xmlInputArea), BorderLayout.CENTER);
        frame.add(validateButton, BorderLayout.SOUTH);
        frame.add(resultLabel, BorderLayout.NORTH);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xmlContent = xmlInputArea.getText();
                String result = validateXML(xmlContent);
                resultLabel.setText(result);
            }
        });

        frame.setVisible(true);
    }

    public static String validateXML(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(xml)));
            return "XML is meya meya.";
        } catch (SAXParseException e) {
            return "Error with XML specification at line " + e.getLineNumber() + ".";
        } catch (SAXException e) {
            return "Error with XML specification.";
        } catch (Exception e) {
            return "Error with XML specification.";
        }
    }
}
