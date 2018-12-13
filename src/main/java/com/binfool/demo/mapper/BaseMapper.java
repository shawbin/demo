package com.binfool.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公共的mybatis操作数据库方法
 * @author bin
 * @date 2018/12/12 16:40
 */
public interface BaseMapper<Record, Example>{

    /**
     * 公共的方法
     * @param example
     * @return
     */
    long countByExample(Example example);

    /**
     * 公共的方法
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 公共的方法
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 公共的方法
     * @param record
     * @return
     */
    int insert(Record record);

    /**
     * 公共的方法
     * @param record
     * @return
     */
    int insertSelective(Record record);

    /**
     * 公共的方法
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

    /**
     * 公共的方法
     * @param id
     * @return
     */
    Record selectByPrimaryKey(Long id);

    /**
     * 公共的方法
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 公共的方法
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 公共的方法
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 公共的方法
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);
}
