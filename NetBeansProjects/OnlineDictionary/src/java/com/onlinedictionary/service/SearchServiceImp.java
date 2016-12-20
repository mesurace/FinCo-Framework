/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinedictionary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author sureshadhikari
 */
public class SearchServiceImp implements SearchService {

    @Override
    public String search(String s) {

        Connection conn = DbConnection.getConnection();

        PreparedStatement stmt = null;
       
        ResultSet rs = null;

        String result = null;

        String query = "SELECT wordtype,definition from entries where word=?;";

        try {

            stmt = conn.prepareStatement(query);
            stmt.setString(1, s);
            rs = stmt.executeQuery();

            result = convertToJSON(rs).toString();

        } catch (JSONException e) {
        } catch (SQLException ex) {
            Logger.getLogger(SearchServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn);
        }
        return result;
    }

    private JSONArray convertToJSON(ResultSet resultSet) throws SQLException, JSONException {
        JSONArray jsonArray = new JSONArray();

        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(), resultSet.getObject(i + 1));
            }
            jsonArray.put(obj);
        }
        

        return jsonArray;
    }

}
