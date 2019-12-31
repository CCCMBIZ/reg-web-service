package com.cccmbiz.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RegisterMeal {
    private int id;
    private byte qty;
    private Register registerByRegisterId;
    private Meal mealByMealId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "qty")
    public byte getQty() {
        return qty;
    }

    public void setQty(byte qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterMeal that = (RegisterMeal) o;
        return id == that.id &&
                qty == that.qty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty);
    }

    @ManyToOne
    @JoinColumn(name = "register_id", referencedColumnName = "id", nullable = false)
    public Register getRegisterByRegisterId() {
        return registerByRegisterId;
    }

    public void setRegisterByRegisterId(Register registerByRegisterId) {
        this.registerByRegisterId = registerByRegisterId;
    }

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "id", nullable = false)
    public Meal getMealByMealId() {
        return mealByMealId;
    }

    public void setMealByMealId(Meal mealByMealId) {
        this.mealByMealId = mealByMealId;
    }
}
