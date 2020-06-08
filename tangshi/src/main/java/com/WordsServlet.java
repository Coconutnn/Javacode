package com;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/words")
public class WordsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        JSONArray jsonArray = new JSONArray();
        HashMap<String,Integer> map = new HashMap<>();
        try (Connection connection = DBConfig.getConnection()) {
            String sql = "SELECT words from t_tangshi";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        int i=0;
                        if(!map.containsKey(rs.getString("words"))){
                            map.put(rs.getString("words"),0);
                        }else{
                            map.put(rs.getString("words"),map.get(rs.getString("words"))+1);
                        }
                    }
                    JSONArray item = new JSONArray();
                    for(Map.Entry<String,Integer> entry: map.entrySet()){
                        item.add(entry.getKey());
                        item.add(entry.getValue());
                        jsonArray.add(item);
                    }

                    resp.getWriter().println(jsonArray.toJSONString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JSONObject object = new JSONObject();
            object.put("error", e.getMessage());
            resp.getWriter().println(object.toJSONString());
        }
    }
}
