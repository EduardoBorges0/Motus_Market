package com.app.motus_finance.presentation.view.NavBottoms.HomeScreen.InsertMarketOrShopping

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.motus_finance.presentation.viewmodel.PaymentsViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MarketOrShopping(paymentsViewModel: PaymentsViewModel) {
    val selectedItem = paymentsViewModel.selectedItem

    Column(modifier = Modifier.fillMaxSize()) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 130.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            listOf("Supermercado", "Compra").forEach { item ->
                FilterChip(
                    selected = selectedItem == item,
                    onClick = {
                        paymentsViewModel.selectedItem = if (selectedItem == item) null else item
                    },
                    label = {
                        Text(
                            item,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(60.dp)
                        .width(160.dp)
                )
            }
        }
    }
}



