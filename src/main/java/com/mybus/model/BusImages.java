package com.mybus.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.TypeAlias;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "public_id" })
@TypeAlias("busImages")
@ApiObject(name = "BusinessImage")
public class BusImages extends AbstractDocument implements AttributesDocument  {

	@Getter
    @Setter
    @ApiObjectField(description = "Public Id")
    private String public_id;

	@Getter
    @Setter
    @ApiObjectField(description = "Version")
    private String version;
	

	@Getter
    @Setter
    @ApiObjectField(description = "Signature")
    private String signature;


	@Getter
    @Setter
    @ApiObjectField(description = "Width")
    private long width;
	

	@Getter
    @Setter
    @ApiObjectField(description = "Height")
    private long height;


	@Getter
    @Setter
    @ApiObjectField(description = "Format")
    private String format;


	@Getter
    @Setter
    @ApiObjectField(description = "Resource Type")
    private String resource_type;

	
	@Getter
    @Setter
    @ApiObjectField(description = "Bytes")
    private long bytes;

	

	@Getter
    @Setter
    @ApiObjectField(description = "Type")
    private String type;


	@Getter
    @Setter
    @ApiObjectField(description = "Etag")
    private String etag;
	

	@Getter
    @Setter
    @ApiObjectField(description = "Url")
    private String url;


	@Getter
    @Setter
    @ApiObjectField(description = "Secure Url")
    private String secure_url;
	

	@Getter
    @Setter
    @ApiObjectField(description = "Business Id")
    private String businessId;


	@Getter
    @Setter
    @ApiObjectField(description = "Name")
    private String name;
	
	@Getter
    @Setter
    @ApiObjectField(description = "Description")
    private String description;
	
	


	@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
