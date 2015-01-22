package com.sirma.itt.java;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;

public class Demo {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		 
		JsonObject jsr335 = Json.createObjectBuilder()
				  .add("tasks", Json.createArrayBuilder()
				    .add(Json.createObjectBuilder()
				      .add("kick", "J")
				      .add("meet", "D")))
				  .build();
		
		System.out.println(jsr335.toString());
		
	
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		byte[] inputStream = out.toByteArray();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JSR353Module());
		
		mapper.writeValue(out, jsr335);
		
		inputStream = out.toByteArray();
		
		
		JsonObject jackson = mapper.readValue(inputStream,JsonObject.class);
		System.out.println(jackson);
		
		

	}

}
