package com.bj.dao;

import com.bj.entity.Test02;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface Test02Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test02
     *
     * @mbggenerated
     */
    @Delete({
        "delete from test02",
        "where zone_id = #{zoneId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String zoneId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test02
     *
     * @mbggenerated
     */
    @Insert({
        "insert into test02 (zone_id, zone_name, ",
        "zone_short_name, zone_code, ",
        "zone_parent_id, zone_level)",
        "values (#{zoneId,jdbcType=VARCHAR}, #{zoneName,jdbcType=VARCHAR}, ",
        "#{zoneShortName,jdbcType=VARCHAR}, #{zoneCode,jdbcType=VARCHAR}, ",
        "#{zoneParentId,jdbcType=VARCHAR}, #{zoneLevel,jdbcType=INTEGER})"
    })
    int insert(Test02 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test02
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "zone_id, zone_name, zone_short_name, zone_code, zone_parent_id, zone_level",
        "from test02",
        "where zone_id = #{zoneId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="zone_id", property="zoneId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="zone_name", property="zoneName", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_short_name", property="zoneShortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_code", property="zoneCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_parent_id", property="zoneParentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_level", property="zoneLevel", jdbcType=JdbcType.INTEGER)
    })
    Test02 selectByPrimaryKey(String zoneId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test02
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "zone_id, zone_name, zone_short_name, zone_code, zone_parent_id, zone_level",
        "from test02"
    })
    @Results({
        @Result(column="zone_id", property="zoneId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="zone_name", property="zoneName", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_short_name", property="zoneShortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_code", property="zoneCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_parent_id", property="zoneParentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_level", property="zoneLevel", jdbcType=JdbcType.INTEGER)
    })
    List<Test02> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test02
     *
     * @mbggenerated
     */
    @Update({
        "update test02",
        "set zone_name = #{zoneName,jdbcType=VARCHAR},",
          "zone_short_name = #{zoneShortName,jdbcType=VARCHAR},",
          "zone_code = #{zoneCode,jdbcType=VARCHAR},",
          "zone_parent_id = #{zoneParentId,jdbcType=VARCHAR},",
          "zone_level = #{zoneLevel,jdbcType=INTEGER}",
        "where zone_id = #{zoneId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Test02 record);
}