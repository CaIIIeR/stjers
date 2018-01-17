
package ee.ttu.idu0075._2017.ws.wlt;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="filmId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="watchlistId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "token",
    "filmId",
    "watchlistId"
})
@XmlRootElement(name = "addWatchlistFilmRequest")
public class AddWatchlistFilmRequest {

    @XmlElement(required = true)
    protected String token;
    @XmlElement(required = true)
    protected BigInteger filmId;
    @XmlElement(required = true)
    protected BigInteger watchlistId;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the filmId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFilmId() {
        return filmId;
    }

    /**
     * Sets the value of the filmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFilmId(BigInteger value) {
        this.filmId = value;
    }

    /**
     * Gets the value of the watchlistId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWatchlistId() {
        return watchlistId;
    }

    /**
     * Sets the value of the watchlistId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWatchlistId(BigInteger value) {
        this.watchlistId = value;
    }

}
