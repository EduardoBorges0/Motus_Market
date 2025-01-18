package com.app.motus_finance.Models.Repositories

import com.app.motus_finance.Models.DAO.PaymentDAO
import com.app.motus_finance.Models.Entities.Payments

class RepositoriesPayments(private val dao: PaymentDAO) {

    suspend fun updatePayments(newPayments: Double) : Double{
        return dao.updatePayment(newPayment = newPayments)
    }
}