package com.dk24.corporateweekfinder.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dk24.corporateweekfinder.models.getWeekDataConfigure
import com.dk24.corporateweekfinder.ui.theme.CorporateWeekFinderTheme
import com.dk24.corporateweekfinder.utilites.DateTimeFormatterHelper
import com.dk24.corporateweekfinder.utilites.SharedPreferHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeekDetailsBottomSheetCompose(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            WeekDetailsViewCompose()
        }
    }
}


@Composable
fun WeekDetailsViewCompose() {
    for (weekData in getWeekDataConfigure()) {
        Text(
            text = weekData.label,
            modifier = Modifier.padding(top = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            CustomOutlinedTextField(
                label = weekData.fromLabel,
                key = weekData.fromSharedPrefersKey
            )
            Spacer(modifier = Modifier.weight(1f))
            CustomOutlinedTextField(
                label = weekData.toLabel,
                key = weekData.toSharedPrefersKey
            )
        }
    }
}


@Composable
fun CustomOutlinedTextField(label: String, key: SharedPreferHelper.Companion.Key) {
    val text = remember { mutableStateOf(SharedPreferHelper.getString(key) ?: "") }
    val showDatePickerDialog = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text.value,
        onValueChange = {},
        label = {
            Text(text = label)
        },
        enabled = false,
        modifier = Modifier
            .defaultMinSize(minWidth = 50.dp, minHeight = 48.dp)
            .clickable {
                showDatePickerDialog.value = true
                Log.i("DK", "OnClick -> ${key.name}")
            }
    )
    if (showDatePickerDialog.value) {
        DateTimeFormatterHelper.DatePickerDialog { selectedDate ->
            showDatePickerDialog.value = false
            text.value = selectedDate
            SharedPreferHelper.put(key, selectedDate)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun WeekDetailsBottomSheetComposePreview() {
    CorporateWeekFinderTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                WeekDetailsViewCompose()
            }
        }
    }
}
