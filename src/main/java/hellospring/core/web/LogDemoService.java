package hellospring.core.web;

import org.springframework.stereotype.Service;

import hellospring.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final MyLogger myLogger;
	public void logic(String testID) {
		myLogger.log("service id = " + testID);
	}
}
