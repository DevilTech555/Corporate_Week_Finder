package com.dk24.corporateweekfinder.activites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.dk24.corporateweekfinder.composables.MainViewCompose
import com.dk24.corporateweekfinder.composables.WeekDetailsBottomSheetCompose
import com.dk24.corporateweekfinder.ui.theme.CorporateWeekFinderTheme
import com.dk24.corporateweekfinder.utilites.ShowToast


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showSheet by remember { mutableStateOf(false) }

            CorporateWeekFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainViewCompose {
                        showSheet = true
                    }
                    if (showSheet) {
                        WeekDetailsBottomSheetCompose() {
                            showSheet = false
                        }
                    }
                }
            }
        }
    }

    private fun onClickUpdateDateBtn() {
        ShowToast("On Click Update Dates Button")
    }

    @Preview(showBackground = true, device = Devices.PIXEL_4_XL)
    @Composable
    fun MainActivityPreview() {
        CorporateWeekFinderTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainViewCompose {
                    onClickUpdateDateBtn()
                }
            }
        }
    }
}


