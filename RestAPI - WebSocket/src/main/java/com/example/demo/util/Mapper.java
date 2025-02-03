package com.example.demo.util;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.NotificationDTO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.model.Book;
import com.example.demo.model.Member;
import com.example.demo.model.Notification;
import com.example.demo.model.Reservation;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mapper {

    public static BookDTO bookToBookDTO (Book book){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setYearPublished(book.getYearPublished());
        bookDTO.setNumPages(book.getNumPages());

        return bookDTO;
    }

    public static Book bookDTOToBook (BookDTO bookDTO){
        Book book = new Book();

        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPublisher(bookDTO.getPublisher());
        book.setTitle(bookDTO.getTitle());
        book.setYearPublished(bookDTO.getYearPublished());
        book.setNumPages(bookDTO.getNumPages());

        return book;
    }

    public static List<BookDTO> booksToBookDTOs (List<Book> books){
        List<BookDTO> bookDTOs = new ArrayList<>();
        for(Book book : books){
            bookDTOs.add(bookToBookDTO(book));
        }

        return bookDTOs;
    }

    public static Page<BookDTO> booksPagetoBookDTOsPage (Page<Book> booksPage){
        return booksPage.map(book -> bookToBookDTO(book));

    }

    public static Member memberDTOToMember (MemberDTO memberDTO){
        Member member = new Member();

        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setDob(memberDTO.getDob());
//        member.setReservation(reservationDTOsToReservation(memberDTO.getReservationDTO()));
//        member.setNotification(notificationDTOsToNotifications(memberDTO.getNotificationDTO()));

        return member;
    }

    public static MemberDTO memberToMemberDTO (Member member){
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setDob(member.getDob());
//        memberDTO.setReservationDTO(reservationToReservationDTOs(member.getReservation()));
//        memberDTO.setNotificationDTO(notificationsToNotificationDTOs(member.getNotification()));


        return memberDTO;
    }

    public static Reservation reservationDTOToReservation (ReservationDTO reservationDTO){
        Reservation reservation = new Reservation();

        reservation.setId(reservationDTO.getId());
        reservation.setMember(memberDTOToMember(reservationDTO.getMemberDTO()));
        reservation.setBook(bookDTOToBook(reservationDTO.getBookDTO()));
        reservation.setReservationDate(LocalDateTime.now());

        return reservation;
    }

    public static ReservationDTO reservationToReservationDTO (Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId(reservation.getId());
        reservationDTO.setMemberDTO(memberToMemberDTO(reservation.getMember()));
        reservationDTO.setBookDTO(bookToBookDTO(reservation.getBook()));
        reservationDTO.setFulfilled(reservation.getFulfilled());

        return reservationDTO;
    }

    public static Set<ReservationDTO> reservationToReservationDTOs (Set<Reservation> reservations){
        Set<ReservationDTO> reservationDTOs = new HashSet<>();

        for(Reservation r: reservations){
            reservationDTOs.add(reservationToReservationDTO(r));
        }

        return reservationDTOs;
    }

    public static Set<Reservation> reservationDTOsToReservation (Set<ReservationDTO> reservationDTOs){
        Set<Reservation> reservations = new HashSet<>();

        for(ReservationDTO r: reservationDTOs){
            reservations.add(reservationDTOToReservation(r));
        }

        return reservations;
    }

    public static NotificationDTO notificationToNotificationDTO (Notification notification){
        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setId(notification.getId());
        notificationDTO.setMessage(notification.getMessage());
        notificationDTO.setMemberDTO(memberToMemberDTO(notification.getMember()));
        notificationDTO.setTimestamp(notification.getTimestamp());

        return notificationDTO;
    }

    public static Notification notificationDTOToNotification (NotificationDTO notificationDTO){
        Notification notification = new Notification();

        notification.setId(notification.getId());
        notification.setMessage(notification.getMessage());
        notification.setMember(memberDTOToMember(notificationDTO.getMemberDTO()));
        notification.setTimestamp(notificationDTO.getTimestamp());

        return notification;
    }

    public static Set<NotificationDTO> notificationsToNotificationDTOs (Set<Notification> notifications){
        Set<NotificationDTO> notificationDTOs = new HashSet<>();

        for (Notification n:notifications){
            notificationDTOs.add(notificationToNotificationDTO(n));
        }

        return notificationDTOs;
    }

    public static Set<Notification> notificationDTOsToNotifications (Set<NotificationDTO> notificationDTOs){
        Set<Notification> notifications = new HashSet<>();

        for (NotificationDTO n:notificationDTOs){
            notifications.add(notificationDTOToNotification(n));
        }

        return notifications;
    }
}
