package com.mybus.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "FactualPlace")
public class FactualPlace  {
	
	@Id @Getter @Setter
    @Field("_id")
    @ApiObjectField(description = "ID of the Object")
    private String id;
	
	@Getter
	@Setter
	@ApiObjectField(description = "factual_id")
	private String factual_id;

	@Getter
	@Setter
	@ApiObjectField(description = "name")
	private String name;

	@Getter
	@Setter
	@ApiObjectField(description = "address")
	private String address;

	@Getter
	@Setter
	@ApiObjectField(description = "address_extended")
	private String address_extended;

	@Getter
	@Setter
	@ApiObjectField(description = "po_box")
	private String po_box;

	@Getter
	@Setter
	@ApiObjectField(description = "locality")
	private String locality;

	@Getter
	@Setter
	@ApiObjectField(description = "region")
	private String region;

	@Getter
	@Setter
	@ApiObjectField(description = "post_town")
	private String post_town;

	@Getter
	@Setter
	@ApiObjectField(description = "admin_region")
	private String admin_region;

	@Getter
	@Setter
	@ApiObjectField(description = "postcode")
	private String postcode;

	@Getter
	@Setter
	@ApiObjectField(description = "country")
	private String country;

	@Getter
	@Setter
	@ApiObjectField(description = "tel")
	private String tel;

	@Getter
	@Setter
	@ApiObjectField(description = "fax")
	private String fax;

	@Getter
	@Setter
	@ApiObjectField(description = "latitude")
	private String latitude;

	@Getter
	@Setter
	@ApiObjectField(description = "longitude")
	private String longitude;

	@Getter
	@Setter
	@ApiObjectField(description = "neighborhoowebsite")
	private String neighborhoowebsite;

	@Getter
	@Setter
	@ApiObjectField(description = "email")
	private String email;

	@Getter
	@Setter
	@ApiObjectField(description = "category_ids")
	private String category_ids;

	@Getter
	@Setter
	@ApiObjectField(description = "category_labels")
	private String category_labels;

	@Getter
	@Setter
	@ApiObjectField(description = "chain_name")
	private String chain_name;

	@Getter
	@Setter
	@ApiObjectField(description = "chain_id")
	private String chain_id;

	@Getter
	@Setter
	@ApiObjectField(description = "hours")
	private String hours;

	@Getter
	@Setter
	@ApiObjectField(description = "hours_display")
	private String hours_display;

	@Getter
	@Setter
	@ApiObjectField(description = "existence")
	private String existence;

	@Getter
	@Setter
	@ApiObjectField(description = "cuisine")
	private String cuisine;

	@Getter
	@Setter
	@ApiObjectField(description = "price")
	private String price;

	@Getter
	@Setter
	@ApiObjectField(description = "rating")
	private String rating;

	@Getter
	@Setter
	@ApiObjectField(description = "payment_cashonly")
	private String payment_cashonly;

	@Getter
	@Setter
	@ApiObjectField(description = "reservations")
	private String reservations;

	@Getter
	@Setter
	@ApiObjectField(description = "open_24hrs")
	private String open_24hrs;

	@Getter
	@Setter
	@ApiObjectField(description = "founded")
	private String founded;

	@Getter
	@Setter
	@ApiObjectField(description = "attire")
	private String attire;

	@Getter
	@Setter
	@ApiObjectField(description = "attire_required")
	private String attire_required;

	@Getter
	@Setter
	@ApiObjectField(description = "attire_prohibited")
	private String attire_prohibited;

	@Getter
	@Setter
	@ApiObjectField(description = "parking")
	private String parking;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_valet")
	private String parking_valet;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_garage")
	private String parking_garage;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_street")
	private String parking_street;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_lot")
	private String parking_lot;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_validated")
	private String parking_validated;

	@Getter
	@Setter
	@ApiObjectField(description = "parking_free")
	private String parking_free;

	@Getter
	@Setter
	@ApiObjectField(description = "smoking")
	private String smoking;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_breakfast")
	private String meal_breakfast;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_lunch")
	private String meal_lunch;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_dinner")
	private String meal_dinner;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_deliver")
	private String meal_deliver;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_takeout")
	private String meal_takeout;

	@Getter
	@Setter
	@ApiObjectField(description = "meal_cater")
	private String meal_cater;

	@Getter
	@Setter
	@ApiObjectField(description = "alcohol")
	private String alcohol;

	@Getter
	@Setter
	@ApiObjectField(description = "alcohol_bar")
	private String alcohol_bar;

	@Getter
	@Setter
	@ApiObjectField(description = "alcohol_beer_wine")
	private String alcohol_beer_wine;

	@Getter
	@Setter
	@ApiObjectField(description = "alcohol_byob")
	private String alcohol_byob;

	@Getter
	@Setter
	@ApiObjectField(description = "kids_goodfor")
	private String kids_goodfor;

	@Getter
	@Setter
	@ApiObjectField(description = "kids_menu")
	private String kids_menu;

	@Getter
	@Setter
	@ApiObjectField(description = "groups_goodfor")
	private String groups_goodfor;

	@Getter
	@Setter
	@ApiObjectField(description = "accessible_wheelchair")
	private String accessible_wheelchair;

	@Getter
	@Setter
	@ApiObjectField(description = "seating_outdoor")
	private String seating_outdoor;

	@Getter
	@Setter
	@ApiObjectField(description = "wifi")
	private String wifi;

	@Getter
	@Setter
	@ApiObjectField(description = "owner")
	private String owner;

	@Getter
	@Setter
	@ApiObjectField(description = "room_private")
	private String room_private;

	@Getter
	@Setter
	@ApiObjectField(description = "options_vegetarian")
	private String options_vegetarian;

	@Getter
	@Setter
	@ApiObjectField(description = "options_vegan")
	private String options_vegan;

	@Getter
	@Setter
	@ApiObjectField(description = "options_glutenfree")
	private String options_glutenfree;

	@Getter
	@Setter
	@ApiObjectField(description = "options_lowfat")
	private String options_lowfat;

	@Getter
	@Setter
	@ApiObjectField(description = "options_organic")
	private String options_organic;

	@Getter
	@Setter
	@ApiObjectField(description = "options_healthy")
	private String options_healthy;

}
