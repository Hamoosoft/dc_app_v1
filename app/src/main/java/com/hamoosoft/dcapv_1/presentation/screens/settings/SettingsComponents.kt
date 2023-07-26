package com.hamoosoft.dcapv_1.presentation.screens.settings

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.hamoosoft.dcapv_1.R
import com.hamoosoft.dcapv_1.common.Utils
import com.hamoosoft.dcapv_1.presentation.ui.theme.Shapes
import java.io.File
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths


@Composable
fun LanguageSettings(
    modifier: Modifier = Modifier,
    language: List<String> = Utils.languages,
    isEnglish: String,
    onLanguageOptionChanged: (String) -> Unit
) {
    Surface(
        modifier = modifier.padding(dimensionResource(id = R.dimen.large_padding)),
        border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colorScheme.primary),
        shape = Shapes.large,
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary, shadowElevation = 7.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.large_padding)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.language),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = stringResource(id = R.string.chooseLanguage),
                style = MaterialTheme.typography.bodyLarge, color = Color.LightGray
            )

            Row() {
                language.forEach {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        RadioButton(
                            selected = it == isEnglish,
                            onClick = {
                                onLanguageOptionChanged(it)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Cyan,
                                unselectedColor = MaterialTheme.colorScheme.onPrimary,
                                disabledUnselectedColor = MaterialTheme.colorScheme.primary.copy(
                                    0.5f
                                )
                            )
                        )
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

        }
    }

}

@Composable
fun DarkMode(modifier: Modifier = Modifier, darkTheme: (Boolean) -> Unit, modeValue: Boolean) {

    Surface(
        modifier = modifier.padding(dimensionResource(id = R.dimen.large_padding)),
        border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colorScheme.primary),
        shape = Shapes.large,
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary, shadowElevation = 7.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.large_padding)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.dark_mode),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = stringResource(id = R.string.chooseMode),
                style = MaterialTheme.typography.bodyLarge, color = Color.LightGray
            )

            Switch(
                checked = modeValue,
                colors = SwitchDefaults.colors(
                    disabledCheckedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    checkedBorderColor = Color.Cyan,
                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    uncheckedBorderColor = MaterialTheme.colorScheme.primary.copy(
                        0.5f
                    ),
                    checkedIconColor = Color.DarkGray,
                    uncheckedIconColor = MaterialTheme.colorScheme.onPrimary,

                    ),
                onCheckedChange = {

                    darkTheme(it)
                },
                thumbContent = {
                    Icon(
                        painterResource(R.drawable.baseline_dark_mode),
                        contentDescription = null, tint = Color.Unspecified, modifier = Modifier
                            .size(dimensionResource(id = R.dimen.color_card_size))
                    )
                },

                )

        }
    }
}

@Composable
fun ExportAndImport(modifier: Modifier = Modifier, context: Context) {
    Surface(
        modifier = modifier.padding(dimensionResource(id = R.dimen.large_padding)),
        border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colorScheme.primary),
        shape = Shapes.large,
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary, shadowElevation = 7.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.small_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ImportDataResult(modifier = Modifier.weight(1f), context = context)
            ElevatedButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .weight(1f)
                    .padding(
                        dimensionResource(id = R.dimen.large_padding)
                    )
            ) {
                Text(text = "Export", style = MaterialTheme.typography.titleMedium)

            }

        }

    }
}

@Composable
fun ImportDataResult(modifier: Modifier, context: Context) {
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            context as Activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )

        ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CALL_PHONE), 1)
    }
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*text/csv*"
    intent.addCategory(Intent.CATEGORY_OPENABLE)


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val uri = activityResult.data?.data?.path

            // readImportData(filepath = uri!!,context)
            Toast.makeText(context, "$uri", Toast.LENGTH_LONG).show()
            // reader.close()

        }
    }

    ElevatedButton(
        onClick = { launcher.launch(intent) }, modifier = modifier
            .padding(
                dimensionResource(id = R.dimen.large_padding)
            )
    ) {
        Text(text = "Import", style = MaterialTheme.typography.titleMedium)

    }
}

@RequiresApi(Build.VERSION_CODES.P)
fun readImportData(filepath: String, context: Context) {
    val reader = Files.newBufferedReader(Paths.get(filepath), Charset.forName("UTF-8"))
    reader.readLines().forEach {

        //get a string array of all items in this line
        val items = it.split(",")

        Toast.makeText(context, items.size.toString(), Toast.LENGTH_LONG).show()
    }
}

@Throws(IOException::class)
fun File.readAsCSV(): List<List<String>> {
    val splitLines = mutableListOf<List<String>>()
    forEachLine {
        splitLines += it.split(", ")
    }
    return splitLines
}



