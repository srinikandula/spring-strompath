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


@ToString
@EqualsAndHashCode(callSuper = false, of = { "email" })
@ApiObject(name = "FactualResponse")
public class FactualResponse extends AbstractDocument implements AttributesDocument {

	@Getter
    @Setter
    @ApiObjectField(description = "BusinessId")
    private String businessId;
	
	@Getter
    @Setter
    @ApiObjectField(description = "Factual resolve response")
    private Map<String, Object> resolveResponse;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Boolean indicates if the factual resolve worked")
	private boolean resolved;
	
	
	@Setter
	@Getter
	@ApiObjectField(description = "Factual crosswalk responses")
	private JSONArray crosswalks;
	
	@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	
	
	public CrosswalkData getCrosswalk(String namespace){
		for(Object obj: crosswalks){
			JSONObject cJson = new JSONObject((Map)obj);
			if(cJson.containsKey("namespace") && cJson.get("namespace").toString().equalsIgnoreCase(namespace)){
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
