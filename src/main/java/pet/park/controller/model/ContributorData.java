package pet.park.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import pet.parks.entity.Contributor;
import pet.parks.entity.GeoLocation;
import pet.parks.entity.PetPark;

@Data
@NoArgsConstructor
public class ContributorData {


	private Long contributorId;
	private String contributorName;
	private String contributorEmail;
	private Set<PetParkResponse> petParks = new HashSet<>();

	public ContributorData(Contributor contributor) {
		contributorId = contributor.getContributorId();
		contributorName = contributor.getContributorName();
		contributorEmail = contributor.getContributorEmail();
		
		for (PetPark petPark.contributor.getPetParks()) {
			petParks.add(new PetParkRessponse(petPark));
		}
	}
	
	@Value
	static class PetParkResponse {
		private Long petParkId;
		private String parkName;
		private String direactions;
		private String stateOrProvince;
		private String country;
		private GeoLocation geolocation;
		private Set<String> amenities = new HashSet<>();

		PetParkResponse(PetPark petPark) {
			petParkId = petPark.getPetParkId();
			parkName = petPark.getPetParkName();
			directions = petPark.getDirections();
			stateOrProvince = petPark.getStateOrProvince();
			country = petPark.getCountry();
			geoLocation = new GeoLocation(petPark.getGeolocation());
			
			for(Amenity amenity : petPark.getAmenities()) {
				amenities.add(amenity.getAmenity());
			}
			
		}

	}
}
