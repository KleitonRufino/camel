package com.example.camelspringboot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Teste extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:xml?fileName=orders.xml&noop=true")
		.split(xpath("//order[@product='electronics']/items/item/text()"))
		.log("${body}");
		
//		from("file:xml?fileName=pokemon.xml&noop=true")
//		.choice()
//			.when(xpath("/pokemons/pokemon/name='bulbasaur'"))
//	              .log("${body}")
//	              .to("file:xml?fileName=pokemon2.xml")
//            .otherwise()
//            	.to("file:json")
//            .end();
		
		
//		from("file:json?noop=true")
//		.process(new ConvertJsonToPOJOProcess())
//		.log("${body}")
//		.to("file:json");
	}

}
