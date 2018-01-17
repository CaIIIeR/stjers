
package ee.ttu.idu0075._2017.ws.wlt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for watchlistFilmListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="watchlistFilmListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="watchlistFilm" type="{http://www.ttu.ee/idu0075/2017/ws/wlt}watchlistFilmType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "watchlistFilmListType", propOrder = {
    "watchlistFilm"
})
public class WatchlistFilmListType {

    protected List<WatchlistFilmType> watchlistFilm;

    /**
     * Gets the value of the watchlistFilm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the watchlistFilm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWatchlistFilm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WatchlistFilmType }
     * 
     * 
     */
    public List<WatchlistFilmType> getWatchlistFilm() {
        if (watchlistFilm == null) {
            watchlistFilm = new ArrayList<WatchlistFilmType>();
        }
        return this.watchlistFilm;
    }

}
