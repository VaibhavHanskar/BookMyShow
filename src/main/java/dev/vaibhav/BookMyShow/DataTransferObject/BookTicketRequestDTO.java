package dev.vaibhav.BookMyShow.DataTransferObject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeaIds;
    private int userId;
}