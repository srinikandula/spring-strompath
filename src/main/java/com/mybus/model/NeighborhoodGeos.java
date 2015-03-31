package com.mybus.model;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "NeighborhoodGeos")
public class NeighborhoodGeos extends AbstractDocument implements AttributesDocument {
	@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Getter
	@Setter
	@ApiObjectField(description = "Ids of the associated NeighborhoodGeos")
	private Set<String> associatedClassificationIds;

	@Getter
	@Setter
	@ApiObjectField(description = "Name of NeighborhoodGeos")
	private String name;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Geo Name of NeighborhoodGeos")
	private String geo_name;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Level of NeighborhoodGeos")
	private Integer level;
	
	@Getter
	@Setter
	@ApiObjectField(description = "API ID of NeighborhoodGeos")
	private Integer api_id;
	
	@Getter
	@Setter
	@ApiObjectField(description = "API PARENT ID of NeighborhoodGeos")
	private Integer api_parent_id;
	
	@Getter
	@Setter
	@ApiObjectField(description = "CenterLat of NeighborhoodGeos")
	private Double centerLat;
	
	@Getter
	@Setter
	@ApiObjectField(description = "CenterLat of NeighborhoodGeos")
	private Double centerLon;
	
	@Getter
	@Setter
	@ApiObjectField(description = "City Name of NeighborhoodGeos")
	private String city;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Geometry of NeighborhoodGeos")
	private Set<Geometry> types;
	
	@Getter
	@Setter
	@ApiObjectField(description = "maxLot of NeighborhoodGeos")
	private Double maxLot;
	
	@Getter
	@Setter
	@ApiObjectField(description = "maxLon of NeighborhoodGeos")
	private Double maxLon;
	
	@Getter
	@Setter
	@ApiObjectField(description = "minLot of NeighborhoodGeos")
	private Double minLot;
	
	@Getter
	@Setter
	@ApiObjectField(description = "minLon of NeighborhoodGeos")
	private Double minLon;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Parent Id of NeighborhoodGeos")
	private String parentId;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Parent Name of NeighborhoodGeos")
	private String parent_name;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Parent path of NeighborhoodGeos")
	private String parent_path;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Path of NeighborhoodGeos")
	private String path;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Poicount of NeighborhoodGeos")
	private Integer poiCount;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Position of NeighborhoodGeos")
	private Integer position;
	
	@Getter
	@Setter
	@ApiObjectField(description = "State Name of NeighborhoodGeos")
	private String state;
}
