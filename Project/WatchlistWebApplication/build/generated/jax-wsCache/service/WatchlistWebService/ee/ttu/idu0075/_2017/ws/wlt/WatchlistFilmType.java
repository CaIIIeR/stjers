
package ee.ttu.idu0075._2017.ws.wlt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for watchlistFilmType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="watchlistFilmType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="film" type="{http://www.ttu.ee/idu0075/2017/ws/wlt}filmType"/&gt;
 *         &lt;element name="dateAdded" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "watchlistFilmType", propOrder = {
    "film",
    "dateAdded"
})
public class WatchlistFilmType {

    @XmlElement(required = true)
    protected FilmType film;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateAdded;

    /**
     * Gets the value of the film property.
     * 
     * @return
     *     possible object is
     *     {@link FilmType }
     *     
     */
    public FilmType getFilm() {
        return film;
    }

    /**
     * Sets the value of the film property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilmType }
     *     
     */
    public void setFilm(FilmType value) {
        this.film = value;
    }

    /**
     * Gets the value of the dateAdded property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets the value of the dateAdded property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAdded(XMLGregorianCalendar value) {
        this.dateAdded = value;
    }

}
