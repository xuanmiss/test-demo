package utils;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/10
 */
public class Xml2JsonUtil {

        public static JSONObject xml2JSON(byte[] xml) throws JDOMException, IOException {
            JSONObject json = new JSONObject();
            InputStream is = new ByteArrayInputStream(xml);
            SAXBuilder sb = new SAXBuilder();
            org.jdom2.Document doc = sb.build(is);
            Element root = doc.getRootElement();
            json.put(root.getName(), iterateElement(root));
            return json;
        }

        private static JSONObject iterateElement(Element element) {
            List node = element.getChildren();
            Element et = null;
            JSONObject obj = new JSONObject();
            List list = null;
            for (int i = 0; i < node.size(); i++) {
                if(node.size()<1) {

                    list = new LinkedList();
                    et = (Element) node.get(i);
                    if (et.getTextTrim().equals("")) {
                        if (et.getChildren().size() == 0)
                            continue;
                        if (obj.containsKey(et.getName())) {
                            list = (List) obj.get(et.getName());
                        }
                        list.add(iterateElement(et));
                        obj.put(et.getName(), list);
                    } else {
                        if (obj.containsKey(et.getName())) {
                            list = (List) obj.get(et.getName());
                        }
                        list.add(et.getTextTrim());
                        obj.put(et.getName(), list);
                    }
                }else {
                    list = new LinkedList();
                    et = (Element) node.get(i);
                    if(et.getName().toLowerCase().equals("lines")){
                        if (et.getTextTrim().equals("")) {
                            if (et.getChildren().size() == 0)
                                continue;
                            if (obj.containsKey(et.getName())) {
                                list = (List) obj.get(et.getName());
                            }
                            list.add(iterateElement(et));
                            obj.put(et.getName(), list);
                        } else {
                            obj.put(et.getName(), et.getTextTrim());
                        }
                    }else {
                        if (et.getTextTrim().equals("")) {
                            if (et.getChildren().size() == 0)
                                continue;
                            obj.put(et.getName(), iterateElement(et));
                        } else {
                            if (obj.containsKey(et.getName())) {
                                list = (List) obj.get(et.getName());
                            }
                            list.add(et.getTextTrim());
                            obj.put(et.getName(), et.getTextTrim());
                        }
                    }
                }

            }
            return obj;
        }

    }
