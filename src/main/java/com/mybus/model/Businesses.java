package com.mybus.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "Businesses")
public class Businesses extends AbstractDocument implements AttributesDocument {
	
	@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Getter
	@Setter
	@ApiObjectField(description = "Address")
	private String addr1;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Alternate name")
	private String altName;

	@Getter
	@Setter
	@ApiObjectField(description = "Category Ids")
	private Set<String> categoryIds;

	@Getter
	@Setter
	@ApiObjectField(description = "City Name")
	private String city;
	
	@Getter
	@Setter
	@ApiObjectField(description = "City Name")
	private String description1;


	@Getter
	@Setter
	@ApiObjectField(description = "Name of the business")
	private String name;

	@Getter
	@Setter
	@ApiObjectField(description = "Neighborhood Geo location ids")
	private Set<String> neighborhoodGeoIds;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Neighborhoods")
	private Set<String> neighborhoods;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Phone")
	private String phone;
	
	@Getter
	@Setter
	@ApiObjectField(description = "published")
	private String published;

	@Getter
	@Setter
	@ApiObjectField(description = "Rating")
	private Double rating;
	
	
	@Getter
	@Setter
	@ApiObjectField(description = "State")
	private String state;
	
	@Getter
	@Setter
	@ApiObjectField(description = "urlFacebook")
	private String urlFacebook;
	
	@Getter
	@Setter
	@ApiObjectField(description = "urlFoursquare")
	private String urlFoursquare;

	@Getter
	@Setter
	@ApiObjectField(description = "urlTwitter")
	private String urlTwitter;
	
	@Getter
	@Setter
	@ApiObjectField(description = "urlYelp")
	private String urlYelp;
	
	@Getter
	@Setter
	@ApiObjectField(description = "website")
	private String website;

	@Getter
	@Setter
	@ApiObjectField(description = "zip")
	private String zip;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Factual Id")
	private String factualId;
	
	@Getter
	@Setter
	@ApiObjectField(description = "loc")
	private Loc loc;
	
	@Getter
	@Setter
	@ApiObjectField(description = "addr2")
	private String addr2;
	
	@Getter
	@Setter
	@ApiObjectField(description = "alcohol Ids")
	private List<Object> alcoholIds = new ArrayList<Object>();
	
	@Getter
	@Setter
	@ApiObjectField(description = "category SubType Ids")
	private List<Object> categorySubTypeIds = new ArrayList<Object>();
	
	@Getter
	@Setter
	@ApiObjectField(description = "category Type Ids")
	private List<String> categoryTypeIds = new ArrayList<String>();
	
	@Getter
	@Setter
	@ApiObjectField(description = "description2")
	private String description2;
	
	@Getter
	@Setter
	@ApiObjectField(description = "import Src")
	private String importSrc;
	
	@Getter
	@Setter
	@ApiObjectField(description = "neighborhoods Display Value")
	private String neighborhoodsDisplayValue;
	
	@Getter
	@Setter
	@ApiObjectField(description = "placeId")
	private String placeId;
	
	@Getter
	@Setter
	@ApiObjectField(description = "primary Image Id")
	private String primaryImageId;
	
	@Getter
	@Setter
	@ApiObjectField(description = "rating Google")
	private Double ratingGoogle;
	
	@Setter
	@ApiObjectField(description = "long")
	private Double lon;
	
	@Setter
	@ApiObjectField(description = "lat")
	private Double lat;
	
	@Getter
	@Setter
	@ApiObjectField(description = "category Display Value")
	private String categoryDisplayValue;
	
	@Getter
	@Setter
	@ApiObjectField(description = "additional Properties")
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@Getter
	@Setter
	@ApiObjectField(description = "opening Hours")
	private List<Object> openingHours;

	public Double getLong() {
		Double lon = null;
		if(null != this.loc && this.loc.getCoordinates()[0] != null){
			lon = Double.parseDouble(this.loc.getCoordinates()[0]);
		}
		return lon;
	}

	public Double getLat() {
		Double lat = null;
		if(null != this.loc && this.loc.getCoordinates()[1] != null){
			lat = Double.parseDouble(this.loc.getCoordinates()[1]);
		}
		return lat;
	}
}
