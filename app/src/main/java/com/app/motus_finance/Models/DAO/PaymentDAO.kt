package com.app.motus_finance.Models.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.motus_finance.Models.DTO.PaymentDTO
import com.app.motus_finance.Models.Entities.Payments

@Dao
interface PaymentDAO {

    @Query("UPDATE payment_table SET payment = :newPayment WHERE id = 1")
    suspend fun updatePayment(newPayment : Double)

    @Query("SELECT payment FROM payment_table WHERE id= 1")
    fun getPayments() : LiveData<Double>

    @Insert
    suspend fun insertPayment(payments: Payments)

    @Query("DELETE FROM payment_table WHERE id= 1")
    suspend fun deletePayment()

}