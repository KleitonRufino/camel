package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class CallMethodUsingBeanComponent {
	public static void main(String[] args) throws Exception {
		
		MyService myService = new MyService();
		SimpleRegistry registry = new SimpleRegistry();
		registry.put("myService",  myService);
		
		CamelContext context = new DefaultCamelContext(registry);
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("direct:start")
					.to("bean:myService?method=dosomething");
			}
		});
		
		context.start();

		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello");
	}
}
