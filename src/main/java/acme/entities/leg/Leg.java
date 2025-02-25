
package acme.entities.leg;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	private Integer				flightNumber;

	@Mandatory
	private Date				scheduledDeparture;

	@Mandatory
	private Date				scheduledArrival;

	@Mandatory
	@Min(0)
	private Double				duration;

	@Mandatory
	@Enumerated(EnumType.STRING)
	private String				status;

	@Mandatory
	private String				depatureAirport;

	@Mandatory
	private String				arrivalAirport;

	@Mandatory
	private String				aircraft;


	public enum Status {
		ON_TIME, DELAYED, CANCELLED, LANDED;
	}

}
