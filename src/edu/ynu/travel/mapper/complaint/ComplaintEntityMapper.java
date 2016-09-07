package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import java.util.List;

public interface ComplaintEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int countByExample(ComplaintEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int insert(ComplaintEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int insertSelective(ComplaintEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    List<ComplaintEntity> selectByExample(ComplaintEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    ComplaintEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int updateByPrimaryKeySelective(ComplaintEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table com_complaint
     *
     * @mbggenerated Wed Sep 07 09:38:59 CST 2016
     */
    int updateByPrimaryKey(ComplaintEntity record);
}