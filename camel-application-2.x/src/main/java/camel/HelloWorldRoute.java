package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;

public class HelloWorldRoute implements RoutesBuilder {

	public void addRoutesToCamelContext(CamelContext context) throws Exception {
		System.out.println("Hello World");
	}

}
