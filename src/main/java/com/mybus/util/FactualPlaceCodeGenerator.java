package com.mybus.util;


public class FactualPlaceCodeGenerator {
	public static void main(String[] args) {
		String fieldString = "factual_id	name	address	address_extended	po_box	locality	region	post_town	admin_region	postcode	country	tel	fax	latitude	longitude	neighborhoowebsite	email	category_ids	category_labels	chain_name	chain_id	hours	hours_display	existence	cuisine	price	rating	payment_cashonly	reservations	open_24hrs	founded	attire	attire_required	attire_prohibited	parking	parking_valet	parking_garage	parking_street	parking_lot	parking_validated	parking_free	smoking	meal_breakfast	meal_lunch	meal_dinner	meal_deliver	meal_takeout	meal_cater	alcohol	alcohol_bar	alcohol_beer_wine	alcohol_byob	kids_goodfor	kids_menu	groups_goodfor	accessible_wheelchair	seating_outdoor	wifi	owner	room_private	options_vegetarian	options_vegan	options_glutenfree	options_lowfat	options_organic	options_healthy";
		String fields[] = fieldString.split("\t");
		for(String field:fields){
			System.out.println("@Getter");
			System.out.println("@Setter");
			System.out.println(String.format("@ApiObjectField(description = \"%s\")", field));
			System.out.println(String.format("private String %s;", field)+"\n");
			
		}
	}
	

}
