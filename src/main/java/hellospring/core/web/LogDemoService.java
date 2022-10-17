package hellospring.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import hellospring.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final ObjectProvider<MyLogger> myLoggerProvider;
	public void logic(String testID) {
		MyLogger myLogger = myLoggerProvider.getObject();
		myLogger.log("service id = " + testID);
	}
}
