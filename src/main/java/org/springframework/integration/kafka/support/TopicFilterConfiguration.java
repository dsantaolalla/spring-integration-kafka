/*
 * Copyright 2002-2013 the original author or authors. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package org.springframework.integration.kafka.support;

import kafka.consumer.Blacklist;
import kafka.consumer.TopicFilter;
import kafka.consumer.Whitelist;

/**
 * @author Rajasekar Elango
 * @since 0.5
 */
public class TopicFilterConfiguration {

	private final int numberOfStreams;
	private TopicFilter topicFilter;

	public TopicFilterConfiguration(final String pattern, final int numberOfStreams, final boolean exclude) {
		this.numberOfStreams = numberOfStreams;
		if (exclude) {
			topicFilter = new Blacklist(pattern);
		}
		else {
			topicFilter = new Whitelist(pattern);
		}
	}

	public TopicFilter getTopicFilter() {
		return topicFilter;
	}

	public int getNumberOfStreams() {
		return numberOfStreams;
	}

	@Override
	public String toString() {
		return new StringBuilder(topicFilter.toString()).append(" : ").append(numberOfStreams).toString();
	}
}
