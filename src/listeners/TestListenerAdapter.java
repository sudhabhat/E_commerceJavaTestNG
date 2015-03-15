package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListenerAdapter implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		System.out.println("after invocation of " + method.getTestMethod().getMethodName());
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		System.out.println("before invocation of " + method.getTestMethod().getMethodName());
	}

}
