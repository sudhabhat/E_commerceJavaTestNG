package listeners;

import java.util.HashMap;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;

public class SuiteListener implements ISuiteListener {

	@Override
    public void onStart(ISuite suite) {
        System.out.println("Start suite " + suite.getName());
        XmlSuite xmlSuite = suite.getXmlSuite();
        if (!xmlSuite.getTests().isEmpty()) {
            Map parms = new HashMap();
            parms.put("ui", "web");
            System.out.println("Set ui param value");
            xmlSuite.setParameters(parms);
        }      
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finish suite " + suite.getName());
    }
}
