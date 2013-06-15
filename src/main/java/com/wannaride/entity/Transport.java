package com.wannaride.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "transport")
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_transport")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private TripProvider tripProvider;

    @Column(name = "seats_number", nullable = false)
    @Max(value = 90, message = "Seats number must be lower than 90")
    @Min(value = 3, message = "Seats number must be higher than 3")
    @Pattern(regexp = "[0-9]+", message="Invalid seats number")
    private String seatsNumber;

    @Column(name = "transport_description", nullable = false)
    @Size(min = 3, max = 2048, message = "Description must be between 3 and 2048 characters long.")
    private String description;

    public Transport() {}

    public Transport(TripProvider tripProvider, String description) {
        this.tripProvider = tripProvider;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TripProvider getTripProvider() {
        return tripProvider;
    }

    public void setTripProvider(TripProvider tripProvider) {
        this.tripProvider = tripProvider;
    }

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(String seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        if (id != null ? !id.equals(transport.id) : transport.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", tripProvider=" + tripProvider +
                ", seatsNumber='" + seatsNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

