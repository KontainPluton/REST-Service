package infres.ws.rest.object;

import infres.ws.grpc.BookHotelRoomOuterClass;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoomHotel {

    private int roomNumber;
    private BookHotelRoomOuterClass.RoomType type;
    private float price;

    public RoomHotel() {
    }

    public RoomHotel(int n, BookHotelRoomOuterClass.RoomData roomData) {
        this.roomNumber = n;
        this.type = roomData.getType();
        this.price = roomData.getPrice();
    }

    public RoomHotel(int rn, BookHotelRoomOuterClass.RoomType t, float p) {
        this.roomNumber = rn;
        this.type = t;
        this.price = p;
    }

    @JsonbProperty("room_number")
    public int getRoomNumber() {
        return roomNumber;
    }

    @JsonbProperty("room_number")
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @JsonbProperty("type")
    public BookHotelRoomOuterClass.RoomType getType() {
        return type;
    }

    @JsonbProperty("type")
    public void setType(BookHotelRoomOuterClass.RoomType type) {
        this.type = type;
    }

    @JsonbProperty("price")
    public float getPrice() {
        return price;
    }

    @JsonbProperty("price")
    public void setPrice(float price) {
        this.price = price;
    }
}
