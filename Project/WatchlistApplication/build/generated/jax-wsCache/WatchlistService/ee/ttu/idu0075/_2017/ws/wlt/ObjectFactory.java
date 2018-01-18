
package ee.ttu.idu0075._2017.ws.wlt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.idu0075._2017.ws.wlt package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWatchlistResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "getWatchlistResponse");
    private final static QName _AddWatchlistResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "addWatchlistResponse");
    private final static QName _GetFilmResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "getFilmResponse");
    private final static QName _AddFilmResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "addFilmResponse");
    private final static QName _GetWatchlistFilmListResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "getWatchlistFilmListResponse");
    private final static QName _AddWatchlistFilmResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/wlt", "addWatchlistFilmResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.idu0075._2017.ws.wlt
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFilmRequest }
     * 
     */
    public AddFilmRequest createAddFilmRequest() {
        return new AddFilmRequest();
    }

    /**
     * Create an instance of {@link GetWatchlistListRequest }
     * 
     */
    public GetWatchlistListRequest createGetWatchlistListRequest() {
        return new GetWatchlistListRequest();
    }

    /**
     * Create an instance of {@link FilmType }
     * 
     */
    public FilmType createFilmType() {
        return new FilmType();
    }

    /**
     * Create an instance of {@link AddWatchlistFilmRequest }
     * 
     */
    public AddWatchlistFilmRequest createAddWatchlistFilmRequest() {
        return new AddWatchlistFilmRequest();
    }

    /**
     * Create an instance of {@link GetWatchlistListResponse }
     * 
     */
    public GetWatchlistListResponse createGetWatchlistListResponse() {
        return new GetWatchlistListResponse();
    }

    /**
     * Create an instance of {@link WatchlistType }
     * 
     */
    public WatchlistType createWatchlistType() {
        return new WatchlistType();
    }

    /**
     * Create an instance of {@link WatchlistFilmType }
     * 
     */
    public WatchlistFilmType createWatchlistFilmType() {
        return new WatchlistFilmType();
    }

    /**
     * Create an instance of {@link GetFilmRequest }
     * 
     */
    public GetFilmRequest createGetFilmRequest() {
        return new GetFilmRequest();
    }

    /**
     * Create an instance of {@link GetWatchlistRequest }
     * 
     */
    public GetWatchlistRequest createGetWatchlistRequest() {
        return new GetWatchlistRequest();
    }

    /**
     * Create an instance of {@link GetFilmListRequest }
     * 
     */
    public GetFilmListRequest createGetFilmListRequest() {
        return new GetFilmListRequest();
    }

    /**
     * Create an instance of {@link GetFilmListResponse }
     * 
     */
    public GetFilmListResponse createGetFilmListResponse() {
        return new GetFilmListResponse();
    }

    /**
     * Create an instance of {@link GetWatchlistFilmListRequest }
     * 
     */
    public GetWatchlistFilmListRequest createGetWatchlistFilmListRequest() {
        return new GetWatchlistFilmListRequest();
    }

    /**
     * Create an instance of {@link AddWatchlistRequest }
     * 
     */
    public AddWatchlistRequest createAddWatchlistRequest() {
        return new AddWatchlistRequest();
    }

    /**
     * Create an instance of {@link WatchlistFilmListType }
     * 
     */
    public WatchlistFilmListType createWatchlistFilmListType() {
        return new WatchlistFilmListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "getWatchlistResponse")
    public JAXBElement<WatchlistType> createGetWatchlistResponse(WatchlistType value) {
        return new JAXBElement<WatchlistType>(_GetWatchlistResponse_QNAME, WatchlistType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "addWatchlistResponse")
    public JAXBElement<WatchlistType> createAddWatchlistResponse(WatchlistType value) {
        return new JAXBElement<WatchlistType>(_AddWatchlistResponse_QNAME, WatchlistType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilmType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "getFilmResponse")
    public JAXBElement<FilmType> createGetFilmResponse(FilmType value) {
        return new JAXBElement<FilmType>(_GetFilmResponse_QNAME, FilmType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilmType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "addFilmResponse")
    public JAXBElement<FilmType> createAddFilmResponse(FilmType value) {
        return new JAXBElement<FilmType>(_AddFilmResponse_QNAME, FilmType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistFilmListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "getWatchlistFilmListResponse")
    public JAXBElement<WatchlistFilmListType> createGetWatchlistFilmListResponse(WatchlistFilmListType value) {
        return new JAXBElement<WatchlistFilmListType>(_GetWatchlistFilmListResponse_QNAME, WatchlistFilmListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistFilmType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", name = "addWatchlistFilmResponse")
    public JAXBElement<WatchlistFilmType> createAddWatchlistFilmResponse(WatchlistFilmType value) {
        return new JAXBElement<WatchlistFilmType>(_AddWatchlistFilmResponse_QNAME, WatchlistFilmType.class, null, value);
    }

}
