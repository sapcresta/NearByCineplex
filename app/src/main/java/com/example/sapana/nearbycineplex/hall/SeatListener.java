package com.example.sapana.nearbycineplex.hall;

/**
 * Created by Nublo on 12.11.2015.
 * Copyright Nublo
 */
public interface SeatListener { //yo vaneko select seat ra unselect seat display garna

    void selectSeat(int id); //HallScheme.SeatStatus status
    void unSelectSeat(int id);
}