package com.app.motus_finance.View.NavBottoms.HomeScreen.AddPayments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.motus_finance.UtilityClass.DateUtils
import com.app.motus_finance.View.UtilsComposable.ArrowBack
import com.app.motus_finance.ViewModel.PaymentsViewModel


@Composable
fun AddPayments(navController: NavController, paymentsViewModel: PaymentsViewModel) {
    var inputText by remember { mutableStateOf("") }

    Box (modifier = Modifier.fillMaxSize()) {
        ArrowBack(navController)
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = inputText,
                onValueChange = {  inputText = it },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Button(onClick = {
           paymentsViewModel.insertPayments(inputText.toDouble())
            navController.popBackStack()
        },
            modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .height(70.dp),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text("efr")
        }
    }
}

fun addNumber(currentText: String, newDigit: String): String {
    val cleanText = currentText
        .replace(",", "")
        .replace(".", "")

    // Se for "000", remover zeros à esquerda
    val newText = if (cleanText == "000") newDigit else cleanText + newDigit

    // Garantir que temos sempre dois dígitos após a vírgula
    val formatted = newText.padStart(2, '0')



    val integerPart = formatted.dropLast(2)
    val integerPartTwo = integerPart.drop(2)
    val decimalPart = formatted.takeLast(2)
    val total = "${if(newText.length > 3) integerPartTwo else integerPart},$decimalPart"
    return total
}
