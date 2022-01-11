package infres.ws.rest.object;

import javax.xml.bind.annotation.XmlRootElement;

import infres.ws.grpc.BookHotelRoomOuterClass;

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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BookHotelRoomOuterClass.RoomType getType() {
        return type;
    }

    public void setType(BookHotelRoomOuterClass.RoomType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
