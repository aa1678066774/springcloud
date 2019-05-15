package com.tww.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public interface MqMessageSource {

	String  TEST_OUT_PUT = "testOutPut";

	@Output(TEST_OUT_PUT)
	MessageChannel testOutPut();

	String TEST_IN_PUT = "testInPut";

	@Input(TEST_IN_PUT)
	SubscribableChannel testInPut();
}
