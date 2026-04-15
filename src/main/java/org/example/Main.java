package org.example;

import oracle.net.jdbc.TNSAddress.SOException;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pais;

        String consulta1 = "SELECT ID_CICLISTA, CICLISTA.NOMBRE AS NOM_CICLISTA, " +
                "NACIONALIDAD, EDAD, EQUIPO.NOMBRE AS NOM_EQUIPO " +
                "FROM CICLISTA JOIN EQUIPO USING(ID_EQUIPO) " +
                "WHERE PAIS LIKE ?";

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword());
                PreparedStatement ps = conn.prepareStatement(consulta1)) {
                    System.out.println("Ingrese el pais: ");
                    pais = sc.nextLine();
                    ps.setString(1, pais);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        int idCiclista = rs.getInt("ID_CICLISTA");
                        String nombreCiclista = rs.getString("NOM_CICLISTA");
                        String nacionalidad = rs.getString("NACIONALIDAD");
                        int edad = rs.getInt("EDAD");
                        String equipo = rs.getString("NOM_EQUIPO");
                        System.out.println(idCiclista + " - " +  nombreCiclista + " - " + nacionalidad + " - " + edad + " - " + equipo);
                    }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}