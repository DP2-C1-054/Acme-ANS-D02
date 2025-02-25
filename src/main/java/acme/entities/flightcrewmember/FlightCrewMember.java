
package acme.entities.flightcrewmember;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUuid;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMember {

	private enum Availability {
		AVAILABLE, ON_VACATION, ON_LEAVE
	}


	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@ValidUuid
	private String			employeeCode;

	@Mandatory
	@ValidString(pattern = "^'\\+?\\d{6,15}$")
	@Column(unique = true)
	private String			phoneNumber;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String			languageSkills;

	@Mandatory
	@ValidString
	@Automapped
	private String			airline;

	@Mandatory
	@Valid
	@Automapped
	private Availability	availability;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money			salary;

	@Optional
	@ValidNumber
	@Automapped
	private Integer			experienceYears;
}
