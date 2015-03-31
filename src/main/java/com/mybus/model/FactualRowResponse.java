package com.mybus.model;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "_id" })
@ApiObject(name = "FactualRowResponse")
public class FactualRowResponse {

	@Id @Getter @Setter
    @Field("_id")
    @ApiObjectField(description = "ID of the Object")
    private String id;
	
	@Setter
	@Getter
	private String factualId;
	
	@Setter
	@Getter
	private JSONArray response;
	
	public FactualRowResponse(String factualId, JSONArray response) {
		this.setFactualId(factualId);
		this.setResponse(response);
	}
	
	public CrosswalkData getCrosswalk(String namespace){
		for(Object obj: response){
			JSONObject cJson = new JSONObject((Map)obj);
			if(cJson.containsKey("namespace") && cJson.get("namespace").toString().equals(namespace)){
				CrosswalkData crosswalk = new CrosswalkData(cJson);
				return crosswalk;
			}
		}
		return null;
	}
	
	@ToString
	public class CrosswalkData{
		
		public CrosswalkData(JSONObject cJson) {
			if(cJson.containsKey("namespace")){
				this.setNamespace(cJson.get("namespace").toString());
			}
			if(cJson.containsKey("namespace_id")){
				this.setNamespace_id(cJson.get("namespace_id").toString());
			}
			if(cJson.containsKey("url")){
				this.setUrl(cJson.get("url").toString());
			}
			if(cJson.containsKey("factual_id")){
				this.setFactual_id(cJson.get("factual_id").toString());
			}
		}
		
		@Setter
		@Getter
		private String namespace;
		
		
		@Setter
		@Getter
		private String namespace_id;
		
		@Setter
		@Getter
		private String url;
		
		@Setter
		@Getter
		private String factual_id;
		
		
	}
}
