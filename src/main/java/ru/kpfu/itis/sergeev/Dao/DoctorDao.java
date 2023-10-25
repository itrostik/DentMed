package ru.kpfu.itis.sergeev.Dao;

import ru.kpfu.itis.sergeev.Dto.DoctorDto;
import ru.kpfu.itis.sergeev.Dto.UserDto;
import ru.kpfu.itis.sergeev.Utils.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    public static DoctorDto getDoctor(int doctorId) {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM doctors WHERE doctor_id = (?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            DoctorDto doctor = null;
            if (resultSet.next()) {
                doctor = new DoctorDto();
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setAgeWork(resultSet.getInt("age_work"));
                doctor.setSpecial(resultSet.getString("special"));
                doctor.setDescription(resultSet.getString("description"));
            }
            resultSet.close();
            statement.close();
            return doctor;
        } catch (SQLException e) {
            return null;
        }
    }
    public static List<DoctorDto> getAllDoctors() {
        Connection connection = DatabaseConnectionUtil.getConnection();
        String sql = "SELECT * FROM doctors";
        List<DoctorDto> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DoctorDto doctor = new DoctorDto();
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setAgeWork(resultSet.getInt("age_work"));
                doctor.setSpecial(resultSet.getString("special"));
                doctor.setDescription(resultSet.getString("description"));
                list.add(doctor);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
}
