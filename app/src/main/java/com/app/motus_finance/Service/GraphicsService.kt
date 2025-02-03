package com.app.motus_finance.Service

import com.app.motus_finance.Models.DTO.BankDTO
import com.app.motus_finance.Models.DTO.DueDatesDTO
import com.app.motus_finance.Models.DTO.GraphicsDTO
import com.app.motus_finance.Models.DTO.ToEntity
import com.app.motus_finance.Models.Repositories.RepositoriesBank
import com.app.motus_finance.Models.Repositories.RepositoriesDueDates
import com.app.motus_finance.Models.Repositories.RepositoriesExpenses
import com.app.motus_finance.Models.Repositories.RepositoriesGraphics
import com.app.motus_finance.UtilityClass.DateUtils
import java.time.LocalDate

class GraphicsService(
    private val repositoriesGraphics: RepositoriesGraphics,
    private val repositoriesDueDates: RepositoriesDueDates,
    private val repositoriesExpenses: RepositoriesExpenses,
    private val repositoriesBank: RepositoriesBank) {

    suspend fun insertGraphics(){
        val dueDate = repositoriesDueDates.getDueDate()
        val lastDay = DateUtils.stringToLocalDate(dueDate)
        val getAllSpendingRatings = repositoriesExpenses.getHighestSpendingRating()?.get(0)

        if(lastDay == LocalDate.now()){
            val sum = repositoriesBank.sumAllBank()
            val graphicsDTO = GraphicsDTO(
                monthly = lastDay.month.toString(),
                value = sum,
                highestSpendingRating = getAllSpendingRatings?.classification.toString(),
                valueSpendingRating = getAllSpendingRatings?.total ?: 0.0

            )
            repositoriesBank.updateAllSumToZero(0.0)
            repositoriesGraphics.insertGraphics(graphicsDTO.ToEntity())
        }
    }

}