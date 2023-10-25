package ru.kpfu.itis.sergeev.Dto;

public class DoctorDto {
    private String name;
    private int doctorId;
    private String special;
    private int ageWork;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DoctorDto() {
    }

    public DoctorDto(String name, int doctorId, String special, int ageWork) {
        this.name = name;
        this.doctorId = doctorId;
        this.special = special;
        this.ageWork = ageWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public int getAgeWork() {
        return ageWork;
    }

    public void setAgeWork(int ageWork) {
        this.ageWork = ageWork;
    }
}
