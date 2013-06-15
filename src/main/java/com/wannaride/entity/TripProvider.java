package com.wannaride.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "trip_provider")
public class TripProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User user;

    @Size(min = 3, max = 36, message = "Your name must be between 3 and 36 characters long.")
    @Column(name = "TP_NAME")
    private String tripProviderName;

    public TripProvider() {
        user = new User();
    }

    public TripProvider(String tripProviderName) {
        this.user = new User();
        this.tripProviderName = tripProviderName;
    }

    public TripProvider(User user, String tripProviderName) {
        this.user = user;
        this.tripProviderName = tripProviderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTripProviderName() {
        return tripProviderName;
    }

    public void setTripProviderName(String tripProviderName) {
        this.tripProviderName = tripProviderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripProvider)) return false;

        TripProvider that = (TripProvider) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "TripProvider{" +
                "user=" + user +
                ", tripProviderName='" + tripProviderName + '\'' +
                '}';
    }
}

