package infres.ws.rest.ressource;

import infres.ws.grpc.BookHotelRoomGrpc;
import infres.ws.grpc.BookHotelRoomOuterClass;
import infres.ws.rest.object.Company;
import infres.ws.rest.object.RoomHotel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rooms")
public class RessourceRoomHotel {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllRooms() {
        return "<h2>Désolé, nous ne proposons pas ce service. (trop compliqué)</h2>" +
                "<p>Essayez avec un numéro de chambre spécifique</p>";
    }

    @GET
    @Path("/{roomNumber}")
    @Produces(MediaType.APPLICATION_XML)
    public RoomHotel getRoom(@PathParam("roomNumber") int roomNumber) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
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
    @Produces(MediaType.TEXT_HTML)
    public String bookRoom(@PathParam("roomNumber") int roomNumber,
            @FormParam("dateDebut") String dateDebut,
            @FormParam("dateFin") String dateFin) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        BookHotelRoomGrpc.BookHotelRoomBlockingStub bookHotelRoomService = BookHotelRoomGrpc.newBlockingStub(channel);

        BookHotelRoomOuterClass.Dates debut = BookHotelRoomOuterClass.Dates.newBuilder()
                .setDay(1)
                .setMonth(11)
                .setYear(1998)
                .build();
        BookHotelRoomOuterClass.Dates fin = BookHotelRoomOuterClass.Dates.newBuilder()
                .setDay(18)
                .setMonth(11)
                .setYear(1998)
                .build();
        BookHotelRoomOuterClass.Booking booking = BookHotelRoomOuterClass.Booking.newBuilder()
                .setNumero(roomNumber)
                .setDateDebut(debut)
                .setDateFin(fin)
                .build();

        try {
            BookHotelRoomOuterClass.Book bookResult = bookHotelRoomService.bookRoom(booking);
            channel.shutdown();

            if (bookResult.getBookStatus()) {
                return "<p>Bravo vous avez réservé</p>";
            } else {
                return "<p>Désolé, la chambre n'est pas disponible pour ces dates ;)</p>";
            }
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
