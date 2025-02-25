
package acme.entities.flightassignment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.entities.flightcrewmember.FlightCrewMember;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightAssignment {

	private enum Duty {
		PILOT, CO_PILOT, LEAD_ATTENTDANT, CABIN_ATTENDANT
	}

	private enum Status {
		CONFIRMED, PENDING, CANCELLED
	}


	@Mandatory
	@Valid
	@Column(unique = true)
	private FlightCrewMember	allocatedFlightCrewMember;

	@Mandatory
	@Valid
	@Automapped
	private Duty				duty;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@Mandatory
	@Valid
	@Automapped
	private Status				status;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				remarks;
}
