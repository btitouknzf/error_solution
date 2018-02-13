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
        
        System.out.println("★★1★★★★★★★★★★★");
        System.out.println(sb);
        System.out.println("★★★★★★★★★★★★★★★");
        
        
        
        StringBuffer sb1 = new StringBuffer();
        Node nList1 = element.getParentNode();
        
            sb1.append(convertToString(nList1));
        
        System.out.println("★★2★★★★★★★★★★★");
        System.out.println(sb1);
        System.out.println("★★★★★★★★★★★★★★★");
        
    }
    
    /**
     * ノードの要素値を文字列に変換します。 ノード内にタグが含まれている場合、そのタグは自動整形されます。
     * @param node 変換対象の文字列
     * @return 変換後文字列
     * @throws TransformerException XML規約に違反している場合に発生する例外
     */
    public static String convertToString(
            Node node) throws TransformerException {
        // ノードをXMLとして定義します
        DOMSource source = new DOMSource(node);
        // 文字列生成用ストリーム
        StringWriter swriter = new StringWriter();
        StreamResult result = new StreamResult(swriter);
        // XMLを文字列に変換します
        transform(source, result);
        return swriter.toString();
    }

    /**
     * XML変換エンジン呼び出しです。
     * @param source 変換対象のXML
     * @param result 変換後文字列
     * @throws TransformerException XML規約に違反している場合に発生する例外
     */
    private static void transform(Source source,
            Result result) throws TransformerException {
        // 変換エンジンを取得します
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        // XML変換のルールを設定します
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        // 変換
        transformer.transform(source, result);
    }
}
