package com.yichen.core.model;

import java.io.Serializable;

public class foodCookSteps implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_food_cook_steps.id
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_food_cook_steps.food_name
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    private Integer foodName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_food_cook_steps.comment
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_food_cook_steps.cook_steps
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    private String cookSteps;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_food_cook_steps.id
     *
     * @return the value of t_food_cook_steps.id
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_food_cook_steps.id
     *
     * @param id the value for t_food_cook_steps.id
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_food_cook_steps.food_name
     *
     * @return the value of t_food_cook_steps.food_name
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public Integer getFoodName() {
        return foodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_food_cook_steps.food_name
     *
     * @param foodName the value for t_food_cook_steps.food_name
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public void setFoodName(Integer foodName) {
        this.foodName = foodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_food_cook_steps.comment
     *
     * @return the value of t_food_cook_steps.comment
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_food_cook_steps.comment
     *
     * @param comment the value for t_food_cook_steps.comment
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_food_cook_steps.cook_steps
     *
     * @return the value of t_food_cook_steps.cook_steps
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public String getCookSteps() {
        return cookSteps;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_food_cook_steps.cook_steps
     *
     * @param cookSteps the value for t_food_cook_steps.cook_steps
     *
     * @mbggenerated Thu Jun 17 10:25:00 CST 2021
     */
    public void setCookSteps(String cookSteps) {
        this.cookSteps = cookSteps == null ? null : cookSteps.trim();
    }
}