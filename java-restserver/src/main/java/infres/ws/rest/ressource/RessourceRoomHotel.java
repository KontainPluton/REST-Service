package infres.ws.rest.ressource;

import infres.ws.grpc.BookHotelRoomGrpc;
import infres.ws.grpc.BookHotelRoomOuterClass;
import infres.ws.rest.object.Company;
import infres.ws.rest.object.RoomHotel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.swagger.annotations.Api;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Api(value = "/rooms")
@Path("/rooms")
public class RessourceRoomHotel {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RoomHotel> getAllRooms() {
        ArrayList<RoomHotel> rooms = new ArrayList<>();
        ManagedChannel channel = getChannel();

        BookHotelRoomGrpc.BookHotelRoomBlockingStub bookHotelRoomService = BookHotelRoomGrpc.newBlockingStub(channel);
        BookHotelRoomOuterClass.Empty empty= BookHotelRoomOuterClass.Empty.newBuilder().build();

        BookHotelRoomOuterClass.RoomNumbers roomNumbers = bookHotelRoomService.getAllRoom(empty);


        for(BookHotelRoomOuterClass.RoomNumber room : roomNumbers.getRoomNumberList()) {
            rooms.add(getRoom(room.getNumero()));
        }

        channel.shutdown();
        return rooms;
    }

    @GET
    @Path("/{roomNumber}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RoomHotel getRoom(@PathParam("roomNumber") int roomNumber) {
        ManagedChannel channel = getChannel();

        BookHotelRoomGrpc.BookHotelRoomBlockingStub bookHotelRoomService = BookHotelRoomGrpc.newBlockingStub(channel);
        BookHotelRoomOuterClass.RoomNumber roomN = BookHotelRoomOuterClass.RoomNumber.newBuilder()
                .setNumero(roomNumber)
                .build();

        try {
            BookHotelRoomOuterClass.RoomData roomData = bookHotelRoomService.getRoom(roomN);
            channel.shutdown();

            return new RoomHotel(roomNumber, roomData);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @POST
    @Path("/{roomNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean bookRoom(@PathParam("roomNumber") int roomNumber, String strJson) {
        ManagedChannel channel = getChannel();
        JSONObject json = new JSONObject(strJson);
        String dateArrive = json.getString("dateArrive");
        String dateDepart = json.getString("dateDepart");

        BookHotelRoomGrpc.BookHotelRoomBlockingStub bookHotelRoomService = BookHotelRoomGrpc.newBlockingStub(channel);

        BookHotelRoomOuterClass.Dates debut = BookHotelRoomOuterClass.Dates.newBuilder()
                .setDay(Integer.parseInt(dateArrive.split("-")[2]))
                .setMonth(Integer.parseInt(dateArrive.split("-")[1]))
                .setYear(Integer.parseInt(dateArrive.split("-")[0]))
                .build();
        BookHotelRoomOuterClass.Dates fin = BookHotelRoomOuterClass.Dates.newBuilder()
                .setDay(Integer.parseInt(dateDepart.split("-")[2]))
                .setMonth(Integer.parseInt(dateDepart.split("-")[1]))
                .setYear(Integer.parseInt(dateDepart.split("-")[0]))
                .build();
        BookHotelRoomOuterClass.Booking booking = BookHotelRoomOuterClass.Booking.newBuilder()
                .setNumero(roomNumber)
                .setDateDebut(debut)
                .setDateFin(fin)
                .build();

        try {
            BookHotelRoomOuterClass.Book bookResult = bookHotelRoomService.bookRoom(booking);
            channel.shutdown();

            return bookResult.getBookStatus();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    private ManagedChannel getChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 8070)
                .usePlaintext()
                .build();
    }
}
