package co.edu.eafit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eafit.beans.Calculator;
import co.edu.eafit.beans.Memory;

@Path("/calculator")
public class CalculatorService {

	Calculator calculator = new Calculator();
	Memory memory = new Memory();

	@GET
	@Path("/sumar/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public float sumarRest(@PathParam("a") float a,
					   @PathParam("b") float b){
		return calculator.sumar(a, b);
	}

	@GET
	@Path("/restar/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public float restarRest(@PathParam("a") float a,
					    @PathParam("b") float b){
		return calculator.restar(a, b);
	}

	@GET
	@Path("/multiplicar/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public float multiplicarRest(@PathParam("a") float a,
					   		 @PathParam("b") float b){
		return calculator.multiplicar(a, b);
	}

	@GET
	@Path("/dividir/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public float dividirRest(@PathParam("a") float a,
					   	 @PathParam("b") float b){
		return calculator.dividir(a, b);
	}
	
	@GET
	@Path("/mc")
	@Produces(MediaType.TEXT_PLAIN)
	public float mcRest(){
		memory.setMemory(0.0f);
		return memory.getMemory();
	}
	
	@GET
	@Path("/mr")
	@Produces(MediaType.TEXT_PLAIN)
	public float mrRest(){
		return memory.getMemory();
	}
	
	@GET
	@Path("/mplus/{a}")
	@Produces(MediaType.TEXT_PLAIN)
	public float mplusRest(@PathParam("a") float a){
		float temp = memory.getMemory() + a;
		memory.setMemory(temp);
		return memory.getMemory();
	}
	
	@GET
	@Path("/mminus/{a}")
	@Produces(MediaType.TEXT_PLAIN)
	public float mminusRest(@PathParam("a") float a){
		float temp = memory.getMemory() - a;
		memory.setMemory(temp);
		return memory.getMemory();
	}
	
}
