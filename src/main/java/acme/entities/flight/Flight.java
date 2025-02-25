
package acme.entities.flight;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.entities.leg.Leg;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Size(max = 50)
	private String				tag;

	@Mandatory
	private Boolean				requiresSelfTransfer;

	@Mandatory
	@Min(0)
	private Integer				cost;

	@Optional
	private String				description;

	@OneToMany(mappedBy = "flight")
	@Valid
	private List<Leg>			legs;


	public Date getScheduledDeparture() {
		return this.legs != null && !this.legs.isEmpty() ? this.legs.get(0).getScheduledDeparture() : null;
	}

	public Date getScheduledArrival() {
		return this.legs != null && !this.legs.isEmpty() ? this.legs.get(this.legs.size() - 1).getScheduledArrival() : null;
	}

	public String getOriginCity() {
		return this.legs != null && !this.legs.isEmpty() ? this.legs.get(0).getDepatureAirport() : null;
	}

	public String getDestinationCity() {
		return this.legs != null && !this.legs.isEmpty() ? this.legs.get(this.legs.size() - 1).getArrivalAirport() : null;
	}

	public Integer getLayovers() {
		return this.legs != null && !this.legs.isEmpty() ? this.legs.size() : 0;
	}

}
