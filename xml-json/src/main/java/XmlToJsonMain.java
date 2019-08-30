import com.alibaba.fastjson.JSONObject;
import org.jdom2.JDOMException;
import utils.Xml2JsonUtil;

import java.io.IOException;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/10
 */
public class XmlToJsonMain {

    public static void main(String[] args) throws JDOMException, IOException {

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<InputParam>  \n" +
                "  <msgHeader> \n" +
                "    <interfaceID>NS-LMIS-006</interfaceID>  \n" +
                "    <transID>string</transID>  \n" +
                "    <sender>LMIS</sender>  \n" +
                "    <receiver>NS</receiver> \n" +
                "  </msgHeader>  \n" +
                "  <msgBody> \n" +
                "    <createdfrom>1</createdfrom>  \n" +
                "    <entity>string</entity>  \n" +
                "    <trandate>string</trandate>  \n" +
                "    <memo>string</memo>  \n" +
                "    <custbody_po_business_types>1</custbody_po_business_types>  \n" +
                "    <custbody_po_storage_type>string</custbody_po_storage_type>  \n" +
                "    <custbody_ir_shipment_time>string</custbody_ir_shipment_time>  \n" +
                "    <custbody_ir_arrival_time>string</custbody_ir_arrival_time>  \n" +
                "    <lines> \n" +
                "      <item>string</item>  \n" +
                "      <quantity>1000.00</quantity>  \n" +
                "      <location>string</location>  \n" +
                "      <issueinventorynumber>string</issueinventorynumber>  \n" +
                "      <inventorystatus>string</inventorystatus>  \n" +
                "      <custcol_ir_serial_number>string</custcol_ir_serial_number>  \n" +
                "      <custcol_ir_sterilization_lot>string</custcol_ir_sterilization_lot>  \n" +
                "      <custcol_ir_sterilization_date>string</custcol_ir_sterilization_date> \n" +
                "    </lines> \n" +
                "  </msgBody> \n" +
                "</InputParam>\n";

        String xmll = "<InputParam  xmlns=\"\"> \n" +
                " <msgHeader> \n" +
                " <interfaceID>NS-LMIS-006</interfaceID> \n" +
                " <transID>string</transID> \n" +
                " <sender>LMIS</sender> \n" +
                " <receiver>NS</receiver> \n" +
                " </msgHeader> \n" +
                " <msgBody> \n" +
                " <createdfrom>1</createdfrom> \n" +
                " <entity>string</entity> \n" +
                " <trandate>string</trandate> \n" +
                " <memo>string</memo> \n" +
                " <custbody_po_business_types>1</custbody_po_business_types> \n" +
                " <custbody_po_storage_type>string</custbody_po_storage_type> \n" +
                " <custbody_ir_shipment_time>string</custbody_ir_shipment_time> \n" +
                " <custbody_ir_arrival_time>string</custbody_ir_arrival_time> \n" +
                " <lines> \n" +
                " <item>string</item> \n" +
                " <quantity>1000.00</quantity> \n" +
                " <location>string</location> \n" +
                " <issueinventorynumber>string</issueinventorynumber> \n" +
                " <inventorystatus>string</inventorystatus> \n" +
                " <custcol_ir_serial_number>string</custcol_ir_serial_number> \n" +
                " <custcol_ir_sterilization_lot>string</custcol_ir_sterilization_lot> \n" +
                " <custcol_ir_sterilization_date>string</custcol_ir_sterilization_date> \n" +
                " </lines> \n" +
                " </msgBody> \n" +
                " </InputParam>";
        JSONObject jsonObject = Xml2JsonUtil.xml2JSON(xmll.getBytes());
        System.out.println(jsonObject.toJSONString());
    }
}
