package moxy;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RootAddress {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RootAddress other = (RootAddress) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    public RootAddress(String city) {
        this.city = city;
    }

    public RootAddress() {
    }

    private String city;

    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
