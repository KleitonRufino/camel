package com.example.camelspringboot;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class PokedexCamel extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input-pokemon?noop=true").routeId("rota-principal").split().xpath("/pokemons/name")
				.to("direct:rota-pokeapi").to("direct:rota-pokedex");

		from("direct:rota-pokeapi").routeId("rota-pokeapi").setProperty("pokemonName", xpath("/name/text()"))
				.log("Buscando dados do Pokemon: ${exchangeProperty.pokemonName}").to("log:?level=INFO&showBody=true")
				.setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.setHeader(Exchange.HTTP_PATH, simple("${exchangeProperty.pokemonName}"))
				.to("http://pokeapi.co/api/v2/pokemon");

		from("direct:rota-pokedex").routeId("rota-pokedex").log("Salvando dados do Pokemon na Pokedex")
				.setHeader(Exchange.HTTP_METHOD, constant("POST")).setHeader(Exchange.HTTP_PATH, constant("pokedex"))
				.to("http://localhost:8080");
	}
}
