package com.example.reply.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.reply.data.local.LocalEmailsDataProvider
import com.example.reply.ui.theme.ReplyTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues

class MainActivity : ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReplyTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                ReplyApp(
                    replyHomeUIState = uiState,
                    onEmailClick = viewModel::setSelectedEmail
                )

                // Periksa apakah currentWindowAdaptiveInfo() tersedia
                /*
                val adaptiveInfo = currentWindowAdaptiveInfo()
                val sizeClassText =
                    "${adaptiveInfo.windowSizeClass.windowWidthSizeClass}\n" +
                            "${adaptiveInfo.windowSizeClass.windowHeightSizeClass}"
                Text(
                    text = sizeClassText,
                    color = Color.Magenta,
                    modifier = Modifier.padding(
                        WindowInsets.safeDrawing.asPaddingValues()
                    )
                )
                */
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppPreviewTablet() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppPreviewDesktop() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}
