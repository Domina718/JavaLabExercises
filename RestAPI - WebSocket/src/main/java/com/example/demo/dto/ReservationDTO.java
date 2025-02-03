package com.example.demo.dto;

public class ReservationDTO {

    private Long id;

    private MemberDTO memberDTO;

    private BookDTO bookDTO;

    private Boolean fulfilled;


    public ReservationDTO() {
    }

    public ReservationDTO(Long id, MemberDTO memberDTO, BookDTO bookDTO, Boolean fulfilled) {
        this.id = id;
        this.memberDTO = memberDTO;
        this.bookDTO = bookDTO;
        this.fulfilled = fulfilled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public Boolean getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Boolean fulfilled) {
        this.fulfilled = fulfilled;
    }
}
