package com.k8.demo.networkTests.k8Demo.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PongMessage {
	String message;
	HostDetails host;
}
