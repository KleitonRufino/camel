package com.example.camelspringboot;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonToPOJOProcess implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String store = exchange.getIn().getBody(String.class);
		ObjectMapper mapper = new ObjectMapper();
		Person p = mapper.readValue(store, Person.class);
		System.out.println(p.toString());
	}

}
