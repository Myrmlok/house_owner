package com.petProjects.house_owner.app;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.relational.domain.RowDocument;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private  final NamedParameterJdbcTemplate template;

    public UserDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public long createUser( User user1){
        String sql="INSERT INTO USERS(user_name,age,password)\n" +
                "values\n" +
                "(:name,:age,:password) returning id";
        SqlParameterSource parameterSource=new MapSqlParameterSource().
                addValue("name",user1.getName()).
                addValue("age",user1.getAge()).
                addValue("password",user1.getPassword());

        return template.queryForObject(sql,parameterSource, Long.class);

    }
}
