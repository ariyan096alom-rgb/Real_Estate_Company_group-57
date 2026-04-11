package com.example.real_estate_company.JakiaJumana;

public class Project {
    private String projectName;
    private String Location;
    private int price;
    private String availability;
    private int availabilityEnds;

    public Project(String projectName, String location, int price, String availability, int availabilityEnds) {
        this.projectName = projectName;
        Location = location;
        this.price = price;
        this.availability = availability;
        this.availabilityEnds = availabilityEnds;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getAvailabilityEnds() {
        return availabilityEnds;
    }

    public void setAvailabilityEnds(int availabilityEnds) {
        this.availabilityEnds = availabilityEnds;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", Location='" + Location + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", availabilityEnds=" + availabilityEnds +
                '}';
    }
}
