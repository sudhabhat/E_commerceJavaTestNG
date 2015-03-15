package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T007_SuiteListener {

    @Parameters("ui")
    @BeforeSuite
    public void beforeSuite(String parm) {
        System.out.println("before suite, ui value: " + parm);
    }

    @Test
    public void t() {
        System.out.println("test method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }
}

