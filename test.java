package sample04.controller;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class test {
    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc = builder.parse("file:C:/brainsellers/biz-StreamV5.0.0/bs/bs-5.0.0/bs-5.0.0/sample/soap_client/xml/Sample4-doc.xml");
        System.out.println("=1=================");
        System.out.println(doc);
        System.out.println("====================");
        Element element = doc.getDocumentElement();
        Node node = doc.cloneNode(true);
        NodeList nList = element.getParentNode();
        for (int j = 0; j < nList.getLength(); j++) {
            sb.append(convertToString(nList.item(j)));
        }
        
        System.out.println("����1����������������������");
        System.out.println(sb);
        System.out.println("������������������������������");
        
        
        
        StringBuffer sb1 = new StringBuffer();
        Node nList1 = element.getParentNode();
        
            sb1.append(convertToString(nList1));
        
        System.out.println("����2����������������������");
        System.out.println(sb1);
        System.out.println("������������������������������");
        
    }
    
    /**
     * �m�[�h�̗v�f�l�𕶎���ɕϊ����܂��B �m�[�h���Ƀ^�O���܂܂�Ă���ꍇ�A���̃^�O�͎������`����܂��B
     * @param node �ϊ��Ώۂ̕�����
     * @return �ϊ��㕶����
     * @throws TransformerException XML�K��Ɉᔽ���Ă���ꍇ�ɔ��������O
     */
    public static String convertToString(
            Node node) throws TransformerException {
        // �m�[�h��XML�Ƃ��Ē�`���܂�
        DOMSource source = new DOMSource(node);
        // �����񐶐��p�X�g���[��
        StringWriter swriter = new StringWriter();
        StreamResult result = new StreamResult(swriter);
        // XML�𕶎���ɕϊ����܂�
        transform(source, result);
        return swriter.toString();
    }

    /**
     * XML�ϊ��G���W���Ăяo���ł��B
     * @param source �ϊ��Ώۂ�XML
     * @param result �ϊ��㕶����
     * @throws TransformerException XML�K��Ɉᔽ���Ă���ꍇ�ɔ��������O
     */
    private static void transform(Source source,
            Result result) throws TransformerException {
        // �ϊ��G���W�����擾���܂�
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        // XML�ϊ��̃��[����ݒ肵�܂�
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        // �ϊ�
        transformer.transform(source, result);
    }
}
