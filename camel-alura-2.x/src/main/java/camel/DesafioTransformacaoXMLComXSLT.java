package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class DesafioTransformacaoXMLComXSLT {
	
	public static void main(String [] args) throws Exception {
		DesafioTransformacaoXMLComXSLT desafio = new DesafioTransformacaoXMLComXSLT();
		//desafio.movimentacoesXMLParaHtml();
		desafio.exemploTransformacaoComVvelocity();
	}
	
	private void movimentacoesXMLParaHtml() throws Exception {
		 CamelContext context = new DefaultCamelContext();

	        context.addRoutes(new RouteBuilder() {

	            @Override
	            public void configure() throws Exception {
	            	from("direct:entrada").
	            	log("teste ${body}").
	        	    to("xslt:movimentacoes-para-html.xslt").
	        	        setHeader(Exchange.FILE_NAME, constant("movimentacoes.html")).
	        	    log("${body}").
	        	    to("file:saida");
	            }
	        });     

	        context.start();
	        
	        
	        ProducerTemplate producer = context.createProducerTemplate();
			 producer.sendBody("direct:entrada", 
				        "<movimentacoes>" +
				            "<movimentacao><valor>2314.4</valor><data>11/12/2015</data><tipo>ENTRADA</tipo></movimentacao>" +
				            "<movimentacao><valor>546.98</valor><data>11/12/2015</data><tipo>SAIDA</tipo></movimentacao>" + 
				            "<movimentacao><valor>314.1</valor><data>12/12/2015</data><tipo>SAIDA</tipo></movimentacao>" + 
				            "<movimentacao><valor>56.99</valor><data>13/12/2015</data><tipo>SAIDA</tipo></movimentacao>" + 
				        "</movimentacoes>");
	        
	        Thread.sleep(2000);
	        
	        context.stop();
	}
	
	private void exemploTransformacaoComVvelocity() throws Exception {
		 CamelContext context = new DefaultCamelContext();

	        context.addRoutes(new RouteBuilder() {

	            @Override
	            public void configure() throws Exception {
	            	from("direct:entrada").
	                setHeader("data", constant("8/12/2015")).
	                to("velocity:template.vm").
	                log("${body}");
	            }
	        });     

	        context.start();
	        
	        ProducerTemplate producer = context.createProducerTemplate();
	        producer.sendBody("direct:entrada", "Apache Camel rocks!!!");
	        
	        Thread.sleep(2000);
	        
	        context.stop();
	}

}
