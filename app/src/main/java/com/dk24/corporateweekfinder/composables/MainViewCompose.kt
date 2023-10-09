package com.dk24.corporateweekfinder.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dk24.corporateweekfinder.ui.theme.CorporateWeekFinderTheme


@Composable
fun MainViewCompose(onClick: () -> Unit) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ElevatedButton(
            onClick = onClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Update Dates")
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun MainViewComposePreview() {
    CorporateWeekFinderTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            MainViewCompose({ })
        }
    }
}
