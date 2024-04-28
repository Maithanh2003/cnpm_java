package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author apple
 */

public class Flight {
    private int id;
    private String name;
    private String departure;
    private String arrival;
    private String duration;

    // Constructor
    public Flight(int id, String name, String departure, String arrival, String duration) {
        this.id = id;
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
    }
    public Flight() {
        // Khởi tạo tất cả các thuộc tính với giá trị mặc định
        this.id = 0;
        this.name = "";
        this.departure = "";
        this.arrival = "";
        this.duration = "";
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDuration() {
        return duration;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDuration(String duration) {
        this.duration = duration;
   
    }
}